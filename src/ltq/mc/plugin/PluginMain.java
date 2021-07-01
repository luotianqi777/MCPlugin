package ltq.mc.plugin;

import org.bukkit.plugin.java.JavaPlugin;

import ltq.mc.commands.*;

public class PluginMain extends JavaPlugin{

	@Override
	public void onDisable() {
	}
	
	@Override
	public void onEnable() {
		this.getCommand("test").setExecutor(new Test());
		getLogger().info("install [test]");
	}

}
