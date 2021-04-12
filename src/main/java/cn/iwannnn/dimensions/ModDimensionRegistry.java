package cn.iwannnn.dimensions;

import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModDimensionRegistry {
    public static final DeferredRegister<ModDimension> MOD_DIMENSIONS = new DeferredRegister<>(
            ForgeRegistries.MOD_DIMENSIONS, "iwannnn");
    public static RegistryObject<IwannnnModDimensions> iwannnnModDimension = MOD_DIMENSIONS
            .register("iwannnn_mod_dimension", () -> {
                return new IwannnnModDimensions();
            });
}
