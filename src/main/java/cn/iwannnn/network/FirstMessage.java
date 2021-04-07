package cn.iwannnn.network;

import cn.iwannnn.group.ModGroup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.PacketDistributor;

public class FirstMessage extends Item {
    public FirstMessage() {
        super(new Properties().group(ModGroup.iwannnnGroup));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (worldIn.isRemote) {
            Networking.INSTANCE.sendToServer(new SendPack("From the Client"));
        }
        if (!worldIn.isRemote) {
            Networking.INSTANCE.send(PacketDistributor.PLAYER.with(() -> {
                return (ServerPlayerEntity) playerIn;// 明确向哪个客户端发送数据
            }), new SendPack("From Server"));
        }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}