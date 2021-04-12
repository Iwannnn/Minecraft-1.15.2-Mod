package cn.iwannnn.dimensions;

import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.ModDimension;

import java.util.function.BiFunction;

public class IwannnnModDimensions extends ModDimension {
    @Override
    public BiFunction<World, DimensionType, ? extends Dimension> getFactory() {
        return (world, type) -> {
            return new IwannnnDimension(world, type);
        };
    }

}
