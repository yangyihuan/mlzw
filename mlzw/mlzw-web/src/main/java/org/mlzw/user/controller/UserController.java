package org.mlzw.user.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.mlzw.user.entity.User;
import org.mlzw.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("user")
public class UserController {
	
	private static Logger log = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	
	
	@RequestMapping(value="queryList", method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String queryList(String param) {
		log.info("执行查询方法");
		List<User> userList = userService.queryList();
		String result = JSON.toJSONString(userList);
		return result;
	}
}
