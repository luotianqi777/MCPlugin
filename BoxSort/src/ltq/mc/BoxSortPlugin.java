package ltq.mc;

import org.bukkit.plugin.java.JavaPlugin;

public class BoxSortPlugin extends JavaPlugin{

	@Override
	public void onEnable() {
		// 注册箱子排序
		getServer().getPluginManager().registerEvents(new BoxSort(), this);
		getLogger().info("load plugin [BoxSort] success");
	}

}
