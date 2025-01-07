package com.github.azeroth.net.server;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.ServerChannel;
import io.netty.channel.epoll.Epoll;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollServerSocketChannel;
import io.netty.channel.kqueue.KQueue;
import io.netty.channel.kqueue.KQueueEventLoopGroup;
import io.netty.channel.kqueue.KQueueServerSocketChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.incubator.channel.uring.IOUring;
import io.netty.incubator.channel.uring.IOUringEventLoopGroup;
import io.netty.incubator.channel.uring.IOUringServerSocketChannel;
import io.netty.util.concurrent.DefaultThreadFactory;
import io.netty.util.concurrent.EventExecutorGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;


public class DefaultLoopResources implements LoopResources {

    private static final Logger log = LoggerFactory.getLogger(DefaultLoopResources.class);

    private static final boolean isIoUringAvailable;
    private static final boolean isEpollAvailable;

    private static final boolean isKqueueAvailable;

    static {
        boolean check = false;
        try {
            Class.forName("io.netty.incubator.channel.uring.IOUring");
            check = IOUring.isAvailable();
        } catch (ClassNotFoundException cnfe) {
            // noop
        }
        isIoUringAvailable = check;
        log.debug("Default io_uring support : {}", isIoUringAvailable);

        check = false;
        try {
            Class.forName("io.netty.channel.epoll.Epoll");
            check = Epoll.isAvailable();
        } catch (ClassNotFoundException cnfe) {
            // noop
        }
        isEpollAvailable = check;
        log.debug("Default Epoll support : {}", isEpollAvailable);

        check = false;
        try {
            Class.forName("io.netty.channel.kqueue.KQueue");
            check = KQueue.isAvailable();
        } catch (ClassNotFoundException cnfe) {
            // noop
        }
        isKqueueAvailable = check;
        log.debug("Default KQueue support : {}", isKqueueAvailable);

    }

    final String prefix;
    final boolean daemon;
    final int selectCount;
    final int workerCount;
    EventLoopGroup serverLoops;
    EventLoopGroup serverSelectLoops;
    final AtomicBoolean running;
    final boolean colocate;

    private ReentrantLock sourceLock = new ReentrantLock();


    DefaultLoopResources(String prefix, int selectCount, int workerCount, boolean daemon) {
        this(prefix, selectCount, workerCount, daemon, true);
    }

    DefaultLoopResources(String prefix, int selectCount, int workerCount, boolean daemon, boolean colocate) {
        this.running = new AtomicBoolean(true);
        this.daemon = daemon;
        this.workerCount = workerCount;
        this.prefix = prefix;
        this.colocate = colocate;

        if (selectCount == -1) {
            this.selectCount = workerCount;
        } else {
            this.selectCount = selectCount;
        }
    }


    public EventLoopGroup newEventLoopGroup(int threads, ThreadFactory factory) {

        EventLoopGroup result = null;
        if (isIoUringAvailable) {
            result = new IOUringEventLoopGroup(threads, factory);
        } else if (isEpollAvailable) {
            result = new EpollEventLoopGroup(threads, factory);
        } else if (isKqueueAvailable) {
            result = new KQueueEventLoopGroup(threads, factory);
        } else {
            result = new NioEventLoopGroup(threads, factory);
        }
        return result;
    }


    @SuppressWarnings("unchecked")
    public <CHANNEL extends ServerSocketChannel> Class<? extends CHANNEL> getServerSocketChannelClass() {

        if (isIoUringAvailable) {
            return (Class<? extends CHANNEL>) IOUringServerSocketChannel.class;
        } else if (isEpollAvailable) {
            return (Class<? extends CHANNEL>) EpollServerSocketChannel.class;
        } else if (isKqueueAvailable) {
            return (Class<? extends CHANNEL>) KQueueServerSocketChannel.class;
        } else {
            return (Class<? extends CHANNEL>) NioServerSocketChannel.class;
        }

    }

    boolean hasNativeSupport() {
        return isIoUringAvailable || isEpollAvailable || isKqueueAvailable;
    }

    public boolean daemon() {
        return daemon;
    }

    @Override
    public EventLoopGroup onServer(boolean useNative) {
        if (colocate) {
            return onServerSelect(useNative);
        }
        sourceLock.lock();
        try {
            DefaultThreadFactory threadFactory = new DefaultThreadFactory(this.prefix, this.daemon);
            serverLoops = useNative && hasNativeSupport() ? newEventLoopGroup(workerCount, threadFactory) : new NioEventLoopGroup(workerCount, threadFactory);
        } finally {
            sourceLock.unlock();
        }
        return serverLoops;
    }

    @Override
    public EventLoopGroup onServerSelect(boolean useNative) {

        sourceLock.lock();
        try {
            DefaultThreadFactory threadFactory = new DefaultThreadFactory(this.prefix, this.daemon);
            serverLoops = useNative && hasNativeSupport() ? newEventLoopGroup(selectCount, threadFactory) : new NioEventLoopGroup(selectCount, threadFactory);
        } finally {
            sourceLock.unlock();
        }
        return serverLoops;
    }
    @Override
    public Class<? extends ServerChannel> channelType(boolean useNative) {
        if (useNative && hasNativeSupport()) {
            return getServerSocketChannelClass();
        }
        return NioServerSocketChannel.class;
    }


    void shutdownGracefully() {
        sourceLock.lock();
        try {
            Optional.ofNullable(serverLoops).ifPresent(EventExecutorGroup::shutdownGracefully);
            Optional.ofNullable(serverSelectLoops).ifPresent(EventExecutorGroup::shutdownGracefully);
            serverLoops = null;
            serverSelectLoops = null;
        } finally {
            sourceLock.unlock();
        }

    }

    @Override
    public String toString() {
        return "DefaultLoopResources {prefix=%s, daemon=%s, selectCount=%d, workerCount=%d}".formatted(prefix, daemon, selectCount, workerCount);
    }


}
