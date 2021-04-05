package cn.iwannnn.group;

import cn.iwannnn.first_item.ItemRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class IwannnnGroup extends ItemGroup {
    public IwannnnGroup() {
        super("first_group");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemRegistry.firstItem.get());
    }
}
