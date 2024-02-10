package net.dachi.dream.item.custom;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

public class DreamPower extends Item {
    public DreamPower(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Player entity = pContext.getPlayer();
        entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,72000,5));
        entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,72000,5));
        entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE,72000,5));
        entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,72000,1));
        return super.useOn(pContext);
    }
}
