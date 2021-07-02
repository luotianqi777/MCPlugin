package ltq.mc;

import java.util.Comparator;
import java.util.LinkedList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * 箱子排序
 */
public class BoxSort implements Listener{
	
	/**
	 * 排序物品堆数组
	 * @param content 容器中所有物品的列表
	 * @param start 排序起始下标
	 * @param end 排序中止下标
	 * @return 排序后的物品列表
	 */
	private LinkedList<ItemStack> sort(ItemStack[] content, int start, int end) {
		LinkedList<ItemStack> items = new LinkedList<ItemStack>();
		// 获取指定范围中的物品
		for (int i = start; i < end; i++) {
			if (content[i] != null) {
				items.add(content[i]);
			}
		}
		items.sort(new Comparator<ItemStack>() {
			@Override
			public int compare(ItemStack arg0, ItemStack arg1) {
				return arg0.getType().ordinal() - arg1.getType().ordinal();
			}
		});
		return items;
	}

	/**
	 * 排序容器
	 * @param inventory 容器对象
	 */
	private void sort(Inventory inventory) {
		ItemStack[] content = inventory.getContents().clone();
		inventory.clear();
		for (ItemStack item : sort(content, 0, content.length)) {
			inventory.addItem(item);
		}
	}

	/**
	 * 排序玩家背包
	 * @param inventory 玩家的容器对象
	 */
	public void sortPlayer(Inventory inventory) {
		ItemStack[] content = inventory.getContents().clone();
		inventory.clear();
		// 工具栏排序
		for (ItemStack item : sort(content, 0, 9)) {
			inventory.addItem(item);
		}
		// 物品栏下标
		int index = 9;
		// 物品栏排序
		for (ItemStack item: sort(content, 9, 36)) {
			inventory.setItem(index, item);
			index++;
		}
		// 装备栏不排序
		for (int i = content.length - 5; i < content.length; i++) {
			inventory.setItem(i, content[i]);
		}
	}

	/**
	 * 监听容器点击事件
	 * @param e 容器点击事件
	 */
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		// 按下滑轮排序
		if (e.getClick() != ClickType.MIDDLE) {
			return;
		}
		// 过滤非箱子容器
		if (!e.getInventory().getType().equals(InventoryType.CHEST)) {
			return;
		}
		// 获取容器对象
		Inventory inventory = e.getClickedInventory();
		if (inventory.getType().equals(InventoryType.CHEST)) {
			// 箱子排序
			sort(inventory);
		} else if (inventory.getType().equals(InventoryType.PLAYER)) {
			// 玩家物品栏排序
			sortPlayer(inventory);
		} else {
			return;
		}
		// 关闭UI再开启模拟刷新
		Player player = Bukkit.getPlayer(e.getWhoClicked().getName());
		player.closeInventory();
		player.openInventory(e.getInventory());
	}
}
