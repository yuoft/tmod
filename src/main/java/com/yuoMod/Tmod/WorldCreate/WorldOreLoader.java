package com.yuoMod.Tmod.WorldCreate;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class WorldOreLoader 
{
	private static WorldGenerator oreCreate = new WorldOreCreate();
	private static WorldGenerator SpaceOre = new SpaceOreSpawn();
	private static WorldGenerator SaltOre = new SaltOreSpawn();
	private static WorldGenerator RubyOre = new RubyOreSpawn();
    private BlockPos pos;
    
    public WorldOreLoader()
    {
        MinecraftForge.ORE_GEN_BUS.register(this);
    }
    
	@SubscribeEvent
    public void onOreGenPost(OreGenEvent.Post event)
    {
        if (!event.getPos().equals(this.pos))
        {
            this.pos = event.getPos();
            oreCreate.generate(event.getWorld(), event.getRand(), event.getPos());
            SpaceOre.generate(event.getWorld(), event.getRand(), event.getPos());
            SaltOre.generate(event.getWorld(), event.getRand(), event.getPos());
            RubyOre.generate(event.getWorld(), event.getRand(), event.getPos());
        }
    }

    @SubscribeEvent
    public void onOreGenGenerateMinable(OreGenEvent.GenerateMinable event)
    {
//    	if (event.getType() == OreGenEvent.GenerateMinable.EventType.QUARTZ)
//        {
//    		event.setResult(Result.DENY);
//            oreCreate.generate(event.getWorld(), event.getRand(), event.getPos());
//        }
    	if (!event.getPos().equals(this.pos))
        {
            this.pos = event.getPos();
            oreCreate.generate(event.getWorld(), event.getRand(), event.getPos());
            SpaceOre.generate(event.getWorld(), event.getRand(), event.getPos());
            SaltOre.generate(event.getWorld(), event.getRand(), event.getPos());
            RubyOre.generate(event.getWorld(), event.getRand(), event.getPos());
        }
    }
}
