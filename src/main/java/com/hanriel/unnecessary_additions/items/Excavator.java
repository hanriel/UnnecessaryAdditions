package com.hanriel.unnecessary_additions.items;

import com.hanriel.unnecessary_additions.inits.InitCommon;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.world.World;

public class Excavator extends ShovelItem {
    public Excavator(IItemTier tier) {
        super(tier, 2, -2.8F, new Item.Properties()
                .group(InitCommon.creativeTab)
                .maxDamage(tier.getMaxUses() * 2)
        );
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if (!worldIn.isRemote && entityLiving instanceof PlayerEntity)
        {
            PlayerEntity player = (PlayerEntity)entityLiving;
            if(state.getBlockHardness(worldIn, pos) != 0.0F) {
                stack.damageItem(1, entityLiving, (p_220038_0_) -> {
                    p_220038_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
                });
            }
            if(!player.isCrouching()) {
                float initialBlockResistance = state.getBlockHardness(worldIn, pos);

                BlockRayTraceResult result = (BlockRayTraceResult) rayTrace(worldIn, player, RayTraceContext.FluidMode.NONE);
                Direction sideHit = result.getFace();
                int xDist, yDist, zDist;
                yDist = xDist = zDist = 1;

                switch (sideHit) {
                    case UP:
                    case DOWN:
                        yDist = 0;
                        break;
                    case NORTH:
                    case SOUTH:
                        zDist = 0;
                        break;
                    case EAST:
                    case WEST:
                        xDist = 0;
                        break;
                }

                for (int x = pos.getX() - xDist; x <= pos.getX() + xDist; x++) {
                    for (int y = pos.getY() - yDist; y <= pos.getY() + yDist; y++) {
                        for (int z = pos.getZ() - zDist; z <= pos.getZ() + zDist; z++) {
                            BlockPos targetPos = new BlockPos(x, y, z);
                            BlockState targetBlock = worldIn.getBlockState(targetPos);
                            if (canHarvestBlock(targetBlock) && targetBlock.getBlockHardness(worldIn, targetPos) <= initialBlockResistance) {
                                if ((stack.getMaxDamage() - stack.getDamage()) >= 1 && targetBlock.getBlock() != Blocks.BEDROCK) {
                                    worldIn.destroyBlock(new BlockPos(x, y, z), true);
                                }
                                if (state.getBlockHardness(worldIn, targetPos) != 0.0F) {
                                    stack.damageItem(1, entityLiving, (p_220038_0_) -> {
                                        p_220038_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
                                    });
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {

        return false;
    }
}
