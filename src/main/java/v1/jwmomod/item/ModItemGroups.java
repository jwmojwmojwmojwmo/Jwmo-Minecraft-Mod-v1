package v1.jwmomod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import v1.jwmomod.Jwmomod;

public class ModItemGroups {
    public static final ItemGroup jwmoitemgroup = Registry.register(Registries.ITEM_GROUP, Identifier.of(Jwmomod.MOD_ID, "jwmoitemgroup"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.jwmofood))
                    .displayName(Text.translatable("itemgroup.jwmomod.jwmoitemgroup"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.jwmofood);
                        entries.add(ModItems.jwmominer);
                    }).build());

    public static void registerModItemGroups() {
        Jwmomod.LOGGER.info("Registering Mod Item Groups for " + Jwmomod.MOD_ID);
    }
}
