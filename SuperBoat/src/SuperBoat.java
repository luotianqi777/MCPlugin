import org.bukkit.entity.Boat;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.vehicle.VehicleDamageEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class SuperBoat implements org.bukkit.event.Listener{

	private static void KeepFly(Vehicle boat) {
		boat.setVelocity(new Vector(0,0.2,0));
	}

	private static void KeepFire(LivingEntity entity){
		entity.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000, 1));
	}

	@EventHandler
	public void OnDamage(VehicleDamageEvent e){
		if (e.getVehicle() instanceof Boat){
			e.setCancelled(true);
			KeepFly(e.getVehicle());
		}
	}

	@EventHandler
	public void OnEnter(VehicleEnterEvent e){
		if (e.getVehicle() instanceof Boat){
			KeepFly(e.getVehicle());
			if (e.getEntered() instanceof LivingEntity){
				// 防火效果
				KeepFire((LivingEntity)e.getEntered());
			}
		}
	}

}