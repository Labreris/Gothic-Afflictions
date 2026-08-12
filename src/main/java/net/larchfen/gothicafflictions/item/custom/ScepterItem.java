package net.larchfen.gothicafflictions.item.custom;

import net.larchfen.gothicafflictions.block.ModBlocks;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import java.util.Map;

public class ScepterItem extends SwordItem {
    public ScepterItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    private static final Map<Block, Block> TESTING_MAP =
            Map.of(
                    Blocks.AIR, Blocks.AIR
            );

    public static Boolean Stance;

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(TESTING_MAP.containsKey(clickedBlock)) {
            if (!level.isClientSide() && !Stance) {
                Stance = true;
            }
            else if (!level.isClientSide() && Stance){
                Stance = false;
            }
        }
        return InteractionResult.SUCCESS;
    }
}
