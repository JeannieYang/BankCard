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
		this.setLocationRelativeTo(null);//���������ʾ
		this.setTitle("���ϵͳ-�û���");
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
		
		JLabel ID1 = new JLabel("ID��");
		ID1.setFont(new Font("����", Font.PLAIN, 21));
		ID1.setBounds(69, 33, 54, 21);
		contentPane.add(ID1);
		
		JLabel money1 = new JLabel("����");
		money1.setFont(new Font("����", Font.PLAIN, 21));
		money1.setBounds(69, 83, 105, 21);
		contentPane.add(money1);
		
		JLabel toID1 = new JLabel("���ID��");
		toID1.setFont(new Font("����", Font.PLAIN, 21));
		toID1.setBounds(69, 133, 105, 21);
		contentPane.add(toID1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(170, 34, 136, 21);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setText(str);
		
		JTextField money = new JTextField();
		money.setFont(new Font("����", Font.PLAIN, 21));
		money.setBounds(170, 80, 137, 27);
		contentPane.add(money);
		money.setColumns(10);
		
		JTextField inputID = new JTextField();
		inputID.setFont(new Font("����", Font.PLAIN, 21));
		inputID.setBounds(169, 130, 137, 27);
		contentPane.add(inputID);
		inputID.setColumns(10);
		
		JButton btnNewButton = new JButton("ȷ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db dbcon = new db();
					ResultSet rs1 = dbcon.executeQuery("select * from bankuser where ID='"+str+"'");
					while(rs1.next()){	   
						ResultSet rs = dbcon.executeQuery("select * from bankuser where ID='"+inputID.getText()+"'");
//						System.out.println(rs.next());
						if(!rs.next()){
							JOptionPane.showMessageDialog(null, "�˻������ڣ����ٴκ˶ԣ�","Warning",JOptionPane.WARNING_MESSAGE);
						}else{
//								System.out.println(rs.getString(7));//����
//								System.out.println(rs.getString(7).trim());//����
//								System.out.println(rs.getString(7).trim().equals("����"));//����
//								System.out.println(rs.getString(1).trim());
								if(rs.getString(7).trim().equals("����")){
								PreparedStatement presta = dbcon.PreparedStatement("update bankuser set money+=? where ID=?");
//								System.out.println(Float.parseFloat(money.getText()));//����
								presta.setFloat(1,Float.parseFloat(money.getText()));
								presta.setString(2,inputID.getText());
								presta.executeUpdate();
//
								PreparedStatement presta1 = dbcon.PreparedStatement("update bankuser set money-=? where ID=?");
//								System.out.println(Float.parseFloat(money.getText())*1.001);//����
//								System.out.println((float) (Float.parseFloat(money.getText())*1.001));//����
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
								prestate.setString(5, "ת��");
								prestate.executeUpdate();
								
								String sql1 = "insert into userevent values(?,?,?,?,?)";
								PreparedStatement prestate1 = dbcon.PreparedStatement(sql1);
								prestate1.setString(1, inputID.getText());
								prestate1.setString(2, sdf.format(date));
								prestate1.setFloat(3, -(float) (Float.parseFloat(money.getText())*0.001));
								prestate1.setString(4, str);
								prestate1.setString(5, "������");
								prestate1.executeUpdate();
								
//								prestate.setString(1, inputID.getText());
//								prestate.setString(2, sdf.format(date));
//								prestate.setFloat(3, -(float) (Float.parseFloat(money.getText())*1.0001));
//								prestate.setString(4, str);
								JOptionPane.showMessageDialog(null, "���ɹ�!");

								dispose();
								user u = new user(str);
								u.setVisible(true);	
							}else{
								JOptionPane.showMessageDialog(null, "���˻�����ע��״̬���޷�ת�ˣ�","Warning",JOptionPane.WARNING_MESSAGE);
							}
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}	
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 21));
		btnNewButton.setBounds(69, 182, 88, 29);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("����");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user u = new user(str);
				u.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 21));
		btnNewButton_1.setBounds(218, 182, 88, 29);
		contentPane.add(btnNewButton_1);
	}
}
