package org.crazyit.hrsystem.dao;

import java.util.List;

import org.crazyit.common.dao.BaseDao;
import org.crazyit.hrsystem.domain.Driver;
public interface DriverDao extends BaseDao<Driver>{
	List<Driver> findDriverrange(String range);
	List<Driver> findDrivering();
	public Driver findByName(String name);
	boolean updateDriverrange(String name,int driverrange);
	boolean updateStatus(String name,int status);
	List<Driver> findDriver();
	List<Driver> findByNameAndPass(Driver driver);
	Driver  findByPhone(String phone);
	List<Driver> searchNearDriver(int pointX,int pointY);
}
