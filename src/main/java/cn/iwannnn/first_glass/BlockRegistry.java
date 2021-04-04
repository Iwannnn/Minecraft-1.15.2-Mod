
package cn.iwannnn.first_glass;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, "iwannnn");
    public static final RegistryObject<Block> firstGlass = BLOCKS.register("first_glass", () -> { return new FirstGlass(); });
}