package com.smart.smartcontactmanager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.smartcontactmanager.Dao.UserRepository;
import com.smart.smartcontactmanager.Entities.User;
import com.smart.smartcontactmanager.Helper.Message;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository; 

    @GetMapping("/")
    public String home(Model m) {
        m.addAttribute("title", "Home - Smart Contact Manager");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model m) {
        m.addAttribute("title", "About - Smart Contact Manager");
        return "about";
    }

    @GetMapping("/login")
    public String login(Model m) {
        m.addAttribute("title", "Login - Smart Contact Manager");
        return "login";
    }

    @GetMapping("/signup")
    public String signup(Model m) {
        m.addAttribute("title", "Signup - Smart Contact Manager");
        m.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/do_register")
    public String registerUser(@Valid @ModelAttribute User user, BindingResult result, @RequestParam(defaultValue = "false") boolean agreement, Model m, HttpSession session){
        
        try {
            if(!agreement){
            System.out.println("You have not agreed the terms and conditions");
            throw new Exception("You have not agreed the terms and conditions");
        }

        if(result.hasErrors()){
            System.out.println("Error "+result.toString());
            m.addAttribute("user", user);
            return "signup";
        }
        user.setRole("ROLE_USER");
        user.setEnabled(true);
        user.setImageUrl("default.png");
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        System.out.println("Agreement: "+agreement);
        System.out.println("USER: "+user);
        userRepository.save(user);
        m.addAttribute("user", new User());
        m.addAttribute("message", new Message("Successfully Registered !!","alert-success"));
        return "signup";

        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("user", user);
            m.addAttribute("message", new Message("Something went wrong !! "+ e.getMessage(),"alert-danger"));
            return "signup";
        }

        
    }
}
