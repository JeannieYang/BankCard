package user;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.db;
import entity.UserEntity;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class findUser2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	static String str;
	String[] date;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					findUser2 frame = new findUser2(str);
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
	public findUser2(String str) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);//窗体居中显示
		this.setTitle("查询系统-用户端");
		ImageIcon img = new ImageIcon("D:\\STUDY\\大二上\\数据库\\课程设计\\admin2.png");
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
		
		JLabel lblNewLabel = new JLabel("请选择查询内容：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 21));
		lblNewLabel.setBounds(44, 26, 168, 21);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				user u = new user(str);
				u.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton_1.setBounds(249, 168, 96, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("查询账户信息");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableUser t = new tableUser(str);
				t.getModel(str);
				t.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton_2.setBounds(44, 62, 168, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("查询转账记录");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableUser2 t = new tableUser2(str);
				t.getModel(str);
				t.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton_3.setBounds(232, 62, 168, 29);
		contentPane.add(btnNewButton_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 21));
		comboBox.setBounds(263, 118, 137, 27);
		contentPane.add(comboBox);
		comboBox.addItem("按收入查询");
		comboBox.addItem("按支出查询");
//		comboBox.addItem("按时间查询");
		
		JLabel lblNewLabel_1 = new JLabel("请选择查询转账方式：");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(44, 121, 210, 21);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("按收入查询")){
//					System.out.println("按收入查询");//检验
					tableUser3 t = new tableUser3(str);
					t.getModel(str);
					t.setVisible(true);
					dispose();
				}else if(comboBox.getSelectedItem().equals("按支出查询")){
					tableUser4 t = new tableUser4(str);
					t.getModel(str);
					t.setVisible(true);
					dispose();
				
//				}else if(comboBox.getSelectedItem().equals("按时间查询")){
////					System.out.println(str);//检验
//					String str1 = JOptionPane.showInputDialog(null, "请输入要查询的始末日期：(以,分隔)", JOptionPane.OK_OPTION);
//					String[] date = str1.split("\\,");
//					System.out.println(date[0]+date[1]);//检验
//					tableUserto b = new tableUserto(str,date[0],date[1]);
//					b.getModel(str,date[0],date[1]);
//					b.setVisible(true);
//					dispose();
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton.setBounds(95, 168, 96, 29);
		contentPane.add(btnNewButton);
	}
}
