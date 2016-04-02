package org.crazyit.hrsystem.service;

import org.crazyit.hrsystem.domain.Adminater;
import org.crazyit.hrsystem.domain.Username;

public interface UsernameManager {
	public static final int LOGIN_FAIL = 0;
	public static final int LOGIN_User = 1;
	public static final int LOGIN_Adm = 2;
	int validLogin(Adminater adm);
	public Username findUsernameByname(String name);
	public Username findUsernameByphone(String phone);
	public boolean saveUsername(Username username);
	public boolean updatephone(String name,String oldphone,String newphone);
	boolean updateinfor(String name,String info);
}
