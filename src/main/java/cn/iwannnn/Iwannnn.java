package cn.iwannnn;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("iwannnn")
public class Iwannnn {
    public Iwannnn() {
        // 注册进Mod总线
        cn.iwannnn.first_item.ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        cn.iwannnn.first_food.ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        cn.iwannnn.first_weapon.ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        cn.iwannnn.first_block.BlockRegistry.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        cn.iwannnn.first_block.ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        cn.iwannnn.first_block_state.BlockRegistry.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        cn.iwannnn.first_block_state.ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        cn.iwannnn.first_glass.BlockRegistry.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        cn.iwannnn.first_glass.ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        cn.iwannnn.first_obj.BlockRegistry.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        cn.iwannnn.first_obj.ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        cn.iwannnn.counter_block.BlockRegistry.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        cn.iwannnn.counter_block.ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        cn.iwannnn.counter_block.TileEntityTypeRegistry.TILE_ENTITY.register(FMLJavaModLoadingContext.get().getModEventBus());
        cn.iwannnn.hello_block.BlockRegistry.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        cn.iwannnn.hello_block.ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        cn.iwannnn.hello_block.TileEntityTypeRegistry.TILE_ENTITY.register(FMLJavaModLoadingContext.get().getModEventBus());
        cn.iwannnn.zombie_block.BlockRegistry.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        cn.iwannnn.zombie_block.ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        cn.iwannnn.zombie_block.TileEntityTypeRegistry.TILE_ENTITY.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
