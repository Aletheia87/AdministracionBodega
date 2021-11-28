package cl.desafiolatam.administracionBodega.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import cl.desafiolatam.administracionBodega.dto.Material;

@Controller
public class MaterialController {

	private List<Material> materiales = new ArrayList<Material>();
	
	
	@GetMapping("")
	public ModelAndView home(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("materiales");
		modelAndView.addObject("materiales", session.getAttribute("materiales"));
		return modelAndView;
		
	}

	@PostMapping("/agregarMaterial")
	public RedirectView home(HttpSession session, @ModelAttribute Material material, Model modelo) {		
	//	if (session.getAttribute("materiales") != null) {
			session.getAttribute("materiales");
	//		materiales.addAll((List<Material>)session.getAttribute("materiales"));
			material.setFechaIngreso(LocalDate.now());
			materiales.add(material);
			session.setAttribute("materiales", materiales);

	//}
		return new RedirectView("");

	}
	
}

