package com.yuoMod.Tmod.Fluid;

import javax.annotation.Nonnull;

import com.yuoMod.Tmod.tmod;
import com.yuoMod.Tmod.Common.Blocks.blockLoader;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class fluidLoader
{
	public static Fluid emerald_fluid = new emerald_fluid("emerald_fluid");

    public fluidLoader(FMLPreInitializationEvent event)
    {
        if (FluidRegistry.isFluidRegistered(emerald_fluid))
        {
            event.getModLog().info("Found fluid {}, the registration is canceled. ", emerald_fluid.getName());
            emerald_fluid = FluidRegistry.getFluid(emerald_fluid.getName());
        }
        else
        {
            FluidRegistry.registerFluid(emerald_fluid);
            FluidRegistry.addBucketForFluid(emerald_fluid);//注册流体桶
        }
    }
    //注册流体方块材质
    @SideOnly(Side.CLIENT)
    public static void registerRenders()
    {
        registerFluidRender((BlockFluidBase) blockLoader.emerald_fluid, "emerald_fluid");
    }

    @SideOnly(Side.CLIENT)
    public static void registerFluidRender(BlockFluidBase blockFluid, String blockStateName)
    {
        //注意到 setCustomStateMapper 将目标方块指向了一个特殊的 StateMapper，
        //它进而无条件将模型指向 assets/my_mod/blockstates/fluid.json 中定义的 my_fluid 这个 variant。
        ModelLoader.setCustomStateMapper(emerald_fluid.getBlock(), new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(@Nonnull IBlockState state) {
                return new ModelResourceLocation(new ResourceLocation(tmod.MODID, "emerald_fluid"), "fluid");
            }
        });
        ModelResourceLocation model = new ModelResourceLocation(blockFluid.getRegistryName(), "inventory");
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(blockFluid), 0, model);
    } 
    
	
}
