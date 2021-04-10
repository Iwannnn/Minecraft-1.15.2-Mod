package cn.iwannnn.first_fluid;

import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FluidRegistry {
    public static final ResourceLocation STILL_OIL_TEXTURE = new ResourceLocation("iwannnn:block/fluid/water_still");
    public static final ResourceLocation FLOWING_OIL_TEXTURE = new ResourceLocation("iwannnn:block/fluid/water_flow");
    public static final DeferredRegister<Fluid> FLUIDS = new DeferredRegister<>(ForgeRegistries.FLUIDS, "iwannnn");
    // 流体需要注册两个部分，source和flowing
    public static RegistryObject<FlowingFluid> firstFluid = FLUIDS.register("first_fluid", () -> {
        return new ForgeFlowingFluid.Source(FluidRegistry.PROPERTIES);

    });
    public static RegistryObject<FlowingFluid> firstFluidFlowing = FLUIDS.register("first_fluid_flowing", () -> {
        return new ForgeFlowingFluid.Flowing(FluidRegistry.PROPERTIES);
    });
    public static ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(firstFluid,
            firstFluidFlowing,
            FluidAttributes.builder(STILL_OIL_TEXTURE, FLOWING_OIL_TEXTURE).color(0xffffffff).density(10)
                    .viscosity(4000))// 对应的材质 颜色（ARGB）稠度
                            .bucket(ItemRegistry.firstFluidBucket).block(BlockRegistry.firstFluidBlock)// 对应的桶和方块
                            .slopeFindDistance(3).explosionResistance(100F);// 水流消失速度和防爆等级

}