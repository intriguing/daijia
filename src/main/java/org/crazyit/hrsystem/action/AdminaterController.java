package org.crazyit.hrsystem.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.crazyit.hrsystem.domain.Adminater;
import org.crazyit.hrsystem.domain.Driver;
import org.crazyit.hrsystem.domain.Username;
import org.crazyit.hrsystem.service.AdminaterManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/adminater")
public class AdminaterController{
    private AdminaterManager adminatermanager;
    @Autowired
	public void setAdminatermanager(AdminaterManager adminatermanager) {
		this.adminatermanager = adminatermanager;
	}
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public Object Adminaterregister(@RequestBody Adminater adminater,
			HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (null != adminater.getName())
			if (null != adminatermanager.findByName(adminater.getName())) {
				map.put("code", false);

			} else {
				adminatermanager.savaAdminater(adminater);
				map.put("code", true);
			}
		return map;
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Object Adminaterlogin(@RequestParam("name") String name,
			@RequestParam("pass") String pass){
		Map<String, Object> map = new HashMap<String, Object>();
		Adminater adminater = adminatermanager.findByName(name);
		if (null != adminater) {
			if (adminater.getPass().equals(pass)) {
				map.put("code", true);
			} else {
				map.put("code", false);
			}
			return map;
		}
		map.put("code", false);
		return map;
	}
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseBody
	public Object AdminaterUser(){
		Map<String, Object> map = new HashMap<String, Object>();
		Iterator<Username> iterator=adminatermanager.findUsername().iterator();
		int i=1;
		if(iterator.hasNext()){
			map.put(""+i, iterator.next());
			i++;
		}
		return map;
	}
	@RequestMapping(value = "/driver", method = RequestMethod.POST)
	@ResponseBody
	public Object AdminaterDriver(){
		Map<String, Object> map = new HashMap<String, Object>();
		Iterator<Driver> iterator=adminatermanager.findDriver().iterator();
		int i=1;
		if(iterator.hasNext()){
			map.put(""+i, iterator.next());
			i++;
		}
		return map;
	}
}
