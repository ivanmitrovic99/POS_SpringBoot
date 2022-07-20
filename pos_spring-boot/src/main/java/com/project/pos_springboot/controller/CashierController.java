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
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.pos_springboot.entity.Cashier;
import com.project.pos_springboot.entity.Customer;
import com.project.pos_springboot.entity.Post;
import com.project.pos_springboot.entity.Product;
import com.project.pos_springboot.entity.Purchase;
import com.project.pos_springboot.service.CashierService;
import com.project.pos_springboot.service.CustomerService;
import com.project.pos_springboot.service.GenerateInvoiceService;
import com.project.pos_springboot.service.PostService;
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
public class CashierController {

@Autowired
private CashierService service;

@Autowired
PostService postService;

@GetMapping("/admin")
public String viewAdminPage(Model model) {
List<Cashier> listCashier = service.getCashiers();
model.addAttribute("listCashier", listCashier);
		return "admin";
	}

@GetMapping("/admin/delete/{id}")
public String viewAdminPageAfterDelete(@PathVariable(value="id") long id, Model model) {
	
	service.deleteCashier(id);
	List<Cashier> listCashier = service.getCashiers();
	model.addAttribute("listCashier", listCashier);
			return "admin";
	}
@GetMapping("admin/update/{id}")
public String viewEditCashier(@PathVariable(value="id") long id, Model model) {
Cashier cashier = service.getCashier(id);
model.addAttribute("cashier", cashier);
		return "updateCashier";
	}

@PostMapping("/saveCashier")
public String viewEditSavedProduct(Cashier cashier, Model model) {
	service.updateCashier(cashier);
	List<Cashier> listCashier = service.getCashiers();
	model.addAttribute("listCashier", listCashier);
			return "admin";
}

@PostMapping("/savePost")
public String viewEditSavedPost(Post post, Model model) {
	postService.save(post);
	List<Cashier> listCashier = service.getCashiers();
	model.addAttribute("listCashier", listCashier);
			return "admin";
}

}
