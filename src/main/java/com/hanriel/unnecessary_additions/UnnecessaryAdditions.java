package com.hanriel.unnecessary_additions;

import com.hanriel.unnecessary_additions.inits.Configs;
import com.hanriel.unnecessary_additions.inits.InitClient;
import com.hanriel.unnecessary_additions.inits.InitCommon;
import com.hanriel.unnecessary_additions.inits.UAContent;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(UnnecessaryAdditions.MODID)
public class UnnecessaryAdditions {

    public static final String MODID = "unaddon";
    private static final Logger LOGGER = LogManager.getLogger();

    public UnnecessaryAdditions() {

        MinecraftForge.EVENT_BUS.register(this);
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        Configs.loadConfig(Configs.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve("unaddon-common.toml"));

        UAContent.init(modEventBus);

        modEventBus.addListener(InitCommon::init);
        modEventBus.addListener(InitClient::init);
        modEventBus.addListener(this::gatherData);
    }

    @SubscribeEvent
    private void gatherData(final GatherDataEvent event) {
        final DataGenerator gen = event.getGenerator();

        if (event.includeServer()) {
            //gen.addProvider(new TrapcraftRecipeProvider(gen));
            gen.addProvider(new UALootTableProvider(gen));
        }
    }

}
