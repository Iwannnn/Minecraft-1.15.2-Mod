package cn.iwannnn.first_weapon;

import cn.iwannnn.first_item.ItemRegistry;
import cn.iwannnn.group.ModGroup;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;

public class FirstWeapon extends SwordItem {
    private static IItemTier itemTier = new IItemTier() {
        @Override
        public int getMaxUses() {
            return 2000;
        }

        @Override
        public float getEfficiency() {
            return 10.0F;
        }

        @Override
        public float getAttackDamage() {
            return 4.0F;
        }

        @Override
        public int getHarvestLevel() {
            return 3;
        }

        @Override
        public int getEnchantability() {
            return 30;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return Ingredient.fromItems(ItemRegistry.firstItem.get());
        }
    };

    public FirstWeapon() {
        super(itemTier, 3, -2.4F, new Item.Properties().group(ModGroup.iwannnnGroup));
    }
}
