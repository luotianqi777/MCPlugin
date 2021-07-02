package ltq.mc;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ZangAi implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String arg, String[] args) {
		Player player = Bukkit.getPlayer(sender.getName());
		player.sendRawMessage(ZangAiTranslator.Translate(arg));
		return true;
	}
}
