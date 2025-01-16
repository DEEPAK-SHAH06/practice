package com.model;

public class Marketing {
	
	private int teamID;
	private String name;
	private String area;
	private String category;
	public int getTeamID() {
		return teamID;
	}
	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	@Override
	public String toString() {
		return "Marketing [teamID=" + teamID + ", name=" + name + ", area=" + area + ", category=" + category + "]";
	}
	
	

}
