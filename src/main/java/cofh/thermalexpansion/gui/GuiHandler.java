package cofh.thermalexpansion.gui;

import cofh.core.block.TileCoFHBase;
import cofh.lib.util.helpers.ItemHelper;
import cofh.thermalexpansion.gui.client.GuiSatchel;
import cofh.thermalexpansion.gui.container.ContainerSatchel;
import cofh.thermalexpansion.item.ItemSatchel;
import cpw.mods.fml.common.network.IGuiHandler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {

	public static final int TILE_ID = 0;
	public static final int SATCHEL_ID = 1;

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {

		switch (id) {
		case TILE_ID:
			TileEntity tile = world.getTileEntity(x, y, z);
			if (tile instanceof TileCoFHBase) {
				return ((TileCoFHBase) tile).getGuiClient(player.inventory);
			}
			return null;
		case SATCHEL_ID:
			if (ItemHelper.isPlayerHoldingItem(ItemSatchel.class, player)) {
				return new GuiSatchel(player.inventory, new ContainerSatchel(player.getCurrentEquippedItem(), player.inventory));
			}
			return null;
		default:
			return null;
		}
	}

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {

		switch (id) {
		case TILE_ID:
			TileEntity tile = world.getTileEntity(x, y, z);
			if (tile instanceof TileCoFHBase) {
				return ((TileCoFHBase) tile).getGuiServer(player.inventory);
			}
			return null;
		case SATCHEL_ID:
			if (ItemHelper.isPlayerHoldingItem(ItemSatchel.class, player)) {
				return new ContainerSatchel(player.getCurrentEquippedItem(), player.inventory);
			}
			return null;
		default:
			return null;
		}
	}

}
