package cn.iwannnn.hello_block;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypeRegistry {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY =
        new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, "iwannnn"); // TileEntityType是一个含有泛型的类 ？代表好多类
    public static RegistryObject<TileEntityType<HelloBlockTileEntity>> helloBlockTilEntity =
        TILE_ENTITY.register("hello_block", () -> {
            return TileEntityType.Builder
                .create(() -> { return new HelloBlockTileEntity(); }, BlockRegistry.helloBlockTileEntity.get())
                .build(null);
        });
}