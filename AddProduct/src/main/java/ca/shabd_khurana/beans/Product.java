package ca.shabd_khurana.beans;



import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {

	private int id;
	private String productname;
	private String brand;
	private String madein;
	private Double price;
	
}
