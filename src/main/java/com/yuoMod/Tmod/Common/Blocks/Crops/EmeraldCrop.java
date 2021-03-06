package com.yuoMod.Tmod.Common.Blocks.Crops;

import javax.annotation.Nonnull;

import com.yuoMod.Tmod.Common.Items.itemLoader;
import com.yuoMod.Tmod.Creativetab.CreativeTabsLoader;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class EmeraldCrop extends BlockCrops implements IGrowable
{
	 public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 7);
	 private static final AxisAlignedBB[] CROPS_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.375D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.625D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.75D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.875D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D)};

	public EmeraldCrop(String name) 
	{
		// TODO 自动生成的构造函数存根
		this.setUnlocalizedName(name);//绿宝石作物
		this.setTickRandomly(true);//随机时间刻
		this.setCreativeTab(CreativeTabsLoader.TMOD);
		this.setHardness(0.0F);
        this.setSoundType(SoundType.PLANT);
        this.disableStats();
        this.setDefaultState(this.blockState.getBaseState().withProperty(this.getAgeProperty(), Integer.valueOf(0)));
	}
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return CROPS_AABB[((Integer)state.getValue(this.getAgeProperty())).intValue()];
    }
	//方块是否可以种植
	protected boolean canSustainBush(IBlockState state) {
		return state.getBlock() == Blocks.FARMLAND;
	}
	//种植的种子
    @Nonnull
    @Override
    protected Item getSeed() {
        return itemLoader.emerald_crop_seeds;
    }
    //收获的物品
    @Nonnull
    @Override
    protected Item getCrop() {
        return Items.EMERALD;
    }
}
