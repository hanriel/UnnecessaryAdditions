package com.hanriel.unnecessary_additions.worldgen;

import com.google.common.collect.Lists;
import com.hanriel.unnecessary_additions.inits.UAContent;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.*;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;


public class WorldGen {

    //MARBLE
    private static ConfiguredFeature<?, ?> COPPER_ORE_FEATURE;
    private static ConfiguredFeature<?, ?> SILVER_ORE_FEATURE;
    private static ConfiguredFeature<?, ?> TIN_ORE_FEATURE;
    private static ConfiguredFeature<?, ?> LEAD_ORE_FEATURE;

    public static void init() {
        COPPER_ORE_FEATURE = Registry.register(WorldGenRegistries.field_243653_e, "unaddon:copper_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, UAContent.COPPER_ORE.get().getDefaultState(), 8)).func_242733_d(16).func_242728_a().func_242731_b(8));
        SILVER_ORE_FEATURE = Registry.register(WorldGenRegistries.field_243653_e, "unaddon:silver_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, UAContent.SILVER_ORE.get().getDefaultState(), 8)).func_242733_d(16).func_242728_a().func_242731_b(8));
        TIN_ORE_FEATURE = Registry.register(WorldGenRegistries.field_243653_e, "unaddon:tin_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, UAContent.TIN_ORE.get().getDefaultState(), 8)).func_242733_d(16).func_242728_a().func_242731_b(8));
        LEAD_ORE_FEATURE = Registry.register(WorldGenRegistries.field_243653_e, "unaddon:lead_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, UAContent.LEAD_ORE.get().getDefaultState(), 8)).func_242733_d(16).func_242728_a().func_242731_b(8));
    }

    public static void addOresToGenerator(BiomeGenerationSettings.Builder genSettings) {
        genSettings.func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, COPPER_ORE_FEATURE);
    }

    public static void setupGeneralWorldGen() {
        for (Map.Entry<RegistryKey<Biome>, Biome> biome : WorldGenRegistries.field_243657_i.func_239659_c_()) {
            if (!biome.getValue().getCategory().equals(Biome.Category.NETHER) && !biome.getValue().getCategory().equals(Biome.Category.THEEND)) {
                addFeatureToBiome(biome.getValue(), GenerationStage.Decoration.UNDERGROUND_ORES, COPPER_ORE_FEATURE);
                addFeatureToBiome(biome.getValue(), GenerationStage.Decoration.UNDERGROUND_ORES, SILVER_ORE_FEATURE);
                addFeatureToBiome(biome.getValue(), GenerationStage.Decoration.UNDERGROUND_ORES, TIN_ORE_FEATURE);
                addFeatureToBiome(biome.getValue(), GenerationStage.Decoration.UNDERGROUND_ORES, LEAD_ORE_FEATURE);
            }
        }
    }

    public static void addFeatureToBiome(Biome biome, GenerationStage.Decoration decoration, ConfiguredFeature<?, ?> configuredFeature) {
        List<List<Supplier<ConfiguredFeature<?, ?>>>> biomeFeatures = new ArrayList<>(biome.func_242440_e().func_242498_c());
        while (biomeFeatures.size() <= decoration.ordinal()) {
            biomeFeatures.add(Lists.newArrayList());
        }
        List<Supplier<ConfiguredFeature<?, ?>>> features = new ArrayList<>(biomeFeatures.get(decoration.ordinal()));
        features.add(() -> configuredFeature);
        biomeFeatures.set(decoration.ordinal(), features);

        ObfuscationReflectionHelper.setPrivateValue(BiomeGenerationSettings.class, biome.func_242440_e(), biomeFeatures, "field_242484_f");
    }
//        for(Biome biome : )
//        {
//            if(Configs.silverProbability.get() > 0)
//
//                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(
//                        new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
//                                UAContent.SILVER_ORE.get().getDefaultState(),
//                                Configs.silverVeinSize.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(Configs.silverProbability.get(), Configs.silverMinY.get(), Configs.silverMinY.get(), Configs.silverMaxY.get()))));
//            if(Configs.leadProbability.get() > 0)
//                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(
//                        new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
//                                UAContent.LEAD_ORE.get().getDefaultState(),
//                                Configs.leadVeinSize.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(Configs.leadProbability.get(), Configs.leadMinY.get(), Configs.leadMinY.get(), Configs.leadMaxY.get()))));
//            if(Configs.copperProbability.get() > 0)
//                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(
//                        new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
//                                UAContent.COPPER_ORE.get().getDefaultState(),
//                                Configs.copperVeinSize.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(Configs.copperProbability.get(), Configs.copperMinY.get(), Configs.copperMinY.get(), Configs.copperMaxY.get()))));
//            if(Configs.tinProbability.get() > 0)
//                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(
//                        new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
//                                UAContent.TIN_ORE.get().getDefaultState(),
//                                Configs.tinVeinSize.get()))
//                                .func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(Configs.tinProbability.get(), Configs.tinMinY.get(), Configs.tinMinY.get(), Configs.tinMaxY.get()))));
//        }
}
