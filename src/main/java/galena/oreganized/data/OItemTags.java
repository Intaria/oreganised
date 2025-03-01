package galena.oreganized.data;

import galena.oreganized.Oreganized;
import galena.oreganized.index.OBlocks;
import galena.oreganized.index.OItems;
import galena.oreganized.index.OTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

import static galena.oreganized.index.OTags.Items.*;

public class OItemTags extends ItemTagsProvider {

    public OItemTags(DataGenerator generator, BlockTagsProvider provider, @Nullable ExistingFileHelper helper) {
        super(generator, provider, Oreganized.MOD_ID, helper);
    }

    @Override
    public String getName() {
        return "Oreganized Item Tags";
    }

    @Override
    protected void addTags() {
        // Oreganized
        tag(LEAD_SOURCE).addTags(INGOTS_LEAD, NUGGETS_LEAD, ORES_LEAD).add(
                OItems.MOLTEN_LEAD_BUCKET.get()
        );
        copy(OTags.Blocks.CRYSTAL_GLASS, CRYSTAL_GLASS);
        copy(OTags.Blocks.CRYSTAL_GLASS_PANES, CRYSTAL_GLASS_PANES);
        tag(LIGHTER_THAN_LEAD).add(Items.IRON_BOOTS);
        copy(OTags.Blocks.STONE_TYPES_GLANCE, STONE_TYPES_GLANCE);

        // Oreganized Forge
        tag(RAW_MATERIALS_SILVER).add(OItems.RAW_SILVER.get());
        tag(RAW_MATERIALS_LEAD).add(OItems.RAW_LEAD.get());

        tag(INGOTS_SILVER).add(OItems.SILVER_INGOT.get());
        tag(INGOTS_LEAD).add(OItems.LEAD_INGOT.get());
        tag(INGOTS_ELECTRUM).add(OItems.ELECTRUM_INGOT.get());

        tag(NUGGETS_SILVER).add(OItems.SILVER_NUGGET.get());
        tag(NUGGETS_LEAD).add(OItems.LEAD_NUGGET.get());
        tag(NUGGETS_ELECTRUM).add(OItems.ELECTRUM_NUGGET.get());
        tag(NUGGETS_NETHERITE).add(OItems.NETHERITE_NUGGET.get());

        tag(BUCKETS_MOLTEN_LEAD).add(OItems.MOLTEN_LEAD_BUCKET.get());


        copy(OTags.Blocks.ORES_SILVER, ORES_SILVER);
        copy(OTags.Blocks.ORES_LEAD, ORES_LEAD);

        copy(OTags.Blocks.STORAGE_BLOCKS_SILVER, STORAGE_BLOCKS_SILVER);
        copy(OTags.Blocks.STORAGE_BLOCKS_LEAD, STORAGE_BLOCKS_LEAD);
        copy(OTags.Blocks.STORAGE_BLOCKS_ELECTRUM, STORAGE_BLOCKS_ELECTRUM);

        copy(OTags.Blocks.STORAGE_BLOCKS_RAW_SILVER, STORAGE_BLOCKS_RAW_SILVER);
        copy(OTags.Blocks.STORAGE_BLOCKS_RAW_LEAD, STORAGE_BLOCKS_RAW_LEAD);

        // Vanilla
        copy(BlockTags.WALLS, ItemTags.WALLS);
        copy(BlockTags.STAIRS, ItemTags.STAIRS);
        copy(BlockTags.SLABS, ItemTags.SLABS);
        tag(ItemTags.BEACON_PAYMENT_ITEMS).add(OItems.ELECTRUM_INGOT.get());

        // Forge
        tag(Tags.Items.NUGGETS).addTags(NUGGETS_SILVER, NUGGETS_LEAD, NUGGETS_ELECTRUM, NUGGETS_NETHERITE);
        tag(Tags.Items.INGOTS).addTags(INGOTS_SILVER, INGOTS_LEAD, INGOTS_ELECTRUM);
        tag(Tags.Items.ORES).addTags(ORES_SILVER, ORES_LEAD);
        tag(Tags.Items.STORAGE_BLOCKS).addTags(STORAGE_BLOCKS_SILVER, STORAGE_BLOCKS_LEAD, STORAGE_BLOCKS_ELECTRUM);
        tag(Tags.Items.GLASS).addTags(CRYSTAL_GLASS);
        tag(Tags.Items.GLASS_PANES).addTags(CRYSTAL_GLASS_PANES);
        tag(Tags.Items.RAW_MATERIALS).addTags(RAW_MATERIALS_SILVER, RAW_MATERIALS_LEAD);
        copy(Tags.Blocks.ORES_IN_GROUND_STONE, Tags.Items.ORES_IN_GROUND_STONE);
        copy(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE, Tags.Items.ORES_IN_GROUND_DEEPSLATE);
    }
}
