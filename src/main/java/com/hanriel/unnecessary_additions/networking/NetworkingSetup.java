package com.hanriel.unnecessary_additions.networking;

import com.hanriel.unnecessary_additions.UnnecessaryAdditions;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class NetworkingSetup {

    public static SimpleChannel INSTANCE;
    private static int ID = 0;

    public static int nextID() {
        return ID++;
    }

    public static void registerMessages() {
        INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(UnnecessaryAdditions.MODID, "unaddon"), () -> "1.0", s -> true, s -> true);

//        INSTANCE.registerMessage(nextID(),
//                TeleportStationSync.class,
//                TeleportStationSync::toBytes,
//                TeleportStationSync::new,
//                TeleportStationSync::handle);
//
//        INSTANCE.registerMessage(nextID(),
//                TeleportStationHoverSync.class,
//                TeleportStationHoverSync::toBytes,
//                TeleportStationHoverSync::new,
//                TeleportStationHoverSync::handle);
    }

}
