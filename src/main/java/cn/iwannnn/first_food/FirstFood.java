package cn.iwannnn.first_food;

import cn.iwannnn.group.ModGroup;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class FirstFood extends Item {
    private static EffectInstance effectInstance = new EffectInstance(Effects.POISON, 3 * 20, 1);
    private static Food food = (new Food.Builder()).saturation(10).hunger(20).effect(effectInstance, 1).build();
    public FirstFood() {
        super(new Properties().food(food).group((ModGroup.iwannnnGroup)));
    }
}
