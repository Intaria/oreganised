package galena.oreganized.index;

import galena.oreganized.Oreganized;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.versions.forge.ForgeVersion;

public class OTags {

    public static class Items {

        public static final TagKey<Item> LEAD_SOURCE = tag("lead_source");
        public static final TagKey<Item> CRYSTAL_GLASS = tag("crystal_glass");
        public static final TagKey<Item> CRYSTAL_GLASS_PANES = tag("crystal_glass_panes");
        public static final TagKey<Item> LIGHTER_THAN_LEAD = tag("lighter_than_lead");
        public static final TagKey<Item> STONE_TYPES_GLANCE = tag("stone_types/glance");

        public static final TagKey<Item> RAW_MATERIALS_SILVER = forgeTag("raw_materials/silver");
        public static final TagKey<Item> RAW_MATERIALS_LEAD = forgeTag("raw_materials/lead");

        public static final TagKey<Item> INGOTS_SILVER = forgeTag("ingots/silver");
        public static final TagKey<Item> INGOTS_LEAD = forgeTag("ingots/lead");
        public static final TagKey<Item> INGOTS_ELECTRUM = forgeTag("ingots/electrum");

        public static final TagKey<Item> NUGGETS_SILVER = forgeTag("nuggets/silver");
        public static final TagKey<Item> NUGGETS_LEAD = forgeTag("nuggets/lead");
        public static final TagKey<Item> NUGGETS_ELECTRUM = forgeTag("nuggets/electrum");
        public static final TagKey<Item> NUGGETS_NETHERITE = forgeTag("nuggets/netherite");

        public static final TagKey<Item> ORES_SILVER = forgeTag("ores/silver");
        public static final TagKey<Item> ORES_LEAD = forgeTag("ores/lead");

        public static final TagKey<Item> STORAGE_BLOCKS_SILVER = forgeTag("storage_blocks/silver");
        public static final TagKey<Item> STORAGE_BLOCKS_LEAD = forgeTag("storage_blocks/lead");
        public static final TagKey<Item> STORAGE_BLOCKS_ELECTRUM = forgeTag("storage_blocks/electrum");

        public static final TagKey<Item> STORAGE_BLOCKS_RAW_SILVER = forgeTag("storage_blocks/raw_silver");
        public static final TagKey<Item> STORAGE_BLOCKS_RAW_LEAD = forgeTag("storage_blocks/raw_lead");
        public static final TagKey<Item> BUCKETS_MOLTEN_LEAD = forgeTag("buckets/molten_lead");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(Oreganized.modLoc(name));
        }
        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation(ForgeVersion.MOD_ID, name));
        }
    }

    public static class Blocks {

        public static final TagKey<Block> ENGRAVABLE = tag("engravable");
        public static final TagKey<Block> ENGRAVABLE_NEEDS_PLATE = tag("engravable/needs_plate");
        public static final TagKey<Block> FIRE_SOURCE = tag("fire_source");
        public static final TagKey<Block> CRYSTAL_GLASS = tag("crystal_glass");
        public static final TagKey<Block> CRYSTAL_GLASS_PANES = tag("crystal_glass_panes");
        public static final TagKey<Block> STONE_TYPES_GLANCE = tag("stone_types/glance");

        public static final TagKey<Block> ORES_SILVER = forgeTag("ores/silver");
        public static final TagKey<Block> ORES_LEAD = forgeTag("ores/lead");

        public static final TagKey<Block> STORAGE_BLOCKS_SILVER = forgeTag("storage_blocks/silver");
        public static final TagKey<Block> STORAGE_BLOCKS_LEAD = forgeTag("storage_blocks/lead");
        public static final TagKey<Block> STORAGE_BLOCKS_ELECTRUM = forgeTag("storage_blocks/electrum");

        public static final TagKey<Block> STORAGE_BLOCKS_RAW_SILVER = forgeTag("storage_blocks/raw_silver");
        public static final TagKey<Block> STORAGE_BLOCKS_RAW_LEAD = forgeTag("storage_blocks/raw_lead");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(Oreganized.modLoc(name));
        }
        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation(ForgeVersion.MOD_ID, name));
        }
    }

    public static class Entities {

        public static final TagKey<EntityType<?>> LIGHTER_THAN_LEAD = tag("lighter_than_lead");

        private static TagKey<EntityType<?>> tag(String name) {
            return EntityTypeTags.create(Oreganized.modLoc(name).toString());
        }
    }

    public static class Fluids {

        public static final TagKey<Fluid> MOLTEN_LEAD = forgeTag("molten_lead");

        private static TagKey<Fluid> tag(String name) {
            return FluidTags.create(Oreganized.modLoc(name));
        }

        private static TagKey<Fluid> forgeTag(String name) {
            return FluidTags.create(new ResourceLocation(ForgeVersion.MOD_ID, name));
        }
    }

    public static class Biomes {

        public static final TagKey<Biome> HAS_BOULDER = tag("has_structure/boulder");
        public static final TagKey<Biome> RICH_IN_LEAD_ORE = tag("rich_in_lead_ore");

        private static TagKey<Biome> tag(String name) {
            return BiomeTags.create(Oreganized.modLoc(name).toString());
        }
    }
}
