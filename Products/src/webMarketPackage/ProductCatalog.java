package webMarketPackage;
import java.util.*;

public class ProductCatalog {
	private Map<String,Product> catalog ;
	public ProductCatalog() {
		catalog= new HashMap<>();
	}
	public Product getProduct(String id) {
		if(!catalog.containsKey(id)) return null;
		return catalog.get(id);
	}
	public void add(Product product) {
		
		catalog.put(product.getId(), product);
	}
	
	public Map<String,Product> getCatalog() {
		return catalog;
	}

}
