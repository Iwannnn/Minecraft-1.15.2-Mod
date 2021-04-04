package cn.iwannnn.counter_block;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypeRegistry {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY =
        new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, "iwannnn");
    public static RegistryObject<TileEntityType<CounterBlockTileEntity>> counterBlockTileEntity =
        TILE_ENTITY.register("counter_block", () -> {
            return TileEntityType.Builder
                .create(() -> { return new CounterBlockTileEntity(); }, BlockRegistry.counterBlockTileEntity.get())
                .build(null);
        });
}