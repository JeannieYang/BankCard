package user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;

import db.db;
import entity.SelectEntity;
import entity.UserEntity;
import tableModel.MyTableModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class tableUser extends JFrame {
	private JTable table;
	private MyTableModel tablemodel;
	private JPanel panel;
	private JButton exit;
	static String str;
	
	public tableUser(String str){
		this.setSize(700,400);
		this.setTitle("��ѯϵͳ-�û���Ϣ");
		this.setLocationRelativeTo(getOwner());//����
		
		tablemodel = getModel(str);
		table = new JTable(tablemodel);
		table.setPreferredScrollableViewportSize(new Dimension(600,350));
		JScrollPane scroll = new JScrollPane(table);
		getContentPane().add(scroll, BorderLayout.CENTER);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		JButton exit = new JButton("����");
		panel.add(exit);
		
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				findUser2 f = new findUser2(str);
				f.setVisible(true);
				dispose();
			}
		});		
	}
	
	MyTableModel getModel(String str) {
		//ʵ�����Լ��ı��ģ����
		MyTableModel tableModel = new MyTableModel();
		try {
			//�������ݿ⣬ִ�в�ѯ���
			db dbcon = new db();
			ResultSet rs = null;
//			System.out.println(str);//����
			rs = dbcon.executeQuery("select * from [bankuser] where ID = '"+str+"'");	
			//��ȡ��ѯ����е������������ģʽ��
			ResultSetMetaData rsmd = rs.getMetaData();
			int Colnum = rsmd.getColumnCount();
			int i;
			for(i=1;i<=Colnum;i++){
				tableModel.addColumn(rsmd.getColumnName(i));
			}
			//��ȡ��ѯ����е�Ԫ�飬�����ģ����
			ArrayList<UserEntity> v = new ArrayList<UserEntity>();
			while(rs.next()){
				UserEntity user = new  UserEntity();
				user.setID(rs.getString("ID"));
				user.setPassword(rs.getString("password"));
				user.setUsername(rs.getString("username"));
				user.setPhone(rs.getString("phone"));
				user.setDate(rs.getDate("date"));
				user.setMoney(rs.getFloat("money"));
				user.setState(rs.getString("state"));
				user.setAddress(rs.getString("address"));
				v.add(user);
			}
			rs.close();
			for(i = 0;i<v.size();i++){
				tableModel.addRow(new Object[]{v.get(i).getID(),
					v.get(i).getPassword(),v.get(i).getUsername(),v.get(i).getPhone(),v.get(i).getDate(),
					v.get(i).getMoney(),v.get(i).getState(),v.get(i).getAddress()});
			}
			dbcon.closeConn();	
		}catch(SQLException sqle){
			System.out.println(sqle.toString());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return tableModel; 
	}				
	
	public static void main(String[] args) {
		tableUser w = new tableUser(str);
		w.setVisible(true);
	}
}
