package com.bloodbank.universal.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/web")
public class WebController 
{
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public ModelAndView home()
    {    	
    	System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public ModelAndView register(@RequestParam(value = "status",required = false)Boolean status)
    {
        ModelAndView mv = new ModelAndView("register");
        mv.addObject("status", status);
        return mv;
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "status",required = false)Boolean status,
    		@RequestParam(value = "v",required = false)Boolean verifystatus)
    {
        ModelAndView mv = new ModelAndView("login");
        mv.addObject("status", status);
        mv.addObject("vstatus", verifystatus);
        return mv;
    }
    
    
}
