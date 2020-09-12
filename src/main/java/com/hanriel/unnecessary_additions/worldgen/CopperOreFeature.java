package com.hanriel.unnecessary_additions.worldgen;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class CopperOreFeature
        //extends OreFeature
{
//    public static final CopperOreFeature INSTANCE = new CopperOreFeature(CopperOreConfig.CODEC);
//
//    public CopperOreFeature(Codec<OreFeatureConfig> p_i231976_1_) {
//        super(p_i231976_1_);
//    }
//
//    @Override
//    public boolean func_241855_a(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, CopperOreConfig config) {
//        ChunkPos chunkPos = new ChunkPos(pos);
//
//        BlockPos.Mutable bpos = new BlockPos.Mutable();
//        int height = worldIn.getHeight(Heightmap.Type.WORLD_SURFACE_WG, pos.getX(), pos.getZ());
//        IChunk chunk = worldIn.getChunk(pos);
//        for (int y = 0; y < height; y++) {
//            bpos.setY(y);
//            for (int x = chunkPos.getXStart(); x <= chunkPos.getXEnd(); x++) {
//                bpos.setX(x);
//                for (int z = chunkPos.getZStart(); z <= chunkPos.getZEnd(); z++) {
//                    bpos.setZ(z);
//                    if (chunk.getBlockState(bpos).getBlock() == config.target.getBlock()
//                            && rand.nextFloat() < config.chance) {
//                        chunk.setBlockState(bpos, config.state, false);
//                    }
//                }
//            }
//        }
//
//        return true;
//    }
}
