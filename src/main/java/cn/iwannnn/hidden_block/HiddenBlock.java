package cn.iwannnn.hidden_block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class HiddenBlock extends Block {
    public HiddenBlock() {
        super(Properties.create(Material.ROCK).hardnessAndResistance(5).notSolid());
    }
}
