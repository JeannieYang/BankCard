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
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class outputMoney extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	static String str;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					outputMoney frame = new outputMoney(str);
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
	public outputMoney(String str) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);//窗体居中显示
		this.setTitle("取款系统-用户端");
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
		
		JLabel lblNewLabel_3 = new JLabel("ID：");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 21));
		lblNewLabel_3.setBounds(65, 34, 48, 21);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 21));
		lblNewLabel.setBounds(107, 34, 126, 21);
		contentPane.add(lblNewLabel);
//		System.out.println(str)//检验
		lblNewLabel.setText(str);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(65, 84, 394, 21);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setText(new Date().toString());
		
		JLabel lblNewLabel_2 = new JLabel("请输入取款金额：");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 21));
		lblNewLabel_2.setBounds(65, 138, 168, 21);
		contentPane.add(lblNewLabel_2);
		
		JTextField money = new JTextField();
		money.setFont(new Font("宋体", Font.PLAIN, 21));
		money.setBounds(248, 135, 134, 27);
		contentPane.add(money);
		money.setColumns(10);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float money1 = 0;
				float money2 = 0;
				try {
					db dbcon = new db();
					ResultSet rs = dbcon.executeQuery("select * from bankuser where ID='"+str+"'");
					int right = 1;
					Label:
					while(right == 1){
						while(rs.next()){	                                
							if(Float.parseFloat(rs.getString("money")) <= Float.parseFloat(money.getText())){
								JOptionPane.showMessageDialog(null, "银行卡余额不足，请确认!","Warning",JOptionPane.WARNING_MESSAGE);
								right = 0;
								break Label;
							}else{
								String sql="update bankuser set money-=? where ID=?";
								PreparedStatement presta = dbcon.PreparedStatement(sql);
								presta.setFloat(1,Float.parseFloat(money.getText()));
								presta.setString(2,str);
								presta.executeUpdate();
								money1 = rs.getFloat("money");//存完的总额		
								break;
							}
						}
						String a = money.getText();
						money2 = Float.parseFloat(a);//存入的金额
						//取当前日期
						Date date= new Date();        
						//格式化日期函数，格式：yyyy-MM-dd
						SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//						System.out.println(sdf.format(date));//检验
						String sql = "insert into userevent values(?,?,?,?,?)";
						//执行动态插入语句
						PreparedStatement prestate;
						prestate = dbcon.PreparedStatement(sql);
						prestate.setString(1, null);
						prestate.setString(2, sdf.format(date));
						prestate.setFloat(3, -money2);
						prestate.setString(4, str);
						prestate.setString(5, "取款");
						prestate.executeUpdate();
						JOptionPane.showMessageDialog(null, "取款成功！");
						right = 0;
						user u = new user(str);
						u.setVisible(true);
						dispose();
						break Label;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton.setBounds(92, 196, 86, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user u = new user(str);
				u.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton_1.setBounds(266, 196, 86, 29);
		contentPane.add(btnNewButton_1);
		
	}
}
