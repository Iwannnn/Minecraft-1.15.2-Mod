package cn.iwannnn.first_animal;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class FirstAnimalRender extends MobRenderer<FirstAnimal, FirstAnimalModel> {
    public FirstAnimalRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new FirstAnimalModel(), 1F);
    }

    public FirstAnimalRender(EntityRendererManager renderManagerIn, FirstAnimalModel entityModelI, float shadowSizeIn) {
        super(renderManagerIn, entityModelI, shadowSizeIn);
    }

    @Override
    public ResourceLocation getEntityTexture(FirstAnimal entity) {
        return new ResourceLocation("iwannnn", "textures/entity/first_animal.png");
    }
}
