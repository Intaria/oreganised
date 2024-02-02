package galena.oreganized.data;

import galena.oreganized.index.OBlocks;
import galena.oreganized.index.OEffects;
import galena.oreganized.index.OItems;
import galena.oreganized.index.OTags;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.Set;
import java.util.function.Consumer;

public class OAdvancements extends AdvancementProvider {

    public OAdvancements(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, helper);
    }

    @Override
    public String getName() {
        return "Oreganized Advancements";
    }

    @Override
    protected void registerAdvancements(Consumer<Advancement> consumer, ExistingFileHelper helper) {
        new Advancements().accept(consumer);
    }

    static class Advancements implements Consumer<Consumer<Advancement>> {

        @Override
        public void accept(Consumer<Advancement> consumer) {
            Advancement eat_with_lead = Advancement.Builder.advancement()
                    .parent(getAdv("minecraft:story/upgrade_tools"))
                    .display(
                            OItems.LEAD_INGOT.get(),
                            Component.translatable("advancements.story.eat_with_lead.title"),
                            Component.translatable("advancements.story.eat_with_lead.description"),
                            null,
                            FrameType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("stunned", EffectsChangedTrigger.TriggerInstance.hasEffects(MobEffectsPredicate.effects().and(OEffects.STUNNING.get())))
                    .addCriterion("has_lead", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(OTags.Items.INGOTS_LEAD).build()))
                    .addCriterion("eaten", ConsumeItemTrigger.TriggerInstance.usedItem())
                    .save(consumer, "oreganized:story/eat_with_lead");

            Advancement obtain_silver = Advancement.Builder.advancement()
                    .parent(getAdv("minecraft:story/iron_tools"))
                    .display(
                            OItems.SILVER_INGOT.get(),
                            Component.translatable("advancements.story.obtain_silver.title"),
                            Component.translatable("advancements.story.obtain_silver.description"),
                            null,
                            FrameType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("has_silver_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(OTags.Items.INGOTS_SILVER).build()))
                    .save(consumer, "oreganized:story/obtain_silver");

            Advancement electrum_gear = Advancement.Builder.advancement()
                    .parent(obtain_silver)
                    .display(
                            OItems.ELECTRUM_CHESTPLATE.get(),
                            Component.translatable("advancements.story.electrum_gear.title"),
                            Component.translatable("advancements.story.electrum_gear.description"),
                            null,
                            FrameType.CHALLENGE,
                            true,
                            true,
                            false
                    )
                    .addCriterion("has_all_electrum_armor", InventoryChangeTrigger.TriggerInstance.hasItems(
                        OItems.ELECTRUM_HELMET.get(), OItems.ELECTRUM_CHESTPLATE.get(), OItems.ELECTRUM_LEGGINGS.get(), OItems.ELECTRUM_BOOTS.get()
                    ))
                    .save(consumer, "oreganized:story/electrum_gear");

            Advancement melting_point = Advancement.Builder.advancement()
                    .parent(getAdv("minecraft:story/upgrade_tools"))
                    .display(
                            OItems.MOLTEN_LEAD_BUCKET.get(),
                            Component.translatable("advancements.story.melting_point.title"),
                            Component.translatable("advancements.story.melting_point.description"),
                            null,
                            FrameType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("has_molten_lead_bucket", InventoryChangeTrigger.TriggerInstance.hasItems(OItems.MOLTEN_LEAD_BUCKET.get()))
                    //.addCriterion("item_used_on_cauldron", ItemInteractWithBlockTrigger.TriggerInstance.itemUsedOnBlock()))
                    .save(consumer, "oreganized:story/melting_point");
        }

        protected Advancement getAdv(String loc) {
            return Advancement.Builder.advancement().build(new ResourceLocation(loc));
        }
    }
}
