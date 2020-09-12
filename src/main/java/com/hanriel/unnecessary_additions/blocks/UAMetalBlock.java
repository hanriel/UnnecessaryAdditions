package com.hanriel.unnecessary_additions.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class UAMetalBlock extends Block {
    public UAMetalBlock(int harvestLevel, float hardness) {
        super(Block.Properties.create(Material.IRON)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(harvestLevel)
                .hardnessAndResistance(hardness)
        );
    }
}
