package com.chinaredstar.eating.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description:
 * @author: chaoyue<chaoyue.fan @ chinaredstar.com>
 * @date: Create in 11:00 2017/12/19
 * @version: 1.0.0
 * @modified by:
 */
@Controller()
@RequestMapping("view/user")
public class UserViewController {
    @RequestMapping(value ="/create", method = {RequestMethod.GET})
    public String create() throws Exception {
        return "index";
    }

    @RequestMapping(value ="/look", method = {RequestMethod.GET})
    public String look() throws Exception {
        return "index2";
    }
}
