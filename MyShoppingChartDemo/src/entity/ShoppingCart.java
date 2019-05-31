package entity;

import java.util.ArrayList;
import java.util.HashMap;

import dao.ItemsDAO;

public class ShoppingCart {
	
	private double sumPrice;
	private HashMap<Integer,BoughtItem> itemList; 
	
	
	public ShoppingCart() {
		this.sumPrice = 0;
		this.itemList = new HashMap<Integer,BoughtItem>();
				
	}
	
	public boolean addItems(Items item) {
		if(itemList.containsKey(item.getId())) {
			
			BoughtItem b1 = itemList.get(item.getId());
			int num = b1.getItemNum();
			b1.setItemNum(++num);
			return itemList.replace(item.getId(), b1)==null ? false :true;
		}else {
			BoughtItem b2 = new BoughtItem(item);
		    return itemList.put(item.getId(),b2)==null ? false :true; 
		}		
	}
	
	public boolean deleteItem(Items item) {
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
		if (bl != null) {
			for (BoughtItem bi : bl) {
				this.sumPrice += bi.getPrice()*bi.getItemNum();
			}
		}		
		return this.sumPrice;
	}
	
    public ArrayList<BoughtItem> getItemList() {
    	return new ArrayList<BoughtItem>(this.itemList.values());
    }
    //test 
//    public static void main (String[] args) {
//    	ItemsDAO idao = new ItemsDAO();
//    	ShoppingCart sc = new ShoppingCart();
//    	sc.addItems(idao.getItemsById(1));
//    	sc.addItems(idao.getItemsById(1));
//    	sc.addItems(idao.getItemsById(3));
//    	sc.addItems(idao.getItemsById(2));
//    	sc.deleteItem(idao.getItemsById(1));
//    	sc.deleteItem(idao.getItemsById(1));
//    	System.out.println(sc.sumItemPrice()+" "+sc.getItemList().size());
//    	ArrayList<BoughtItem> bi = sc.getItemList();
//    	for(BoughtItem i:bi) {
//    		System.out.println(i.getName()+" "+i.getItemNum()+" "+i.getPrice());
//    	}
//    }
    
}
