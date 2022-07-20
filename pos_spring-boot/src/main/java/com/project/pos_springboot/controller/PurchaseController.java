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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.pos_springboot.entity.Cashier;
import com.project.pos_springboot.entity.Customer;
import com.project.pos_springboot.entity.Product;
import com.project.pos_springboot.entity.Purchase;
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
public class PurchaseController {

@Autowired
private ProductService service;

@Autowired 
private CustomerService customerService;

@Autowired
private CashierService cashierService;

@Autowired
private PurchaseService purchaseService;

@Autowired
private GenerateInvoiceService invoiceService;

@PostMapping("/search")
public String doSearchEmployee(@ModelAttribute("employeeSearchFormData") Product formData, Model model) {
       Product product = service.findById(formData.getId());
       model.addAttribute("product", product);
       Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
   		String currentUser = authentication.getName();
   		int userId=cashierService.cashierId(currentUser);
   		model.addAttribute("user",currentUser);
   		model.addAttribute("userid",userId);
       return "purchase";            
}

@PostMapping("/saveCustomer")
public String saveCustomer(Customer customer, Model model) {
	customerService.saveData(customer);
	long id=customerService.customerId();
	String customerId="Id poslednjeg dodatog kupca je " + id;
	Product product = new Product();
	model.addAttribute("product",product);
	Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
	String currentUser = authentication.getName();
	int userId=cashierService.cashierId(currentUser);
	model.addAttribute("user",currentUser);
	model.addAttribute("userid",userId);
	model.addAttribute("customerId",customerId);
	return "purchase";
}
/*
@PostMapping("/savePurchase")
public String savePurchase(Purchase purchase, Model model) {
	System.out.println(purchase.getProducts());
	purchaseService.saveData(purchase);
	
	Product product = new Product();
	model.addAttribute("product",product);
	Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
	String currentUser = authentication.getName();
	int userId=cashierService.cashierId(currentUser);
	model.addAttribute("user",currentUser);
	model.addAttribute("userid",userId);
	return "purchase";
}*/

@PostMapping("/savePurchase")
public String test(Purchase purchase, float total, float paid, Model model) throws FileNotFoundException, JRException {
	float total_tax=0;
	purchaseService.saveData(purchase);
	String products=purchase.getProducts();
	String quantities=purchase.getQuantity();
	Customer customer=purchase.getCustomer();
	Cashier cashier= purchase.getCashier();
	List<String> quantitiesList = Arrays.asList(quantities.split(" "));
	String outputFile= "C:\\Users\\Ivan\\eclipse-workspace\\pos_spring-boot.zip_expanded\\pos_spring-boot\\src\\main\\resources\\Invoice.pdf";
	List<Product> listProducts = invoiceService.getProducts(products);
	for(int i=0;i<listProducts.size();i++) {
		listProducts.get(i).setTax_symbol(quantitiesList.get(i));
		
		total_tax=total_tax+listProducts.get(i).getPrice()*Float.parseFloat(quantitiesList.get(i))*listProducts.get(i).getTax_rate()/100;
	}
	JRBeanCollectionDataSource items = new JRBeanCollectionDataSource(listProducts);
	
	Map parameters = new HashMap<>();
	parameters.put("CollectionBeanParam", items);
	parameters.put("Parameter1", quantitiesList);
	parameters.put("Parameter2",customer);
	parameters.put("Parameter3", cashier);
	parameters.put("purchase", purchase);
	parameters.put("paid", paid);
	parameters.put("total_tax", total_tax);
	InputStream input = new FileInputStream("C:\\Users\\Ivan\\eclipse-workspace\\pos_spring-boot.zip_expanded\\pos_spring-boot\\src\\main\\resources\\Invoice.jrxml");
	JasperDesign jasperDesign = JRXmlLoader.load(input);
	JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
	JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
	OutputStream outputStream = new FileOutputStream(new File(outputFile));
	JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
	Product product = new Product();
	model.addAttribute("product",product);
	Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
	String currentUser = authentication.getName();
	int userId=cashierService.cashierId(currentUser);
	model.addAttribute("user",currentUser);
	model.addAttribute("userid",userId);
	model.addAttribute("customerId",customer.getId());
	return "purchase";
}

}
