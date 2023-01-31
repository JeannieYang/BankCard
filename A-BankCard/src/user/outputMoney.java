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
		this.setLocationRelativeTo(null);//���������ʾ
		this.setTitle("ȡ��ϵͳ-�û���");
		ImageIcon img = new ImageIcon("D:\\STUDY\\�����\\���ݿ�\\�γ����\\admin2.png");
		//Ҫ���õı���ͼƬ
		JLabel imgLabel = new JLabel(img);
		//������ͼ���ڱ�ǩ��
		this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		//��������ǩ��ӵ�Jframe��LayeredPane�����
		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		// ���ñ�����ǩ��λ��
		Container contain = this.getContentPane();
		((JPanel) contain).setOpaque(false); 
		// �����������Ϊ͸������LayeredPane����еı�����ʾ����
		
		JLabel lblNewLabel_3 = new JLabel("ID��");
		lblNewLabel_3.setFont(new Font("����", Font.PLAIN, 21));
		lblNewLabel_3.setBounds(65, 34, 48, 21);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 21));
		lblNewLabel.setBounds(107, 34, 126, 21);
		contentPane.add(lblNewLabel);
//		System.out.println(str)//����
		lblNewLabel.setText(str);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(65, 84, 394, 21);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setText(new Date().toString());
		
		JLabel lblNewLabel_2 = new JLabel("������ȡ���");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 21));
		lblNewLabel_2.setBounds(65, 138, 168, 21);
		contentPane.add(lblNewLabel_2);
		
		JTextField money = new JTextField();
		money.setFont(new Font("����", Font.PLAIN, 21));
		money.setBounds(248, 135, 134, 27);
		contentPane.add(money);
		money.setColumns(10);
		
		JButton btnNewButton = new JButton("ȷ��");
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
								JOptionPane.showMessageDialog(null, "���п����㣬��ȷ��!","Warning",JOptionPane.WARNING_MESSAGE);
								right = 0;
								break Label;
							}else{
								String sql="update bankuser set money-=? where ID=?";
								PreparedStatement presta = dbcon.PreparedStatement(sql);
								presta.setFloat(1,Float.parseFloat(money.getText()));
								presta.setString(2,str);
								presta.executeUpdate();
								money1 = rs.getFloat("money");//������ܶ�		
								break;
							}
						}
						String a = money.getText();
						money2 = Float.parseFloat(a);//����Ľ��
						//ȡ��ǰ����
						Date date= new Date();        
						//��ʽ�����ں�������ʽ��yyyy-MM-dd
						SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//						System.out.println(sdf.format(date));//����
						String sql = "insert into userevent values(?,?,?,?,?)";
						//ִ�ж�̬�������
						PreparedStatement prestate;
						prestate = dbcon.PreparedStatement(sql);
						prestate.setString(1, null);
						prestate.setString(2, sdf.format(date));
						prestate.setFloat(3, -money2);
						prestate.setString(4, str);
						prestate.setString(5, "ȡ��");
						prestate.executeUpdate();
						JOptionPane.showMessageDialog(null, "ȡ��ɹ���");
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
		btnNewButton.setFont(new Font("����", Font.PLAIN, 21));
		btnNewButton.setBounds(92, 196, 86, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("����");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user u = new user(str);
				u.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 21));
		btnNewButton_1.setBounds(266, 196, 86, 29);
		contentPane.add(btnNewButton_1);
		
	}
}
