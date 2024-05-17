package com.example.springbootmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
    // When client sends a request ,request first goes to DispatcherServlet (Front
    // Controller) and depending on the
    // type of request DispatcherServlet redirects the request to desired
    // controller.
    // In theory we need to create a configuration for DispatcherServlet, but here
    // spring boot comes into action
    // and tells there is no need of create the configuration file if you need
    // default configurations for Dispatcher Servlet

    // Since DispatcherServlet is calling this HomeController so if we return the
    // name of file then it will match if there is
    // any file with name index.jsp present inside src->main->webapp folder if
    // present it will automatically
    // serve that file on internet as a response

    // When we talk about tomcat, JSP gets converted into Servlet and that Servlet
    // runs on tomcat but here since we are using
    // internal tomcat there is nothing present in between which can convert jsp to
    // servlet and serve it.. that's why it is
    // getting downloaded.

    // If we want it to get served we need to add dependency of TomcatJasper
    @RequestMapping("/")
    public String home() {
        return "index";
    }

    // @RequestMapping("/add")
    // public String add(HttpServletRequest req) {
    // int x=Integer.parseInt(req.getParameter("num1"));
    // int y=Integer.parseInt(req.getParameter("num2"));
    // int res=x+y;

    // HttpSession session=req.getSession();
    // session.setAttribute("res", res);
    // // Another way of passing this variable to result page is
    // // return "result.jsp?res="+res;// use url rewriting to pass this
    // return "result.jsp";
    // }

    // These num1 and num2 values are getting extracted from Url(query params of
    // URL)
    // @RequestMapping("/add")
    // public String add(@RequestParam("num1") int x, @RequestParam("num2") int y,
    // HttpSession session) {
    // int res = x + y;
    // session.setAttribute("res", res);
    // return "result.jsp";
    // }

    // Removing Http Session also using the concept of Model and View
    // Using ModelView we can pass along two things a) any dynamic data and any view
    // name
    // @RequestMapping("/add")
    // public ModelAndView add(@RequestParam("num1") int x, @RequestParam("num2")
    // int y) {
    // int res = x + y;
    // ModelAndView mv = new ModelAndView();
    // mv.setViewName("result.jsp");
    // mv.addObject("res", res);

    // return mv;
    // }

    // Now what if we want to change our view technology in future, now we are using
    // jsp in future
    // we want to use some other view technology may be freemarker or velocity so we
    // want to avoid using extension
    // Another problem is whatever view templates we are using are part of webapp
    // folder which is public
    // so anyone can access it.... if we open website/pageName it will open that
    // page without even calling
    // the controller we dont want that
    // Although we can make it private by placing the view templates in web-inf
    // folder it will make them private
    // But what if we want to make them but place in different folder
    // So now sincw we are removing the extension and changing path of file in which
    // our view is present
    // We need to somehow tell DispatchServlet controller of spring framework that
    // we are reffering to
    // a particular file over here .... so for this we need to add configuration and
    // we do add this configuration
    // in application.properties (Spring boot application properties)
    // @RequestMapping("/add")
    // public ModelAndView add(@RequestParam("num1") int x, @RequestParam("num2")
    // int y) {
    // int res = x + y;
    // ModelAndView mv = new ModelAndView("result");
    // mv.addObject("res", res);

    // return mv;
    // }

    /**
     * Can we use something else instead of using ModelView?
     * a) Model
     * b) ModelMap
     */
    // @RequestMapping("/add")
    // public String add(@RequestParam("num1") int x, @RequestParam("num2") int
    // y,Model m) {
    // int res = x + y;
    // m.addAttribute("res", res);
    // return "result";
    // }

    @RequestMapping("/add")
    public String add(@RequestParam("num1") int x, @RequestParam("num2") int y, ModelMap m) {
        int res = x + y;
        m.addAttribute("res", res);
        return "result";
    }

}
