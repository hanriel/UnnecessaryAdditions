package com.hanriel.unnecessary_additions.networking;

import com.hanriel.unnecessary_additions.tileentities.TeleportStationTE;
import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class TeleportStationSync {

//    public int numHits;
//    public BlockPos tePos = new BlockPos(0, 0, 0);
//
//    public TeleportStationSync(){}
//
//    public TeleportStationSync(int numHits, BlockPos tePos)
//    {
//        this.numHits = numHits;
//        this.tePos = tePos;
//    }
//
//    public TeleportStationSync(PacketBuffer buf) {
//        numHits = buf.readInt();
//        tePos = buf.readBlockPos();
//    }
//
//    public void toBytes(PacketBuffer buf) {
//        buf.writeInt(numHits);
//        buf.writeBlockPos(tePos);
//    }
//
//    public void handle(Supplier<NetworkEvent.Context> ctx) {
//        ctx.get().enqueueWork(() -> {
//            Minecraft mc = Minecraft.getInstance();
//            TeleportStationTE te = (TeleportStationTE)mc.world.getTileEntity(tePos);
//            if(te != null)
//            {
//                te.setCurrentHits(numHits);
//            }
//        });
//        ctx.get().setPacketHandled(true);
//    }


}
