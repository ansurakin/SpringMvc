package ru.alexander.springmvc.controller;

import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import javax.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import ru.alexander.springmvc.model.User;

@Controller
//@SessionAttributes("user")
public class LoginController {
    
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main(@ModelAttribute User user, HttpSession httpSession) {
        user.setName("username");
        user.setPassword("userpas");
        return new ModelAndView("login", "user", user);
    }

    @RequestMapping(value = "/check-user", method = RequestMethod.POST)
    public String checkUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        return "main";
    }

    @RequestMapping(value = "/failed", method = RequestMethod.GET)
    public ModelAndView failed() {
        return new ModelAndView("login-failed", "message", "Ошибка доступа!");
    }

    //Отперавка
    @RequestMapping(value = "/get-user-json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User getUserJson(@RequestParam("name") String name) {
        User user = new User();
        user.setName(name);
        return user;
    }
    
    //Получение
    @RequestMapping(value = "/put-user-json", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String>  setJsonUser(@RequestBody User user){
        logger.info("Получен пользователь с именем: " + user.getName());
        return new ResponseEntity<>(HttpStatus.OK);                
    }

}
