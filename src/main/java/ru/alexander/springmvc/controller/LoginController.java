package ru.alexander.springmvc.controller;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.alexander.springmvc.model.User;

@Controller
public class LoginController {
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main(){
        return new ModelAndView("login", "user", new User());
    }
    
    @RequestMapping(value = "/check-user", method = RequestMethod.POST)
    public String checkUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            return "login";
        }
        model.addAttribute("user", user);
        return "main";
    }
    
    @RequestMapping(value = "/failed", method = RequestMethod.GET)
    public ModelAndView failed(){
        return new ModelAndView("login-failed", "message", "Ошибка доступа!");
    }
    
}
