package admin;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import db.db;
import entity.SelectEntity;
import entity.UserEntity;

public class deleteUser extends JFrame {

	private JPanel contentPane;
	static float money;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteUser frame = new deleteUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public deleteUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);//窗体居中显示
		this.setTitle("注销系统-管理员端");
		ImageIcon img = new ImageIcon("D:\\STUDY\\大二上\\数据库\\课程设计\\admin.png");
		//要设置的背景图片
		JLabel imgLabel = new JLabel(img);
		//将背景图放在标签里
		this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		//将背景标签添加到Jframe的LayeredPane面板里
		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		// 设置背景标签的位置
		Container contain = this.getContentPane();
		((JPanel) contain).setOpaque(false); 
		// 将内容面板设为透明。将LayeredPane面板中的背景显示出来
		
		JLabel lblNewLabel = new JLabel("ID：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 21));
		lblNewLabel.setBounds(86, 59, 81, 21);
		contentPane.add(lblNewLabel);
		
		JTextField ID = new JTextField();
		ID.setFont(new Font("宋体", Font.PLAIN, 21));
		ID.setBounds(182, 56, 175, 27);
		contentPane.add(ID);
		ID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("密码：");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(86, 120, 81, 21);
		contentPane.add(lblNewLabel_1);
		
		JPasswordField password = new JPasswordField();
		password.setFont(new Font("宋体", Font.PLAIN, 21));
		password.setBounds(182, 117, 175, 27);
		contentPane.add(password);
		password.setColumns(10);
		
		JButton btnNewButton = new JButton("注销");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db dbcon = new db();
				try {
					ResultSet rs1 = dbcon.executeQuery("select * from [bankuser] where ID ='"+ID.getText()+"'");
//					System.out.println("检验");//注意要导入jar包，否则无法连接成功数据库，会出现空指针异常
					Map m = new HashMap();
					Map m1 = new HashMap();
					int i = 1;
					while(rs1.next()){
//						System.out.println(rs.getString(1)+rs.getString(2).trim());//检验
						m.put(rs1.getString(1).trim(),rs1.getString(2).trim());
						m1.put(rs1.getString(1).trim(),rs1.getString(7).trim());
					}
//					System.out.println(ID.getText());//检验
//					System.out.println(m.get(ID.getText()));//检验
//					System.out.println(m.containsKey(ID.getText()));//检验
					if(m.containsKey(ID.getText())){
						if(m1.get(ID.getText()).equals("注销")){
							JOptionPane.showMessageDialog(null, "该账户已注销!","Warning",JOptionPane.WARNING_MESSAGE);
						}else if((password.getText()).equals(m.get(ID.getText()))){
							ResultSet rs = dbcon.executeQuery("select money from [bankuser] where ID ='"+ID.getText()+"'");
							PreparedStatement ps1 = dbcon.PreparedStatement("update [bankuser] set money = '0' where ID ='"+ID.getText()+"'");
							PreparedStatement ps = dbcon.PreparedStatement("update [bankuser] set state ='注销' where ID ='"+ID.getText()+"'");
								while(rs.next()){
									money = Float.parseFloat(rs.getString(1));
//									System.out.println(money);//检验
									//执行动态插入语句
//									//取当前日期
									Date date1= new Date();        
//									//格式化日期函数，格式：yyyy-MM-dd
									SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
////								System.out.println(sdf.format(date1));//检验
									PreparedStatement prestate = dbcon.PreparedStatement("insert into userevent values(?,?,?,?,?)");
									prestate.setString(1, null);
									prestate.setString(2, sdf.format(date1));
									prestate.setFloat(3, -money);
									prestate.setString(4, ID.getText());
									prestate.setString(5, "注销");
									prestate.executeUpdate();
									ps1.executeUpdate();
									ps.executeUpdate();	
									JOptionPane.showMessageDialog(null, "注销成功！");
									dispose();
									admin ad = new admin();
									ad.setVisible(true);
									dispose();
								}
							}else{
								JOptionPane.showMessageDialog(null, "密码错误,请重新输入!","Warning",JOptionPane.WARNING_MESSAGE);
							}
					}else{
						JOptionPane.showMessageDialog(null, "用户名错误,请重新输入!","Warning",JOptionPane.WARNING_MESSAGE);
					}		
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton.setBounds(97, 184, 96, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				admin ad = new admin();
				ad.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton_1.setBounds(249, 184, 96, 29);
		contentPane.add(btnNewButton_1);
	}

}
