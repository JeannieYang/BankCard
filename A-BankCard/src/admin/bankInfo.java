package admin;

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
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class bankInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	float money1 = 0;
	int kaiHu = 0,xiaoHu = 0;
	String beginTime;
	String endTime;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bankInfo frame = new bankInfo();
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
	public bankInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);//窗体居中显示
		this.setTitle("统计系统-管理员端");
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
		
		JLabel lblNewLabel = new JLabel("请填写统计时间：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 21));
		lblNewLabel.setBounds(47, 33, 174, 37);
		contentPane.add(lblNewLabel);
		
		JLabel begin = new JLabel("开始时间：");
		begin.setFont(new Font("宋体", Font.PLAIN, 21));
		begin.setBounds(44, 94, 118, 21);
		contentPane.add(begin);
		
		JLabel end = new JLabel("结束时间：");
		end.setFont(new Font("宋体", Font.PLAIN, 21));
		end.setBounds(47, 156, 118, 21);
		contentPane.add(end);
		
		JTextField begint = new JTextField();
		begint.setHorizontalAlignment(SwingConstants.CENTER);
		begint.setFont(new Font("宋体", Font.PLAIN, 21));
		begint.setBounds(177, 91, 211, 27);
		contentPane.add(begint);
		begint.setColumns(10);
		
		JTextField endt = new JTextField();
		endt.setHorizontalAlignment(SwingConstants.CENTER);
		endt.setFont(new Font("宋体", Font.PLAIN, 21));
		endt.setBounds(177, 153, 211, 27);
		contentPane.add(endt);
		endt.setColumns(10);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				beginTime = begint.getText().toString();
				endTime = endt.getText().toString();
//				System.out.println(beginTime);//检验
//				System.out.println(endTime);//检验
				db dbcon = new db();
				try {
					ResultSet rs = dbcon.executeQuery("select * from [bankuser] where date between '"+beginTime+"' and '"+endTime+"'");
					while(rs.next()){
						if(rs.getString("State").equals("开户")){
							kaiHu++;					
//							System.out.println("kaihu");//检验
						}
						if(rs.getString("State").equals("注销")){
							xiaoHu++;
//							System.out.println("xiaohu");//检验
						}
						money1 += rs.getFloat("money");
//						System.out.println(xiaoHu+kaiHu+money1);//检验
					}
//					System.out.println(xiaoHu);//检验
//					System.out.println(kaiHu);//检验
//					System.out.println(money1);//检验
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String s = "日期为："+beginTime+"至"+endTime+"\n"+"开户人数为："+kaiHu+"\n"+"销户人数为："+xiaoHu+"\n"+"储蓄为："+money1;
				JOptionPane.showMessageDialog(null, s);
				xiaoHu = 0;//开户销户人数置零，进行下一次的查询报表
				kaiHu = 0;
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton.setBounds(89, 209, 82, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin a = new admin();
				a.setVisible(true);
//				baoBiao b = new baoBiao();
//				b.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton_1.setBounds(294, 209, 82, 29);
		contentPane.add(btnNewButton_1);
	}
}
