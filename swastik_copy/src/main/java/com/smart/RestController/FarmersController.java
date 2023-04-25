package com.smart.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smart.Entity.Farmers;
import com.smart.service.FarmersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class FarmersController {

	@Autowired
	private FarmersService farmersService;

	// handler for entry page
	@RequestMapping("/farmers")
	public String Showfirstpage(Model m) {

		m.addAttribute("title", "Farmers - igaptech_Swastik ");

		return "farmer";
	}

	// handler for Showall all farmers
	@RequestMapping("/allfarmers")
	public String Viewall(Model m) {

		List<Farmers> fm = farmersService.FindAll();
		
		m.addAttribute("viewfarmers", fm);
		
		return "farmer";
	}

	// A.handler for adding farmers
	@RequestMapping("/addfarmer")
	public String Addfarmers() {

		return "addfarmer";

	}

	// a.Handler to save the farmer
	@PostMapping("/savefarmer")
	public String Addfarmer(@ModelAttribute Farmers farmers, HttpSession session) {

		farmersService.save(farmers);

		session.setAttribute("msg", "Farmer Added succesfully");

		return "redirect:/addfarmer";

	}

	// B. for Edit Or Update Farmer
	@RequestMapping("/editfarmer/{id}")
	public String editCrop(@PathVariable(value = "id") int id, Model m) {

		Optional<Farmers> f = farmersService.findById(id);// Calling repository findbyid method and storing value in crp

		Farmers f1 = f.get();// Getting value in cp

		m.addAttribute("farmer", f1); // and here value of cp stored in crop

		return "Editfarmer";

	}

	// b. Handler for update Farmer
	@PostMapping("/updatefarmer")
	public String updatecrops(@ModelAttribute Farmers farmers, HttpSession session) {

		farmersService.save(farmers);

		session.setAttribute("msg", "Farmer Update succesfully");

		return "redirect:/allfarmers";
	}

	// handler for delete operation
	@RequestMapping("/deletefarmer/{id}")
	public String deletecrops(@PathVariable(value = "id") int theId, HttpSession session) {

		farmersService.deleteById(theId);

		session.setAttribute("msg", "Farmer Delete succesfully");

		return "redirect:/allfarmers";

	}

}