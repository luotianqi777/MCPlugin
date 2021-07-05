import org.bukkit.plugin.java.JavaPlugin;

public class AutoFishPlugin extends JavaPlugin{
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new AutoFish(), this);
		getLogger().info("load plugin [AutoFish] success");
	}
} 