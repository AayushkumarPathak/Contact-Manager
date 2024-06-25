package com.scm.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class PageController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home(Model model){
        System.out.println("Home page handller");
        model.addAttribute("name", "Hashing Technologies");
        model.addAttribute("github", "https://gitub.io/aayushkrpathak122");
        return "home";
    }

    //about page route
    @RequestMapping("/about")
    public String aboutPage(Model model){
        model.addAttribute("base","content");
        System.out.println("About page loading");
        return "about";
    }
    @RequestMapping("/services")
    public String servicesPage(){
        System.out.println("services page loading");
        return "services";
    }
    @GetMapping("/contact")
    public String contact() {
        return new String("contact");
    }
    
    @GetMapping("/login")
    public String login() {
        return new String("login");
    }
    @GetMapping("/register")
    public String register(Model model) {
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
        // userForm.setName("Aayush");
        // userForm.setEmail("ak@");
        // userForm.setPhoneNumber("91828");
        
       
        return "register";
    }

    @RequestMapping(value = "/do-register",method = RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm,BindingResult rBindingResult, HttpSession session){
        System.out.println("Process registration");
        System.out.println("\n\n\n"+userForm+"\n\n");

        // validating form
        if(rBindingResult.hasErrors()){
            System.out.println("Some client error fill the for correctly LPU");
            return "register";
        }
        else{
            System.out.println("No errors");
        }

        /*
         * fetch form data -> user form class
         * validate data
         * save data to DB
         * redirect to login page
         */
        
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Default_pfp.svg/1200px-Default_pfp.svg.png");
        
        User savedUser = userService.saveUser(user);
        

        Message message = Message.builder().message("Registration success.").type(MessageType.green).build();
        
        session.setAttribute("message", message);

        // System.out.println("\n\nUser saved\n\t\n");
        
        return "redirect:/register";
    }
    
    


}
