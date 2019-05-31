package entity;

public class BoughtItem extends Items {
	private int itemNum = 0;
	public BoughtItem() {
		super();
	}
	
	public BoughtItem(Items it) {
		this.setId(it.getId());
		this.setCity(it.getCity());
		this.setName(it.getName());
		this.setPicture(it.getPicture());
		this.setPrice(it.getPrice());
		this.setStockNum(it.getStockNum());
		itemNum = 1; 
	}
	
	public int getItemNum() {
		return itemNum;
	}
	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}

}
