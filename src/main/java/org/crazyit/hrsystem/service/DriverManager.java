package org.crazyit.hrsystem.service;

import java.util.List;

import org.crazyit.hrsystem.domain.Driver;
import org.crazyit.hrsystem.vo.DriversInfo;

public interface DriverManager {
	Driver  findByPhone(String phone);
	boolean saveDriver(Driver driver);
	List<Driver> findDriverrange(String range);
	boolean updateDriverrange(String name,int driverrange);
	boolean updateStatus(String name,int status);
    Driver findByName(String name);
    List<Driver> findDrivering();
	public DriversInfo searchNearDriver(int pointX,int pointY);
}
