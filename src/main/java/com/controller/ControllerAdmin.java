package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class ControllerAdmin {
	@RequestMapping(value = {"", "/admin"})
	public String admin() {
		
		return "admin/quan-tri-he-thong";
	}
}
