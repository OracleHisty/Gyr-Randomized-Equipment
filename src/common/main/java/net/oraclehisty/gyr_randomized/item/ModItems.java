package net.oraclehisty.gyr_randomized.item;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.oraclehisty.gyr_randomized.utility.PlatformRegistry;

public class ModItems extends PlatformRegistry<Item> {
    public final static ModItems INSTANCE;

    public final Holder<Item> GENERIC_PLACEHOLDER;

    private ModItems() {
        super(Registries.ITEM, BuiltInRegistries.ITEM);

        GENERIC_PLACEHOLDER = create("generic_placeholder", () -> new Item(new Item.Properties()));
    }

    static {
        INSTANCE = new ModItems();
    }
}
