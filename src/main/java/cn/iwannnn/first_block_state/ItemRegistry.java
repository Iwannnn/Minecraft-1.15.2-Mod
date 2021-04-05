package cn.iwannnn.first_block_state;

import cn.iwannnn.group.ModGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, "iwannnn");
    public static final RegistryObject<Item> firstBlockState = ITEMS.register("first_block_state", () -> {
        return new BlockItem(BlockRegistry.firstBlockState.get(), new Item.Properties().group(ModGroup.iwannnnGroup));
    });
}