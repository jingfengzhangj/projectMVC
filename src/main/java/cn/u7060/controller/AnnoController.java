package cn.u7060.controller;

import cn.u7060.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("anno")
public class AnnoController {


    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("anno/list3");//设置视图位置
        System.out.println("b");
        return mv;
    }


    @RequestMapping("/list2")
    public String list2(Model model){
        model.addAttribute("msg","abc");
//        return "";//视图路径 这种方式最好用
//        return "forward:/index.jsp";//不使用视图解析器配置
        return "redirect:/index.jsp";//不适用视图，共享数据在请求中
    }

    @RequestMapping("/list3")//视图地址
    @ModelAttribute("oneUser")
    public User list2(){
        User user = new User();
        user.setName("abc");
        return user;
    }


    @GetMapping("param1")
    public ModelAndView listParam1(@RequestParam("username") String name, String age){
        ModelAndView mv = new ModelAndView();
        mv.addObject("username",name);
        mv.addObject("age",age);
        mv.setViewName("anno/list3");
        return mv;
    }


    @GetMapping("param2")
    public ModelAndView listParam2(User user){
        ModelAndView mv = new ModelAndView();
        mv.addObject("username",user.getName());
        mv.setViewName("anno/list3");
        return mv;
    }

    @GetMapping("param3")
    public String listParam3(@ModelAttribute("myUser") User user,@ModelAttribute("age") String age){
        return "anno/list3";
    }

    @GetMapping("param4/{age}")
    public String listParam4(@PathVariable("age") String age){
        return "anno/list3";
    }
}
