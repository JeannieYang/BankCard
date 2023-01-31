package user;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.db;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class remittance extends JFrame {

	private JPanel contentPane;
	static String str;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					remittance frame = new remittance(str);
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
	public remittance(String str) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 387, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);//窗体居中显示
		this.setTitle("汇款系统-用户端");
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
		
		JLabel ID1 = new JLabel("ID：");
		ID1.setFont(new Font("宋体", Font.PLAIN, 21));
		ID1.setBounds(69, 33, 54, 21);
		contentPane.add(ID1);
		
		JLabel money1 = new JLabel("汇款金额：");
		money1.setFont(new Font("宋体", Font.PLAIN, 21));
		money1.setBounds(69, 83, 105, 21);
		contentPane.add(money1);
		
		JLabel toID1 = new JLabel("汇款ID：");
		toID1.setFont(new Font("宋体", Font.PLAIN, 21));
		toID1.setBounds(69, 133, 105, 21);
		contentPane.add(toID1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(170, 34, 136, 21);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setText(str);
		
		JTextField money = new JTextField();
		money.setFont(new Font("宋体", Font.PLAIN, 21));
		money.setBounds(170, 80, 137, 27);
		contentPane.add(money);
		money.setColumns(10);
		
		JTextField inputID = new JTextField();
		inputID.setFont(new Font("宋体", Font.PLAIN, 21));
		inputID.setBounds(169, 130, 137, 27);
		contentPane.add(inputID);
		inputID.setColumns(10);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db dbcon = new db();
					ResultSet rs1 = dbcon.executeQuery("select * from bankuser where ID='"+str+"'");
					while(rs1.next()){	   
						ResultSet rs = dbcon.executeQuery("select * from bankuser where ID='"+inputID.getText()+"'");
//						System.out.println(rs.next());
						if(!rs.next()){
							JOptionPane.showMessageDialog(null, "账户不存在，请再次核对！","Warning",JOptionPane.WARNING_MESSAGE);
						}else{
//								System.out.println(rs.getString(7));//检验
//								System.out.println(rs.getString(7).trim());//检验
//								System.out.println(rs.getString(7).trim().equals("开户"));//检验
//								System.out.println(rs.getString(1).trim());
								if(rs.getString(7).trim().equals("开户")){
								PreparedStatement presta = dbcon.PreparedStatement("update bankuser set money+=? where ID=?");
//								System.out.println(Float.parseFloat(money.getText()));//检验
								presta.setFloat(1,Float.parseFloat(money.getText()));
								presta.setString(2,inputID.getText());
								presta.executeUpdate();
//
								PreparedStatement presta1 = dbcon.PreparedStatement("update bankuser set money-=? where ID=?");
//								System.out.println(Float.parseFloat(money.getText())*1.001);//检验
//								System.out.println((float) (Float.parseFloat(money.getText())*1.001));//检验
								presta1.setFloat(1,(float) (Float.parseFloat(money.getText())*1.001));
								presta1.setString(2,str);
								presta1.executeUpdate();

								Date date= new Date();      
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
								String sql = "insert into userevent values(?,?,?,?,?)";
								PreparedStatement prestate = dbcon.PreparedStatement(sql);
								prestate.setString(1, inputID.getText());
								prestate.setString(2, sdf.format(date));
								prestate.setFloat(3, (float) (Float.parseFloat(money.getText())));
								prestate.setString(4, str);
								prestate.setString(5, "转账");
								prestate.executeUpdate();
								
								String sql1 = "insert into userevent values(?,?,?,?,?)";
								PreparedStatement prestate1 = dbcon.PreparedStatement(sql1);
								prestate1.setString(1, inputID.getText());
								prestate1.setString(2, sdf.format(date));
								prestate1.setFloat(3, -(float) (Float.parseFloat(money.getText())*0.001));
								prestate1.setString(4, str);
								prestate1.setString(5, "手续费");
								prestate1.executeUpdate();
								
//								prestate.setString(1, inputID.getText());
//								prestate.setString(2, sdf.format(date));
//								prestate.setFloat(3, -(float) (Float.parseFloat(money.getText())*1.0001));
//								prestate.setString(4, str);
								JOptionPane.showMessageDialog(null, "汇款成功!");

								dispose();
								user u = new user(str);
								u.setVisible(true);	
							}else{
								JOptionPane.showMessageDialog(null, "该账户处于注销状态，无法转账！","Warning",JOptionPane.WARNING_MESSAGE);
							}
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}	
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton.setBounds(69, 182, 88, 29);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user u = new user(str);
				u.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton_1.setBounds(218, 182, 88, 29);
		contentPane.add(btnNewButton_1);
	}
}
