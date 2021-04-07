package cn.iwannnn.flying_sword;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypeRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE = new DeferredRegister<>(ForgeRegistries.ENTITIES,
            "iwannnn");
    public static RegistryObject<EntityType<FlyingSwordEntity>> flyingSwordEntity = ENTITY_TYPE.register("flying_sword",
            () -> {
                return EntityType.Builder.create((EntityType<FlyingSwordEntity> entityType, World world) -> {
                    return new FlyingSwordEntity(entityType, world);
                }, EntityClassification.MISC).size(3, 0.5F).build("flying_sword");
            });
}
