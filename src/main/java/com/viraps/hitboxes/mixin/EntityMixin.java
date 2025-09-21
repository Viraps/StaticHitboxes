package com.viraps.hitboxes.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityMixin {
    @Inject(method = "getPos", at = @At("HEAD"), cancellable = true)
    private void onGetPose(CallbackInfoReturnable<EntityPose> cir){
        Entity entity = Entity.class.cast(this);
        if (entity instanceof PlayerEntity && !((PlayerEntity) entity).isMainPlayer()){
            cir.setReturnValue(EntityPose.STANDING);
        }
    }
}
