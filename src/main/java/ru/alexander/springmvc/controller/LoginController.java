package ru.alexander.springmvc.controller;

import java.util.Locale;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpRequest;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;
import ru.alexander.springmvc.model.User;

@Controller
@SessionAttributes("user")
public class LoginController {
    
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private MessageSource messageSource;    
    
    @ModelAttribute
    private User createUser(){
        User user = new User();
        user.setName("username");
        user.setPassword("userpas");
        return user;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main(@ModelAttribute User user, HttpSession httpSession, Locale locale) {
        logger.info(locale.getDisplayLanguage());
        logger.info(messageSource.getMessage("locale", new String[]{locale.getDisplayName(locale)}, locale));        
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/check-user", method = RequestMethod.POST)
    public ModelAndView checkUser(Locale locale, @Valid @ModelAttribute("user") User user, BindingResult bindingResult, RedirectAttributes redirectAttributes, ModelAndView modelAndView) {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("login");
        } else {
            RedirectView redirectView = new RedirectView("mainpage");
            redirectView.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
            modelAndView.setView(redirectView);
            redirectAttributes.addFlashAttribute("locale", messageSource.getMessage("locale", new String[]{locale.getDisplayName(locale)}, locale));
        }
        return modelAndView;
    }

    @RequestMapping(value = "/mainpage", method = RequestMethod.GET)
    public String goMainPage(HttpServletRequest request) {
        Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);
        if (map != null) {
            logger.info("redirect!");
        } else {
            logger.info("update!");
        }
        return "main";
    }

    //Отправка
    @RequestMapping(value = "/get-user-json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User getUserJson(@RequestParam("name") String name) {
        User user = new User();
        user.setName(name);
        return user;
    }

    //Получение
    @RequestMapping(value = "/put-user-json", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> setJsonUser(@RequestBody User user) {
        logger.info("Получен пользователь с именем: " + user.getName());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
