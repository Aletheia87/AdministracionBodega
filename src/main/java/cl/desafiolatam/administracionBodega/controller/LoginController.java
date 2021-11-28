package cl.desafiolatam.administracionBodega.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController  {
	
	@GetMapping("/login")
	public ModelAndView login(@RequestParam(required = false) Boolean error, Model modelo){
		modelo.addAttribute("error", error);
		
	return new ModelAndView("login");
	}
	
		
}
