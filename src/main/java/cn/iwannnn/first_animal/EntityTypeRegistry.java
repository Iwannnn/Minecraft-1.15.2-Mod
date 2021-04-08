package cn.iwannnn.first_animal;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypeRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE = new DeferredRegister<>(ForgeRegistries.ENTITIES,
            "iwannnn");
    public static RegistryObject<EntityType<FirstAnimal>> firstAnimal = ENTITY_TYPE.register("first_animal", () -> {
        return EntityType.Builder.create((EntityType<FirstAnimal> entityType, World world) -> {
            return new FirstAnimal(entityType, world);
        }, EntityClassification.MISC).size(3, 0.5F).build("first_animal");
    });
}
