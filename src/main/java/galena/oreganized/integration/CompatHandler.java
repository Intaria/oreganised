package galena.oreganized.integration;

import galena.oreganized.integration.farmersdelight.FDCompatRegistry;
import galena.oreganized.integration.modestmining.MMCompatRegistry;
import galena.oreganized.integration.nethersdelight.NDCompatRegistry;
import galena.oreganized.integration.quark.QCompatRegistry;
import galena.oreganized.integration.shieldexp.SECompatRegistry;
import galena.oreganized.integration.tconstruct.TCCompatRegistry;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CompatHandler {

    public static final boolean farmersDelight;
    public static final boolean shieldexp;
    public static final boolean nethersdelight;
    public static final boolean quark;
    public static final boolean modestmining;
    public static final boolean tinkersConstruct;

    static {
        ModList mods = ModList.get();

        farmersDelight = mods.isLoaded("farmersdelight");
        shieldexp = mods.isLoaded("shieldexp");
        nethersdelight = mods.isLoaded("nethersdelight");
        quark = mods.isLoaded("quark");
        modestmining = mods.isLoaded("modestmining");
        tinkersConstruct = mods.isLoaded("tconstruct");
    }

    public static void register() {
        if (farmersDelight) FDCompatRegistry.register();
        if (shieldexp) SECompatRegistry.register();
        if (nethersdelight) NDCompatRegistry.register();
        //if (quark) QCompatRegistry.register();
        if (modestmining) MMCompatRegistry.register();
        if (tinkersConstruct) TCCompatRegistry.register();
    }
}
