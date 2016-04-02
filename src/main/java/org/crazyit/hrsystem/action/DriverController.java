package org.crazyit.hrsystem.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.crazyit.hrsystem.domain.Driver;
import org.crazyit.hrsystem.service.DriverManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/driver")
public class DriverController{
	private DriverManager driverManager;
	@Autowired
	public void setDriverManager(DriverManager driverManager) {
		this.driverManager = driverManager;
	}
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public Object Driverregister(@RequestBody Driver driver,
			HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(null!=driverManager.findByPhone(driver.getPhone())){
			map.put("code", false);
		}else{
			driverManager.saveDriver(driver);
			map.put("code", true);
		}	
		return map;
	}
	@RequestMapping(value = "/range", method = RequestMethod.POST)
	@ResponseBody
	public Object Driverrange(@RequestParam("range") String range){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Driver> driverlist=driverManager.findDriverrange(range);
		Iterator<Driver> iterator=driverlist.iterator();
		int i=1;
		if(iterator.hasNext()){
		   map.put(""+i, iterator.next());
		   i++;
		   }
		return map;
	}
	@RequestMapping(value = "/updatedriverrange", method = RequestMethod.GET)
	@ResponseBody
	public Object UpdateDriverrange(@RequestParam("name") String name,@RequestParam("driverrange") int driverrange){
		Map<String, Object> map = new HashMap<String, Object>();
		if(null!=driverManager.findByName(name)){
			driverManager.updateDriverrange(name, driverrange);
			map.put("code", true);
			return map;
		}
		map.put("code", false);
		return map;
	}
	@RequestMapping(value = "/updatestatus", method = RequestMethod.POST)
	@ResponseBody
	public Object UpdateDriverStatus(@RequestParam("name") String name,@RequestParam("updatestatus") int updatestatus){
		Map<String, Object> map = new HashMap<String, Object>();
		if(null!=driverManager.findByName(name)){
			driverManager.updateStatus(name, updatestatus);
			map.put("code", true);
			return map;
		}
		map.put("code", false);
		return map;
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Object Driverlogin(@RequestParam("name") String name,
			@RequestParam("pass") String pass) {
		Map<String, Object> map = new HashMap<String, Object>();
		Driver driver = driverManager.findByName(name);
		if (null != driver) {
			if (driver.getPass().equals(pass)) {
				map.put("code", true);
			} else {
				map.put("code", false);
			}
			return map;
		}
		Driver drivert = driverManager.findByPhone(name);
		if (null != drivert) {
			if (drivert.getPass().equals(pass)) {
				map.put("code", true);
			}
			map.put("code", false);
			return map;
		}
		map.put("code", false);
		return map;
	}
	@RequestMapping(value = "/drivering", method = RequestMethod.POST)
	@ResponseBody
	public Object Drivering(){
		Map<String, Object> map = new HashMap<String, Object>();
		int i=1;
		Iterator<Driver> iterator=driverManager.findDrivering().iterator();
		if(iterator.hasNext()){
			map.put(""+i, iterator.next());
			i++;
		}
		return map;
	}
	@RequestMapping(value = "/searchNearDriver", method = RequestMethod.POST)
	@ResponseBody
	public Object DriversInfo(@RequestParam("pointX") String pointX,
			@RequestParam("pointY") String pointY){
		Map<String,Object> map=new HashMap<String,Object>();
		org.crazyit.hrsystem.vo.DriversInfo driversInfo=driverManager.searchNearDriver(Integer.parseInt(pointX), Integer.parseInt(pointY));
		map.put("DriversInfo", driversInfo.getDrivers());
		map.put("PageIndex", driversInfo.getPageIndex());
		map.put("TotalPage", driversInfo.getTotalPage());
		return map;
	}
}
