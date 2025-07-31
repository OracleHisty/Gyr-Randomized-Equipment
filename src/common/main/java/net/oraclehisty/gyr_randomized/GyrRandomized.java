package net.oraclehisty.gyr_randomized;

import net.minecraft.resources.ResourceLocation;
import net.oraclehisty.gyr_randomized.item.ModItems;

public class GyrRandomized {
    public static final String MODID = "randomized_gyr";

    public static GyrRandomizedImplementation implementation;

    public static ModItems ITEMS;

    public static void init(GyrRandomizedImplementation implementation) {
        GyrRandomized.implementation = implementation;

        ITEMS = new ModItems();
    }

    public static ResourceLocation id(String name) {
        return ResourceLocation.fromNamespaceAndPath(MODID, name);
    }
}
