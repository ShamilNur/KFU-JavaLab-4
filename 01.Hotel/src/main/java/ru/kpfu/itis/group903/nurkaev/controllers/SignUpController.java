package ru.kpfu.itis.group903.nurkaev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.group903.nurkaev.dto.UserDto;
import ru.kpfu.itis.group903.nurkaev.exceptions.DuplicateEntryException;
import ru.kpfu.itis.group903.nurkaev.services.UsersService;

import javax.validation.Valid;
import java.util.Objects;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 1
 */

@Controller
public class SignUpController {
    private final UsersService usersService;

    @Autowired
    public SignUpController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping(value = "/signUp")
    public String getSignUpPage(ModelMap map) {
        map.addAttribute("userDto", new UserDto());
        return "signUp";
    }

    @PostMapping(value = "/signUp")
    public String signUpUser(@Valid UserDto userDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                if (Objects.requireNonNull(error.getCodes())[0].equals("userDto.ValidNames")) {
                    model.addAttribute("namesErrorMessage", error.getDefaultMessage());
                }
            }
            model.addAttribute("userDto", userDto);
            return "signUp";
        }
        try {
            usersService.signUp(userDto);
            return "redirect:/signIn";
        } catch (DuplicateEntryException e) {
            model.addAttribute("message", "Пользователь с таким email уже существует.");
            return "signUp";
        }
    }
}