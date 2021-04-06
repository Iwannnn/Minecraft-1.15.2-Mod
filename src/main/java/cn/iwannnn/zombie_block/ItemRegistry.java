package cn.iwannnn.zombie_block;

import cn.iwannnn.group.ModGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, "iwannnn");
    public static RegistryObject<Item> zombieBlockTileEntity = ITEMS.register("zombie_block", () -> {
        return new BlockItem(BlockRegistry.zombieBlockTileEntity.get(), new Item.Properties().group(ModGroup.iwannnnGroup));
    });
}