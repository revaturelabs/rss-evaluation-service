//This is a Account bean which is a dummy bean used only to send account ID and achieved points in quiz to the account service for adding that points in that particular account and it is not persisted in table.
package com.revature.beans;

public class Account {
	
	private int accId;
	private int points;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	@Override
	public String toString() {
		return "Account [accId=" + accId + ", points=" + points + "]";
	}
}
