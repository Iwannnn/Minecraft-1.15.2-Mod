package cn.iwannnn.dimensions;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.WorldGenRegion;

public class IwannnnChunkGenerate extends ChunkGenerator<GenerationSettings> {
    public IwannnnChunkGenerate(IWorld world, BiomeProvider provider) {
        super(world, provider, createDefault());
    }

    public static GenerationSettings createDefault() {// 创建默认的settings
        GenerationSettings config = new GenerationSettings();
        config.setDefaultBlock(Blocks.DIAMOND_BLOCK.getDefaultState());
        config.setDefaultFluid(Blocks.LAVA.getDefaultState());
        return config;
    }

    @Override
    public void generateSurface(WorldGenRegion region, IChunk chunk) {
        BlockState bedrock = Blocks.BEDROCK.getDefaultState();
        BlockState stone = Blocks.STONE.getDefaultState();
        ChunkPos chunkPos = chunk.getPos();

        BlockPos.Mutable pos = new BlockPos.Mutable();

        int x, z;

        for (x = 0; x < 16; x++) {
            for (z = 0; z < 16; z++) {
                int realx = chunkPos.x * 16 + x;
                int realz = chunkPos.z * 16 + z;
                int height = (int) (65 + Math.sin(realx / 20.0f) * 10 + Math.cos(realz / 20.0f) * 10);
                for (int y = 1; y < height; y++) {
                    chunk.setBlockState(pos.setPos(x, y, z), stone, false);
                }
            }
        } // 生成地形
    }

    @Override
    public int getGroundHeight() {
        return world.getSeaLevel() + 1;
    }

    @Override
    public void makeBase(IWorld worldIn, IChunk chunkIn) {
        return;
    }

    @Override
    public int func_222529_a(int p_222529_1_, int p_222529_2_, Heightmap.Type heightMapType) {
        return 0;
    }
}
