package org.crazyit.hrsystem.dao.impl;

import java.util.List;

import org.crazyit.common.dao.impl.BaseDaoHibernate4;
import org.crazyit.hrsystem.dao.UsernameDao;
import org.crazyit.hrsystem.domain.Username;

public class UsernameDaoHibernate4 extends BaseDaoHibernate4<Username>
implements UsernameDao{

	@Override
	public List<Username> findByNameAndPass(Username emp) {
		// TODO Auto-generated method stub
		return find("select p from Username p where p.name = ?0 and p.pass=?1"
				, emp.getName() , emp.getPass());
	}

	@Override
	public Username findByName(String name) {
		// TODO Auto-generated method stub
		List<Username> emps = find("select e from Username e where e.name = ?0"
				, name);
			if (emps!= null && emps.size() >= 1)
			{
				return emps.get(0);
			}
			return null;
	}

	@Override
	public boolean updatepass(String name, String oldpass, String newpass) {
		// TODO Auto-generated method stub
		List<Username> emps=find("select p from Username p where p.name = ?0 and p.pass=?1"
				, name, oldpass);
		if(emps!=null&&emps.size()>=1){
			Username temp=emps.get(0);
			temp.setPass(newpass);
			this.save(temp);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateinfor(String name, String info) {
		// TODO Auto-generated method stub
		Username temp=findByName(name);
		if(null!=temp){
		temp.setInfor(info);
		return true;
		}
		return false;
	}

	@Override
	public Username findByPhone(String phone) {
		// TODO Auto-generated method stub
		List<Username> emps = find("select e from Username e where e.phone = ?0"
				, phone);
			if (emps!= null && emps.size() >= 1)
			{
				return emps.get(0);
			}
			return null;
	}

	@Override
	public boolean updatephone(String name,String oldphone,String newphone) {
		// TODO Auto-generated method stub
		List<Username> emps=find("select p from Username p where p.name = ?0 and p.phone=?1"
				, name, oldphone);
		if(emps!=null&&emps.size()>=1){
			Username temp=emps.get(0);
			temp.setPhone(newphone);
			this.save(temp);
			return true;
		}
		return false;
	}

	@Override
	public List<Username> findUsername() {
		// TODO Auto-generated method stub
		return find("select e from Username e");
	}



}
