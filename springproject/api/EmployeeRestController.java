package com.bway.springproject.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bway.springproject.model.Cart;
import com.bway.springproject.model.Employee;
import com.bway.springproject.model.Product;
import com.bway.springproject.repository.CartRepository;
import com.bway.springproject.repository.ProductRepository;
import com.bway.springproject.service.EmployeeService;

@RestController
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService empService;
	@Autowired
	private ProductRepository prodRepo;
	@Autowired
	private CartRepository cartRepo;
	
	@GetMapping("/api/emp/list")
	public List<Employee> getAll() {
		return empService.getAllEmps();
	}

	@GetMapping("/api/emp/{id}")
	public Employee getOne(@PathVariable("id") long id) {
		return empService.getEmployeeById(id);
	}
	
	@PostMapping("/api/emp/add")
	public String add(@RequestBody Employee emp) {
		empService.addEmp(emp);
		return "success";
	}
	
	@PutMapping("/api/emp/update")
	public String update(@RequestBody Employee emp) {
		empService.updateEmp(emp);
		return "success";
	}
	
	@DeleteMapping("/api/emp/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
//		empService.deleteEmp(id);
//		return "Deleted Success";
		
		empService.deleteEmp(id);
		return new ResponseEntity<>("delete success",HttpStatus.OK);
		
	}
	@GetMapping("/api/j2o")
	public String json2object() {
		
		RestTemplate tmp = new RestTemplate();
		Employee emp=tmp.getForObject("http://localhost/api/emp/12",Employee.class);
		// tmp.postForObject("http://localhost/api/emp/add", emp, null);
		return "FirstName = "+emp.getFname();
	}
	
	@GetMapping("/api/ja2oa")
	public String jsonArrayToObjectArray() {
		
		RestTemplate temp = new RestTemplate();
		Employee emp[]=temp.getForObject("http://localhost/api/emp/list",Employee[].class);
		return "Name "+emp[1].getFname();
	}
	
	@GetMapping("/api/loadProduct")
	public String loadProduct() {
		
		RestTemplate temp = new RestTemplate();
		Product product[]=temp.getForObject("https://fakestoreapi.com/products",Product[].class);
		prodRepo.saveAll(List.of(product));
		return "success";
	}
	
	

	
//	public void saveToCart(Product product) {
//		Cart cart = new Cart();
//		cart.setProductId(product.getId());
//		cart.setProductName(product.getTitle());
//		cart.setPrice(product.getPrice());
//		cartRepo.save(cart);
//	}
//	
//	@GetMapping("/api/addToCart/{productId}")
//	public String addToCart(@PathVariable int productId) {
//	    RestTemplate temp = new RestTemplate();
//	    
//	    // Fetch the product details from the external API
//	    Product product = temp.getForObject("https://fakestoreapi.com/products/" + productId, Product.class);
//	    
//	    if (product != null) {
//	        // Logic to add the product to the cart (database, in-memory storage, etc.)
//	        saveToCart(product); // Implement saveToCart
//	        return "Product added to cart: " + product.getTitle();
//	    }
//	    return "Product not found!";
//	}
//	
//
//	
//	@GetMapping("/api/cart")
//	public List<Cart> getCartContents(Model model) {
//		model.addAttribute("clist",cartRepo.findAll());
//	    return cartRepo.findAll();
//	}

	
}
