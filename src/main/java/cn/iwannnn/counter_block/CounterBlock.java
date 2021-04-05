package cn.iwannnn.counter_block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class CounterBlock extends Block {
    public CounterBlock() {
        super(Properties.create(Material.ROCK).hardnessAndResistance(5));
    }

    @Override public boolean hasTileEntity(BlockState state) { //是一个有实体的方块
        return true;
    }

    @Override public TileEntity createTileEntity(BlockState state, IBlockReader world) { //什么样的实体
        return new CounterBlockTileEntity();
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn,
                                             BlockRayTraceResult hit) {
        if (!worldIn.isRemote && handIn == Hand.MAIN_HAND) { // 判断是不是在服务端和手
            CounterBlockTileEntity counterBlockTileEntity = (CounterBlockTileEntity)worldIn.getTileEntity(pos);
            int counter = counterBlockTileEntity.increase();
            TranslationTextComponent translationTextComponent =
                new TranslationTextComponent("message.iwannnn.counter", counter); //对应lang文件里的message
            player.sendStatusMessage(translationTextComponent, false);            //发送给客户端
        }
        return ActionResultType.SUCCESS;
    }
}
