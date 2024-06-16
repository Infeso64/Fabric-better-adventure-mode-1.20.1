package net.infeso.betteradventuremode.block.custom;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.event.client.ClientTickCallback;
import net.fabricmc.fabric.api.event.world.WorldTickCallback;
import net.infeso.betteradventuremode.BetterAdventureMode;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.GameMode;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class BaseMarkerBlock extends Block {

    public int boundingBoxDistance = 10;
    public boolean ticking = false;
    public BaseMarkerBlock(Settings settings) {
        super(settings);
    }


    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        ticking = true;
        initialiseSwitchingMechanic(pos);
        super.onPlaced(world, pos, state, placer, itemStack);
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        ticking = false;
        super.onBroken(world, pos, state);
    }

    public void initialiseSwitchingMechanic(BlockPos pos)
    {
        ClientTickEvents.START_CLIENT_TICK.register(client -> {
            Vec3d playerpos = MinecraftClient.getInstance().player.getPos();
            Vec3d blockpos = pos.toCenterPos();
            if (ticking) {
                if (getDistance(blockpos, playerpos) < boundingBoxDistance) {
                    MinecraftClient.getInstance().player.networkHandler.sendCommand("gamemode survival");
                } else {
                    MinecraftClient.getInstance().player.networkHandler.sendCommand("gamemode adventure");
                }
            }
            else {
                MinecraftClient.getInstance().player.networkHandler.sendCommand("gamemode adventure");
            }
            });
    }

    public static double getDistance(Vec3d vec1, Vec3d vec2)
    {
        Vec3d vecRelativ = new Vec3d(vec1.x - vec2.x,vec1.y - vec2.y,vec1.z - vec2.z );
        double firstdis = Math.sqrt((vecRelativ.x * vecRelativ.x) + (vecRelativ.z * vecRelativ.z));
        return Math.sqrt((firstdis * firstdis) + (vecRelativ.y * vecRelativ.y));
    }

}
