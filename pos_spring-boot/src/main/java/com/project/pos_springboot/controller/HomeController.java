package com.project.pos_springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.pos_springboot.entity.Post;
import com.project.pos_springboot.entity.Product;
import com.project.pos_springboot.service.CashierService;
import com.project.pos_springboot.service.PostService;
import com.project.pos_springboot.service.ProductService;

@Controller
public class HomeController {
	

@Autowired
private CashierService cashierService;
@Autowired
private PostService postService;
@GetMapping("/home")
	public String viewHomePage(Model model) {
	List<Post> listPosts = postService.getPosts();
	model.addAttribute("listPosts", listPosts);
	Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
	String currentUser = authentication.getName();
	int userId=cashierService.cashierId(currentUser);
	model.addAttribute("user",currentUser);
	model.addAttribute("userid",userId);
			return "home";
		}	
	
	
@GetMapping("/")
	public String homepage() {
		return "login";
	}


/*@GetMapping("/admin")
public String admin()
{
	return "admin";
}*/


@GetMapping("/about")
public String about()
{
	return "about";
}

@GetMapping("/logout")
public String logout()
{
	return "Log out successfull!";
}

@GetMapping("/login")
public String login(){
	return "login";
}

@GetMapping("/purchase")
public String doSearchEmployee1(@ModelAttribute("employeeSearchFormData") Product formData, Model model) {
    Product product = new Product();
    model.addAttribute("product", product);
	Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
	String currentUser = authentication.getName();
	int userId=cashierService.cashierId(currentUser);
	model.addAttribute("user",currentUser);
	model.addAttribute("userid",userId);
    return "purchase";            
}


}
