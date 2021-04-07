package cn.iwannnn.network;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

public class SendPack {
    private String message;
    private static final Logger LOGGER = LogManager.getLogger();

    public SendPack(PacketBuffer buffer) {
        message = buffer.readString(Short.MAX_VALUE);
    }

    public SendPack(String message) {
        this.message = message;
    }

    public void toBytes(PacketBuffer buf) {// 数据包转为字节流
        buf.writeString(this.message);
    }

    public void handler(Supplier<NetworkEvent.Context> ctx) {// 如何使用数据
        ctx.get().enqueueWork(() -> { // 执行操作必须放在这里
            LOGGER.info(this.message);
        });
        ctx.get().setPacketHandled(true);
    }
}