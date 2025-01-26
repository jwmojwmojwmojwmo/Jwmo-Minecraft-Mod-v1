package v1.jwmomod.block;

import net.minecraft.block.Block;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import v1.jwmomod.Jwmomod;

import java.util.function.Function;

public class ModBlocks {
    public static final Block jwmoblock = registerBlock("jwmoblock", Block::new, AbstractBlock.Settings.create().hardness(0.5f).resistance(1000f), true);

    public static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> factory, Block.Settings settings, boolean registerBlockItem) {
        final RegistryKey<Block> registerBlockKey = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Jwmomod.MOD_ID, name));
        final Block block = Blocks.register(registerBlockKey, factory, settings);
        if (registerBlockItem) {
            Items.register(block);
        }
        return block;
    }

    public static void registerModBlocks() {
        Jwmomod.LOGGER.info("Registering Mod Blocks for " + Jwmomod.MOD_ID);
    }
}
