package com.smart.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smart.Entity.Crops;
import com.smart.service.CropsService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CropsController {

	@Autowired
	private CropsService cropsService;

	// Handler for main crop page
	@RequestMapping("/crops")
	public String Login(Model model) {

		model.addAttribute("title", "Crops - igaptech_Swastik ");

		return "crops";
	}

	// Show all--to display all crops
	@RequestMapping("/allcrops")
	public String viewAll(Model m) {

		List<Crops> list = cropsService.FindAll();

		m.addAttribute("viewcrops", list);

		return "crops";
	}


	// A. for adding crop
	@RequestMapping("/addcrop")
	public String AddCrop() {

		return "addcrops";
	}

	// a. Hander for to add new crops
	@PostMapping("/savecrop")
	public String addcrops(@ModelAttribute Crops crops, HttpSession session) {

		cropsService.save(crops);

		session.setAttribute("msg", "Crop Added succesfully..");

		return "redirect:/addcrop";

	}

	// B. for Edit Or Update crop
	@RequestMapping("/editcrop/{id}")
	public String editCrop(@PathVariable(value = "id") int id, Model m) {

		Optional<Crops> crp = cropsService.findById(id);//Calling repository findbyid  method and storing value in crp
		
		Crops cp=crp.get();//Getting value in cp 
		                             
		m.addAttribute("crop", cp); //and here value of cp stored in crop
		
		return "Edit";
		
	}

	// b. Handler for update crops
	
	  @PostMapping("/updatecrop")
	  public String updatecrops(@ModelAttribute Crops thecrops,HttpSession session) {
	  
	  cropsService.save(thecrops);
	  
	  session.setAttribute("msg", "Crop Update succesfully");
	  
	  return "redirect:/allcrops"; }
	 
	  

	  // handler for delete operation
	@RequestMapping("/deletecrop/{id}")
	public String deletecrops(@PathVariable(value= "id") int theId, HttpSession session) {

		cropsService.deleteById(theId); 
		  
		session.setAttribute("msg", "Crop Delete succesfully");
		
		return "redirect:/allcrops" ;

	}
}
