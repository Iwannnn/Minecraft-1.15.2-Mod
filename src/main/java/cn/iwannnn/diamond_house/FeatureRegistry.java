package cn.iwannnn.diamond_house;

import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FeatureRegistry {
    public static final DeferredRegister<Feature<?>> FEATURES = new DeferredRegister<>(ForgeRegistries.FEATURES,
            "iwannnn");// structure 是一种特殊的feature
    public static RegistryObject<Structure<NoFeatureConfig>> firstBlock = FEATURES.register("house", () -> {
        return new DiamondHouse(Dynamic -> {
            return NoFeatureConfig.deserialize(Dynamic);
        });
    });

}
