package org.crazyit.hrsystem.service.impl;

import org.crazyit.hrsystem.dao.AdminaterDao;
import org.crazyit.hrsystem.dao.DriverDao;
import org.crazyit.hrsystem.dao.UsernameDao;
import org.crazyit.hrsystem.domain.Adminater;
import org.crazyit.hrsystem.domain.Username;
import org.crazyit.hrsystem.service.UsernameManager;
public class UsernameManagerImpl implements UsernameManager{
	private AdminaterDao adminaterDao;
	private DriverDao driverDao;
	private UsernameDao usernameDao;

	@Override
	public int validLogin(Adminater adm) {
		// TODO Auto-generated method stub
		if (adminaterDao.findByNameAndPass(adm).size() >= 1)
		{
			return LOGIN_Adm;
		}
		else if (usernameDao.findByNameAndPass(adm).size() >= 1)
		{
			return LOGIN_User;
		}
		else
		{
			return LOGIN_FAIL;
		}
	}

	public void setAdminaterDao(AdminaterDao adminaterDao) {
		this.adminaterDao = adminaterDao;
	}

	public void setDriverDao(DriverDao driverDao) {
		this.driverDao = driverDao;
	}
	public void setUsernameDao(UsernameDao usernameDao) {
		this.usernameDao =usernameDao;
	}

	@Override
	public Username findUsernameByname(String name) {
		// TODO Auto-generated method stub
		return this.usernameDao.findByName(name);
	}

	@Override
	public Username findUsernameByphone(String phone) {
		// TODO Auto-generated method stub
		return this.usernameDao.findByPhone(phone);
	}

	@Override
	public boolean saveUsername(Username username) {
		// TODO Auto-generated method stub
		this.usernameDao.save(username);
		return true;
	}

	@Override
	public boolean updatephone(String name, String oldphone, String newphone) {
		// TODO Auto-generated method stub
		return this.usernameDao.updatephone(name, oldphone, newphone);
	}

	@Override
	public boolean updateinfor(String name, String info) {
		// TODO Auto-generated method stub
		return this.usernameDao.updateinfor(name, info);
	}

}
