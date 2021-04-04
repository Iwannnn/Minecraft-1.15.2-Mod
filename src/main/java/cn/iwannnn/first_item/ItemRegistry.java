package cn.iwannnn.first_item;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
    // public static <B extends IForgeRegistryEntry<B>> DeferredRegister<B>
    // create(IForgeRegistry<B> reg, String modid)
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, "iwannnn");
    // public <I extends T> RegistryObject<I> register(final String name, final
    // Supplier<? extends I> sup)
    public static final RegistryObject<Item> firstItem = ITEMS.register("first_item", () -> { return new FirstItem(); });
}
