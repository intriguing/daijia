package org.crazyit.hrsystem.dao.impl;

import java.util.List;

import org.crazyit.common.dao.impl.BaseDaoHibernate4;
import org.crazyit.hrsystem.dao.AdminaterDao;
import org.crazyit.hrsystem.domain.Adminater;

public class AdminaterDaoHibernate4 extends BaseDaoHibernate4<Adminater> implements AdminaterDao{
	@Override
	public boolean findAdminater(String name, String pass) {
		// TODO Auto-generated method stub
		List<Adminater> emps=find("select p from Adminater p where p.flag=1 and p.name = ?0 and p.pass=?1"
				, name, pass);
		if(null!=emps&&emps.size()>=1){
			return true;
		}
		return false;
	}

	@Override
	public List<Adminater> findByNameAndPass(Adminater adminater) {
		// TODO Auto-generated method stub
		return find("select p from Adminater p where p.name = ?0 and p.pass=?1"
				, adminater.getName() , adminater.getPass());
	}

	@Override
	public Adminater findByName(String name) {
		// TODO Auto-generated method stub
		List<Adminater> emps = find("select e from Adminater e where e.name = ?0"
				, name);
			if (emps!= null && emps.size() >= 1)
			{
				return emps.get(0);
			}
			return null;
	}

}
