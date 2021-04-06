package cn.iwannnn.zombie_block;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypeRegistry {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY =
        new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, "iwannnn");
    public static RegistryObject<TileEntityType<ZombieBlockTileEntity>> zombieBlockTileEntity =
        TILE_ENTITY.register("zombie_block", () -> {
            return TileEntityType.Builder
                .create(() -> { return new ZombieBlockTileEntity(); }, BlockRegistry.zombieBlockTileEntity.get())
                .build(null);
            });
}
