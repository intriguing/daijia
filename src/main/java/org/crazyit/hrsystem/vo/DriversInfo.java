package org.crazyit.hrsystem.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.crazyit.hrsystem.domain.Driver;

public class DriversInfo implements Serializable{
	private static final long serialVersionUID = 48L;
	private List<Driver> Drivers=new ArrayList<Driver>();
	private int PageIndex;
	private int TotalPage;
	public List<Driver> getDrivers() {
		return Drivers;
	}
	public void setDrivers(List<Driver> drivers) {
		Drivers = drivers;
	}
	public int getPageIndex() {
		return PageIndex;
	}
	public void setPageIndex(int pageIndex) {
		PageIndex = pageIndex;
	}
	public int getTotalPage() {
		return TotalPage;
	}
	public void setTotalPage(int totalPage) {
		TotalPage = totalPage;
	}
}
