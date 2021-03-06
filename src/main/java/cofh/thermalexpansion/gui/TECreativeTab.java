package cofh.thermalexpansion.gui;

import cofh.thermalexpansion.block.machine.BlockMachine;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TECreativeTab extends CreativeTabs {

	private final String label;

	public TECreativeTab() {

		this("");
	}

	public TECreativeTab(String label) {

		super("ThermalExpansion" + label);
		this.label = label;
	}

	protected ItemStack getStack() {

		return BlockMachine.furnace;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack() {

		return getStack();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {

		return getIconItemStack().getItem();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getTabLabel() {

		return "thermalexpansion.creativeTab" + label;
	}

}
