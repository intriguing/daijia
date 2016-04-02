package org.crazyit.hrsystem.dao;

import java.util.List;

import org.crazyit.common.dao.BaseDao;
import org.crazyit.hrsystem.domain.Username;

public interface UsernameDao extends BaseDao<Username>{
	List<Username> findByNameAndPass(Username emp);
	Username findByName(String name);
	Username findByPhone(String phone);
	boolean updatepass(String name,String oldpass,String newpass);
	boolean updateinfor(String name,String info);
	boolean updatephone(String name,String oldphone,String newphone);
	List<Username> findUsername();
}
