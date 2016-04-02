package org.crazyit.hrsystem.domain;

import java.io.Serializable;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name = "username_inf")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@DiscriminatorColumn(name="user_type"
, discriminatorType=DiscriminatorType.INTEGER)
@DiscriminatorValue(value="1")
public class Username implements Serializable {
	private static final long serialVersionUID = 48L;
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "user_name", nullable = false, length = 50, unique = true)
	private String name;
	@Column(name = "user_sex", nullable = false)
	private int sex;
	@Column(name = "user_pass", nullable = false, length = 50)
	private String pass;
	@Column(name = "user_phone", nullable = false, length =18)
	private String phone;
	@Column(name = "user_infor", nullable = false)
	private String infor;
	public Username() {
	}
	public Username(Integer id, String name, String pass, String infor,String phone,int sex) {
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.infor = infor;
		this.phone=phone;
		this.sex=sex;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getInfor() {
		return infor;
	}

	public void setInfor(String infor) {
		this.infor = infor;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Username other = (Username) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}
}