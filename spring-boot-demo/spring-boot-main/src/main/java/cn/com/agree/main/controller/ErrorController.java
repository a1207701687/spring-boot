package cn.com.agree.main.controller;

//import cn.com.agree.basis.unitTest.AService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "error")
class MyErrorController implements ErrorController {

//    @Autowired
//    AService aService;

    @RequestMapping(produces = "text/html")
    public ModelAndView error(HttpServletRequest request) {
//        System.err.println(aService.getAServiceName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(getErrorPath());
        Map<String, String> madleMap = new HashMap<>();
        Integer statusCode = (Integer) request
                .getAttribute("javax.servlet.error.status_code");
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        madleMap.put("errorcode", Integer.toString(statusCode));
        madleMap.put("errorMsg", throwable.getMessage());
        modelAndView.addAllObjects(madleMap);
        return modelAndView;
    }

    @Override
    public String getErrorPath() {
        return "error/5xx";
    }
}
