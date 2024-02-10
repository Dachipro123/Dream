package net.dachi.dream.entity.custom;

import net.dachi.dream.entity.ModEntityTypes;
import net.dachi.dream.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.ForgeEventFactory;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class FlyingHorseEntity extends TamableAnimal implements IAnimatable,PlayerRideableJumping {
    protected int gallopSoundCounter;
    protected boolean isJumping;
    protected float playerJumpPendingScale;
    private AnimationFactory factory = new AnimationFactory(this);

    public FlyingHorseEntity(EntityType<? extends TamableAnimal> entityType, Level world) {
        super(entityType, world);
        this.maxUpStep = 3f;
    }

    public static AttributeSupplier setAttributes() {
        return TamableAnimal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 500.0D)
                .add(Attributes.ATTACK_DAMAGE, 7.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.4f)
                .add(ForgeMod.ENTITY_GRAVITY.get(), 0.025f)
                .add(Attributes.JUMP_STRENGTH,3f).build();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.2D));
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, Ingredient.of(ModItems.DREAM_INGOT.get()), false));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 0.7D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));

    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.flying_horse.walk", true));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.flying_horse.idle", true));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }


    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.HORSE_STEP, 0.15F, 1.0F);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.HORSE_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.HORSE_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.HORSE_DEATH;
    }

    protected float getSoundVolume() {
        return 0.2F;
    }

    //BABY(DONE)\\


    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return ModEntityTypes.FLYING_HORSE.get().create(pLevel);
    }
    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.getItem() == ModItems.DREAM_INGOT.get();
    }


    //TAMABLE TEST (BETA)\\
    @Override
    public InteractionResult mobInteract(Player player, InteractionHand pHand) {
        ItemStack itemstack = player.getItemInHand(pHand);
        Item item = itemstack.getItem();
        Item tameableItem = ModItems.DREAM_INGOT.get();

        if (this.level.isClientSide) {
            boolean flag = this.isOwnedBy(player) || this.isTame() || item == tameableItem
                    && !this.isTame();
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else {
            if (this.isTame()) {
                if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
                    if (!player.getAbilities().instabuild) {
                        itemstack.shrink(1);
                    }
                    if (!(item.getFoodProperties() == null))
                    {
                        this.heal((float)item.getFoodProperties().getNutrition());
                        return InteractionResult.SUCCESS;
                    }
                }
                player.startRiding(this);
            } else if (item == tameableItem && !this.isOnFire()) {
                if (!player.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }

                if (this.random.nextInt(3) == 0 && !ForgeEventFactory.onAnimalTame(this, player)) {
                    this.tame(player);
                    this.navigation.stop();

                    this.setTarget((LivingEntity)null);
                    this.setOrderedToSit(true);
                    this.level.broadcastEntityEvent(this, (byte)7);
                } else {
                    this.level.broadcastEntityEvent(this, (byte)6);
                }
                return InteractionResult.SUCCESS;
            }
            return super.mobInteract(player, pHand);
        }
    }
    public boolean canBeControlledByRider() {
        return this.getControllingPassenger() instanceof LivingEntity;
    }

    @Nullable
    public Entity getControllingPassenger() {
        return this.getFirstPassenger();
    }

    public double getCustomJump() {
        return this.getAttributeValue(Attributes.JUMP_STRENGTH);
    }
    public void setIsJumping(boolean pJumping) {
        this.isJumping = pJumping;
    }
    public boolean isJumping() {
        return this.isJumping;
    }

    private boolean allowStandSliding;

    //public void travel(Vec3 pTravelVector) {
    //    if (this.isAlive()) {
    //        LivingEntity livingentity = (LivingEntity) this.getControllingPassenger();
    //        if (this.isVehicle() && livingentity != null) {
    //            this.setYRot(livingentity.getYRot());
    //            this.yRotO = this.getYRot();
    //            this.setXRot(livingentity.getXRot() * 0.5F);
    //            this.setRot(this.getYRot(), this.getXRot());
    //            this.yBodyRot = this.getYRot();
    //            this.yHeadRot = this.yBodyRot;
    //            float f = livingentity.xxa * 0.5F;
    //            float f1 = livingentity.zza;
    //            if (f1 <= 0.0F) {
    //                f1 *= 0.25F;
    //                this.gallopSoundCounter = 0;
    //            }
//
    //            if (this.onGround && this.playerJumpPendingScale == 0.0F && !this.allowStandSliding) {
    //                f = 0.0F;
    //                f1 = 0.0F;
    //            }
//
    //            if (this.playerJumpPendingScale > 0.0F && !this.isJumping() && this.onGround) {
    //                double d0 = this.getCustomJump() * (double)this.playerJumpPendingScale * (double)this.getBlockJumpFactor();
    //                double d1 = d0 + this.getJumpBoostPower();
    //                Vec3 vec3 = this.getDeltaMovement();
    //                this.setDeltaMovement(vec3.x, d1, vec3.z);
    //                this.setIsJumping(true);
    //                this.hasImpulse = true;
    //                net.minecraftforge.common.ForgeHooks.onLivingJump(this);
    //                if (f1 > 0.0F) {
    //                    float f2 = Mth.sin(this.getYRot() * ((float)Math.PI / 180F));
    //                    float f3 = Mth.cos(this.getYRot() * ((float)Math.PI / 180F));
    //                    this.setDeltaMovement(this.getDeltaMovement().add((double)(-0.4F * f2 * this.playerJumpPendingScale), 0.0D, (double)(0.4F * f3 * this.playerJumpPendingScale)));
    //                }
//
    //                this.playerJumpPendingScale = 0.0F;
    //            }
//
    //            this.flyingSpeed = this.getSpeed() * 0.1F;
    //            if (this.isControlledByLocalInstance()) {
    //                this.setSpeed((float)this.getAttributeValue(Attributes.MOVEMENT_SPEED));
    //                super.travel(new Vec3((double)f, pTravelVector.y, (double)f1));
    //            } else if (livingentity instanceof Player) {
    //                this.setDeltaMovement(Vec3.ZERO);
    //            }
//
    //            if (this.onGround) {
    //                this.playerJumpPendingScale = 0.0F;
    //                this.setIsJumping(false);
    //            }
//
    //            this.calculateEntityAnimation(this, false);
    //            this.tryCheckInsideBlocks();
    //        } else {
    //            this.flyingSpeed = 0.02F;
    //            super.travel(pTravelVector);
    //        }
    //    }
    //}
    public void onPlayerJump(int pJumpPower) {
            if (pJumpPower < 0) {
                pJumpPower = 0;
            } else {
                this.allowStandSliding = true;
            }

            if (pJumpPower >= 90) {
                this.playerJumpPendingScale = 1.0F;
            } else {
                this.playerJumpPendingScale = 0.4F + 0.4F * (float)pJumpPower / 90.0F;
            }
    }

    protected void playJumpSound() {
        this.playSound(SoundEvents.HORSE_JUMP, 0.4F, 1.0F);
    }
    

    @Override
    public boolean canJump() {
        return true;
    }

    @Override
    public void handleStartJump(int pJumpPower) {
        this.allowStandSliding = true;
        this.playJumpSound();
    }

    @Override
    public void handleStopJump() {
    }

    public void travel(Vec3 pTravelVector) {
        if (this.isAlive()) {
            if (this.isVehicle() && this.canBeControlledByRider()) {
                LivingEntity livingentity = (LivingEntity)this.getControllingPassenger();
                this.setYRot(livingentity.getYRot());
                this.yRotO = this.getYRot();
                this.setXRot(livingentity.getXRot() * 0.5F);
                this.setRot(this.getYRot(), this.getXRot());
                this.yBodyRot = this.getYRot();
                this.yHeadRot = this.yBodyRot;
                float f = livingentity.xxa * 0.5F;
                float f1 = livingentity.zza;
                if (f1 <= 0.0F) {
                    f1 *= 0.25F;
                }
                if (this.isOnGround()){
                    this.setIsJumping(false);
                }
                if (this.onGround && this.playerJumpPendingScale == 0.0F && !this.allowStandSliding) {
                    f = 0.0F;
                    f1 = 0.0F;
                }
                if (this.playerJumpPendingScale > 0.0F && !this.isJumping() && this.onGround) {
                    double d0 = this.getCustomJump() * (double)this.playerJumpPendingScale * (double)this.getBlockJumpFactor();
                    double d1 = d0 + this.getJumpBoostPower();
                    Vec3 vec3 = this.getDeltaMovement();
                    this.setDeltaMovement(vec3.x, d1, vec3.z);
                    this.setIsJumping(true);
                    this.hasImpulse = true;
                    net.minecraftforge.common.ForgeHooks.onLivingJump(this);
                    if (f1 > 0.0F) {
                        float f2 = Mth.sin(this.getYRot() * ((float)Math.PI / 180F));
                        float f3 = Mth.cos(this.getYRot() * ((float)Math.PI / 180F));
                        this.setDeltaMovement(this.getDeltaMovement().add((double)(-0.4F * f2 * this.playerJumpPendingScale), 0.0D, (double)(0.4F * f3 * this.playerJumpPendingScale)));
                    }

                    this.playerJumpPendingScale = 0.0F;
                }
                if (this.isControlledByLocalInstance()) {
                    this.setSpeed((float)this.getAttributeValue(Attributes.MOVEMENT_SPEED));
                    super.travel(new Vec3((double)f, pTravelVector.y, (double)f1));
                } else if (livingentity instanceof Player) {
                    this.setDeltaMovement(Vec3.ZERO);
                }

                this.calculateEntityAnimation(this, false);
                this.tryCheckInsideBlocks();
            } else {
                super.travel(pTravelVector);
            }
        }
    }

    @Override
    public Vec3 getDismountLocationForPassenger(LivingEntity pLivingEntity) {
        Direction direction = this.getMotionDirection();
        if (direction.getAxis() == Direction.Axis.Y) {
            return super.getDismountLocationForPassenger(pLivingEntity);
        } else {
            int[][] aint = DismountHelper.offsetsForDirection(direction);
            BlockPos blockpos = this.blockPosition();
            BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos();

            for(Pose pose : pLivingEntity.getDismountPoses()) {
                AABB axisalignedbb = pLivingEntity.getLocalBoundsForPose(pose);

                for(int[] aint1 : aint) {
                    blockpos$mutable.set(blockpos.getX() + aint1[0], blockpos.getY(), blockpos.getZ() + aint1[1]);
                    double d0 = this.level.getBlockFloorHeight(blockpos$mutable);
                    if (DismountHelper.isBlockFloorValid(d0)) {
                        Vec3 vec3 = Vec3.upFromBottomCenterOf(blockpos$mutable, d0);
                        if (DismountHelper.canDismountTo(this.level, pLivingEntity, axisalignedbb.move(vec3))) {
                            pLivingEntity.setPose(pose);
                            return vec3;
                        }
                    }
                }
            }

            return super.getDismountLocationForPassenger(pLivingEntity);
        }
    }

}
