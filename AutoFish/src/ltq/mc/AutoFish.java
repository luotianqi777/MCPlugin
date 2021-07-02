package ltq.mc;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

public class AutoFish implements Listener {

	@EventHandler
	/**
	 * 监听钓鱼事件
	 * @param e 玩家钓鱼事件
	 */
	public void onFishing(PlayerFishEvent e){
		// 咬钩
		if (e.getState().equals(PlayerFishEvent.State.BITE)){
		}
	}
	
}
