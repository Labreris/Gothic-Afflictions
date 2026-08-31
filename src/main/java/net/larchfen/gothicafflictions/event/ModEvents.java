package net.larchfen.gothicafflictions.event;

import net.larchfen.gothicafflictions.GothicAfflictions;
import net.larchfen.gothicafflictions.item.ModItems;
import net.larchfen.gothicafflictions.item.custom.HammerItem;
import net.larchfen.gothicafflictions.sound.ModSounds;
import net.larchfen.gothicafflictions.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.TagManager;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EventBusSubscriber(modid = GothicAfflictions.MOD_ID)
public class ModEvents {
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    // Done with the help of https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java
    // Don't be a jerk License
    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if (mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if (HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            for (BlockPos pos : HammerItem.getBlocksToBeDestroyed(1, initialBlockPos, serverPlayer)) {
                if (pos == initialBlockPos || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }
    }

    @SubscribeEvent
    public static void livingDamage(LivingDamageEvent.Pre event) {
        if (event.getEntity().getType().is(EntityTypeTags.UNDEAD) && event.getSource().getDirectEntity() instanceof Player player) {
            if (player.getMainHandItem().is(ModTags.Items.SILVER_HELD_ITEMS)) {
                event.setNewDamage(event.getOriginalDamage() + 3);
            }
        }
        if (event.getSource().getDirectEntity() instanceof Player player && player.getMainHandItem().is(ModItems.RITUAL_DAGGER)) {
            event.getEntity().addEffect(new MobEffectInstance(MobEffects.WITHER, 40, 4));
        }
    }

    @SubscribeEvent
    public static void livingDamage( LivingDamageEvent.Post event) {
        if (event.getSource().getDirectEntity() instanceof LivingEntity enemyMob) {
            if (enemyMob != null) {
                if (enemyMob.getType().is(EntityTypeTags.UNDEAD) && event.getEntity() instanceof Player player) {
                    float chanceToWeakness = 0f;
                    for (ItemStack armorItem : player.getArmorSlots()) {
                        if (armorItem.is(ModTags.Items.SILVER_ARMOR)) {
                            chanceToWeakness += 0.2f;
                        }
                    }
                    if (chanceToWeakness >= player.getRandom().nextFloat()) {
                        enemyMob.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 80, 0));
                        enemyMob.playSound(ModSounds.SILVER_ARMOR_REBUKE.get(), 0.7f, 3.5f);
                    }
                }
            }
        }
    }
}