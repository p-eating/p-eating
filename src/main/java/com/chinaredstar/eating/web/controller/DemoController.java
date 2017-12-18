package com.chinaredstar.eating.web.controller;

import com.chinaredstar.eating.model.UserModel;
import com.chinaredstar.eating.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private DemoService demoService;

    @RequestMapping("/test")
    public String demo(Model model){
        logger.info(">>>>>>>> -- 进入 DemoController#demo方法");
        UserModel user = demoService.findUser();
        model.addAttribute("hello", user.getName());
        return "/test";
    }
}
