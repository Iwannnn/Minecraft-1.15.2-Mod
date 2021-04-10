package cn.iwannnn.first_gui;

import cn.iwannnn.group.ModGroup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;

public class FirstGuiItem extends Item {
    public FirstGuiItem() {
        super(new Properties().group(ModGroup.iwannnnGroup));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (worldIn.isRemote) {
            DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
                OpenGui.openGUI();

            });
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
