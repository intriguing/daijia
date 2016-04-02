package org.crazyit.hrsystem.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@DiscriminatorValue(value="2")
public class Driver extends Username implements Serializable{
	private static final long serialVersionUID = 48L;
	@Column(name="status")
	private int status;
	@Column(name="driverrange")
	private int driverrange;
	@Column(name="drivingYears")
	private int drivingYears;
	@Column(name="pointX",length=10)
	private int pointX;
	@Column(name="pointY",length=10)
	private int pointY;
	public int getDrivingYears() {
		return drivingYears;
	}
	public void setDrivingYears(int drivingYears) {
		this.drivingYears = drivingYears;
	}
	public int getPointX() {
		return pointX;
	}
	public void setPointX(int pointX) {
		this.pointX = pointX;
	}
	public int getPointY() {
		return pointY;
	}
	public void setPointY(int pointY) {
		this.pointY = pointY;
	}
	public int getDriverrange() {
		return driverrange;
	}
	public void setDriverrange(int driverrange) {
		this.driverrange = driverrange;
	}
	public Driver(){}
	public Driver(Integer id, String name, String pass,String phone,int sex,String infor,int status,int driverrange,int drivingYears,int pointX,int pointY){
		super(id,name,pass,infor,phone,sex);
		this.status=status;
		this.driverrange=driverrange;
		this.drivingYears=drivingYears;
		this.pointX=pointX;
		this.pointY=pointY;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
