package com.rainbowland.portal.rpc.service;

import bnet.protocol.RpcProto;
import bnet.protocol.connection.v1.ConnectionServiceProto;
import com.google.protobuf.RpcCallback;
import com.google.protobuf.RpcController;
import com.rainbowland.common.RpcErrorCode;
import com.rainbowland.portal.rpc.NettyRpcChannel;
import com.rainbowland.portal.rpc.NettyRpcController;

import java.time.Instant;

public class ConnectionService implements ConnectionServiceProto.ConnectionService.Interface {

    private ConnectionServiceProto.ConnectionService.Interface clientNotification = ConnectionServiceProto.ConnectionService.newStub(new NettyRpcChannel());


    @Override
    public void connect(RpcController controller, ConnectionServiceProto.ConnectRequest request, RpcCallback<ConnectionServiceProto.ConnectResponse> done) {
        ConnectionServiceProto.ConnectResponse.Builder builder = ConnectionServiceProto.ConnectResponse.newBuilder();
        if (request.hasClientId()) {
            builder.setClientId(request.getClientId());
        }
        long pid = ProcessHandle.current().pid();
        Instant now = Instant.now();
        builder.setServerId(RpcProto.ProcessId.newBuilder()
                .setEpoch((int) now.getEpochSecond())
                .setLabel((int) pid).build())
                .setServerTime(now.toEpochMilli())
                .setUseBindlessRpc(request.getUseBindlessRpc());
        done.run(builder.build());

    }

    @Override
    @Deprecated
    public void bind(RpcController controller, ConnectionServiceProto.BindRequest request, RpcCallback<ConnectionServiceProto.BindResponse> done) {
        NettyRpcController nettyRpcController = (NettyRpcController) controller;
        nettyRpcController.setFailed(RpcErrorCode.ERROR_RPC_NOT_IMPLEMENTED);
        done.run(ConnectionServiceProto.BindResponse.getDefaultInstance());

    }

    @Override
    public void echo(RpcController controller, ConnectionServiceProto.EchoRequest request, RpcCallback<ConnectionServiceProto.EchoResponse> done) {
        NettyRpcController nettyRpcController = (NettyRpcController) controller;
        nettyRpcController.setFailed(RpcErrorCode.ERROR_RPC_NOT_IMPLEMENTED);
        done.run(ConnectionServiceProto.EchoResponse.getDefaultInstance());
    }

    @Override
    public void forceDisconnect(RpcController controller, ConnectionServiceProto.DisconnectNotification request, RpcCallback<RpcProto.NO_RESPONSE> done) {
        NettyRpcController nettyRpcController = (NettyRpcController) controller;
        nettyRpcController.setFailed(RpcErrorCode.ERROR_RPC_NOT_IMPLEMENTED);
        done.run(RpcProto.NO_RESPONSE.getDefaultInstance());
    }

    @Override
    public void keepAlive(RpcController controller, RpcProto.NoData request, RpcCallback<RpcProto.NO_RESPONSE> done) {
        done.run(RpcProto.NO_RESPONSE.getDefaultInstance());
    }

    @Override
    public void encrypt(RpcController controller, ConnectionServiceProto.EncryptRequest request, RpcCallback<RpcProto.NoData> done) {
        NettyRpcController nettyRpcController = (NettyRpcController) controller;
        nettyRpcController.setFailed(RpcErrorCode.ERROR_RPC_NOT_IMPLEMENTED);
        done.run(RpcProto.NoData.getDefaultInstance());
    }

    @Override
    public void requestDisconnect(RpcController controller, ConnectionServiceProto.DisconnectRequest request, RpcCallback<RpcProto.NO_RESPONSE> done) {
        ConnectionServiceProto.DisconnectNotification notification
                = ConnectionServiceProto.DisconnectNotification.newBuilder()
                .setErrorCode(request.getErrorCode()).build();
        clientNotification.forceDisconnect(controller, notification, done);
        done.run(RpcProto.NO_RESPONSE.getDefaultInstance());
    }
}
