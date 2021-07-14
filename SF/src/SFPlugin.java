import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SFPlugin extends JavaPlugin {

	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new SF(), this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		// 检查是否是玩家
		if (sender instanceof Player) {
			// 发送快递
			if (command.getName().equalsIgnoreCase(SF.send)) {
				if (args.length != 1) {
					sender.sendMessage("参数错误!");
					return false;
				}
				Player target = Bukkit.getPlayer(args[0]);
				if(target instanceof Player == false) {
					sender.sendMessage("参数必须为玩家名称");
					return false;
				}
				// 检查是否在线
				if(!target.isOnline()) {
					sender.sendMessage("玩家已离线");
					return true;
				}
				SF.send((Player) sender, target, this);
				return true;
			}
			// 是否接收快递
			if (command.getName().equalsIgnoreCase(SF.accept)||command.getName().equalsIgnoreCase(SF.ignore)) {
				SF.accept((Player) sender,command.getName().equalsIgnoreCase(SF.accept));
				return true;
			}
		}else{
			sender.sendMessage("该命令仅玩家可用");
		}
		return false;
	}

}
