package galena.oreganized.world.event;

import galena.oreganized.Oreganized;
import galena.oreganized.OreganizedConfig;
import galena.oreganized.content.block.MoltenLeadCauldronBlock;
import galena.oreganized.index.*;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.player.inventory.Hotbar;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.event.entity.item.ItemEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.swing.text.html.parser.Entity;

@Mod.EventBusSubscriber(modid = Oreganized.MOD_ID)
public class PlayerEvents {

    @SubscribeEvent
    public static void blockToolInteractions(final BlockEvent.BlockToolModificationEvent event) {
        ToolAction action = event.getToolAction();
        BlockState state = event.getState();
        if (event.isSimulated()) return;

        // Removing Wax ('Unwaxing' - Using an Axe on a waxed block).
        if (action.equals(ToolActions.AXE_WAX_OFF)) {
            Block unWaxedBlock = OBlocks.WAXED_BLOCKS.get(state.getBlock());
            if (unWaxedBlock == null) return;
            event.setFinalState(unWaxedBlock.defaultBlockState());
        }
    }

    /**
     *Use if interaction is not defined in {@link ToolActions}
     **/
    @SubscribeEvent
    public static void blockItemInteractions(final PlayerInteractEvent.RightClickBlock event) {
        Level world = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = world.getBlockState(pos);
        ItemStack itemStack = event.getItemStack();
        Player player = event.getEntity();
        InteractionHand hand = event.getHand();

        // Waxing (Using Honeycomb on a waxable block).
        if (itemStack.is(Items.HONEYCOMB) && OBlocks.WAXED_BLOCKS.inverse().get(state.getBlock()) != null) {

            if (player instanceof ServerPlayer) CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer) player, pos, itemStack);

            player.swing(event.getHand());
            if (!player.isCreative()) event.getItemStack().shrink(1);
            Block waxedBlock = OBlocks.WAXED_BLOCKS.inverse().get(state.getBlock());
            if (!world.isClientSide() && waxedBlock != null) world.setBlock(pos, waxedBlock.defaultBlockState(), 11);
            world.levelEvent(player, 3003, pos, 0);
        }
    }

    @SubscribeEvent
    public static void finishUsingItem(final LivingEntityUseItemEvent.Finish event) {
        LivingEntity entity = event.getEntity();
        ItemStack itemStack = event.getItem();
        if (itemStack.isEdible()) {
            boolean leadPoisoning = entity.isInFluidType(OFluids.MOLTEN_LEAD_TYPE.get());
            if (entity instanceof Player player) {
                for (int i = 0; i < 9; i++) {
                    if (player.getInventory().items.get(i).is(OTags.Items.LEAD_SOURCE))
                        leadPoisoning = true;
                }
            }
            if ((entity.getOffhandItem().is(OTags.Items.LEAD_SOURCE) || leadPoisoning) && OreganizedConfig.COMMON.leadPoisining.get()) {
                if (OreganizedConfig.stunningFromConfig()) entity.addEffect(new MobEffectInstance(OEffects.STUNNING.get(), 40 * 20));
                entity.addEffect(new MobEffectInstance(MobEffects.POISON, 200));
            }
        }
    }
}
