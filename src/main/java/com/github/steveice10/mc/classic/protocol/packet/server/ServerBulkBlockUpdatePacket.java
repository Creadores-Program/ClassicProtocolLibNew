package com.github.steveice10.mc.classic.protocol.packet.server;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.io.IOException;

public class ServerBulkBlockUpdatePacket implements Packet {
    private int count;
    private byte[] data;

    @SuppressWarnings("unused")
    private ServerBulkBlockUpdatePacket() {}

    public ServerBulkBlockUpdatePacket(int count, byte[] data) {
        this.count = count;
        this.data = data;
    }

    @Override
    public void read(NetInput in) throws IOException {
        this.count = in.readUnsignedByte();
        this.data = in.readBytes(this.count * 4);
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeByte(this.count);
        out.writeBytes(this.data);
    }

    public int getCount() { return count; }
    public byte[] getData() { return data; }

    @Override public boolean isPriority() { return false; }
}
