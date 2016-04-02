package org.crazyit.hrsystem.action;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.crazyit.hrsystem.domain.Username;
import org.crazyit.hrsystem.service.UsernameManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/user")
public class UserController{
	private UsernameManager usernameManager;
	@Autowired
	public void setUsernameManager(UsernameManager mgr) {
		this.usernameManager = mgr;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public Object Userregister(@RequestBody Username username,
			HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		Map<String, Object> map = new HashMap<String, Object>();
		if (!username.getName().equals(""))
			if (null != usernameManager.findUsernameByname(username.getName())) {
				map.put("code",false);
				return map;
			}
		if (!username.getPhone().equals(""))
			if (null != usernameManager.findUsernameByphone(username.getPhone())) {
				map.put("code", true);
				return map;
			}

		if ( usernameManager.saveUsername(username)) {
			map.put("code", true);
		} else {
			map.put("code", false);
		}
		return map;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Object Userlogin(@RequestParam("name") String name,
			@RequestParam("pass") String pass,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		Map<String, Object> map = new HashMap<String, Object>();
		Username username = usernameManager.findUsernameByname(name);
		if (null != username) {
			if (username.getPass().equals(pass)) {
				map.put("code", true);
			} else {
				map.put("code", false);
			}
			return map;
		}
		Username usernamet = usernameManager.findUsernameByphone(name);
		if (null != usernamet) {
			if (usernamet.getPass().equals(pass)) {
				map.put("code", true);
				return map;
			}
			map.put("code", false);
			return map;
		}
		map.put("code", false);
		return map;
	}
	@RequestMapping(value = "/updatephone", method = RequestMethod.POST)
	@ResponseBody
	public Object Userupdatephone(@RequestParam("name") String name,@RequestParam("oldphone") String oldphone,@RequestParam("newphone") String newphone,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		Map<String, Object> map = new HashMap<String, Object>();
		if(usernameManager.updatephone(name, oldphone, newphone)){
			map.put("code", true);
		}else{
			map.put("code", false);
		}
		return map;
	}
	@RequestMapping(value = "/updatepass", method = RequestMethod.POST)
	@ResponseBody
	public Object Userupdatepass(@RequestParam("name") String name,@RequestParam("oldpass") String oldpass,@RequestParam("newpass") String newpass,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		Map<String, Object> map = new HashMap<String, Object>();
		if(usernameManager.updatephone(name, oldpass, newpass)){
			map.put("code", true);
		}else{
			map.put("code", false);
		}
		return map;
	}
	@RequestMapping(value = "/updateinfo", method = RequestMethod.POST)
	@ResponseBody
	public Object Userupdateinfo(@RequestParam("name") String name,@RequestParam("info") String info,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		Map<String, Object> map = new HashMap<String, Object>();
		if(usernameManager.updateinfor(name, info)){
			map.put("code", true);
		}else{
			map.put("code", false);
		}
		return map;
	}
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String test(){
		return "tsafa";
	}
}
