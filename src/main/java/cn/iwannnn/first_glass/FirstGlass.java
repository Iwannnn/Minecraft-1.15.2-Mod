package cn.iwannnn.first_glass;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class FirstGlass extends Block {
    public FirstGlass() {
        super(Properties.create(Material.ROCK).hardnessAndResistance(5).notSolid());
    }
}
