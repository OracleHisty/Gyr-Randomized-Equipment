package net.oraclehisty.gyr_randomized;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(GyrRandomized.MODID)
public class ForgeGyrRandomized {
    public ForgeGyrRandomized(IEventBus bus) {
        GyrRandomized.init();
    }
}
