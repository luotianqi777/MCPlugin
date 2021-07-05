import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockIgniteEvent.IgniteCause;

public class SuperBoat implements org.bukkit.event.Listener{

	@EventHandler
	/**
	 * 监听点燃事件
	 * @param e 点燃事件
	 */
	public void OnFire(BlockIgniteEvent e){
		// 被岩浆点燃
		if (e.getCause() == IgniteCause.LAVA){
			for (Player player : Bukkit.getOnlinePlayers()){
				player.sendMessage("something be fired by lava!");
			}
			// 取消事件
			e.setCancelled(true);
		}
	}
}
