package com.yuoMod.Tmod.Common;

import com.yuoMod.Tmod.Capability.CapabilityLoader;
import com.yuoMod.Tmod.Capability.EventMobLv;
import com.yuoMod.Tmod.Common.Blocks.blockLoader;
import com.yuoMod.Tmod.Common.Crafting.CraftingLoader;
import com.yuoMod.Tmod.Common.Items.itemLoader;
import com.yuoMod.Tmod.Creativetab.CreativeTabsLoader;
import com.yuoMod.Tmod.Enchantment.enchantmentLoader;
import com.yuoMod.Tmod.Entity.EntityLoader;
import com.yuoMod.Tmod.Entity.Villager.VillagerLoader;
import com.yuoMod.Tmod.Fluid.fluidLoader;
import com.yuoMod.Tmod.Gui.guiLoader;
import com.yuoMod.Tmod.Network.NetworkLoader;
import com.yuoMod.Tmod.Potion.potionLoader;
import com.yuoMod.Tmod.TileEntity.TileEntityLoader;
import com.yuoMod.Tmod.WorldCreate.WorldOreLoader;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class common
{
    public void preInit(FMLPreInitializationEvent event)
    {
    	new CreativeTabsLoader(event);//创造物品栏注册
    	new fluidLoader(event);//流体注册
    	itemLoader.init(event);//注册物品
    	new blockLoader(event);//方块注册
    	new potionLoader(event);//药水状态注册
    	new EntityLoader();//实体注册
    	new TileEntityLoader(event);//TileEntity注册
    	new VillagerLoader();//村民职业注册
    	new CapabilityLoader(event);//能力系统注册
    	new NetworkLoader(event);//消息传递，数据同步
    }

    public void init(FMLInitializationEvent event)
    {
    	new CraftingLoader();//熔炉配方注册
    	new enchantmentLoader();//附魔注册
    	new eventLoader();//事件注册
    	new EventCraftSalt();//含杂盐洗净事件
    	new EventCraftRuby();//红宝石矿烧炼
    	new EventMobLv();//怪物等级
    	new LuckyEvent();//幸运方块事件
    	new WorldOreLoader();//矿物生成注册
    	new guiLoader();//gui注册
    }
    public void postInit(FMLPostInitializationEvent event)
    {
    	
    }
}
