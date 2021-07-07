import org.bukkit.plugin.java.JavaPlugin;

public class SuperBoatPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new SuperBoat(), this);
    }
}
