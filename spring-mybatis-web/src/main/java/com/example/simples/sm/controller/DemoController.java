package com.example.simples.sm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.simples.sm.service.DemoService;

@Controller
public class DemoController {

	@Autowired
	private DemoService demoService;

	@RequestMapping("/showMessage.html")
	public String showMessage(Model model){
		model.addAttribute("message", "这是来自后台的消息123");
		return "showMessage";
	}

	@RequestMapping("/httpInvoker")
	@ResponseBody
	public String httpInvoker() {
		return this.demoService.sayHello("luoxx");
	}

}
