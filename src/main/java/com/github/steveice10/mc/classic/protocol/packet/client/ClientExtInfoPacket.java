package com.github.steveice10.mc.classic.protocol.packet.client;

import com.github.steveice10.mc.classic.protocol.packet.ClassicPacketUtil;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

import java.io.IOException;

public class ClientExtInfoPacket implements Packet{
    private String appName;
    private short extensionCount;
    @SuppressWarnings("unused")
	  private ClientExtInfoPacket() {
    }
    public ClientExtInfoPacket(String appName, short extensionCount){
        this.appName = appName;
        this.extensionCount = extensionCount;
    }
    public String getAppName(){
        return this.appName;
    }
    public short getExtensionCount(){
        return this.extensionCount;
    }
    @Override
    public void read(NetInput in) throws IOException {
        this.appName = ClassicPacketUtil.readString(in);
        this.extensionCount = in.readShort();
    }
    @Override
	  public void write(NetOutput out) throws IOException {
        ClassicPacketUtil.writeString(out, this.appName);
        out.writeShort(this.extensionCount);
    }
    @Override
	  public boolean isPriority() {
		    return false;
    }
}
