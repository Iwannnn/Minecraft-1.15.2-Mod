package cn.iwannnn.flying_sword;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;

public class FlyingSwordRender extends EntityRenderer<FlyingSwordEntity> {
    private EntityModel<FlyingSwordEntity> flyingSwordModel;

    public FlyingSwordRender(EntityRendererManager renderManager) {
        super(renderManager);
        flyingSwordModel = new FlyingSwordModel();
    }

    @Override
    public ResourceLocation getEntityTexture(FlyingSwordEntity entity) {
        return new ResourceLocation("iwannnn", "textures/entity/flying_sword.png");
    }

    @Override
    public void render(FlyingSwordEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
            IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);// 必须要调用父类的渲染方法
        matrixStackIn.push();// 对于模型的操作的数据都会存放在这个里面 要保存上一次嗲所使用这个再在渲染结束时回复他。
        matrixStackIn.rotate(Vector3f.YN.rotationDegrees(45));// 将模型旋转45°
        IVertexBuilder ivertexbuilder = bufferIn
                .getBuffer(this.flyingSwordModel.getRenderType(this.getEntityTexture(entityIn)));// 构建顶点，模型在渲染是会被分解成一个个顶点，保存数据构成最宠的模型
        this.flyingSwordModel.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F,
                1.0F, 1.0F, 1.0F);// 调用模型的render渲染方块
        matrixStackIn.pop();
    }
}
