package cl.desafiolatam.administracionBodega.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogOutController {

	@GetMapping("/logout")
	public String logOut() {
		return"login";
		}
	
}
