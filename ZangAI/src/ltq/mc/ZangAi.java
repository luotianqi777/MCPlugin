package ltq.mc;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ZangAi implements CommandExecutor{

	/**
	 * 发送消息给所有玩家
	 * @param message 发送的消息
	 */
	public void SendMessage(String message){
		for (Player player : Bukkit.getOnlinePlayers()){
			player.sendMessage(message);
		}
		Bukkit.getLogger().info(message);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String arg, String[] args) {
		StringBuilder message = new StringBuilder();
		message.append(sender.getName() + ": ");
		for (String s : args){
			message.append(s);
		}
		SendMessage(ZangAiTranslator.Translate(message.toString()));
		return true;
	}
}
