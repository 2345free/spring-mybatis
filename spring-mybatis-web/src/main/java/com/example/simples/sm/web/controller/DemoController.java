package com.example.simples.sm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @RequestMapping("/showMessage.html")
    public String showMessage(Model model) {
        model.addAttribute("message", "这是来自后台的消息123");
        return "showMessage";
    }


}
