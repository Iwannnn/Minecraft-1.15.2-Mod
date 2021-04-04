package cn.iwannnn.first_weapon;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, "iwannnn");
    public static final RegistryObject<Item> firstWeapon = ITEMS.register("first_weapon", () -> { return new FirstWeapon(); });
}
