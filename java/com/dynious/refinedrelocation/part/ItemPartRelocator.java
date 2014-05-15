package com.dynious.refinedrelocation.part;

import codechicken.lib.vec.BlockCoord;
import codechicken.lib.vec.Vector3;
import codechicken.multipart.JItemMultiPart;
import codechicken.multipart.TMultiPart;
import com.dynious.refinedrelocation.RefinedRelocation;
import com.dynious.refinedrelocation.lib.Names;
import com.dynious.refinedrelocation.lib.Resources;
import com.dynious.refinedrelocation.renderer.RendererRelocator;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ItemPartRelocator extends JItemMultiPart
{
    public ItemPartRelocator(int id)
    {
        super(id);
        this.setUnlocalizedName(Names.relocator);
        this.setCreativeTab(RefinedRelocation.tabRefinedRelocation);
    }

    @Override
    public TMultiPart newPart(ItemStack itemStack, EntityPlayer player, World world, BlockCoord blockCoord, int i, Vector3 vector3)
    {
        return PartFactory.INSTANCE.createPart(Names.relocator, false);
    }

    @Override
    public void registerIcons(IconRegister register)
    {
        RendererRelocator.loadIcons(register);
    }
}