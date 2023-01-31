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

public class tableUser4 extends JFrame {
	private JTable table;
	private MyTableModel tablemodel;
	private JPanel panel;
	private JButton exit;
	static String str;
	
	public tableUser4(String str){
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
			rs = dbcon.executeQuery("select * from [userevent] where outputID = '"+str+"'");	
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
				user.setInputID(rs.getString("inputID"));
				user.setDate(rs.getDate("date"));
				user.setMoney(rs.getFloat("money"));
				user.setOutputID(rs.getString("outputID"));
				user.setType(rs.getString("type"));
				v.add(user);
			}
			rs.close();
			for(i = 0;i<v.size();i++){
				tableModel.addRow(new Object[]{v.get(i).getInputID(),
					v.get(i).getDate(),v.get(i).getMoney(),v.get(i).getOutputID(),v.get(i).getType()});
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
		tableUser4 w = new tableUser4(str);
		w.setVisible(true);
	}
}