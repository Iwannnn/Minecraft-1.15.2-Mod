package cn.iwannnn.first_fluid;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RenderTypeRegistry {
    @SubscribeEvent
    public void onRenderTypeSetup(FMLClientSetupEvent event) {
        // public static void
        // setRenderLayer(net.minecraft.fluid.Fluidp_setRenderLayer_0_,
        // net.minecraft.client.renderer.RenderTypep_setRenderLayer_1_) {}
        RenderTypeLookup.setRenderLayer(FluidRegistry.firstFluid.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(FluidRegistry.firstFluidFlowing.get(), RenderType.getTranslucent());
    }

}
