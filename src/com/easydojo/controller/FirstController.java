package com.easydojo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easydojo.bean.EasyRequest;
import com.easydojo.bean.EasyResponse;

@Controller
public class FirstController {
	@RequestMapping("first")  // 请求url地址映射，类似Struts的action-mapping
    public String first(@RequestParam(value="username")String username, String password, HttpServletRequest request) {

		System.out.println("first");
        return "second";
    }
	
	@RequestMapping("demo")
	public @ResponseBody EasyResponse second(@RequestBody EasyRequest request, HttpServletRequest httpRequest) {
		EasyResponse response = new EasyResponse();
		response.setCode(request.getType());
		response.setMsg(request.getTimestamp());
        return response;
    }
}
