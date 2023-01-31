package entity;

import java.util.Date;
import javax.swing.JFrame;

public class SelectEntity{
	private String InputID;
	private Date date;
	private float money;
	private String OutputID;
	public String getInputID() {
		return InputID;
	}
	public void setInputID(String inputID) {
		InputID = inputID;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public String getOutputID() {
		return OutputID;
	}
	public void setOutputID(String outputID) {
		OutputID = outputID;
	}
	@Override
	public String toString() {
		return "SelectEntity [InputID=" + InputID + ", date=" + date + ", money=" + money + ", OutputID=" + OutputID
				+ "]";
	}
}
