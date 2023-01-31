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
		this.setLocationRelativeTo(null);//���������ʾ
		this.setTitle("��ѯϵͳ-�û���");
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
		
		JLabel lblNewLabel = new JLabel("��ѡ���ѯ���ݣ�");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 21));
		lblNewLabel.setBounds(44, 26, 168, 21);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("����");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				user u = new user(str);
				u.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 21));
		btnNewButton_1.setBounds(249, 168, 96, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("��ѯ�˻���Ϣ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableUser t = new tableUser(str);
				t.getModel(str);
				t.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("����", Font.PLAIN, 21));
		btnNewButton_2.setBounds(44, 62, 168, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("��ѯת�˼�¼");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableUser2 t = new tableUser2(str);
				t.getModel(str);
				t.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setFont(new Font("����", Font.PLAIN, 21));
		btnNewButton_3.setBounds(232, 62, 168, 29);
		contentPane.add(btnNewButton_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("����", Font.PLAIN, 21));
		comboBox.setBounds(263, 118, 137, 27);
		contentPane.add(comboBox);
		comboBox.addItem("�������ѯ");
		comboBox.addItem("��֧����ѯ");
//		comboBox.addItem("��ʱ���ѯ");
		
		JLabel lblNewLabel_1 = new JLabel("��ѡ���ѯת�˷�ʽ��");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(44, 121, 210, 21);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("ȷ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("�������ѯ")){
//					System.out.println("�������ѯ");//����
					tableUser3 t = new tableUser3(str);
					t.getModel(str);
					t.setVisible(true);
					dispose();
				}else if(comboBox.getSelectedItem().equals("��֧����ѯ")){
					tableUser4 t = new tableUser4(str);
					t.getModel(str);
					t.setVisible(true);
					dispose();
				
//				}else if(comboBox.getSelectedItem().equals("��ʱ���ѯ")){
////					System.out.println(str);//����
//					String str1 = JOptionPane.showInputDialog(null, "������Ҫ��ѯ��ʼĩ���ڣ�(��,�ָ�)", JOptionPane.OK_OPTION);
//					String[] date = str1.split("\\,");
//					System.out.println(date[0]+date[1]);//����
//					tableUserto b = new tableUserto(str,date[0],date[1]);
//					b.getModel(str,date[0],date[1]);
//					b.setVisible(true);
//					dispose();
				}
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 21));
		btnNewButton.setBounds(95, 168, 96, 29);
		contentPane.add(btnNewButton);
	}
}
