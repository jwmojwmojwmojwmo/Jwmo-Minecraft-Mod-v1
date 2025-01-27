package v1.jwmomod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class JwmoWolfTransformerBlock extends Block {
    public JwmoWolfTransformerBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (!world.isClient()) {
            if (entity instanceof MobEntity mobentity && entity.getType() != EntityType.WOLF) {
                mobentity.teleport(pos.getX() + 5, pos.getY(), pos.getZ(), false);
                WolfEntity wolf = new WolfEntity(EntityType.WOLF, world);
                PlayerEntity player = world.getClosestPlayer(entity, 20d);
                wolf.setOwner(player);
                wolf.setPosition(player.getPos().offset(Direction.NORTH, 3));
                mobentity.kill((ServerWorld) world);
                world.spawnEntity(wolf);
            }
        }
    }
}
