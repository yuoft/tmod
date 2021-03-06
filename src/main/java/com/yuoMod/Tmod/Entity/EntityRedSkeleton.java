package com.yuoMod.Tmod.Entity;

import com.yuoMod.Tmod.Common.Items.itemLoader;
import com.yuoMod.Tmod.Entity.AI.AISkeletonAttackBow;
import com.yuoMod.Tmod.Entity.AI.AISkeletonAttackSword;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityRedSkeleton extends EntitySkeleton
{
	public EntityRedSkeleton(World worldIn) {
		super(worldIn);
		this.targetTasks.addTask(1, new AISkeletonAttackSword(this));
		this.targetTasks.addTask(0, new AISkeletonAttackBow(this));
		this.SpwanMob();
	}
	// 实体更新
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
	}
	// 掉落物(是否被玩家杀死，抢夺等级)
	@Override
	protected void dropFewItems(boolean arg1, int arg2) 
	{
		super.dropFewItems(arg1, arg2);
	}
	//wasRecentlyHit 最近是否被击中
	protected void dropLoot(boolean wasRecentlyHit, int lootingModifier, DamageSource source)
	{
		if(wasRecentlyHit == true && rand.nextInt(100) < 69)
		{
			ItemStack stack=new ItemStack(Items.GOLD_INGOT,rand.nextInt(4)+lootingModifier);
			ItemStack stack1=new ItemStack(Blocks.DIAMOND_BLOCK,rand.nextInt(1)+lootingModifier);
			ItemStack stack2=new ItemStack(itemLoader.exp_big,rand.nextInt(2)+lootingModifier);
			ItemStack stack3=new ItemStack(itemLoader.exp_small,rand.nextInt(4)+lootingModifier);
			this.entityDropItem(stack, 0.0f);
			this.entityDropItem(stack1, 0.0f);
			this.entityDropItem(stack2, 0.0f);
			this.entityDropItem(stack3, 0.0f);
		}
		super.dropLoot(wasRecentlyHit, lootingModifier, source);
	}
	// 实体生成属性
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();

		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(80.0D);//生命
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);//速度
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);//攻击伤害
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.5D);//击退抗性
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(10.0D);//盔甲防御
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).setBaseValue(4.0D);//盔甲韧性
	}
	private void SpwanMob()
	{
		int i=rand.nextInt(100);
		if(i < 70 && i >= 30)
		{
			if(rand.nextInt(100) >50)
				this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Items.DIAMOND_HELMET));
			else this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Items.IRON_HELMET));
		}
		else if(i < 85 && i>= 70)
		{
			if(rand.nextInt(100) > 50)
				this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Items.IRON_CHESTPLATE));
			else this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
		}
		else if(i < 95 && i >= 85)
		{
			if(rand.nextInt(100) >50)
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
			else this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
		}
		else if(i >= 95)
		{
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
			this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Items.DIAMOND_HELMET));
			this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
			this.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(Items.DIAMOND_BOOTS));
			this.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(Items.DIAMOND_LEGGINGS));
		}
		else
		{
			if(rand.nextInt(10000) == 0)//0.01%概率绿宝石锭套
			{
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(itemLoader.emerald_sword));
				this.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(Items.TOTEM_OF_UNDYING));
				this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(itemLoader.emerald_helmet));
				this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(itemLoader.emerald_breastplate));
				this.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(itemLoader.emerald_shoes));
				this.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(itemLoader.emerald_leggings));
			}
		}
	}
}
