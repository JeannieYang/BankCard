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
		this.setLocationRelativeTo(null);//���������ʾ
		this.setTitle("��ѯϵͳ-����Ա��");
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
		
		JButton btnNewButton = new JButton("��ѯ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				str = ID.getText().trim();
//				System.out.println(str);//����
				db dbcon = new db();
				try {
					ResultSet rs = dbcon.executeQuery("select * from [bankuser] where ID ='"+str+"'");
					Map m = new HashMap();
					while(rs.next()){
						m.put(rs.getString(1).trim(),rs.getString(2).trim());
					}
					if(m.containsKey(str)){
						if((password.getText()).equals(m.get(str))){
//							System.out.println(str);//����
							table t = new table(str);
							t.setVisible(true);
							dispose();
						}else{
							JOptionPane.showMessageDialog(null, "�������,����������!","Warning",JOptionPane.WARNING_MESSAGE);
						}					
					}else{
						JOptionPane.showMessageDialog(null, "�û������Ϸ�,����������!","Warning",JOptionPane.WARNING_MESSAGE);
					}							
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 21));
		btnNewButton.setBounds(15, 184, 120, 29);
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
		btnNewButton_1.setBounds(332, 184, 96, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("��ѯ��ʷ��¼");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {str = ID.getText().trim();
//				System.out.println(str);//����
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
							JOptionPane.showMessageDialog(null, "�������,����������!","Warning",JOptionPane.WARNING_MESSAGE);
						}					
					}else{
						JOptionPane.showMessageDialog(null, "�û������Ϸ�,����������!","Warning",JOptionPane.WARNING_MESSAGE);
					}							
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setFont(new Font("����", Font.PLAIN, 21));
		btnNewButton_2.setBounds(150, 185, 167, 29);
		contentPane.add(btnNewButton_2);
	}
}
