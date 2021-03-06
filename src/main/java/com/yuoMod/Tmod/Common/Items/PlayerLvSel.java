package com.yuoMod.Tmod.Common.Items;

import java.util.List;

import javax.annotation.Nullable;

import com.yuoMod.Tmod.Capability.CapabilityLoader;
import com.yuoMod.Tmod.Capability.EventMobLv;
import com.yuoMod.Tmod.Capability.IPlayerLevel;
import com.yuoMod.Tmod.Creativetab.CreativeTabsLoader;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

//玩家等级查看器
public class PlayerLvSel extends Item{
	public PlayerLvSel(String name) {
		super();
		this.setUnlocalizedName(name);
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabsLoader.TMOD);
	}
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
		if(!worldIn.isRemote) {
			IPlayerLevel playerCaop = playerIn.getCapability(CapabilityLoader.tmodLv, null);
			Integer exp = playerCaop.getPlayerExp();
			Integer lv = EventMobLv.setPlayerLv(playerIn);
			playerIn.sendMessage(new TextComponentTranslation(I18n.format("tmod.text.level") + lv.intValue()));
			playerIn.sendMessage(new TextComponentTranslation(I18n.format("tmod.text.exp") + exp.intValue())); 
			int id = worldIn.provider.getDimension();
			playerIn.sendMessage(new TextComponentTranslation("世界维度：" + id)); 
		}
        return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		 tooltip.add(I18n.format("tmod.item.player_level", ""));
    }
}
