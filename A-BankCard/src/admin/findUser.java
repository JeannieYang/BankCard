package admin;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.synth.SynthSpinnerUI;

import db.db;
import entity.UserEntity;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;

public class findUser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	static String str;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					findUser frame = new findUser();
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
	public findUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);//窗体居中显示
		this.setTitle("查询系统-管理员端");
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
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				str = ID.getText().trim();
//				System.out.println(str);//检验
				db dbcon = new db();
				try {
					ResultSet rs = dbcon.executeQuery("select * from [bankuser] where ID ='"+str+"'");
					Map m = new HashMap();
					while(rs.next()){
						m.put(rs.getString(1).trim(),rs.getString(2).trim());
					}
					if(m.containsKey(str)){
						if((password.getText()).equals(m.get(str))){
//							System.out.println(str);//检验
							table t = new table(str);
							t.setVisible(true);
							dispose();
						}else{
							JOptionPane.showMessageDialog(null, "密码错误,请重新输入!","Warning",JOptionPane.WARNING_MESSAGE);
						}					
					}else{
						JOptionPane.showMessageDialog(null, "用户名不合法,请重新输入!","Warning",JOptionPane.WARNING_MESSAGE);
					}							
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton.setBounds(15, 184, 120, 29);
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
		btnNewButton_1.setBounds(332, 184, 96, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("查询历史记录");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {str = ID.getText().trim();
//				System.out.println(str);//检验
				db dbcon = new db();
				try {
					ResultSet rs = dbcon.executeQuery("select * from [bankuser] where ID ='"+str+"'");
					Map m = new HashMap();
					while(rs.next()){
						m.put(rs.getString(1).trim(),rs.getString(2).trim());
					}
					if(m.containsKey(str)){
						if((password.getText()).equals(m.get(str))){
							table2 t2 = new table2(str);
							t2.getModel(str);
							t2.setVisible(true);
							dispose();
						}else{
							JOptionPane.showMessageDialog(null, "密码错误,请重新输入!","Warning",JOptionPane.WARNING_MESSAGE);
						}					
					}else{
						JOptionPane.showMessageDialog(null, "用户名不合法,请重新输入!","Warning",JOptionPane.WARNING_MESSAGE);
					}							
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton_2.setBounds(150, 185, 167, 29);
		contentPane.add(btnNewButton_2);
	}
}
