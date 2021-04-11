package cn.iwannnn.diamond_house;

import com.mojang.datafixers.Dynamic;

import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeManager;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.Random;
import java.util.function.Function;

public class DiamondHouse extends Structure<NoFeatureConfig> {
    // public
    // Structure(java.util.function.Function<com.mojang.datafixers.Dynamic<?>,?
    // extends C> p_i51427_1_)
    public DiamondHouse(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
        super(configFactoryIn);
    }

    // public abstract boolean canBeGenerated(net.minecraft.world.biome.BiomeManager
    // arg0, net.minecraft.world.gen.ChunkGenerator<?> arg1, java.util.Random arg2,
    // int arg3, int arg4, net.minecraft.world.biome.Biome arg5);
    @Override
    public boolean canBeGenerated(BiomeManager biomeManagerIn, ChunkGenerator<?> generatorIn, Random randIn, int chunkX,
            int chunkZ, Biome biomeIn) {
        if (randIn.nextFloat() < 0.03) {
            return true;
        }
        return false;
    }

    @Override
    public IStartFactory getStartFactory() {
        return DiamondHouse.Start::new;
    }

    @Override
    public String getStructureName() {
        return "diamond_house";
    }

    @Override // 作用不明 原版好多都是3
    public int getSize() {
        return 3;
    }

    public static class Start extends StructureStart {
        public Start(Structure<?> structure, int chunkPosX, int chunkPosZ, MutableBoundingBox bounds, int reference,
                long seed) {
            super(structure, chunkPosX, chunkPosZ, bounds, reference, seed);
        }

        @Override
        public void init(ChunkGenerator<?> generator, TemplateManager templateManagerIn, int chunkX, int chunkZ,
                Biome biomeIn) {
            DiamondHousePiece diamondHousePiece = new DiamondHousePiece(this.rand, chunkX * 16, chunkZ * 16);
            this.components.add(diamondHousePiece);
            // 先创建一个自定义的StructPiece 添加到Structure自带的components里 给结构添加一个结构组件
            this.recalculateStructureSize();
        }
    }
}
