package com.yuoMod.Tmod.Common.Items;

import com.yuoMod.Tmod.Creativetab.CreativeTabsLoader;

import net.minecraft.item.ItemAxe;

public class emerald_axe extends ItemAxe
{

	protected emerald_axe(String name,ToolMaterial toolmaterial) 
	{
		super(toolmaterial, 10.0f, -2.0f);
		this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabsLoader.TMOD);
	}
}
