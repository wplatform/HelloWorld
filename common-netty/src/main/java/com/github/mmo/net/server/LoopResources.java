/*
 * Copyright (c) 2011-2023 VMware, Inc. or its affiliates, All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.mmo.net.server;

import java.util.Objects;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.ServerChannel;


public interface LoopResources {
    boolean DEFAULT_NATIVE = Boolean.parseBoolean(System.getProperty("netty.native", "true"));

    static LoopResources create(String prefix, int workerCount, boolean daemon) {
        return create(prefix, -1, workerCount, daemon, true);
    }

    static LoopResources create(String prefix, int selectCount, int workerCount, boolean daemon) {
        if (Objects.requireNonNull(prefix, "prefix").isEmpty()) {
            throw new IllegalArgumentException("Cannot use empty prefix");
        }
        if (workerCount < 1) {
            throw new IllegalArgumentException("Must provide a strictly positive worker threads number, was: " + workerCount);
        }
        if (selectCount < 1) {
            throw new IllegalArgumentException("Must provide a strictly positive selector threads number, was: " + selectCount);
        }
        return new DefaultLoopResources(prefix, selectCount, workerCount, daemon);
    }


    static LoopResources create(String prefix, int selectCount, int workerCount, boolean daemon, boolean colocate) {
        if (Objects.requireNonNull(prefix, "prefix").isEmpty()) {
            throw new IllegalArgumentException("Cannot use empty prefix");
        }
        if (workerCount < 1) {
            throw new IllegalArgumentException("Must provide a strictly positive worker threads number, was: " + workerCount);
        }
        if (selectCount < 1 && selectCount != -1) {
            throw new IllegalArgumentException("Must provide a strictly positive selector threads number or -1, was: " + selectCount);
        }

        return new DefaultLoopResources(prefix, selectCount, workerCount, daemon, colocate);
    }

    EventLoopGroup onServer(boolean useNative);

    EventLoopGroup onServerSelect(boolean useNative);

    Class<? extends ServerChannel> channelType(boolean useNative);




}
