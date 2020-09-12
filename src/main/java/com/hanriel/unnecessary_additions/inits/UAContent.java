package com.hanriel.unnecessary_additions.inits;

import com.hanriel.unnecessary_additions.blocks.TeleportStation;
import com.hanriel.unnecessary_additions.blocks.UABlockOre;
import com.hanriel.unnecessary_additions.blocks.UAMetalBlock;
import com.hanriel.unnecessary_additions.items.*;
import com.hanriel.unnecessary_additions.worldgen.CopperOreConfig;
import com.hanriel.unnecessary_additions.worldgen.CopperOreFeature;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.hanriel.unnecessary_additions.UnnecessaryAdditions.MODID;

public class UAContent {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    private static final DeferredRegister<TileEntityType<?>> TILEENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MODID);
    private static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, MODID);

    private static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, MODID);
    
    public static void init(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        TILEENTITIES.register(modEventBus);
        CONTAINERS.register(modEventBus);
    }

    //Blocks and BlockItems
    //Ores
    public static final RegistryObject<UABlockOre> COPPER_ORE = BLOCKS.register("copper_ore", () -> new UABlockOre(1, 2F));

    //public static final RegistryObject<CopperOreFeature> ORE_COPPER = FEATURES.register("copper_ore", ()-> new CopperOreFeature(CopperOreConfig.CODEC));

    public static final RegistryObject<Item> COPPER_ORE_ITEM = ITEMS.register("copper_ore", () -> new BlockItem(COPPER_ORE.get(), new Item.Properties().group(InitCommon.creativeTab)));
    public static final RegistryObject<UABlockOre> SILVER_ORE = BLOCKS.register("silver_ore", () -> new UABlockOre(2, 4F));
    public static final RegistryObject<Item> SILVER_ORE_ITEM = ITEMS.register("silver_ore", () -> new BlockItem(SILVER_ORE.get(), new Item.Properties().group(InitCommon.creativeTab)));
    public static final RegistryObject<UABlockOre> LEAD_ORE = BLOCKS.register("lead_ore", () -> new UABlockOre(2, 4F));
    public static final RegistryObject<Item> LEAD_ORE_ITEM = ITEMS.register("lead_ore", () -> new BlockItem(LEAD_ORE.get(), new Item.Properties().group(InitCommon.creativeTab)));
    public static final RegistryObject<UABlockOre> TIN_ORE = BLOCKS.register("tin_ore", () -> new UABlockOre(1, 2F));
    public static final RegistryObject<Item> TIN_ORE_ITEM = ITEMS.register("tin_ore", () -> new BlockItem(TIN_ORE.get(), new Item.Properties().group(InitCommon.creativeTab)));

    //Metal Blocks
    public static final RegistryObject<UAMetalBlock> COPPER_BLOCK = BLOCKS.register("copper_block", () -> new UAMetalBlock(1, 2F));
    public static final RegistryObject<Item> COPPER_BLOCK_ITEM = ITEMS.register("copper_block", () -> new BlockItem(COPPER_BLOCK.get(), new Item.Properties().group(InitCommon.creativeTab)));
    public static final RegistryObject<UAMetalBlock> SILVER_BLOCK = BLOCKS.register("silver_block", () -> new UAMetalBlock(2, 4F));
    public static final RegistryObject<Item> SILVER_BLOCK_ITEM = ITEMS.register("silver_block", () -> new BlockItem(SILVER_BLOCK.get(), new Item.Properties().group(InitCommon.creativeTab)));
    public static final RegistryObject<UAMetalBlock> LEAD_BLOCK = BLOCKS.register("lead_block", () -> new UAMetalBlock(2, 4F));
    public static final RegistryObject<Item> LEAD_BLOCK_ITEM = ITEMS.register("lead_block", () -> new BlockItem(LEAD_BLOCK.get(), new Item.Properties().group(InitCommon.creativeTab)));
    public static final RegistryObject<UAMetalBlock> TIN_BLOCK = BLOCKS.register("tin_block", () -> new UAMetalBlock(1, 2F));
    public static final RegistryObject<Item> TIN_BLOCK_ITEM = ITEMS.register("tin_block", () -> new BlockItem(TIN_BLOCK.get(), new Item.Properties().group(InitCommon.creativeTab)));
    public static final RegistryObject<UAMetalBlock> BRONZE_BLOCK = BLOCKS.register("bronze_block", () -> new UAMetalBlock(1, 2F));
    public static final RegistryObject<Item> BRONZE_BLOCK_ITEM = ITEMS.register("bronze_block", () -> new BlockItem(BRONZE_BLOCK.get(), new Item.Properties().group(InitCommon.creativeTab)));
    public static final RegistryObject<UAMetalBlock> ELECTRUM_BLOCK = BLOCKS.register("electrum_block", () -> new UAMetalBlock(1, 2F));
    public static final RegistryObject<Item> ELECTRUM_BLOCK_ITEM = ITEMS.register("electrum_block", () -> new BlockItem(ELECTRUM_BLOCK.get(), new Item.Properties().group(InitCommon.creativeTab)));

    //Machines
    public static final RegistryObject<TeleportStation> TELEPORT_STATION = BLOCKS.register("teleportstation", TeleportStation::new);
    public static final RegistryObject<Item> TELEPORT_STATION_ITEM = ITEMS.register("teleportstation", () -> new BlockItem(TELEPORT_STATION.get(), new Item.Properties().group(InitCommon.creativeTab)));

    //TileEntities
    //public static final RegistryObject<TileEntityType<TeleportStationTE>> TELEPORT_STATION_TE = TILEENTITIES.register("teleportstation", () -> TileEntityType.Builder.create(TeleportStationTE::new, TELEPORT_STATION.get()).build(null));

    //Items
    public static final RegistryObject<UAItem> ENDERR_TEAR = ITEMS.register("ender_tear", UAItem::new);
    public static final RegistryObject<UAItem> TEAR_PEARL = ITEMS.register("tear_pearl", UAItem::new);

    public static final RegistryObject<UAItem> BRONZE_NUGGET = ITEMS.register("bronze_nugget", UAItem::new);
    public static final RegistryObject<UAItem> COPPER_NUGGET = ITEMS.register("copper_nugget", UAItem::new);
    public static final RegistryObject<UAItem> ELECTRUM_NUGGET = ITEMS.register("electrum_nugget", UAItem::new);
    public static final RegistryObject<UAItem> LEAD_NUGGET = ITEMS.register("lead_nugget", UAItem::new);
    public static final RegistryObject<UAItem> SILVER_NUGGET = ITEMS.register("silver_nugget", UAItem::new);
    public static final RegistryObject<UAItem> TIN_NUGGET = ITEMS.register("tin_nugget", UAItem::new);

    //Items - dusts
    public static final RegistryObject<UAOreDust> IRON_ORE_DUST = ITEMS.register("iron_dust", UAOreDust::new);
    public static final RegistryObject<UAOreDust> GOLD_ORE_DUST = ITEMS.register("gold_dust", UAOreDust::new);
    public static final RegistryObject<UAOreDust> BRONZE_ORE_DUST = ITEMS.register("bronze_dust", UAOreDust::new);
    public static final RegistryObject<UAOreDust> COPPER_ORE_DUST = ITEMS.register("copper_dust", UAOreDust::new);
    public static final RegistryObject<UAOreDust> ELECTRUM_ORE_DUST = ITEMS.register("electrum_dust", UAOreDust::new);
    public static final RegistryObject<UAOreDust> LEAD_ORE_DUST = ITEMS.register("lead_dust", UAOreDust::new);
    public static final RegistryObject<UAOreDust> SILVER_ORE_DUST = ITEMS.register("silver_dust", UAOreDust::new);
    public static final RegistryObject<UAOreDust> TIN_ORE_DUST = ITEMS.register("tin_dust", UAOreDust::new);

    //Items - ingots
    public static final RegistryObject<UAIngot> BRONZE_INGOT = ITEMS.register("bronze_ingot", UAIngot::new);
    public static final RegistryObject<UAIngot> COPPER_INGOT = ITEMS.register("copper_ingot", UAIngot::new);
    public static final RegistryObject<UAIngot> ELECTRUM_INGOT = ITEMS.register("electrum_ingot", UAIngot::new);
    public static final RegistryObject<UAIngot> LEAD_INGOT = ITEMS.register("lead_ingot", UAIngot::new);
    public static final RegistryObject<UAIngot> SILVER_INGOT = ITEMS.register("silver_ingot", UAIngot::new);
    public static final RegistryObject<UAIngot> TIN_INGOT = ITEMS.register("tin_ingot", UAIngot::new);

    //Items - plates
    public static final RegistryObject<UAPlate> IRON_PLATE = ITEMS.register("iron_plate", UAPlate::new);
    public static final RegistryObject<UAPlate> GOLD_PLATE = ITEMS.register("gold_plate", UAPlate::new);
    public static final RegistryObject<UAPlate> BRONZE_PLATE = ITEMS.register("bronze_plate", UAPlate::new);
    public static final RegistryObject<UAPlate> COPPER_PLATE = ITEMS.register("copper_plate", UAPlate::new);
    public static final RegistryObject<UAPlate> ELECTRUM_PLATE = ITEMS.register("electrum_plate", UAPlate::new);
    public static final RegistryObject<UAPlate> LEAD_PLATE = ITEMS.register("lead_plate", UAPlate::new);
    public static final RegistryObject<UAPlate> SILVER_PLATE = ITEMS.register("silver_plate", UAPlate::new);
    public static final RegistryObject<UAPlate> TIN_PLATE = ITEMS.register("tin_plate", UAPlate::new);


    //Items - tools
    public static final RegistryObject<Hammer> WOOD_HAMMER = ITEMS.register("wooden_hammer", () -> new Hammer(ItemTier.WOOD));
    public static final RegistryObject<Hammer> STONE_HAMMER = ITEMS.register("stone_hammer", () -> new Hammer(ItemTier.STONE));
    public static final RegistryObject<Hammer> IRON_HAMMER = ITEMS.register("iron_hammer", () -> new Hammer(ItemTier.IRON));
    public static final RegistryObject<Hammer> GOLDEN_HAMMER = ITEMS.register("golden_hammer", () -> new Hammer(ItemTier.GOLD));
    public static final RegistryObject<Hammer> DIAMOND_HAMMER = ITEMS.register("diamond_hammer", () -> new Hammer(ItemTier.DIAMOND));

    public static final RegistryObject<Hammer> EMERALD_HAMMER = ITEMS.register("emerald_hammer", () -> new Hammer(HammerMaterials.EMERALD));
    public static final RegistryObject<Hammer> OBSIDIAN_HAMMER = ITEMS.register("obsidian_hammer", () -> new Hammer(HammerMaterials.OBSIDIAN));
    public static final RegistryObject<Hammer> LAPIS_HAMMER = ITEMS.register("lapis_hammer", () -> new Hammer(HammerMaterials.QUARTZ));
    public static final RegistryObject<Hammer> QUARTZ_HAMMER = ITEMS.register("quartz_hammer", () -> new Hammer(HammerMaterials.LAPIS));
    public static final RegistryObject<Hammer> FIERY_HAMMER = ITEMS.register("fiery_hammer", () -> new Hammer(HammerMaterials.FIERY));
    public static final RegistryObject<Hammer> PRISMARINE_HAMMER = ITEMS.register("prismarine_hammer", () -> new Hammer(HammerMaterials.PRISMARINE));
    public static final RegistryObject<Hammer> ENDER_HAMMER = ITEMS.register("ender_hammer", () -> new Hammer(HammerMaterials.ENDER));
    public static final RegistryObject<Hammer> SLIME_HAMMER = ITEMS.register("slime_hammer", () -> new Hammer(HammerMaterials.SLIME));

    public static final RegistryObject<Hammer> SILVER_HAMMER = ITEMS.register("silver_hammer", () -> new Hammer(ItemTier.DIAMOND));
    public static final RegistryObject<Hammer> LEAD_HAMMER = ITEMS.register("lead_hammer", () -> new Hammer(ItemTier.DIAMOND));
    public static final RegistryObject<Hammer> COPPER_HAMMER = ITEMS.register("copper_hammer", () -> new Hammer(ItemTier.IRON));
    public static final RegistryObject<Hammer> TIN_HAMMER = ITEMS.register("tin_hammer", () -> new Hammer(ItemTier.IRON));
    public static final RegistryObject<Hammer> BRONZE_HAMMER = ITEMS.register("bronze_hammer", () -> new Hammer(ItemTier.IRON));
    public static final RegistryObject<Hammer> ELECTRUM_HAMMER = ITEMS.register("electrum_hammer", () -> new Hammer(ItemTier.IRON));

    public static final RegistryObject<Excavator> STONE_EXCAVATOR = ITEMS.register("stone_excavator", () -> new Excavator(ItemTier.STONE));
    public static final RegistryObject<Excavator> IRON_EXCAVATOR = ITEMS.register("iron_excavator", () -> new Excavator(ItemTier.IRON));
    public static final RegistryObject<Excavator> DIAMOND_EXCAVATOR = ITEMS.register("diamond_excavator", () -> new Excavator(ItemTier.DIAMOND));

    public static final RegistryObject<Excavator> EMERALD_EXCAVATOR = ITEMS.register("emerald_excavator", () -> new Excavator(HammerMaterials.EMERALD));
    public static final RegistryObject<Excavator> OBSIDIAN_EXCAVATOR = ITEMS.register("obsidian_excavator", () -> new Excavator(HammerMaterials.OBSIDIAN));

}
