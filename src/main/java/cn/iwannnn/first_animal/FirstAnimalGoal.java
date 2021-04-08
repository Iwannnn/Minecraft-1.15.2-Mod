package cn.iwannnn.first_animal;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FirstAnimalGoal extends Goal {
    private FirstAnimal firstAnimal;

    public FirstAnimalGoal(FirstAnimal firstAnimal) {
        this.firstAnimal = firstAnimal;
    }

    @Override
    public boolean shouldExecute() {
        World world = this.firstAnimal.getEntityWorld();
        if (!world.isRemote) {
            BlockPos blockPos = this.firstAnimal.getPosition();
            PlayerEntity player = world.getClosestPlayer(blockPos.getX(), blockPos.getY(), blockPos.getZ(), 10, false);
            if (player != null) {// 靠近给玩家一个饥饿效果
                player.addPotionEffect(new EffectInstance(Effects.HUNGER, 3 * 20, 3));
            }
        }
        return true;
    }
}