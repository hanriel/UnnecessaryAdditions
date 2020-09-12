package com.hanriel.unnecessary_additions;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableList;
import com.hanriel.unnecessary_additions.inits.UAContent;
import com.mojang.datafixers.util.Pair;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.data.loot.EntityLootTables;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.ConstantRange;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.ValidationTracker;
import net.minecraft.loot.conditions.RandomChanceWithLooting;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public class UALootTableProvider extends LootTableProvider {

    public UALootTableProvider(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
    }

    @Nonnull
    @Override
    public String getName() {
        return "UnAddon's LootTables";
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
        return ImmutableList.of(
                Pair.of(Blocks::new, LootParameterSets.BLOCK),
                Pair.of(Entities::new, LootParameterSets.ENTITY)
        );
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationTracker) {}

    private static class Blocks extends BlockLootTables {

        @Override
        protected void addTables() {
            dropsSelf(UAContent.TIN_BLOCK);
            dropsSelf(UAContent.COPPER_BLOCK);
            dropsSelf(UAContent.LEAD_BLOCK);
            dropsSelf(UAContent.SILVER_BLOCK);
        }

        private void dropsSelf(Supplier<? extends Block> block) {
            registerDropSelfLootTable(block.get());
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return UAContent.BLOCKS.getEntries().stream().map(Supplier::get).collect(Collectors.toList());
        }
    }

    private static class Entities extends EntityLootTables {

        @Override
        protected void addTables() {
            this.registerLootTable(EntityType.ENDERMAN, LootTable.builder().addLootPool(LootPool.builder().rolls(ConstantRange.of(1)).addEntry(ItemLootEntry.builder(UAContent.ENDERR_TEAR.get())).acceptCondition(RandomChanceWithLooting.builder(1F, 5F))));
        }

        protected void registerLootTable(Supplier<? extends EntityType<?>> type, final LootTable.Builder table) {
            this.registerLootTable(type.get().getLootTable(), table);
        }

        //@Override
        //protected Iterable<EntityType<?>> getKnownEntities() {
            //return TrapcraftEntityTypes.ENTITIES.getEntries().stream().map(Supplier::get).collect(Collectors.toList());
        //}
    }
}
