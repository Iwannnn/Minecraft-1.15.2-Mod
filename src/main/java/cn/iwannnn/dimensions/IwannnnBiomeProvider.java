package cn.iwannnn.dimensions;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;

import java.util.*;

public class IwannnnBiomeProvider extends BiomeProvider {
    private static final List<Biome> BIOMES = new ArrayList<>(Arrays.asList(Biomes.PLAINS, Biomes.OCEAN));// 两种生物群系
    private Random random;

    protected IwannnnBiomeProvider() {
        super(new HashSet<>(BIOMES));
        random = new Random();
    }

    @Override // 给指定位置随机返回生物群系
    public Biome getNoiseBiome(int x, int y, int z) {
        return BIOMES.get(random.nextInt(2));
    }
}
