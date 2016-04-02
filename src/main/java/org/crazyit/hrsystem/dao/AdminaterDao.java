package org.crazyit.hrsystem.dao;

import java.util.List;

import org.crazyit.common.dao.BaseDao;
import org.crazyit.hrsystem.domain.Adminater;

public interface AdminaterDao extends BaseDao<Adminater>{
	boolean findAdminater(String name,String pass);
	List<Adminater> findByNameAndPass(Adminater adminater);
	Adminater findByName(String name); 
}
