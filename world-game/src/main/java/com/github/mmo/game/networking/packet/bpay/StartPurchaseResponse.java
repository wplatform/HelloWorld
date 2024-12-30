package com.github.mmo.game.networking.packet.bpay;


public class StartPurchaseResponse extends ServerPacket {
    private long purchaseID = 0;
    private int clientToken = 0;
    private int purchaseResult = 0;

    public StartPurchaseResponse() {
        super(ServerOpcode.BattlePayStartPurchaseResponse);
    }

    public final long getPurchaseID() {
        return purchaseID;
    }

    public final void setPurchaseID(long value) {
        purchaseID = value;
    }

    public final int getClientToken() {
        return clientToken;
    }

    public final void setClientToken(int value) {
        clientToken = value;
    }

    public final int getPurchaseResult() {
        return purchaseResult;
    }

    public final void setPurchaseResult(int value) {
        purchaseResult = value;
    }

    @Override
    public void write() {
        this.write(getPurchaseID());
        this.write(getPurchaseResult());
        this.write(getClientToken());
    }
}
