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

import com.smart.Entity.Crops;
import com.smart.Entity.Recommendation;
import com.smart.service.RecommendationsService;

import jakarta.servlet.http.HttpSession;

@Controller
public class RecoController {

	@Autowired
	private RecommendationsService recommendationsService;

	//for entry page
	@RequestMapping("/recommendation")
	public String Entrypage() {

		return "reco";

	}

	//To show all
	@RequestMapping("/allreco")
	public String ViewAll(Model m) {

		List<Recommendation> data = recommendationsService.FindAll();

		m.addAttribute("veiwdata", data);

		return "reco";
	}

	// A. for adding recommendation
	@RequestMapping("/addrecom")
	public String AddCrop() {

		return "addreco";
	}
	
	//a.To save new recommendation
	@PostMapping("/savereco")
	public String Save(@ModelAttribute Recommendation rec, HttpSession session) {
		
		recommendationsService.save(rec);
		
		session.setAttribute("msg", "Recommendation Added succesfully..");
		
		return "rediret:/addrecom";
		
	}
	

	// B. for Edit Or Update recommendations
	@RequestMapping("/editreco/{id}")
	public String editCrop(@PathVariable(value = "id") int id, Model m) {

		Optional<Recommendation> rec = recommendationsService.FindById(id);//Calling repository findbyid  method and storing value in 
		
		Recommendation recom=rec.get();//Getting value in cp 
		                             
		m.addAttribute("rec", recom); //and here value of cp stored in crop
		
		return "editrecom";
		
	}

	// b. Handler for update crops
	
	  @PostMapping("/updatereco")
	  public String updatecrops(@ModelAttribute Recommendation recom,HttpSession session) {
	  
		  recommendationsService.save(recom);
	  
	  session.setAttribute("msg", "Recommendation Update succesfully");
	  
	  return "redirect:/allreco"; 
	  }
      

	  // handler for delete operation
	@RequestMapping("/deletereco/{id}")
	public String deletecrops(@PathVariable(value= "id") int theId, HttpSession session) {

		recommendationsService.DeleteById(theId);
		  
		session.setAttribute("msg", "Recommendation Delete succesfully");
		
		return "redirect:/allreco" ;

	}

}
