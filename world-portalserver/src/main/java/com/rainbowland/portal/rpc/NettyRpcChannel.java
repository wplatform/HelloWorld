package com.rainbowland.portal.rpc;

import bnet.protocol.MethodOptionsProto;
import bnet.protocol.RpcProto;
import bnet.protocol.ServiceOptionsProto;
import com.google.protobuf.*;
import com.rainbowland.portal.proto.RpcPacket;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class NettyRpcChannel implements RpcChannel {

    private AtomicInteger token = new AtomicInteger(0);

    @Override
    public void callMethod(Descriptors.MethodDescriptor method, RpcController controller,
                           Message request, Message responsePrototype, RpcCallback<Message> done) {

        NettyRpcController rpcController = (NettyRpcController) controller;
        ServiceOptionsProto.BGSServiceOptions serviceOptions = method.getService().getOptions().getExtension(ServiceOptionsProto.serviceOptions);
        MethodOptionsProto.BGSMethodOptions methodOptions = method.getOptions().getExtension(MethodOptionsProto.methodOptions);
        Integer serviceHash = ServiceMetadata.getServiceHashByServiceName(serviceOptions.getDescriptorName());
        if (serviceHash == null) {
            throw new IllegalStateException("Not have service hash for " + serviceOptions.getDescriptorName());
        }
        byte[] messageBody = request.toByteArray();
        RpcProto.Header header = RpcProto.Header.newBuilder()
                .setServiceId(0)
                .setServiceHash(serviceHash)
                .setMethodId(methodOptions.getId())
                .setSize(messageBody.length)
                .setToken(token.getAndIncrement()).build();
        RpcPacket packet = new RpcPacket(header, messageBody);
        rpcController.addListenerPacket(packet);
        if(log.isInfoEnabled()) {
            StringBuilder logMsg = new StringBuilder().append(" <--").append(" service: ").append(Integer.toHexString(serviceHash)).append("-").append(serviceOptions.getDescriptorName()).append(".").append(method.getName())
                    .append(" token: ").append(header.getToken())
                    .append(" status: ").append(header.getStatus());
            log.info(logMsg.toString());
        }
    }
}
