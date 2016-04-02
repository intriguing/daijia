package org.crazyit.hrsystem.service;

import java.util.List;

import org.crazyit.hrsystem.domain.Adminater;
import org.crazyit.hrsystem.domain.Driver;
import org.crazyit.hrsystem.domain.Username;

public interface AdminaterManager {
	Adminater findByName(String name); 
	boolean savaAdminater(Adminater adminater);
	List<Driver> findDriver();
	List<Username> findUsername();
}
