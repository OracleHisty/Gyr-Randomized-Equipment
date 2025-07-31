package net.oraclehisty.gyr_randomized;

import net.fabricmc.api.ModInitializer;

public class FabricGyrRandomized implements ModInitializer {
    @Override
    public void onInitialize() {
        GyrRandomized.init();
    }
}
