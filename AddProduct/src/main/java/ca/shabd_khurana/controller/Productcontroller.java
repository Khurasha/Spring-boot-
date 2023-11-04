package ca.shabd_khurana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.shabd_khurana.beans.Product;
import ca.shabd_khurana.database.databaseaccess;


@Controller
public class Productcontroller {

	@Autowired
	private databaseaccess da;
	
	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("productList", da.getproductList());
		model.addAttribute("product", new Product());

		return "index";
	}
	
	@GetMapping("/new")
	public String Product(Model model) {

		model.addAttribute("product", new Product());
		return "new";
	}
	
	@GetMapping("/deleteProductById/{id}")
	public String deleteProductById(Model model, @PathVariable Long id) {
		da.deleteProductById(id);
		
		model.addAttribute("product", new Product());
		model.addAttribute("productList", da.getproductList());
		
		return "index";
		
	}
	
	@GetMapping("/editProductById/{id}")
	public String editProductById(Model model, @PathVariable Long id) {
	    
		Product product = da.getProductListById(id).get(0);

	    model.addAttribute("product", product);

	    da.deleteProductById(id);

	    model.addAttribute("productList", da.getproductList());

	    return "new";
	}
	
	@PostMapping("/addproduct")
	public String addroduct(Model model, @ModelAttribute Product product) {
	    da.addproduct(product);
	    model.addAttribute("productList", da.getproductList());
	    model.addAttribute("product", new Product());

	    return "index";
	}
}
