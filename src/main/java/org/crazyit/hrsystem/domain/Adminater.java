package org.crazyit.hrsystem.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@DiscriminatorValue(value="3")
public class Adminater extends Username implements Serializable{
	private static final long serialVersionUID = 48L;
	@Column(name="flag",length=50)
	private String flag;
	public Adminater(){}
	public Adminater(Integer id, String name, String pass, String infor,String phone,int sex,String flag){
		super(id,name,pass,infor,phone,sex);
		this.flag=flag;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
}
