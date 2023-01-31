package admin;

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

public class table extends JFrame {
	private JTable table;
	private MyTableModel tablemodel;
	private JPanel panel;
	private JButton exit;
	private JButton change;
	static String str;
	
	public table(String str){
		this.setSize(700,400);
		this.setTitle("查询系统-用户信息");
		this.setLocationRelativeTo(getOwner());//居中
		
		tablemodel = getModel(str);
		table = new JTable(tablemodel);
		table.setPreferredScrollableViewportSize(new Dimension(600,350));
		JScrollPane scroll = new JScrollPane(table);
		getContentPane().add(scroll, BorderLayout.CENTER);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		JButton exit = new JButton("返回");
		JButton change = new JButton("修改");
		panel.add(change);
		panel.add(exit);
		
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				findUser f = new findUser();
				f.setVisible(true);
				dispose();
			}
		});		
		
		change.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int i,index = 0,count;
				db dbcon = new db();
				if(table.getCellEditor()!=null){
					table.getCellEditor().stopCellEditing();
				}
				try {
					String sql = "update bankuser set password=?,username=?,phone=?,date=?,money=?,state=?,address=? where ID=?";
					PreparedStatement presta = dbcon.PreparedStatement(sql);
					//获得JTable中所修改的行数
					count  = tablemodel.getEditedIndex().size();
					//获得JTable中所修改的行的数据，更新数据库
					if (count > 0){
						for(i = 0;i<count;i++){
							index = tablemodel.getEditedIndex().get(i);
							presta.setString(1,table.getValueAt(index,1).toString());
							presta.setString(2,table.getValueAt(index,2).toString());
							presta.setString(3,table.getValueAt(index,3).toString());
							presta.setString(4,table.getValueAt(index,4).toString());
							presta.setString(5,table.getValueAt(index,5).toString());
							presta.setString(6,table.getValueAt(index,6).toString());
							presta.setString(7,table.getValueAt(index,7).toString());
							presta.setString(8,table.getValueAt(index,0).toString());							
							presta.addBatch();
						}
					}
					presta.executeBatch();
					JOptionPane.showMessageDialog(null, "修改成功！");
				}catch(SQLException sqle){
					System.out.println(sqle.toString());
				}
			}
		});		
	}
	
	MyTableModel getModel(String str) {
		//实例化自己的表格模型类
		MyTableModel tableModel = new MyTableModel();
		try {
			//连接数据库，执行查询语句
			db dbcon = new db();
			ResultSet rs = null;
//			System.out.println(str);//检验
			rs = dbcon.executeQuery("select * from [bankuser] where ID = '"+str+"'");	
			//获取查询结果中的列名，填充表格模式列
			ResultSetMetaData rsmd = rs.getMetaData();
			int Colnum = rsmd.getColumnCount();
			int i;
			for(i=1;i<=Colnum;i++){
				tableModel.addColumn(rsmd.getColumnName(i));
			}
			//获取查询结果中的元组，填充表格模型行
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
		table w = new table(str);
		w.setVisible(true);
	}
}
