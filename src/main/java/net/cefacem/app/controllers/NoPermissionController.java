package net.cefacem.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NoPermissionController {
	
	@RequestMapping( value="/no_permission_to_edit", method=RequestMethod.GET)
	public String noPermissionToEdit() {
		return "/no_permission_to_edit";
	}
}
