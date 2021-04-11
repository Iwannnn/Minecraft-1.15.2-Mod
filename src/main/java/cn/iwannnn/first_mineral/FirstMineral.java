package cn.iwannnn.first_mineral;

import cn.iwannnn.first_block.BlockRegistry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.DepthAverageConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FirstMineral {
    @SubscribeEvent
    public static void onSetUpEvent(FMLCommonSetupEvent event) {
        for (Biome biome : ForgeRegistries.BIOMES) {
            // public void addFeature(net.minecraft.world.gen.GenerationStage.Decoration
            // p_203611_1_, net.minecraft.world.gen.feature.ConfiguredFeature<?,?>
            // p_203611_2_)
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                    // public net.minecraft.world.gen.feature.ConfiguredFeature<FC,?>
                    // withConfiguration(FC p_225566_1_)
                    // public
                    // OreFeatureConfig(net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType
                    // p_i51473_1_, net.minecraft.block.BlockState p_i51473_2_, int p_i51473_3_)
                    .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                            BlockRegistry.firstBlock.get().getDefaultState(), 3))
                    // public net.minecraft.world.gen.feature.ConfiguredFeature<?,?>
                    // withPlacement(net.minecraft.world.gen.placement.ConfiguredPlacement<?>
                    // p_227228_1_)
                    // 生成次数，生成高度，生成范围
                    .withPlacement(Placement.COUNT_DEPTH_AVERAGE.configure(new DepthAverageConfig(30, 30, 20))));
        }
    }
}
