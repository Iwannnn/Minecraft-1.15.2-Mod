package cn.iwannnn.hidden_block;

import java.util.*;
import javax.annotation.Nullable;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.model.BakedQuad;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ILightReader;
import net.minecraftforge.client.model.data.IModelData;
import net.minecraftforge.client.model.data.ModelDataMap;
import net.minecraftforge.client.model.data.ModelProperty;

public class HiddenBlockModel implements IBakedModel {
    IBakedModel defaultModel;
    public static ModelProperty<BlockState> COPIED_BLOCK = new ModelProperty<>();

    public HiddenBlockModel(IBakedModel existingModel) {
        defaultModel = existingModel;
    }

    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, Random rand, IModelData extraData) {
        IBakedModel renderModel = defaultModel;
        if (extraData.hasProperty(COPIED_BLOCK)) {
            BlockState copiedBlock = extraData.getData(COPIED_BLOCK);
            if (copiedBlock != null) {
                Minecraft mc = Minecraft.getInstance();
                BlockRendererDispatcher blockRendererDispatcher = mc.getBlockRendererDispatcher();
                renderModel = blockRendererDispatcher.getModelForState(copiedBlock);
            }
        }
        return renderModel.getQuads(state, side, rand, extraData);
    }

    @Override
    public IModelData getModelData(ILightReader world, BlockPos pos, BlockState state, IModelData tileData) {
        BlockState downBlockState = world.getBlockState(pos.down());
        ModelDataMap modelDataMap = new ModelDataMap.Builder().withInitial(COPIED_BLOCK, null).build();

        if (downBlockState.getBlock() == Blocks.AIR || downBlockState.getBlock() == BlockRegistry.hiddenBlock.get()) {
            return modelDataMap;
        }
        modelDataMap.setData(COPIED_BLOCK, downBlockState);
        return modelDataMap;
    }

    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, Random rand) {
        throw new AssertionError("IBakedModel::getQuads should never be called, only IForgeBakedModel::getQuads");
    }

    @Override
    public boolean isAmbientOcclusion() {
        return defaultModel.isAmbientOcclusion();
    }

    @Override
    public boolean isGui3d() {
        return defaultModel.isGui3d();
    }

    @Override
    public boolean func_230044_c_() {
        return defaultModel.func_230044_c_();
    }

    @Override
    public boolean isBuiltInRenderer() {
        return defaultModel.isBuiltInRenderer();
    }

    @Override
    public TextureAtlasSprite getParticleTexture() {
        return defaultModel.getParticleTexture();
    }

    @Override
    public ItemOverrideList getOverrides() {
        return defaultModel.getOverrides();
    }
}
