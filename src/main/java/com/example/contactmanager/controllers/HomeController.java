package com.example.contactmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.contactmanager.dao.UserRepository;
import com.example.contactmanager.entities.User;
import com.example.contactmanager.helper.Message;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;


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

    @GetMapping("/")
    public String getHome(Model model) {
        model.addAttribute("title", "Home -contact Manager");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "About -contact Manager");
        return "about";
    }
    @GetMapping("/signup")
    public String signUp(Model model) {
        model.addAttribute("title", "signUp -contact Manager");
        model.addAttribute("user", new User());
        return "signup";
    }
    //handler for registering user
    @PostMapping("/do-register")
    public String registerUser(@ModelAttribute("user") User in_user,@RequestParam(value = "check1",defaultValue = "false")boolean check1,Model model,HttpSession session){
        try {
            if(!check1){
                System.out.println("not agreed term and conditions...");
                throw new Exception("not agggreed terms and conditions");
            }
            in_user.setRole("admin");
            in_user.setEnable(true);
            userRepository.save(in_user);
            System.out.println("Agreement:"+check1);
            System.out.println("User:"+in_user);
            model.addAttribute("user", new User());
            session.setAttribute("message", new Message("Succesfully registered...", "alert-success"));
            return "signup";
           
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("user", in_user);  //again sending to page to show on fields as previous value
            session.setAttribute("message", new Message("something wents wrong..."+ e.getMessage(), "alert-danger"));
            return "signup";
        }

        
    }
    
}
