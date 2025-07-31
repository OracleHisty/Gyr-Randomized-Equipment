package net.oraclehisty.gyr_randomized;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.oraclehisty.gyr_randomized.utility.EntryRegister;

import java.util.function.Supplier;

@Mod(GyrRandomized.MODID)
public class ForgeGyrRandomized implements GyrRandomizedImplementation {
    private IEventBus bus;

    public ForgeGyrRandomized(IEventBus bus) {
        this.bus = bus;
        GyrRandomized.init(this);
    }

    @Override
    public <T> EntryRegister<T> entryRegister(Registry<T> registry, ResourceKey<Registry<T>> resourceKey) {
        return new NeoForgeEntryRegister<>(registry, bus);
    }

    private static class NeoForgeEntryRegister<T> implements EntryRegister<T> {
        private final DeferredRegister<T> defferedRegister;

        public NeoForgeEntryRegister(Registry<T> resourceKey, IEventBus bus) {
             defferedRegister = DeferredRegister.create(resourceKey, GyrRandomized.MODID);
             defferedRegister.register(bus);
        }

        @Override
        public <V extends T> net.minecraft.core.Holder<V> holder(String name, Supplier<V> supplier) {
            return (Holder<V>) defferedRegister.register(name, supplier);
        }
    }
}
