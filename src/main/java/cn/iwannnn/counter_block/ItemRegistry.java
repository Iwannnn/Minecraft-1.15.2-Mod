package cn.iwannnn.counter_block;

import cn.iwannnn.group.ModGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, "iwannnn");
    public static RegistryObject<Item> counterBlockTileEntity = ITEMS.register("counter_block", () -> {
        return new BlockItem(BlockRegistry.counterBlockTileEntity.get(), new Item.Properties().group(ModGroup.iwannnnGroup));
    });
}