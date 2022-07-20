package com.project.pos_springboot.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.pos_springboot.entity.Cashier;
import com.project.pos_springboot.entity.Customer;
import com.project.pos_springboot.entity.Product;
import com.project.pos_springboot.entity.Purchase;
import com.project.pos_springboot.repository.ProductRepository;
import com.project.pos_springboot.service.CashierService;
import com.project.pos_springboot.service.CustomerService;
import com.project.pos_springboot.service.GenerateInvoiceService;
import com.project.pos_springboot.service.ProductService;
import com.project.pos_springboot.service.PurchaseService;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

@Controller
public class ProductController {

@Autowired
private ProductService service;


@GetMapping("/products")
public String viewProductPage(Model model) {
List<Product> listProduct = service.findAll();
model.addAttribute("listProduct", listProduct);
		return "products";
	}

@PostMapping("/productSearch")
public String pidUserSubmit(@RequestParam(name = "name") String name, Model model) {
   List<Product> listProduct = service.productSearch(name);
   model.addAttribute("listProduct", listProduct);
   return "products";
}
@GetMapping("/delete/{id}")
public String viewProudctPageAfterDelete(@PathVariable(value="id") long id, Model model) {
	
	service.deleteProduct(id);
	List<Product> listProduct = service.findAll();
	model.addAttribute("listProduct", listProduct);
	return "products";
	}
@GetMapping("/update/{id}")
public String viewEditProduct(@PathVariable(value="id") long id, Model model) {
Product product = service.findById(id);
System.out.print(id);
model.addAttribute("product", product);
		return "updateProduct";
	}


@PostMapping("/saveProduct")
public String viewEditSavedProduct(Product product, Model model) {
	service.updateProduct(product);
	List<Product> listProduct = service.findAll();
	model.addAttribute("listProduct", listProduct);
	return "products";
}

}
