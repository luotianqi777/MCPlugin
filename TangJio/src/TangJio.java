import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class TangJio implements Listener {

	@EventHandler
	/**
	 * 监听实体着火事件
	 * @param e 实体着火事件
	 */
	public void onFire(EntityCombustEvent e){
		// 检测是否是玩家
		if (e.getEntity() instanceof Player){
			Player player = (Player)e.getEntity();
			// 加速
			Vector speed = player.getFacing().getDirection();
			speed.setY(1);
			player.setVelocity(speed);
			// 添加防火效果
			player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 100, 1));
			// 取消着火事件
			e.setCancelled(true);
		}
	}
}
