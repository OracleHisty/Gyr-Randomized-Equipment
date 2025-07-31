package net.oraclehisty.gyr_randomized.utility;

import net.minecraft.core.Holder;

import java.util.function.Supplier;

public interface EntryRegister<T> {
    public <V extends T> Holder<V> holder(String name, Supplier<V> supplier);
}
