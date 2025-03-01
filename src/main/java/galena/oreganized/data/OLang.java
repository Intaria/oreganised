package galena.oreganized.data;

import galena.oreganized.Oreganized;
import galena.oreganized.data.provider.OLangProvider;
import galena.oreganized.index.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

import java.util.function.Supplier;

public class OLang extends OLangProvider {

    public OLang(DataGenerator gen) {
        super(gen, Oreganized.MOD_ID, "en_us");
    }
    @Override
    protected void addTranslations() {
        addItem(OItems.SHRAPNEL_BOMB_MINECART, "Minecart with Shrapnel Bomb");

        addBlock(OBlocks.RAW_SILVER_BLOCK, "Block of Raw Silver");
        addBlock(OBlocks.RAW_LEAD_BLOCK, "Block of Raw Lead");
        addBlock(OBlocks.SILVER_BLOCK, "Block of Silver");
        addBlock(OBlocks.LEAD_BLOCK, "Block of Lead");
        addBlock(OBlocks.ELECTRUM_BLOCK, "Block of Electrum");

        addEffect(OEffects.STUNNING, "Stunning");
        addPotion(OPotions.STUNNING, "Stunning");

        addAdvTitle("story.melting_point", "Melting Point");
        addAdvDesc("story.melting_point", "Pick up Molten Lead from a cauldron");
        addAdvTitle("story.obtain_silver", "Every Stone has a Silver Lining");
        addAdvDesc("story.obtain_silver", "Smelt Raw Silver");
        addAdvTitle("story.electrum_gear", "Cover me in... Wings?");
        addAdvDesc("story.electrum_gear", "Obtain a full set of electrum armor");
        addAdvTitle("story.eat_with_lead", "Like the Romans");
        addAdvDesc("story.eat_with_lead", "Eat anything with lead in your hotbar");

        // JEED compat
        add("effect.oreganized.stunning.description", "Paralyzes the victim periodically with random intervals");

        addSubtitle("entity", "shrapnel_bomb.primed", "Shrapnel Bomb fizzes");

        add("tooltip.oreganized.wip.title", "Work In Progress");
        add("tooltip.oreganized.wip.description", "Usages for this item will be available in a future release");

        /*
            Automatically create translations for blocks and items based on their registry name.

            This must be at the very bottom to avoid overwriting errors. These functions ignore objects
            that have already been translated above.
         */
        for (Supplier<? extends Block> blocks : OBlocks.BLOCKS.getEntries()) {
            tryBlock(blocks);
        }
        for (Supplier<? extends Item> items : OItems.ITEMS.getEntries()) {
            tryItem(items);
        }
        for (Supplier<? extends Fluid> fluids : OFluids.FLUIDS.getEntries()) {
            tryFluid(fluids);
        }
        for (Supplier<? extends EntityType<?>> entities : OEntityTypes.ENTITIES.getEntries()) {
            tryEntity(entities);
        }
    }
}
