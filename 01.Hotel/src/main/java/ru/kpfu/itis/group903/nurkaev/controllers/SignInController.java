package ru.kpfu.itis.group903.nurkaev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import ru.kpfu.itis.group903.nurkaev.dto.LoginDto;
import ru.kpfu.itis.group903.nurkaev.exceptions.WrongEmailOrPasswordException;
import ru.kpfu.itis.group903.nurkaev.services.UsersService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 1
 */

@Controller
@SessionAttributes(value = "Email")
public class SignInController {
    private final UsersService usersService;

    @Autowired
    public SignInController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping(value = "/signIn")
    public String getSignInPage() {
        return "signIn";
    }

    @PostMapping(value = "/signIn")
    public String signInUser(ModelMap modelMap, LoginDto loginDto) {
        try {
            usersService.signIn(loginDto);
            //TODO: хранить в сессии объект User вместо Email
            modelMap.put("Email", loginDto.getEmail());
            return "redirect:/main";
        } catch (WrongEmailOrPasswordException e) {
            modelMap.put("wrongEmailOrPasswordMessage", "Неправильный логин или пароль.");
        }

        return "redirect:/signIn";
    }
}
