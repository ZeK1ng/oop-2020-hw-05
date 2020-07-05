package webMarketPackage;
import java.util.*;
public class ShoppingCart {
	private Map<String , Integer> productsInCart;
	private double totalCost;
	
	public ShoppingCart() {
		productsInCart = new HashMap<>();
		totalCost = 0;
	}
	public void add(String prodId, double price) {
		totalCost+=price;
		if(productsInCart.containsKey(prodId)) {
			productsInCart.put(prodId, productsInCart.get(prodId) +1);
		}else {
			productsInCart.put(prodId, 1);
		}
	}
	public void add(String prodId,double price, int amount) {
		if(productsInCart.containsKey(prodId)) {
			totalCost -= productsInCart.get(prodId) * price;
			productsInCart.remove(prodId);
		}
		if(amount == 0 )return;
		totalCost+=amount * price;
		productsInCart.put(prodId, amount);
	}
	
	public double getTC() {
		return totalCost;
	}
	public int getAmount(String id) {
		if(productsInCart.containsKey(id)) {
			return productsInCart.get(id);
		}
		return -1;
	}
	public Map<String,Integer> getCart() {
		return productsInCart;
	}
	
}
