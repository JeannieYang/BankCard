package entity;

import java.util.Date;

public class UserEntity {
	private String ID;
	private String password;
	private String username;
	private String phone;	
	private String address;
	private float money;
	private String state;
	private Date date;
	private String InputID;
	private String OutputID;
	private String date1;
	private String type;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(Float string) {
		this.money = string;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date string) {
		this.date = string;
	}
	public String getInputID() {
		return InputID;
	}
	public void setInputID(String inputID) {
		InputID = inputID;
	}
	public String getOutputID() {
		return OutputID;
	}
	public void setOutputID(String outputID) {
		OutputID = outputID;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "UserEntity [ID=" + ID + ", password=" + password + ", username=" + username + ", phone=" + phone
				+ ", address=" + address + ", money=" + money + ", state=" + state + ", date=" + date + ", InputID="
				+ InputID + ", OutputID=" + OutputID + ", date1=" + date1 + ", type=" + type + "]";
	}	
}
	