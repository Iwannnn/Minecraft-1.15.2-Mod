package cn.iwannnn.counter_block;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypeRegistry {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY =
        new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, "iwannnn"); // TileEntityType是一个含有泛型的类 ？代表好多类
    public static RegistryObject<TileEntityType<CounterBlockTileEntity>> counterBlockTileEntity =
        TILE_ENTITY.register("counter_block", () -> {
            return TileEntityType.Builder
                .create(()
                            -> { return new CounterBlockTileEntity(); },
                        BlockRegistry.counterBlockTileEntity.get()) //一个supplier和block
                .build(null);                                       //通常填null datafix用于不同版本的存档转换
        });
}