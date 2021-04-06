package cn.iwannnn.hello_block;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.StringTextComponent;

public class HelloBlockTileEntity extends TileEntity implements ITickableTileEntity {
    private static final int MAX_TIME = 5 * 20;
    private int timer = 0;

    public HelloBlockTileEntity() {
        super(TileEntityTypeRegistry.helloBlockTilEntity.get());
    }

    @Override
    public void tick() {
        if (!world.isRemote) {
            if (timer == MAX_TIME) {
                PlayerEntity player = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 10, false);
                StringTextComponent stringTextComponent = new StringTextComponent("HELLO");
                if (player != null) {
                    player.sendMessage(stringTextComponent);
                }
                timer = 0;
            }
            timer++;
            ;
        }
    }
}
