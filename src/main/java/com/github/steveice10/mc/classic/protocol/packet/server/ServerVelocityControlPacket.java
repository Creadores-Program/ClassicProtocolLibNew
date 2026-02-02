package com.github.steveice10.mc.classic.protocol.packet.server;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

import java.io.IOException;

public class ServerVelocityControlPacket implements Packet {
    private int xVelocity;
    private int yVelocity;
    private int zVelocity;
    private int mode;

    @SuppressWarnings("unused")
    private ServerVelocityControlPacket() {
    }

    public ServerVelocityControlPacket(int xVelocity, int yVelocity, int zVelocity, int mode) {
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.zVelocity = zVelocity;
        this.mode = mode;
    }

    @Override
    public void read(NetInput in) throws IOException {
        this.xVelocity = in.readInt();
        this.yVelocity = in.readInt();
        this.zVelocity = in.readInt();
        this.mode = in.readUnsignedByte();
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeInt(this.xVelocity);
        out.writeInt(this.yVelocity);
        out.writeInt(this.zVelocity);
        out.writeByte(this.mode);
    }

    public int getRawX() { return xVelocity; }
    public int getRawY() { return yVelocity; }
    public int getRawZ() { return zVelocity; }
    public int getMode() { return mode; }

    @Override
    public boolean isPriority() {
        return false;
    }
}
