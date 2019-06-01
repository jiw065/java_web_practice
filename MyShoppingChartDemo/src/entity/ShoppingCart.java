package entity;

import java.util.ArrayList;
import java.util.HashMap;

import dao.ItemsDAO;

public class ShoppingCart {
	
	private double sumPrice;
	private HashMap<Integer,BoughtItem> itemList; 
	private ItemsDAO idao = new ItemsDAO();
	
	public ShoppingCart() {
		this.sumPrice = 0;
		this.itemList = new HashMap<Integer,BoughtItem>();
				
	}
	
	public boolean addItems(int id) {
		
		Items item = idao.getItemsById(id);
		if(itemList.containsKey(item.getId())) {
			
			BoughtItem b1 = itemList.get(item.getId());
			int num = b1.getItemNum();
			b1.setItemNum(++num);
			return itemList.replace(item.getId(), b1)==null ? false :true;
		}else {
			BoughtItem b2 = new BoughtItem(item);
			itemList.put(item.getId(),b2);
		    return true; 
		}		
	}
	
	public boolean deleteItem(int id) {
		Items item = idao.getItemsById(id);
		BoughtItem bi = itemList.get(item.getId());
		int num = bi.getItemNum();
		if (num > 1) {
			bi.setItemNum(--num);
			return itemList.replace(item.getId(), bi)==null ? false :true;
		}else {
			return itemList.remove(item.getId())==null ? false:true;
		}
	}
	
	public double sumItemPrice() {
		ArrayList<BoughtItem> bl = this.getItemList();
		this.sumPrice = 0;
		if (bl != null) {
			for (BoughtItem bi : bl) {
				System.out.println(bi.getName()+" "+bi.getItemNum()+" "+bi.getPrice());
				this.sumPrice += bi.getPrice()*bi.getItemNum();
			}
		}		
		return this.sumPrice;
	}
	
	public BoughtItem getBoughtItem(int id) {
		return itemList.get(id);	
	}
	
    public ArrayList<BoughtItem> getItemList() {
    	return new ArrayList<BoughtItem>(this.itemList.values());
    }
    //test 
//    public static void main (String[] args) {
//    	ShoppingCart sc = new ShoppingCart();
//    	sc.addItems(1);
//    	sc.addItems(1);
//    	sc.addItems(3);
//    	sc.addItems(2);
//    	sc.deleteItem(1);
//    	sc.deleteItem(1);
//    	System.out.println(sc.sumItemPrice()+" "+sc.getItemList().size());
//
//    }
}
