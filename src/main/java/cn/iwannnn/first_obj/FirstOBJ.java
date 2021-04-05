package cn.iwannnn.first_obj;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class FirstOBJ extends Block {
    public FirstOBJ() {
        super(Properties.create(Material.ROCK).hardnessAndResistance(5).notSolid());
    }
}