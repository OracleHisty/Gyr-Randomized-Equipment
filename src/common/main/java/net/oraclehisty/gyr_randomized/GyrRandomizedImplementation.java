package net.oraclehisty.gyr_randomized;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.oraclehisty.gyr_randomized.utility.EntryRegister;

public interface GyrRandomizedImplementation {
    <T> EntryRegister<T> entryRegister(Registry<T> registry, ResourceKey<Registry<T>> resourceKey);
}
