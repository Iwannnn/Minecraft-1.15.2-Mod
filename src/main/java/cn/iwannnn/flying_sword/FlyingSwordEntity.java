package cn.iwannnn.flying_sword;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class FlyingSwordEntity extends Entity {
    private static final DataParameter<Integer> COUNTER = EntityDataManager.createKey(FlyingSwordEntity.class,
            DataSerializers.VARINT);// 想要同步的数据 必须是static 通过调用EntityDataManager.createKey来创建需要同步的数据，第一个参数是填入实体的类
                                    // 第二个参数是变量如何转换为字节流，interger类型调用DataSerializers,VARINT 其他的数据类型得调用其他的方法

    public FlyingSwordEntity(EntityType<?> entityTypeIn, World worldIn) {
        super(entityTypeIn, worldIn);
    }

    @Override
    protected void registerData() {
        this.dataManager.register(COUNTER, 0);// 注册数据
    }

    @Override
    protected void readAdditional(CompoundNBT compound) {
        this.dataManager.set(COUNTER, compound.getInt("counter"));
    }

    @Override
    protected void writeAdditional(CompoundNBT compound) {
        compound.putInt("counter", this.dataManager.get(COUNTER));
    }

    @Override
    public void tick() {
        // if (world.isRemote) {// 服务端
        // logger.info(this.dataManager.get(COUNTER));
        // }
        // if (!world.isRemote) {// 客户端
        // logger.info(this.dataManager.get(COUNTER));
        // this.dataManager.set(COUNTER, this.dataManager.get(COUNTER));
        // }
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);// 实体在服务端创建后通知客户端船舰涉及到了发包操作在客户端创建实体
    }

}
