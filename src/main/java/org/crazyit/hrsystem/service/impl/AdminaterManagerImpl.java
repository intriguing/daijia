package org.crazyit.hrsystem.service.impl;

import java.util.List;

import org.crazyit.hrsystem.dao.AdminaterDao;
import org.crazyit.hrsystem.dao.DriverDao;
import org.crazyit.hrsystem.dao.UsernameDao;
import org.crazyit.hrsystem.domain.Adminater;
import org.crazyit.hrsystem.domain.Driver;
import org.crazyit.hrsystem.domain.Username;
import org.crazyit.hrsystem.service.AdminaterManager;

public class AdminaterManagerImpl implements AdminaterManager{
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
	public Adminater findByName(String name) {
		// TODO Auto-generated method stub
		return this.adminaterDao.findByName(name);
	}

	@Override
	public boolean savaAdminater(Adminater adminater) {
		// TODO Auto-generated method stub
		this.adminaterDao.save(adminater);
		return true;
	}

	@Override
	public List<Driver> findDriver() {
		// TODO Auto-generated method stub
		return this.driverDao.findDriver();
	}

	@Override
	public List<Username> findUsername() {
		// TODO Auto-generated method stub
		return this.usernameDao.findUsername();
	}

}
