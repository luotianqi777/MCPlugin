import org.bukkit.plugin.java.JavaPlugin;

public class TangJioPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new TangJio(), this);
    }
}
