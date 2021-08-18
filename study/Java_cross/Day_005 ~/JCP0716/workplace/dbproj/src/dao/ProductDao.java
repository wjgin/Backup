package dao;

public class ProductDao {

	private static ProductDao dao = new ProductDao();
	
	private ProductDao() {
	}
	
	public static ProductDao getInstance() { 
		return dao;
	}
}
