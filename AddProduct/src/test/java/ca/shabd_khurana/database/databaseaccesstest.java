package ca.shabd_khurana.database;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ca.shabd_khurana.beans.Product;


public class databaseaccesstest {

	@Autowired
    private databaseaccess databaseAccess;

    @Test
    public void whenInsertProduct_getProductList() {
        int initialSize = databaseAccess.getproductList().size();

        Product product = new Product();
        product.setId(1);
        product.setProductname("Mobile");
        product.setBrand("Apple");
        product.setMadein("California");
        product.setPrice(1500.0);

        databaseAccess.addproduct(product);

        List<Product> productList = databaseAccess.getproductList();

        assertEquals(initialSize + 1, productList.size());
    }
}
