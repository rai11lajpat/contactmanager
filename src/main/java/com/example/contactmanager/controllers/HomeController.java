package com.example.contactmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.contactmanager.dao.UserRepository;
import com.example.contactmanager.entities.User;


@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/test")
    @ResponseBody
    public User test(){
        User user=new User();
        user.setName("lajpat");
        user.setEmail("lajpatsankhla");
        user.setAbout("xyz");
        user.setRole("student");
        userRepository.save(user);

        return user;
    }

    @GetMapping("/home")
    public String getHome(Model model) {
        model.addAttribute("title", "Home -contact Manager");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "About -contact Manager");
        return "about";
    }
    
}
