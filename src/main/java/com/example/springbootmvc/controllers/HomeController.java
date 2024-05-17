package com.example.springbootmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
    // When client sends a request ,request first goes to DispatcherServlet (Front Controller) and depending on the
    // type of request DispatcherServlet redirects the request to desired controller.
    // In theory we need to create a configuration for DispatcherServlet, but here spring boot comes into action
    // and tells there is no need of create the configuration file if you need default configurations for Dispatcher Servlet

    // Since DispatcherServlet is calling this HomeController so if we return the name of file then it will match if there is 
    // any file with name index.jsp present inside src->main->webapp folder if present it will automatically
    // serve that file on internet as a response

    // When we talk about tomcat, JSP gets converted into Servlet and that Servlet runs on tomcat but here since we are using 
    // internal tomcat there is nothing present in between which can convert jsp to servlet and serve it.. that's why it is 
    // getting downloaded.

    // If we want it to get served we need to add dependency of TomcatJasper
    @RequestMapping("/")
    public String home(){
        return "index.jsp";
    }
}
