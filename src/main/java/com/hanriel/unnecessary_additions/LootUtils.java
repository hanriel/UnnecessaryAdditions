package com.hanriel.unnecessary_additions;


import net.minecraft.item.Item;

import net.minecraft.loot.*;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.loot.conditions.RandomChance;
import net.minecraft.loot.functions.ILootFunction;
import net.minecraft.loot.functions.SetCount;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

public class LootUtils
{
    private static Field tablePools;
    private static Field poolEntries;
    private static Field entryItem;

    static
    {
        tablePools = ObfuscationReflectionHelper.findField(LootTable.class, "pools");
        tablePools.setAccessible(true);
        poolEntries = ObfuscationReflectionHelper.findField(LootPool.class, "lootEntries");
        poolEntries.setAccessible(true);
        entryItem = ObfuscationReflectionHelper.findField(ItemLootEntry.class, "item");
        entryItem.setAccessible(true);
    }

    public static LootPool createLootPool(String name, RandomValueRange numRolls, RandomValueRange bonusRolls, LootEntry.Builder entryBuilder, ILootCondition.IBuilder conditionBuilder, ILootFunction.IBuilder functionBuilder)
    {
        LootPool.Builder builder = LootPool.builder();
        builder.name(name);
        builder.rolls(numRolls);
        builder.bonusRolls(bonusRolls.getMin(), bonusRolls.getMax());
        builder.addEntry(entryBuilder);
        builder.acceptCondition(conditionBuilder);
        builder.acceptFunction(functionBuilder);

        return builder.build();
    }

    public static void addItemToTable(LootTable table, LootPool pool)
    {
        table.addPool(pool);
    }

    public static void addItemToTable(LootTable table, Item item, int weight, float probability, int minQuantity, int maxQuantity, String name)
    {
        addItemToTable(table, item, weight, 1, probability, minQuantity, maxQuantity, name);
    }

    public static void addItemToTable(LootTable table, Item item, int weight, float probability, int quantity, String name)
    {
        addItemToTable(table, item, weight, 1, probability, quantity, quantity, name);
    }

    private static void addItemToTable(LootTable table, Item item, int weight, float numRolls, float probability, int minQuantity, int maxQuantity, String name)
    {
        RandomChance.IBuilder conditionBuilder = RandomChance.builder(probability);
        SetCount.IBuilder functionBuilder = SetCount.builder(new RandomValueRange(minQuantity, maxQuantity));

        ItemLootEntry.Builder entryBuilder = ItemLootEntry.builder(item);
        entryBuilder.weight(weight);
        entryBuilder.quality(1);
        entryBuilder.acceptCondition(conditionBuilder);
        entryBuilder.acceptFunction(functionBuilder);

        LootPool newPool = createLootPool(name, new RandomValueRange(numRolls), new RandomValueRange(0), entryBuilder, conditionBuilder, functionBuilder);

        addItemToTable(table, newPool);
    }
}
