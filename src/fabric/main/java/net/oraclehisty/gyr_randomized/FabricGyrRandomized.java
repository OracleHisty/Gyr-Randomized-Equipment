package net.oraclehisty.gyr_randomized;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.oraclehisty.gyr_randomized.utility.EntryRegister;

import java.util.function.Supplier;

public class FabricGyrRandomized implements ModInitializer, GyrRandomizedImplementation {
    @Override
    public void onInitialize() {
        GyrRandomized.init(this);
    }

    @Override
    public <T> EntryRegister<T> entryRegister(Registry<T> registry, ResourceKey<Registry<T>> resourceKey) {
        return new FabricEntryRegister<>(registry);
    }

    private record FabricEntryRegister<T>(Registry<T> registry) implements EntryRegister<T> {
        @Override
        public <V extends T> Holder<V> holder(String name, Supplier<V> supplier) {
            return (Holder<V>) Registry.registerForHolder(registry, GyrRandomized.id(name), supplier.get());
        }
    }
}
