package net.oraclehisty.gyr_randomized.utility;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.info.RegistryDumpReport;
import net.minecraft.resources.ResourceKey;
import net.oraclehisty.gyr_randomized.GyrRandomized;
import net.oraclehisty.gyr_randomized.GyrRandomizedImplementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

public abstract class PlatformRegistry<T> {
    private final EntryRegister<T> register;
    protected final List<Holder<T>> queue = new ArrayList<>();

    public PlatformRegistry(ResourceKey<Registry<T>> resourceKey, Registry<T> registry) {
        register = GyrRandomized.implementation.entryRegister(registry, resourceKey);
    }

//    /**
//     * Creates a new entry in this registry.
//     *
//     * @param T The type of the entry.
//     * @param name The name of the entry, this will be an [ResourceLocation.path].
//     * @param entry The entry being added.
//     * @return The entry created.
//     */
    public <V extends T> Holder<V> create(String name, Supplier<V> entry) {
        var holder = register.holder(name, entry);
        queue.add((Holder<T>) holder);

        return holder;
    }

    /**
     * Returns a collection of every holder in this registry.
     *
     * @return The holders of this registry.
     */
    public Collection<Holder<T>> allHolders() {
        return this.queue;
    }

    /**
     * Returns a collection of every entry in this registry.
     *
     * @return The entries of this registry.
     */
    public Collection<T> all() {
        return allHolders().stream().map(Holder::value).toList();
    }

    public void init() {

    }
}
