package admin;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.db;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class addUser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addUser frame = new addUser();
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
	public addUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 435, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);//窗体居中显示
		this.setTitle("开户系统");
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
		
		JLabel lblNewLabel = new JLabel("Address");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 21));
		lblNewLabel.setBounds(49, 50, 81, 21);
		contentPane.add(lblNewLabel);
		
		JTextField address = new JTextField();
		address.setFont(new Font("宋体", Font.PLAIN, 21));
		address.setBounds(183, 44, 172, 27);
		contentPane.add(address);
		address.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(49, 100, 81, 21);
		contentPane.add(lblNewLabel_1);
		
		JTextField ID = new JTextField();
		ID.setFont(new Font("宋体", Font.PLAIN, 21));
		ID.setBounds(183, 97, 172, 27);
		contentPane.add(ID);
		ID.setColumns(10);
		
		JTextField password = new JTextField();
		password.setFont(new Font("宋体", Font.PLAIN, 21));
		password.setBounds(183, 148, 172, 27);
		contentPane.add(password);
		password.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("密码");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 21));
		lblNewLabel_3.setBounds(49, 156, 81, 21);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("姓名");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 21));
		lblNewLabel_4.setBounds(49, 210, 81, 21);
		contentPane.add(lblNewLabel_4);
		
		JTextField name = new JTextField();
		name.setFont(new Font("宋体", Font.PLAIN, 21));
		name.setBounds(183, 207, 172, 27);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("电话号码");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 21));
		lblNewLabel_5.setBounds(49, 264, 106, 21);
		contentPane.add(lblNewLabel_5);
		
		JTextField phone = new JTextField();
		phone.setFont(new Font("宋体", Font.PLAIN, 21));
		phone.setBounds(183, 261, 172, 27);
		contentPane.add(phone);
		phone.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("日期");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 21));
		lblNewLabel_6.setBounds(49, 314, 81, 21);
		contentPane.add(lblNewLabel_6);
		
		JTextField year = new JTextField();
		year.setFont(new Font("宋体", Font.PLAIN, 21));
		year.setBounds(153, 312, 60, 27);
		contentPane.add(year);
		year.setColumns(10);
		
		JComboBox month = new JComboBox();
		month.setBounds(255, 312, 41, 27);
		contentPane.add(month);
		month.addItem("01");
		month.addItem("02");
		month.addItem("03");
		month.addItem("04");
		month.addItem("05");
		month.addItem("06");
		month.addItem("07");
		month.addItem("08");
		month.addItem("09");
		month.addItem("10");
		month.addItem("11");
		month.addItem("12");
		//添加12个选择项目
		
		JComboBox day = new JComboBox();
		day.setBounds(337, 312, 41, 27);
		contentPane.add(day);
		day.addItem("01");
		day.addItem("01");
		day.addItem("02");
		day.addItem("03");
		day.addItem("04");
		day.addItem("05");
		day.addItem("06");
		day.addItem("07");
		day.addItem("08");
		day.addItem("09");
		for(int i=10;i<=31;i++){
			day.addItem(i);
		}
		//添加31个选择项目
		
		JLabel lblNewLabel_7 = new JLabel("-");
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 21));
		lblNewLabel_7.setBounds(226, 314, 18, 21);
		contentPane.add(lblNewLabel_7);
		
		JLabel label = new JLabel("-");
		label.setFont(new Font("宋体", Font.PLAIN, 21));
		label.setBounds(311, 315, 18, 21);
		contentPane.add(label);
		
		JLabel lblNewLabel_8 = new JLabel("余额");
		lblNewLabel_8.setFont(new Font("宋体", Font.PLAIN, 21));
		lblNewLabel_8.setBounds(49, 362, 81, 21);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("状态");
		lblNewLabel_9.setFont(new Font("宋体", Font.PLAIN, 21));
		lblNewLabel_9.setBounds(49, 407, 81, 21);
		contentPane.add(lblNewLabel_9);
		
		JTextField money = new JTextField();
		money.setFont(new Font("宋体", Font.PLAIN, 21));
		money.setBounds(183, 359, 172, 27);
		contentPane.add(money);
		money.setColumns(10);
		
		JComboBox state = new JComboBox();
		state.setFont(new Font("宋体", Font.PLAIN, 21));
		state.setBounds(183, 404, 172, 27);
		contentPane.add(state);
		state.addItem("开户");
		state.addItem("注销");
		//添加2个选择项目
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				db dbcon = new db();
				try {
					String sql = "insert into bankuser values(?,?,?,?,?,?,?,?)";
					String sql1 = "insert into userevent values(?,?,?,?,?)";
					PreparedStatement prestate = dbcon.PreparedStatement(sql);
					PreparedStatement prestate1 = dbcon.PreparedStatement(sql1);
					prestate.setString(1, ID.getText());
					prestate.setString(2, password.getText());
					prestate.setString(3, name.getText());
					prestate.setString(4, phone.getText());//获取选中项目的索引
					prestate.setString(5, year.getText()+"-"+month.getSelectedItem()
						+"-"+day.getSelectedItem());  
					prestate.setString(6, money.getText());
					prestate.setString(7, state.getSelectedItem().toString());
					prestate.setString(8, address.getText());
					prestate.executeUpdate();
							
					prestate1.setString(1, ID.getText());
					prestate1.setString(2, year.getText()+"-"+month.getSelectedItem()
							+"-"+day.getSelectedItem());  
					prestate1.setString(3, money.getText());
					prestate1.setString(4, null);
					prestate1.setString(5, state.getSelectedItem().toString());
					prestate1.executeUpdate();
							
					JOptionPane.showMessageDialog(null, "添加成功!");
					
				}catch(SQLException e) {
						System.out.println(e.toString());
				}
			}
		});
		
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton.setBounds(85, 465, 96, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				admin admin = new admin();
				admin.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton_1.setBounds(233, 465, 96, 29);
		contentPane.add(btnNewButton_1);
	}
}
