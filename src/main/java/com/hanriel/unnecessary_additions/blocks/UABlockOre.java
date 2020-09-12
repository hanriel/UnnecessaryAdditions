package com.hanriel.unnecessary_additions.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;

import java.util.Random;

public class UABlockOre extends Block {
    public UABlockOre(int harvestLevel, float hardness) {
        super(Properties.create(Material.ROCK)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(harvestLevel)
                .hardnessAndResistance(hardness)
        );
    }
}
