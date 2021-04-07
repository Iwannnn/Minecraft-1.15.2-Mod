package cn.iwannnn.network;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class Networking {
    public static SimpleChannel INSTANCE;
    public static final String VERSION = "1.0";
    public static int ID = 0;

    public static int nextID() {
        return ID++;
    }

    public static void registerMessage() {
        INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation("iwannnn", "first_networking"), () -> {
            return VERSION;
        }, (version) -> {
            return version.equals(VERSION);
        }, (version) -> {
            return version.equals(VERSION);
        });
        INSTANCE.registerMessage(nextID(), SendPack.class, SendPack::toBytes, SendPack::new, SendPack::handler);
    }
}
