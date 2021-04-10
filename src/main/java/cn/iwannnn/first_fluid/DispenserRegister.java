package cn.iwannnn.first_fluid;

import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DispenserRegister {
    @SubscribeEvent
    public static void onDispenserRegister(FMLClientSetupEvent event) {
        // public static void registerDispenseBehavior(net.minecraft.util.IItemProvider
        // p_199774_0_, net.minecraft.dispenser.IDispenseItemBehavior p_199774_1_) {}
        DispenserBlock.registerDispenseBehavior(ItemRegistry.firstFluidBucket.get(), new DefaultDispenseItemBehavior() {
            private final DefaultDispenseItemBehavior dispenseItemBehavior = new DefaultDispenseItemBehavior();

            public ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
                BucketItem buckItem = (BucketItem) stack.getItem();
                BlockPos blockPos = source.getBlockPos().offset(source.getBlockState().get(DispenserBlock.FACING));
                World world = source.getWorld();
                // public boolean
                // tryPlaceContainedLiquid(net.minecraft.entity.player.PlayerEntity p_180616_1_,
                // net.minecraft.world.World p_180616_2_, net.minecraft.util.math.BlockPos
                // p_180616_3_, net.minecraft.util.math.BlockRayTraceResult p_180616_4_)
                if (buckItem.tryPlaceContainedLiquid(null, world, blockPos, null)) {
                    buckItem.tryPlaceContainedLiquid(null, world, blockPos, null);
                    return new ItemStack(Items.BUCKET);
                } else {
                    // public final net.minecraft.item.ItemStack
                    // dispense(net.minecraft.dispenser.IBlockSource p_dispense_1_,
                    // net.minecraft.item.ItemStack p_dispense_2_)
                    return this.dispenseItemBehavior.dispense(source, stack);
                }
            }
        });
    }
}
