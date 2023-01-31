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
		this.setLocationRelativeTo(null);//���������ʾ
		this.setTitle("ע��ϵͳ-����Ա��");
		ImageIcon img = new ImageIcon("D:\\STUDY\\�����\\���ݿ�\\�γ����\\admin.png");
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
		
		JLabel lblNewLabel = new JLabel("ID��");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 21));
		lblNewLabel.setBounds(86, 59, 81, 21);
		contentPane.add(lblNewLabel);
		
		JTextField ID = new JTextField();
		ID.setFont(new Font("����", Font.PLAIN, 21));
		ID.setBounds(182, 56, 175, 27);
		contentPane.add(ID);
		ID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("���룺");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(86, 120, 81, 21);
		contentPane.add(lblNewLabel_1);
		
		JPasswordField password = new JPasswordField();
		password.setFont(new Font("����", Font.PLAIN, 21));
		password.setBounds(182, 117, 175, 27);
		contentPane.add(password);
		password.setColumns(10);
		
		JButton btnNewButton = new JButton("ע��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db dbcon = new db();
				try {
					ResultSet rs1 = dbcon.executeQuery("select * from [bankuser] where ID ='"+ID.getText()+"'");
//					System.out.println("����");//ע��Ҫ����jar���������޷����ӳɹ����ݿ⣬����ֿ�ָ���쳣
					Map m = new HashMap();
					Map m1 = new HashMap();
					int i = 1;
					while(rs1.next()){
//						System.out.println(rs.getString(1)+rs.getString(2).trim());//����
						m.put(rs1.getString(1).trim(),rs1.getString(2).trim());
						m1.put(rs1.getString(1).trim(),rs1.getString(7).trim());
					}
//					System.out.println(ID.getText());//����
//					System.out.println(m.get(ID.getText()));//����
//					System.out.println(m.containsKey(ID.getText()));//����
					if(m.containsKey(ID.getText())){
						if(m1.get(ID.getText()).equals("ע��")){
							JOptionPane.showMessageDialog(null, "���˻���ע��!","Warning",JOptionPane.WARNING_MESSAGE);
						}else if((password.getText()).equals(m.get(ID.getText()))){
							ResultSet rs = dbcon.executeQuery("select money from [bankuser] where ID ='"+ID.getText()+"'");
							PreparedStatement ps1 = dbcon.PreparedStatement("update [bankuser] set money = '0' where ID ='"+ID.getText()+"'");
							PreparedStatement ps = dbcon.PreparedStatement("update [bankuser] set state ='ע��' where ID ='"+ID.getText()+"'");
								while(rs.next()){
									money = Float.parseFloat(rs.getString(1));
//									System.out.println(money);//����
									//ִ�ж�̬�������
//									//ȡ��ǰ����
									Date date1= new Date();        
//									//��ʽ�����ں�������ʽ��yyyy-MM-dd
									SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
////								System.out.println(sdf.format(date1));//����
									PreparedStatement prestate = dbcon.PreparedStatement("insert into userevent values(?,?,?,?,?)");
									prestate.setString(1, null);
									prestate.setString(2, sdf.format(date1));
									prestate.setFloat(3, -money);
									prestate.setString(4, ID.getText());
									prestate.setString(5, "ע��");
									prestate.executeUpdate();
									ps1.executeUpdate();
									ps.executeUpdate();	
									JOptionPane.showMessageDialog(null, "ע���ɹ���");
									dispose();
									admin ad = new admin();
									ad.setVisible(true);
									dispose();
								}
							}else{
								JOptionPane.showMessageDialog(null, "�������,����������!","Warning",JOptionPane.WARNING_MESSAGE);
							}
					}else{
						JOptionPane.showMessageDialog(null, "�û�������,����������!","Warning",JOptionPane.WARNING_MESSAGE);
					}		
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 21));
		btnNewButton.setBounds(97, 184, 96, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("����");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				admin ad = new admin();
				ad.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 21));
		btnNewButton_1.setBounds(249, 184, 96, 29);
		contentPane.add(btnNewButton_1);
	}

}
