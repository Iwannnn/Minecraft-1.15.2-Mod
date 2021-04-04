package cn.iwannnn.counter_block;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, "iwannnn");
    public static final RegistryObject<Block> counterBlockTileEntity =
        BLOCKS.register("counter_block", () -> { return new CounterBlock(); });
}