package com.hanriel.unnecessary_additions.networking;

import com.hanriel.unnecessary_additions.tileentities.TeleportStationTE;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class TeleportStationHoverSync {
//    public boolean lookingAt;
//    public BlockPos tePos = new BlockPos(0, 0, 0);
//    public DimensionType dimType;
//
//    public TeleportStationHoverSync(){}
//
//    public TeleportStationHoverSync(boolean lookingAt, BlockPos tePos, DimensionType dimType)
//    {
//        this.lookingAt = lookingAt;
//        this.tePos = tePos;
//        this.dimType = dimType;
//    }

//    public TeleportStationHoverSync(PacketBuffer buf) {
//        lookingAt = buf.readBoolean();
//        tePos = buf.readBlockPos();
//        dimType = DimensionType.getById(buf.readInt());
//    }

//    public void toBytes(PacketBuffer buf) {
//        buf.writeBoolean(lookingAt);
//        buf.writeBlockPos(tePos);
//        buf.writeInt(dimType.func_241513_m_());
//    }
//
//    public void handle(Supplier<NetworkEvent.Context> ctx) {
//        ctx.get().enqueueWork(() -> {
//            ServerWorld world = ctx.get().getSender().world.getServer().getWorld(dimType);
//            TeleportStationTE te = (TeleportStationTE)world.getTileEntity(tePos);
//            if(te != null)
//            {
//                te.clientOnLookAt = lookingAt;
//                te.markDirty();
//            }
//        });
//        ctx.get().setPacketHandled(true);
//    }
}
