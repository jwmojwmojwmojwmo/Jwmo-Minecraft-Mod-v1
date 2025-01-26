package v1.jwmomod.item;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import v1.jwmomod.Jwmomod;

import java.util.function.Function;

public class ModItems {
    public static final Item jwmofood = registerItem("jwmofood", Item::new, new Item.Settings().food(ModFoodComponents.jwmofood, ModConsumableComponents.jwmofood));
    public static final Item jwmominer = registerItem("jwmominer", Item::new, new Item.Settings());

    public static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registerItemKey =RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Jwmomod.MOD_ID, name));
        return Items.register(registerItemKey, factory, settings);
    }

    public static void registerModItems() {
        Jwmomod.LOGGER.info("Registering Mod Items for " + Jwmomod.MOD_ID);
    }
}
