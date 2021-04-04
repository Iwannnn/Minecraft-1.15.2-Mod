package cn.iwannnn.first_glass;

import cn.iwannnn.group.ModGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, "iwannnn");
    public static RegistryObject<Item> firstGlass = ITEMS.register("first_glass", () -> {
        return new BlockItem(BlockRegistry.firstGlass.get(), new Item.Properties().group(ModGroup.firstGroup));
    });
}
