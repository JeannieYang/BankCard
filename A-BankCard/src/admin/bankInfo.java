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
		this.setLocationRelativeTo(null);//���������ʾ
		this.setTitle("ͳ��ϵͳ-����Ա��");
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
		
		JLabel lblNewLabel = new JLabel("����дͳ��ʱ�䣺");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 21));
		lblNewLabel.setBounds(47, 33, 174, 37);
		contentPane.add(lblNewLabel);
		
		JLabel begin = new JLabel("��ʼʱ�䣺");
		begin.setFont(new Font("����", Font.PLAIN, 21));
		begin.setBounds(44, 94, 118, 21);
		contentPane.add(begin);
		
		JLabel end = new JLabel("����ʱ�䣺");
		end.setFont(new Font("����", Font.PLAIN, 21));
		end.setBounds(47, 156, 118, 21);
		contentPane.add(end);
		
		JTextField begint = new JTextField();
		begint.setHorizontalAlignment(SwingConstants.CENTER);
		begint.setFont(new Font("����", Font.PLAIN, 21));
		begint.setBounds(177, 91, 211, 27);
		contentPane.add(begint);
		begint.setColumns(10);
		
		JTextField endt = new JTextField();
		endt.setHorizontalAlignment(SwingConstants.CENTER);
		endt.setFont(new Font("����", Font.PLAIN, 21));
		endt.setBounds(177, 153, 211, 27);
		contentPane.add(endt);
		endt.setColumns(10);
		
		JButton btnNewButton = new JButton("ȷ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				beginTime = begint.getText().toString();
				endTime = endt.getText().toString();
//				System.out.println(beginTime);//����
//				System.out.println(endTime);//����
				db dbcon = new db();
				try {
					ResultSet rs = dbcon.executeQuery("select * from [bankuser] where date between '"+beginTime+"' and '"+endTime+"'");
					while(rs.next()){
						if(rs.getString("State").equals("����")){
							kaiHu++;					
//							System.out.println("kaihu");//����
						}
						if(rs.getString("State").equals("ע��")){
							xiaoHu++;
//							System.out.println("xiaohu");//����
						}
						money1 += rs.getFloat("money");
//						System.out.println(xiaoHu+kaiHu+money1);//����
					}
//					System.out.println(xiaoHu);//����
//					System.out.println(kaiHu);//����
//					System.out.println(money1);//����
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String s = "����Ϊ��"+beginTime+"��"+endTime+"\n"+"��������Ϊ��"+kaiHu+"\n"+"��������Ϊ��"+xiaoHu+"\n"+"����Ϊ��"+money1;
				JOptionPane.showMessageDialog(null, s);
				xiaoHu = 0;//���������������㣬������һ�εĲ�ѯ����
				kaiHu = 0;
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 21));
		btnNewButton.setBounds(89, 209, 82, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("����");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin a = new admin();
				a.setVisible(true);
//				baoBiao b = new baoBiao();
//				b.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 21));
		btnNewButton_1.setBounds(294, 209, 82, 29);
		contentPane.add(btnNewButton_1);
	}
}
