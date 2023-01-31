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
		this.setTitle("查询系统-用户信息");
		this.setLocationRelativeTo(getOwner());//居中
//		System.out.println(str);//检验
		
		tablemodel = getModel(str,begin,end);
		table = new JTable(tablemodel);
		table.setPreferredScrollableViewportSize(new Dimension(600,350));
		JScrollPane scroll = new JScrollPane(table);
		getContentPane().add(scroll, BorderLayout.CENTER);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		JButton exit = new JButton("返回");
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
		//实例化自己的表格模型类
		MyTableModel tableModel = new MyTableModel();
		try {
//			System.out.println(str+begin+end);//检验
			//连接数据库，执行查询语句
			db dbcon = new db();
			ResultSet rs = dbcon.executeQuery("select * from [userevent] where date between '"+begin+"' and '"+end+"'");
//			ResultSet rs1 = dbcon.executeQuery("select * from [userevent] where InputID = '"+str+"' or OutputID = '"+str+"'");
//			System.out.println("查询成功！");//检验
			//获取查询结果中的列名，填充表格模式列
			ResultSetMetaData rsmd = rs.getMetaData();
			int Colnum = rsmd.getColumnCount();
			for(int i=1;i<=Colnum;i++){
				tableModel.addColumn(rsmd.getColumnName(i));
			}
			//获取查询结果中的元组，填充表格模型行
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
//				System.out.println(v.get(i).getInputID());//检验
//				System.out.println(v.get(i).getOutputID());//检验
//				System.out.println(v.get(i).getInputID().toString().equals(str));//检验
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