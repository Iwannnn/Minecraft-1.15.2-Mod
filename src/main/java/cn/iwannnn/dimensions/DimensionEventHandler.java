package cn.iwannnn.dimensions;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class DimensionEventHandler {
    public static final ResourceLocation DIMENSION_ID = new ResourceLocation("iwannnn", "iwannnn_dimension");
    public static DimensionType DIMENSION_TYPE;

    @SubscribeEvent
    public static void onDispenserRegister(RegisterDimensionsEvent event) {
        if (DimensionType.byName(DIMENSION_ID) == null) {
            DIMENSION_TYPE = DimensionManager.registerDimension(DIMENSION_ID,
                    ModDimensionRegistry.iwannnnModDimension.get(), null, true);
        }
    }
}
