package user;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import login.login;

public class user extends JFrame {

	private JPanel contentPane;
	static String str;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user frame = new user(str);
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
	public user(String str) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);//���������ʾ
		this.setTitle("����ϵͳ-�û���");
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
		
		JLabel look = new JLabel("");
		look.setBounds(101, 32, 32, 40);
		contentPane.add(look);
		look.setIcon(new ImageIcon("D:\\STUDY\\�����\\���ݿ�\\�γ����\\search.png"));
		
		JButton lookB = new JButton("��ѯ");
		lookB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findUser2 fu = new findUser2(str);
				fu.setVisible(true);
				dispose();
			}
		});
		lookB.setFont(new Font("����", Font.PLAIN, 21));
		lookB.setBounds(77, 75, 82, 29);
		contentPane.add(lookB);
		
		JLabel transfer = new JLabel("");
		transfer.setBounds(274, 32, 32, 40);
		contentPane.add(transfer);
		transfer.setIcon(new ImageIcon("D:\\STUDY\\�����\\���ݿ�\\�γ����\\transfer.png"));
		
		JButton transferB = new JButton("ת��");
		transferB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remittance r = new remittance(str);
				r.setVisible(true);
				dispose();
			}
		});
		transferB.setFont(new Font("����", Font.PLAIN, 21));
		transferB.setBounds(250, 76, 81, 29);
		contentPane.add(transferB);
		
		JLabel deposit = new JLabel("");
		deposit.setBounds(101, 140, 32, 49);
		contentPane.add(deposit);
		deposit.setIcon(new ImageIcon("D:\\STUDY\\�����\\���ݿ�\\�γ����\\add.png"));
		
		JButton depositB = new JButton("���");
		depositB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.println(str);//����
				inputMoney im = new inputMoney(str);
				im.setVisible(true);
				dispose();
			}
		});
		depositB.setFont(new Font("����", Font.PLAIN, 21));
		depositB.setBounds(77, 196, 82, 29);
		contentPane.add(depositB);
		
		JLabel withdraw = new JLabel("");
		withdraw.setBounds(274, 140, 32, 52);
		contentPane.add(withdraw);
		withdraw.setIcon(new ImageIcon("D:\\STUDY\\�����\\���ݿ�\\�γ����\\withdraw.png"));
		
		JButton withdrawB= new JButton("ȡ��");
		withdrawB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outputMoney om = new outputMoney(str);
				om.setVisible(true);
				dispose();
			}
		});
		withdrawB.setFont(new Font("����", Font.PLAIN, 21));
		withdrawB.setBounds(249, 196, 82, 29);
		contentPane.add(withdrawB);
		
		JButton btnNewButton_1 = new JButton("����");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login l = new login();
				l.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 21));
		btnNewButton_1.setBounds(50, 263, 88, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("�˳�");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 21));
		btnNewButton.setBounds(284, 262, 88, 29);
		contentPane.add(btnNewButton);
	}
}
