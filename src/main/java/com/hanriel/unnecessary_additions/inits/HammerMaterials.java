package com.hanriel.unnecessary_additions.inits;

import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public enum HammerMaterials implements IItemTier {

    EMERALD(3, 1028 * 2, 12.0F / 3.5f, 0.0f, 25, () -> {
        return Ingredient.fromItems(Items.EMERALD);
    }),
    OBSIDIAN(2, 2048 * 2, 5.0F / 3.5f, 0.0f, 5, () -> {
        return Ingredient.fromItems(Items.OBSIDIAN);
    }),
    LAPIS(1, 220 * 2, 6.0f / 3.5f, 0.0f, 30, () -> {
        return Ingredient.fromItems(Items.LAPIS_LAZULI);
    }),
    QUARTZ(2, 1028 * 2, 8.0F / 3.5f, 0.0f, 10, () -> {
        return Ingredient.fromItems(Items.QUARTZ);
    }),
    FIERY(3, 750 * 2, 7.0F / 3.5f, 0f, 15, () -> {
        return Ingredient.fromItems(Items.MAGMA_BLOCK);
    }),
    PRISMARINE(3, 750 * 2, 7.0F / 3.5F, 0f, 20, () -> {
        return Ingredient.fromItems(Items.PRISMARINE_SHARD);
    }),
    ENDER(3, 1561 * 2, 10f / 3.5f, 0, 10, () -> {
        return Ingredient.fromItems(Items.ENDER_PEARL);
    }),
    SLIME(2, 1500 * 2, 6f / 3.5f, 0, 20, () -> {
        return Ingredient.fromItems(Items.SLIME_BALL);
    });

    private final int miningLevel;
    private final int durability;
    private final float blockBreakSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final LazyValue<Ingredient> repairIngredient;

    HammerMaterials(int int_1, int int_2, float float_1, float float_2, int int_3, Supplier<Ingredient> supplier_1) {
        this.miningLevel = int_1;
        this.durability = int_2;
        this.blockBreakSpeed = float_1;
        this.attackDamage = float_2;
        this.enchantability = int_3;
        this.repairIngredient = new LazyValue(supplier_1);
    }

    @Override
    public int getMaxUses() {
        return this.durability;
    }

    @Override
    public float getEfficiency() {
        return this.blockBreakSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return this.miningLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairIngredient.getValue();
    }

}
