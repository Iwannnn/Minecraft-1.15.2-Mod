package cn.iwannnn.hidden_block;

import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.BlockModelShapes;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModBusEventHandler {
    @SubscribeEvent
    public static void onModleBaked(ModelBakeEvent event) {
        for (BlockState blockstate : BlockRegistry.hiddenBlock.get().getStateContainer().getValidStates()) {
            ModelResourceLocation modelResourceLocation = BlockModelShapes.getModelLocation(blockstate);
            IBakedModel existingModel = event.getModelRegistry().get(modelResourceLocation);
            if (existingModel == null) {
                throw new RuntimeException("Did not find HiddenBlock in registery");
            } else if (existingModel instanceof HiddenBlockModel) {
                throw new RuntimeException("Tired to replace Hidden Block twice");
            } else {
                HiddenBlockModel hiddenBlockModel = new HiddenBlockModel(existingModel);
                event.getModelRegistry().put(modelResourceLocation, hiddenBlockModel);
            }
        }
    }
}
