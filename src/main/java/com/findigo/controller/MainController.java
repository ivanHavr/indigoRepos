package com.findigo.controller;

import com.findigo.entity.User;
import com.findigo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;

@Controller
@Slf4j
public class MainController {

    @Autowired
    private final UserRepository userRepository = null;

    @RequestMapping("/search")
    ModelAndView resultSet(@ModelAttribute("user") User user) {
        User users = userRepository.findUserByPassword(user.getPassword());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", users);
        modelAndView.setViewName("main");
        return modelAndView;
    }

    @RequestMapping("/")
    ModelAndView resultSet() {
        return new ModelAndView("index","user", new User());
    }

    @RequestMapping(value = "/results/{stringss}", method = RequestMethod.GET)
    ModelAndView resultSet(@PathVariable("stringss") String stringss) {
        return new ModelAndView("result","stringss", stringss+"123");
    }
}
