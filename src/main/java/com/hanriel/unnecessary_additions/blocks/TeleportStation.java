package com.hanriel.unnecessary_additions.blocks;

import com.hanriel.unnecessary_additions.inits.UAContent;
import com.hanriel.unnecessary_additions.tileentities.TeleportStationTE;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class TeleportStation extends ModelledFallingBlock {

//    public TeleportStation() {
//        setDefaultState(getDefaultState());
//    }
//
//    @Override
//    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
//        super.fillStateContainer(builder);
//    }
//
//    @Override
//    public boolean hasTileEntity(BlockState state) {
//        return true;
//    }
//
//    @Nullable
//    @Override
//    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
//        return new TeleportStationTE();
//    }
//
//    @Override
//    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
//        super.onReplaced(state, worldIn, pos, newState, isMoving);
//    }
//
//    @Override
//    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
//        if (!worldIn.isRemote) {
//            TeleportStationTE te = (TeleportStationTE) worldIn.getTileEntity(pos);
//            if (player.getHeldItem(Hand.MAIN_HAND).getItem() == UAContent.IRON_HAMMER.get() || player.getHeldItem(Hand.MAIN_HAND).getItem() == UAContent.DIAMOND_HAMMER.get()) {
//                InventoryHelper.spawnItemStack(worldIn, te.getPos().getX(), te.getPos().getY() + 1, te.getPos().getZ(), te.getContainedItem());
//                te.markDirty();
//                worldIn.notifyBlockUpdate(te.getPos(), worldIn.getBlockState(te.getPos()), worldIn.getBlockState(te.getPos()), 2);
//            }
//        }
//    }
//
//    @Override
//    public ActionResultType func_225533_a_(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult p_225533_6_) {
//        if (handIn == Hand.OFF_HAND) return ActionResultType.PASS;
//        TeleportStationTE te = (TeleportStationTE) worldIn.getTileEntity(pos);
//        if (worldIn.isRemote) {
//            return ActionResultType.SUCCESS;
//        } else {
//            if (te != null) {
//                if (player.getHeldItem(handIn).isEmpty()) {
//                    if (te.getContainedItem() != ItemStack.EMPTY) {
//                        player.setHeldItem(handIn, te.interact(ItemStack.EMPTY));
//                    }
//                } else {
//                    if (te.hasValidRecipe() && (player.getHeldItem(handIn).getItem() == UAContent.IRON_HAMMER.get() || player.getHeldItem(handIn).getItem() == UAContent.DIAMOND_HAMMER.get())) {
//                        player.getHeldItem(Hand.MAIN_HAND).damageItem(1, player, (p_220038_0_) -> {
//                            p_220038_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
//                        });
//                        if (!te.bash(Hand.OFF_HAND)) {
//                            InventoryHelper.spawnItemStack(worldIn, te.getPos().getX(), te.getPos().getY() + 1, te.getPos().getZ(), te.getContainedItem());
//                            te.markDirty();
//                            worldIn.notifyBlockUpdate(te.getPos(), worldIn.getBlockState(te.getPos()), worldIn.getBlockState(te.getPos()), 2);
//                        }
//                    } else
//                        player.setHeldItem(handIn, te.interact(player.getHeldItem(handIn)));
//                }
//
//            }
//        }
//        return ActionResultType.SUCCESS;
//    }
//
//
//    @Override
//    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
//        return Block.makeCuboidShape(1, 0, 1, 15, 16, 15);
//    }
}
