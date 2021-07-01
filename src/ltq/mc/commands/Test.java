package ltq.mc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * 测试命令
 */
public class Test implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sendor, Command command, String arg, String[] args) {
		if (sendor instanceof Player){
			Player player = (Player)sendor;
			player.sendMessage("test success");
		}
		return false;
	}

}
