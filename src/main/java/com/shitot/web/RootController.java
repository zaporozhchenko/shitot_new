package com.shitot.web;

import com.shitot.model.Doctor;
import com.shitot.model.TargetAudience;
import com.shitot.model.User;
import com.shitot.service.DoctorService;
import com.shitot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Next on 21.07.2016.
 */
@Controller
public class RootController {

    private User loggedUser;
    private boolean isLogged;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root(Model model) {
        model.addAttribute("page", "login");
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model model) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        loggedUser = userService.login(new User(login, password));
        if (loggedUser != null) {
            model.addAttribute("loggedUser", loggedUser.getLogin());
            model.addAttribute("page", "userHomePage");
        }
        else {
            model.addAttribute("page", "login");
        }
        return "index";
    }

    @RequestMapping(value = "/logout")
    public String logout(Model model) {
        loggedUser = null;
        model.addAttribute("page", "login");
        return "index";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(HttpServletRequest request, Model model) {
        String login = request.getParameter("newlogin");
        String password = request.getParameter("newpassword");
        User newUser = userService.register(new User(login, password));
        if (newUser != null) {
            model.addAttribute("result", "Registered");
        } else model.addAttribute("result", "User exists!");
        model.addAttribute("page", "login");
        return "index";
    }

    @RequestMapping(value = "/doctors", method = RequestMethod.GET)
    public String doctorList(Model model) {
        if (loggedUser == null) {
            model.addAttribute("page", "login");
        } else model.addAttribute("page", "doctorList");
        return "index";
    }
}
