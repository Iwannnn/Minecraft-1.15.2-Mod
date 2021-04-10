package cn.iwannnn.first_fluid;

import cn.iwannnn.group.ModGroup;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static net.minecraft.item.Items.BUCKET;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, "iwannnn");
    public static RegistryObject<Item> firstFluidBucket = ITEMS.register("first_fluid_bucket", () -> {
        return new BucketItem(FluidRegistry.firstFluid,
                new Item.Properties().group(ModGroup.iwannnnGroup).containerItem(BUCKET));

    });
}
