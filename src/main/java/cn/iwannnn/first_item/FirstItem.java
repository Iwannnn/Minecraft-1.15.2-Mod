package cn.iwannnn.first_item;

import cn.iwannnn.group.ModGroup;
import net.minecraft.item.Item;

public class FirstItem extends Item {

    public FirstItem() {
        // public Item(Item.Properties p_i48487_1_)
        // public Item.Properties tab(ItemGroup p_200916_1_)
        // public static final ItemGroup TAB_MATERIALS = TAB_MISC;
        super(new Properties().group(ModGroup.firstGroup));
    }
}
