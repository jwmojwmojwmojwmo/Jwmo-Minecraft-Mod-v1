package v1.jwmomod.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

import java.util.List;

import static net.minecraft.component.type.ConsumableComponents.food;

public class ModConsumableComponents {
    public static final ConsumableComponent jwmofood = food()
            .consumeEffect(new ApplyEffectsConsumeEffect(List.of(
                            new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 999999999, 3),
                            new StatusEffectInstance(StatusEffects.REGENERATION, 10, 10)
                    ))
            )
            .build();
}
