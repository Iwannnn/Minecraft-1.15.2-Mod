package cn.iwannnn.zombie_block;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.util.Constants;

public class ZombieBlockTileEntity extends TileEntity implements ITickableTileEntity {
    private boolean flag = false;
    private int MAX_TIME = 5 * 20;
    private int timer = 0;

    public ZombieBlockTileEntity() {
        super(TileEntityTypeRegistry.zombieBlockTileEntity.get());
    }

    @Override
    public void tick() {
        if (world.isRemote && flag) { //客户端
            PlayerEntity player = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 10, false);
            this.world.playSound(player, pos, SoundEvents.ENTITY_ZOMBIE_AMBIENT, SoundCategory.AMBIENT, 1.0f, 1.0f);
            flag = false;
        }
        if (!world.isRemote) { //服务端
            if (timer == MAX_TIME) {
                flag = true;
                world.notifyBlockUpdate(pos, getBlockState(), getBlockState(),
                                        Constants.BlockFlags.BLOCK_UPDATE); //需要触发数据同步时调用这个方法
                flag = true;
                timer = 0;
            }
            timer++;
        }
    }

    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(pos, 1, getUpdateTag());
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        handleUpdateTag(pkt.getNbtCompound());
    }

    //这两个复写的方法是在区块被调用时的方法
    @Override
    public CompoundNBT getUpdateTag() {
        CompoundNBT compoundNBT = super.getUpdateTag();
        compoundNBT.putBoolean("flag", flag);
        return compoundNBT;
    }

    @Override
    public void handleUpdateTag(CompoundNBT tag) {
        flag = tag.getBoolean("flag");
    }
}