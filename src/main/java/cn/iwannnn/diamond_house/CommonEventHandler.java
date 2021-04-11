package cn.iwannnn.diamond_house;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonEventHandler {
    public static IStructurePieceType diamondHousePieceType;// 需要被注册的内容

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        diamondHousePieceType = Registry.register(Registry.STRUCTURE_PIECE, "house", (templateManager, nbt) -> {
            return new DiamondHousePiece(templateManager, nbt);
        });
        for (Biome biome : ForgeRegistries.BIOMES) {
            // public <C extends net.minecraft.world.gen.feature.IFeatureConfig> void
            // addStructure(net.minecraft.world.gen.feature.ConfiguredFeature<C,? extends
            // net.minecraft.world.gen.feature.structure.Structure<C>> p_226711_1_)
            biome.addStructure(FeatureRegistry.firstBlock.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));// 添加结构
            // public void addFeature(net.minecraft.world.gen.GenerationStage.Decoration
            // p_203611_1_, net.minecraft.world.gen.feature.ConfiguredFeature<?,?>
            // p_203611_2_)
            biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES,
                    FeatureRegistry.firstBlock.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
                            .withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));// 让这个结构可以生成
        }
    }
}
