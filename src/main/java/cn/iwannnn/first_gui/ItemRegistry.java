package cn.iwannnn.first_gui;

import org.lwjgl.system.CallbackI.F;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, "iwannnn");
    public static RegistryObject<Item> firstGui = ITEMS.register("first_gui", () -> {
        return new FirstGuiItem();
    });
}
