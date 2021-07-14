import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class TPPlugin extends JavaPlugin {

	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new TP(), this);
		TP.setPlugin(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		// 检查是否为玩家
		if (sender instanceof Player) {
			// 传送请求
			if (command.getName().equalsIgnoreCase(TP.tpa) || command.getName().equalsIgnoreCase(TP.tpahere)) {
			Boolean dire = command.getName().equalsIgnoreCase(TP.tpa);
				if (args.length == 0) {
					// 无参数则显示UI
					TP.tpUI((Player) sender, dire);
				} else if (args.length == 1) {
					// 有参数则tp到玩家
					Player target = Bukkit.getPlayer(args[0]);
					// 检查是否是玩家
					if (target instanceof Player == false) {
						sender.sendMessage("参数必须为玩家名称");
						return false;
					}
					// 检查是否在线
					if (target.isOnline()) {
						TP.tp((Player) sender, target, dire);
						return true;
					}else{
						sender.sendMessage("玩家已离线");
						return false;
					}
				}
			}else 
			// 是否接受请求
			if (command.getName().equalsIgnoreCase(TP.accept)||command.getName().equalsIgnoreCase(TP.ignore)) {
				Boolean ok = command.getName().equalsIgnoreCase(TP.accept);
				TP.accept(ok, (Player) sender);
				return true;
			}else{
				return false;
			}
		}else{
			sender.sendMessage("该命令仅玩家可用");
			return false;
		}
		return false;
	}
}
