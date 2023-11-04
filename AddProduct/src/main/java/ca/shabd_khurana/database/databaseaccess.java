package ca.shabd_khurana.database;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.shabd_khurana.beans.Product;

@Repository
public class databaseaccess {
	
    @Autowired
    protected NamedParameterJdbcTemplate jdbc;

    public void addproduct(Product product) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();

        String query = "INSERT INTO product(productname, brand, madein, price) " +
                "VALUES (:productname, :brand, :madein, :price)";

        namedParameters
                .addValue("productname", product.getProductname())
                .addValue("brand", product.getBrand())
                .addValue("madein", product.getMadein())
                .addValue("price", product.getPrice());

        int rowsAffected = jdbc.update(query, namedParameters);

        if (rowsAffected > 0)
            System.out.println("Product added into the database");
    }


    public List<Product> getproductList() {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "SELECT * FROM product";

        return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Product>(Product.class));
    }

    public void deleteProductById(Long id) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();

        String query = "DELETE FROM product WHERE id = :id";
        namedParameters.addValue("id", id);

        int rowsAffected = jdbc.update(query, namedParameters);
        if (rowsAffected > 0) {
            System.out.println("Deleted product " + id + " from the database.");
        }
    }

    public List<Product> getProductListById(Long id) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "SELECT * FROM product WHERE id = :id";
        namedParameters.addValue("id", id);

        return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Product>(Product.class));
    }
}
