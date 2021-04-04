package cn.iwannnn.counter_block;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.system.CallbackI.P;

public class CounterBlockTileEntity extends TileEntity {
    private int counter = 0;

    public CounterBlockTileEntity() {
        super(TileEntityTypeRegistry.counterBlockTileEntity.get());
    }

    public int increase() {
        counter++;
        markDirty();
        return counter;
    }

    @Override
    public void read(CompoundNBT compound) {
        counter = compound.getInt("counter");
        super.read(compound);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.putInt("counter", counter);
        return super.write(compound);
    }
}
