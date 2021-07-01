package ltq.mc.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Test implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sendor, Command command, String arg, String[] args) {
		if (sendor instanceof Player){
			Player player = (Player)sendor;
			player.sendMessage("test success");
			ItemStack bread = new ItemStack(Material.BREAD, 10);
			ItemStack redstone = new ItemStack(Material.REDSTONE, 5);
			player.getInventory().addItem(bread, redstone);
		}
		return false;
	}

}
