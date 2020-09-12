package com.hanriel.unnecessary_additions.inits;

import com.hanriel.unnecessary_additions.UnnecessaryAdditions;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = UnnecessaryAdditions.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class InitClient {
    public static void init(final FMLClientSetupEvent event) {
    }
}
