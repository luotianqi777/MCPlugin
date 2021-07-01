package ltq.mc.plugin;

import org.bukkit.plugin.java.JavaPlugin;

import ltq.mc.commands.*;
import ltq.mc.listener.BoxSort;

public class PluginMain extends JavaPlugin{

	@Override
	public void onDisable() {
	}
	
	@Override
	public void onEnable() {
		// 注册test命令
		this.getCommand("test").setExecutor(new Test());
		// 注册箱子排序
		getServer().getPluginManager().registerEvents(new BoxSort(), this);
	}

}
