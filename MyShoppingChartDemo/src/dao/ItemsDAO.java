package dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Items;

import java.sql.Array;
import java.sql.PreparedStatement;
import oracle.jdbc.*;
import util.DbHelper;
/**
 * 
 * @author Amber
 *
 *  id number(11) NOT NULL,
   name varchar(50) default NULL,
   city varchar(50) default NULL,
   price number(11) default NULL,
   stock number(11) default NULL,
   picture varchar(500) default NULL,
 *
 */
public class ItemsDAO {
	
	
	public ItemsDAO() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * get info for all items from database
	 */
	public ArrayList<Items> getAllItems(){
		String pStr = "SELECT * FROM ITEMS";
		ArrayList<Items> itemList = new ArrayList<Items>();
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection conn = null;
		try {
			conn = DbHelper.getConnection();
			stmt = conn.prepareStatement(pStr);
			rs = stmt.executeQuery();

			Items item; 
			 while(rs.next()){
				 item = new Items();
		         item.setCity(rs.getString("city"));
		         item.setId(rs.getInt("id"));
		         item.setName(rs.getString("name"));
		         item.setPicture(rs.getString("picture"));
		         item.setPrice(rs.getInt("price"));
		         item.setStockNum(rs.getInt("stock"));
		         itemList.add(item);
		     }  
			 return itemList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}		
		
	}
	
	public Items getItemsById(int id) {
		Items item = new Items(); 
		String pStr = "SELECT * FROM ITEMS WHERE ID = ?";
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection conn = null;
		
		try {
			conn = DbHelper.getConnection();
			stmt = conn.prepareStatement(pStr);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				item.setCity(rs.getString("city"));
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setPicture(rs.getString("picture"));
				item.setPrice(rs.getInt("price"));
				item.setStockNum(rs.getInt("stock"));			
			}else {
				return null;
			}
				
			return item; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}		
		
	}
	
	
	public ArrayList<Items> getViewItems(String list){
		ArrayList<Items> vList = new ArrayList<Items>();
		System.out.println(list);
		int count = 5;
		
		if( list!=null && !list.equals("")) {
			String[] listItem = list.split(",");
			int len = 0;
			while(count>0) {
				Items item = getItemsById(Integer.parseInt(listItem[len]));
				vList.add(item);				
				len++;
				if(len == listItem.length) {
					break;
				}
				count--; 
			}
		}else {
			return null;
		}		
		
		return vList;
	}
	
/*	
	public static void main(String[] args) {
		ItemsDAO idao = new ItemsDAO();
		ArrayList<Items> l =idao.getViewItems("1,2,3,4,5");
		for(Items i: l) {
			System.out.println("item:"+i.getName());
		}
	}
*/

}
