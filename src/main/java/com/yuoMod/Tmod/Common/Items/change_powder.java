package com.yuoMod.Tmod.Common.Items;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.yuoMod.Tmod.Creativetab.CreativeTabsLoader;

import net.minecraft.block.Block;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class change_powder extends Item
{
	public change_powder(String name)
	{
		super();
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabsLoader.TMOD);
		this.setMaxStackSize(64);
	}
	//��Ʒʹ��
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		Block block=worldIn.getBlockState(pos).getBlock();
//		player.sendMessage(new TextComponentTranslation(block.getUnlocalizedName()+" "+pos.toString()));
		if (block.getUnlocalizedName().equals("tile.sapling")) {
			Random random=new Random();
			if(random.nextInt(100)>89)
			{
//				player.sendMessage(new TextComponentTranslation("tmod.text.change_powder1"));
			}
			else 
			{
				worldIn.setBlockState(pos, itemLoader.emerald_sapling.getBlock().getDefaultState());
				// ��������� Translation Key �Ž�ȥ���ɡ�
//				player.sendMessage(new TextComponentTranslation("tmod.text.change_powder2"));
			}
			ItemStack itemStack=player.getHeldItem(hand);
			itemStack.setCount(itemStack.getCount()-1);
		}
        return EnumActionResult.PASS;
    }
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
       tooltip.add(I18n.format("tmod.item.change_powder3", ""));
       tooltip.add(I18n.format("tmod.item.change_powder4", ""));
    }
}