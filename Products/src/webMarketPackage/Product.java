package webMarketPackage;


public class Product {
	private String id;
	private String name;
	private String imageFile;
	private double price;
	public Product(String prod_id, String name, String imageFile, double price) {
		// TODO Auto-generated constructor stub
		this.id= prod_id;
		this.name = name;
		this.imageFile = imageFile;
		this.price = price;
	}
	public String getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public String getImageFile() {
		return this.imageFile;
	}
	public double getPrice() {
		return this.price;
	}
	
//	@Override
//	public boolean equals(Object ob) {
//		if(ob== this) return true;
//		if(! (ob instanceof Product)) return false;
//		Product prod = (Product) ob;
//		return this.id.equals(prod.getId()) && this.name.equals(prod.getName())
//				&& this.imageFile.equals(prod.getImageFile()) && this.price == prod.getPrice();
//	}
//	@Override
//	public int hashCode() {
//		String st = this.id + this.name + this.imageFile + this.price;
//		return st.hashCode();
//	}
////	
//	<%
//	ProductCatalog cat = (ProductCatalog)getServletContext().getAttribute("productCatalog");
//	List<Product> catalog = cat.getCatalog();
//	out.print("<ul>");
//	for(int i = 0; i<catalog.size(); i++){
//		out.print("<li>");
//		out.print("<a href=\"ProductServlet?id=" + catalog.get(i).getId());
//		out.print("\">");
//		out.print(catalog.get(i).getName());
//		out.print("/a>");
//		out.print("</li>");
//	}
//	out.print("</ul>");
//%>

}
