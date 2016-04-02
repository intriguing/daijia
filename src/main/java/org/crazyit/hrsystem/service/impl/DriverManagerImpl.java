package org.crazyit.hrsystem.service.impl;

import java.util.List;

import org.crazyit.hrsystem.dao.AdminaterDao;
import org.crazyit.hrsystem.dao.DriverDao;
import org.crazyit.hrsystem.dao.UsernameDao;
import org.crazyit.hrsystem.domain.Driver;
import org.crazyit.hrsystem.service.DriverManager;
import org.crazyit.hrsystem.vo.DriversInfo;

public class DriverManagerImpl implements DriverManager{
	private AdminaterDao adminaterDao;
	private DriverDao driverDao;
	private UsernameDao usernameDao;

	public void setAdminaterDao(AdminaterDao adminaterDao) {
		this.adminaterDao = adminaterDao;
	}

	public void setDriverDao(DriverDao driverDao) {
		this.driverDao = driverDao;
	}

	public void setUsernameDao(UsernameDao usernameDao) {
		this.usernameDao = usernameDao;
	}

	@Override
	public Driver findByPhone(String phone) {
		// TODO Auto-generated method stub
		return this.driverDao.findByPhone(phone);
	}
	@Override
	public boolean saveDriver(Driver driver) {
		// TODO Auto-generated method stub
		this.driverDao.save(driver);
		return true;
	}

	@Override
	public List<Driver> findDriverrange(String range) {
		// TODO Auto-generated method stub
		return this.driverDao.findDriverrange(range);
	}

	@Override
	public boolean updateDriverrange(String name, int driverrange) {
		// TODO Auto-generated method stub
		return this.driverDao.updateDriverrange(name, driverrange);
	}

	@Override
	public boolean updateStatus(String name, int status) {
		// TODO Auto-generated method stub
		return this.driverDao.updateStatus(name, status);
	}

	@Override
	public Driver findByName(String name) {
		// TODO Auto-generated method stub
		return this.driverDao.findByName(name);
	}

	@Override
	public List<Driver> findDrivering() {
		// TODO Auto-generated method stub
		return this.driverDao.findDrivering();
	}
	public DriversInfo searchNearDriver(int pointX,int pointY){
		List<Driver> emps=driverDao.searchNearDriver(pointX, pointY);
		DriversInfo driversInfo=new DriversInfo();
		driversInfo.setDrivers(emps);
		driversInfo.setPageIndex(10);
		if(emps.size()%10!=0){
		driversInfo.setTotalPage(emps.size()/10+1);
		}else{
			driversInfo.setTotalPage(emps.size()/10);
		}
		return driversInfo;
	}
}
