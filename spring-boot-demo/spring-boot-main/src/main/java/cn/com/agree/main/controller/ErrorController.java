package cn.com.agree.main.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "error")
class MyErrorController implements ErrorController {
    @RequestMapping(produces = "text/html")
    public ModelAndView error(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(getErrorPath());
        return modelAndView;
    }

    @Override
    public String getErrorPath() {
        return "error/401.html";
    }
}
