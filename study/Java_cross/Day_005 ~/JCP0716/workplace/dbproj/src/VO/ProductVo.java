package VO;

// product# table mapping
public class ProductVo {
	
	private String product_code;
	private String product_category;
	private String product_name;
	private int product_price;
	
	
	
	// 기본 생성자
	public ProductVo() {
	}
	
	// 커스텀 생성자
	public ProductVo(String product_code, String product_category, String product_name, int product_price) {
		super();
		this.product_code = product_code;
		this.product_category = product_category;
		this.product_name = product_name;
		this.product_price = product_price;
	}

	public String toString() {
		// TODO Auto-generated method stub
		return "ProductVo [product_code : " + product_code + "   product_category : " + product_category 
				+ "   product_name : " + product_name + "   product_price : " + product_price + "]";
	}

	// getter, setter
	public String getProduct_code() {
		return product_code;
	}



	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}



	public String getProduct_category() {
		return product_category;
	}



	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}



	public String getProduct_name() {
		return product_name;
	}



	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}



	public int getProduct_price() {
		return product_price;
	}



	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	
		
	
	
}
