package com.github.steveice10.mc.classic.protocol.packet.server;

import com.github.steveice10.mc.classic.protocol.packet.ClassicPacketUtil;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

import java.io.IOException;

public class ServerSetClickDistancePacket implements Packet{
    private short distance;
    @SuppressWarnings("unused")
	  private ServerSetClickDistancePacket() {
    }
    public ServerSetClickDistancePacket(short distance){
        this.distance = distance;
    }
    public short getDistance(){
        return this.distance;
    }
    @Override
    public void read(NetInput in) throws IOException {
        this.distance = in.readShort();
    }
    @Override
	public void write(NetOutput out) throws IOException {
        out.writeShort(this.distance);
    }
    @Override
	public boolean isPriority() {
		return false;
    }
}
