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

public class tableUserto extends JFrame {
	private JTable table;
	private MyTableModel tablemodel;
	private JPanel panel;
	private JButton exit;
	static String begin;
	static String end;
	static String str;
	String da;
	
	public tableUserto(String str,String begin,String end){
		this.setSize(700,400);
		this.setTitle("��ѯϵͳ-�û���Ϣ");
		this.setLocationRelativeTo(getOwner());//����
//		System.out.println(str);//����
		
		tablemodel = getModel(str,begin,end);
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
	
	MyTableModel getModel(String str,String begin,String end) {
		//ʵ�����Լ��ı��ģ����
		MyTableModel tableModel = new MyTableModel();
		try {
//			System.out.println(str+begin+end);//����
			//�������ݿ⣬ִ�в�ѯ���
			db dbcon = new db();
			ResultSet rs = dbcon.executeQuery("select * from [userevent] where date between '"+begin+"' and '"+end+"'");
//			ResultSet rs1 = dbcon.executeQuery("select * from [userevent] where InputID = '"+str+"' or OutputID = '"+str+"'");
//			System.out.println("��ѯ�ɹ���");//����
			//��ȡ��ѯ����е������������ģʽ��
			ResultSetMetaData rsmd = rs.getMetaData();
			int Colnum = rsmd.getColumnCount();
			for(int i=1;i<=Colnum;i++){
				tableModel.addColumn(rsmd.getColumnName(i));
			}
			//��ȡ��ѯ����е�Ԫ�飬�����ģ����
			ArrayList<SelectEntity> v = new ArrayList<SelectEntity>();
			ArrayList<SelectEntity> v1 = new ArrayList<SelectEntity>();
			Map m = new HashMap();
			while(rs.next()){
				SelectEntity user = new SelectEntity();
				user.setInputID(rs.getString("InputID"));
				user.setDate(rs.getDate("date"));
				user.setMoney(rs.getFloat("money"));
				user.setOutputID(rs.getString("OutputID"));
				v.add(user);
				m.put(v, user.getOutputID());
			}
			System.out.println(v);
			System.out.println(m);
			rs.close();
			for(int i = 0;i<v.size();i++){
//				System.out.println(v.get(i).getInputID());//����
//				System.out.println(v.get(i).getOutputID());//����
//				System.out.println(v.get(i).getInputID().toString().equals(str));//����
//				if((v.get(i).getInputID().equals(str))){
//					v1.add(v.get(i));
//				}
				if(v.get(i).getInputID().equals(str)){
					v1.add(v.get(i));
					v.remove(v.get(i));
				}
				System.out.println(v1);
//				if(v.get(i).getOutputID().equals(str)){
				
//				tableModel.addRow(new Object[]{v.get(i).getInputID(),
//						v.get(i).getDate(),v.get(i).getMoney(),v.get(i).getOutputID()});
//				}
					
//				}
//				if((v.get(i).getOutputID().equals(str))){
//						tableModel.addRow(new Object[]{v.get(i).getInputID(),
//							v.get(i).getDate(),v.get(i).getMoney(),v.get(i).getOutputID()});
//						continue;
//				}
			}
			System.out.println(v1);
			dbcon.closeConn();	
		}catch(SQLException sqle){
			System.out.println(sqle.toString());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return tableModel; 
	}				
	
	@Override
	public String toString() {
		return "tableUser5 [da=" + da + "]";
	}

	public static void main(String[] args) {
		tableUser2 w = new tableUser2(str);//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		w.setVisible(true);
	}
}