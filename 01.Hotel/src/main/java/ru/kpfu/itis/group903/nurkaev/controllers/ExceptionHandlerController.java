package ru.kpfu.itis.group903.nurkaev.controllers;//package ru.kpfu.itis.group903.nurkaev.controllers;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.servlet.ModelAndView;
//import ru.kpfu.itis.group903.nurkaev.exceptions.DuplicateEntryException;
//import ru.kpfu.itis.group903.nurkaev.exceptions.WrongEmailOrPasswordException;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * 18.03.2021
// * 06.Hotel
// *
// * @author Shamil Nurkaev @nshamil
// * 11-903
// */
//
//@ControllerAdvice
//public class ExceptionHandlerController {
//
////    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(DuplicateEntryException.class)
//    public String handleDuplicateEntry(HttpServletRequest request, Exception exception/*, ModelMap modelMap*/) {
//        /*modelMap.addAttribute("duplicateEntryMessage",
//                "Пользователь с таким email уже существует.");*/
//        return "signUp";
//    }
//
////    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(WrongEmailOrPasswordException.class)
//    public String handleWrongEmailOrPassword(ModelMap modelMap) {
//        modelMap.put("wrongEmailOrPasswordMessage", "Неправильный логин или пароль.");
//        return "signIn";
//    }
//
//}
