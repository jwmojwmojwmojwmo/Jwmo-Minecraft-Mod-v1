package v1.jwmomod.item.custom;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class JwmoMinerItem extends Item {
    public JwmoMinerItem(Settings settings) {
        super(settings);
    }


    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();

        if (!world.isClient()) {
            BlockPos blockPos = context.getBlockPos();

            if (String.valueOf(world.getBlockState(blockPos.offset(Direction.Axis.Y,1)).getBlock()).equals("Block{minecraft:air}")) {
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        for (int k = 0; k <= 2; k++) {
                            world.removeBlock(blockPos.offset(Direction.Axis.X, -i).offset(Direction.Axis.Z, -j).offset(Direction.Axis.Y, -k), false);
                        }
                    }
                }
            } else {
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        for (int k = -1; k <= 1; k++) {
                            world.removeBlock(blockPos.offset(Direction.Axis.X, -i).offset(Direction.Axis.Z, -j).offset(Direction.Axis.Y, -k), false);
                        }
                    }
                }
            }

            context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                    item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));
            world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_BAMBOO_BREAK, SoundCategory.BLOCKS);

            return ActionResult.SUCCESS;
        } else {
            return ActionResult.PASS;
        }
    }
}
