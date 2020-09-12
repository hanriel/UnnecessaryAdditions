package com.hanriel.unnecessary_additions.inits;

import com.hanriel.unnecessary_additions.UnnecessaryAdditions;
import com.hanriel.unnecessary_additions.networking.NetworkingSetup;
import com.hanriel.unnecessary_additions.worldgen.WorldGen;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = UnnecessaryAdditions.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class InitCommon {

    public static final ItemGroup creativeTab = new ItemGroup("unaddon") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(UAContent.TEAR_PEARL.get());
        }
    };

    public static void init(final FMLCommonSetupEvent event) {
        initCapabilities();
        WorldGen.init();
        WorldGen.setupGeneralWorldGen();
        NetworkingSetup.registerMessages();
    }

    public static void initCapabilities()
    {
    }
}
