package ltq.mc;
import org.bukkit.plugin.java.JavaPlugin;

public class ZangAiPlugin extends JavaPlugin {

    @Override
    /**
     * 激活插件
     */
    public void onEnable() {
        getLogger().info("load plugin [ZangAi] succuss");
        getCommand("za").setExecutor(new ZangAi());
    }
}
