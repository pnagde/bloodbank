package com.bloodbank.universal.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bloodbank.universal.model.BloodRequest;
import com.bloodbank.universal.model.User;
import com.bloodbank.universal.service.BloodRequestService;
import com.bloodbank.universal.service.MailService;
import com.bloodbank.universal.service.UserService;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/user")
public class UserController 
{
    @Autowired
    private UserService userService;
    
    @Autowired
    private MailService mailService; 
    
    @Autowired
    private BloodRequestService bloodRequestService;
    
    @RequestMapping(value = "/changepass",method = RequestMethod.POST)
    public String changePass(@RequestParam(value = "oldpass")String oldpass,
    		@RequestParam(value = "newpass")String newpass,
    		HttpSession session) 
    {
    	User user = (User)session.getAttribute("user");
    	boolean status = userService.changePassword(user.getUserId(),oldpass,newpass);
    	if(status) {
    		return "redirect:/user/logout";
    	}else {
    		return "redirect:/user/profile?cp=false";
    	}    	
    }
    
    @RequestMapping(value = "/profile")
    public ModelAndView profileUser(@RequestParam(value = "cp",required = false)Boolean cpstatus,
    		@RequestParam(value = "status",required = false)Boolean status,
    		HttpSession session)
    {
    	User user = (User)session.getAttribute("user");
    	ModelAndView mv = new ModelAndView("profile");
    	mv.addObject("cpstatus", cpstatus);
    	mv.addObject("status", status);
    	mv.addObject("user", user);
        return mv;
    }
    
    @RequestMapping(value = "/home")
    public String homeUser()
    {
        return "userhome";
    }
    
    @RequestMapping(value = "/search")
    public @ResponseBody String search(@RequestParam(value = "bloodgroup")String bloodgroup)
    {
        List<User> users = userService.search(bloodgroup);
        System.out.println(users);
        Gson gson = new Gson();
        String json = gson.toJson(users);
        return json;
    }
    
    @RequestMapping(value = "/bloodrequest")
    public ModelAndView bloodRequest()
    {
        ModelAndView mv = new ModelAndView("bloodrequest");
        List<BloodRequest> list = bloodRequestService.getAll();
        mv.addObject("requests", list);
        return mv;
    }
    
    @RequestMapping(value = "/saverequest")
    public String saveBloodRequest(BloodRequest request,HttpSession session)
    {
        Object userOb = session.getAttribute("user");
        if(userOb!=null)
        {
            User user = (User)userOb;
            request.setRequestSender(user);
            bloodRequestService.save(request);        
        }
        return "redirect:/user/bloodrequest";
    }
    
    
    @RequestMapping(value = "/save",
            method = RequestMethod.POST)
    public String saveUser(User user)
    {
        boolean status = userService.saveUser(user);
        if(status) 
        {
        	try {
        		int code = mailService.sendVerifyLink(user.getUserEmail(), user.getUserName());
        		user.setVerifyCode(code);
        		userService.updateUser(user);
        	}catch(Exception ex) {
        		System.out.println(ex.getMessage());        		
        	}
        }
        return "redirect:/web/register?status="+status;
    }
    
    @RequestMapping(value = "/update",
            method = RequestMethod.POST)
    public String updateUser(User user,HttpSession session)
    {
    	User sessuser = (User)session.getAttribute("user");
    	user.setPassword(sessuser.getPassword());
    	user.setUserBloodGroup(sessuser.getUserBloodGroup());
    	user.setActiveStatus(sessuser.isActiveStatus());
    	user.setVerifyStatus(sessuser.isVerifyStatus());
    	System.out.println(">>> " + user);
        boolean status = userService.updateUser(user);
        
        return "redirect:/user/profile?status="+status;
    }
    
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String loginUser(@RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password,
            HttpSession session)
    {
        User user = userService.checkUser(email,password);
        if(user==null)
            return "redirect:/web/login?status=false";
        else
        {
        	if(user.isVerifyStatus())
        	{
        		session.setAttribute("user", user);
            	return "redirect:/user/home";
        	}else {
        		return "redirect:/web/login?v=true";	
        	}
        }
    }
    
    @RequestMapping(value = "/logout")
    public String homeUser(HttpSession session)
    {
        session.invalidate();
        return "redirect:/web/login";
    }
    
    @InitBinder
    public void initBinder(WebDataBinder binder) 
    {    	
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
