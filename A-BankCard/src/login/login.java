package login;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import admin.admin;
import db.db;
import user.user;

public class login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField_1;
	static String ID;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("��ӭ�������д��ϵͳ");
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("����", Font.BOLD, 25));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		this.setLocationRelativeTo(null);//���������ʾ
		this.setTitle("BankCardSystem");
		
		ImageIcon img = new ImageIcon("D:\\STUDY\\�����\\���ݿ�\\�γ����\\money.jpg");
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
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("����Ա��¼", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("�˺ţ�");
		lblNewLabel_1.setForeground(new Color(0, 100, 0));
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(103, 45, 75, 21);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("���룺");
		lblNewLabel_2.setForeground(new Color(0, 100, 0));
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(103, 100, 60, 21);
		panel.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("����", Font.PLAIN, 20));
		passwordField.setBounds(193, 97, 156, 27);
		panel.add(passwordField);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("����", Font.PLAIN, 20));
		textField.setBounds(193, 42, 156, 27);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("�˳�");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBackground(new Color(240, 255, 240));
		btnNewButton.setFont(new Font("����", Font.PLAIN, 20));
		btnNewButton.setBounds(255, 158, 109, 29);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("��¼");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File("D:\\STUDY\\�����\\���ݿ�\\�γ����\\admin.txt");
				String[] a = null;
				String[] arr = null;
				try {
					BufferedReader bf = new BufferedReader(new FileReader(file));
					String s = bf.readLine();
//					System.out.println(s);//����
					while(s!=null){
						arr = s.split("\\,");
//						for(int i=0;i<arr.length;i++){
//							System.out.println(arr[i]);
//						}//����
						break;
					}
					String admin = arr[0];
					String password = arr[1];
					if(textField.getText().equals(admin)){
						if(passwordField.getText().equals(password)){
							JOptionPane.showMessageDialog(null, "��½�ɹ���");
							admin ad = new admin();
							ad.setVisible(true);
							dispose();
						}else if(!passwordField.getText().equals(password)){
							JOptionPane.showMessageDialog(null, "�������,����������!","Warning",JOptionPane.WARNING_MESSAGE);
						}
					}else{
						JOptionPane.showMessageDialog(null, "�û�������,����������!","Warning",JOptionPane.WARNING_MESSAGE);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBackground(new Color(240, 255, 240));
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 20));
		btnNewButton_1.setBounds(103, 158, 109, 29);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("�û���¼", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("�˺ţ�");
		lblNewLabel_3.setForeground(new Color(255, 140, 0));
		lblNewLabel_3.setBackground(new Color(0, 100, 0));
		lblNewLabel_3.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(103, 45, 75, 21);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("���룺");
		lblNewLabel_4.setForeground(new Color(255, 140, 0));
		lblNewLabel_4.setBackground(new Color(0, 100, 0));
		lblNewLabel_4.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(103, 100, 60, 21);
		panel_1.add(lblNewLabel_4);
		
		JButton btnNewButton_3 = new JButton("�˳�");
		btnNewButton_3.setBackground(new Color(255, 250, 240));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_3.setFont(new Font("����", Font.PLAIN, 20));
		btnNewButton_3.setBounds(255, 158, 109, 29);
		panel_1.add(btnNewButton_3);
		
		JTextField text = new JTextField();
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setFont(new Font("����", Font.PLAIN, 20));
		text.setBounds(193, 42, 156, 27);
		panel_1.add(text);
		text.setColumns(10);
		
		JPasswordField password = new JPasswordField();
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setFont(new Font("����", Font.PLAIN, 20));
		password.setBounds(193, 97, 156, 27);
		panel_1.add(password);
		JButton btnNewButton_2 = new JButton("��¼");
		btnNewButton_2.setBackground(new Color(255, 250, 240));
		btnNewButton_2.setFont(new Font("����", Font.PLAIN, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db dbcon = new db();
				try {
					ResultSet rs = dbcon.executeQuery("select * from [bankuser]");
//					System.out.println("����");//ע��Ҫ����jar���������޷����ӳɹ����ݿ⣬����ֿ�ָ���쳣
					Map m = new HashMap();
					Map m1 = new HashMap();
					int i = 1;
					while(rs.next()){
//						System.out.println(rs.getString(1)+rs.getString(2).trim());//����
						m.put(rs.getString(1).trim(),rs.getString(2).trim());
						m1.put(rs.getString(1).trim(),rs.getString(7).trim());
					}
//						System.out.println(m);//����
//						System.out.println(m.keySet());//����
//						System.out.println(m.get(textField_1.getText()));//����
//						System.out.println(password.getText());//����
//						System.out.println(m.get(text.getText()));//����
					if(m.containsKey(text.getText())){
//						System.out.println(m1.get(text.getText().trim()));//����
//						System.out.println(m1.get(text.getText().trim()).equals("ע��"));//����
						if(m1.get(text.getText().trim()).equals("ע��")){
							JOptionPane.showMessageDialog(null, "���˻���ע�����޷���¼��","Warning",JOptionPane.WARNING_MESSAGE);
						}else{
							if((password.getText()).equals(m.get(text.getText()))){
								JOptionPane.showMessageDialog(null, "��¼�ɹ���");
								user u = new user(text.getText());
								u.setVisible(true);
								dispose();
							}else{
								JOptionPane.showMessageDialog(null, "�������,����������!","Warning",JOptionPane.WARNING_MESSAGE);
							}
						}
					}else{
						JOptionPane.showMessageDialog(null, "�û�������,����������!","Warning",JOptionPane.WARNING_MESSAGE);
					}							
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(103, 158, 109, 29);
		panel_1.add(btnNewButton_2);
	}
}