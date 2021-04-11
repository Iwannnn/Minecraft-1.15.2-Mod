package cn.iwannnn.diamond_house;

import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.ScatteredStructurePiece;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.Random;

public class DiamondHousePiece extends ScatteredStructurePiece {
    private static final DiamondHousePiece.Selector BUILD_STONE_SELECTOR = new DiamondHousePiece.Selector();

    // protected
    // ScatteredStructurePiece(net.minecraft.world.gen.feature.structure.IStructurePieceType
    // p_i51344_1_, java.util.Random p_i51344_2_, int p_i51344_3_, int p_i51344_4_,
    // int p_i51344_5_, int p_i51344_6_, int p_i51344_7_, int p_i51344_8_)
    protected DiamondHousePiece(Random random, int x, int z) {
        super(CommonEventHandler.diamondHousePieceType, random, x, 64, z, 12, 10, 15);
    }

    // protected
    // ScatteredStructurePiece(net.minecraft.world.gen.feature.structure.IStructurePieceType
    // p_i51345_1_, net.minecraft.nbt.CompoundNBT p_i51345_2_)
    protected DiamondHousePiece(TemplateManager templateManagger, CompoundNBT nbt) {
        super(CommonEventHandler.diamondHousePieceType, nbt);
    }

    @Override // 绘制内容
    public boolean create(IWorld worldIn, ChunkGenerator<?> chunkGeneratorIn, Random randomIn,
            MutableBoundingBox mutableBoundingBoxIn, ChunkPos chunkPosIn) {
        this.fillWithRandomizedBlocks(worldIn, mutableBoundingBoxIn, 0, 0, 0, 4, 4, 4, false, randomIn,
                BUILD_STONE_SELECTOR);
        this.fillWithAir(worldIn, mutableBoundingBoxIn, 1, 1, 1, 3, 3, 3);
        this.setBlockState(worldIn, Blocks.ACACIA_TRAPDOOR.getDefaultState().rotate(Rotation.CLOCKWISE_90), 2, 2, 0,
                mutableBoundingBoxIn);
        this.fillWithAir(worldIn, mutableBoundingBoxIn, 2, 1, 0, 2, 1, 0);
        return true;
    }

    static class Selector extends StructurePiece.BlockSelector { // 设置方块的种类
        private Selector() {
        }

        public void selectBlocks(Random rand, int x, int y, int z, boolean wall) {
            this.blockstate = Blocks.DIAMOND_BLOCK.getDefaultState();
        }
    }
}
