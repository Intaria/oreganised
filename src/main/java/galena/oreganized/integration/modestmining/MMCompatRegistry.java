package galena.oreganized.integration.modestmining;

import com.ncpbails.modestmining.item.ModItems;
import com.ncpbails.modestmining.item.custom.weapons.GlaiveItem;
import com.ncpbails.modestmining.item.custom.weapons.HammerItem;
import com.ncpbails.modestmining.item.custom.weapons.KatanaItem;
import galena.oreganized.content.item.OItem;
import galena.oreganized.index.OItemTiers;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraftforge.registries.RegistryObject;

import static galena.oreganized.index.OItems.ITEMS;

public class MMCompatRegistry {

    public static final RegistryObject<Item> ELECTRUM_GLAIVE = ITEMS.register("electrum_glaive", () -> new GlaiveItem(OItemTiers.ELECTRUM, 3, -3.3F, 3.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> ELECTRUM_KATANA = ITEMS.register("electrum_katana", () -> new KatanaItem(OItemTiers.ELECTRUM, 2, -2.7F, 3.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    
    public static void register() {

    }
}
