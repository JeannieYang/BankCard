package admin;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;

import login.login;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class admin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin frame = new admin();
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
	public admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 434, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);//���������ʾ
		this.setTitle("����ϵͳ-����Ա��");
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
		
		JLabel addLabel = new JLabel("");
		addLabel.setBounds(101, 28, 32, 44);
		contentPane.add(addLabel);
		addLabel.setIcon(new ImageIcon("D:\\STUDY\\�����\\���ݿ�\\�γ����\\add.png"));
		
		JButton addLabelB = new JButton("����");
		addLabelB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addUser au = new addUser();
				au.setVisible(true);
				dispose();
			}
		});
		addLabelB.setFont(new Font("����", Font.PLAIN, 21));
		addLabelB.setBounds(77, 75, 82, 29);
		contentPane.add(addLabelB);
		
		JLabel look = new JLabel("");
		look.setBounds(274, 28, 43, 50);
		contentPane.add(look);
		look.setIcon(new ImageIcon("D:\\STUDY\\�����\\���ݿ�\\�γ����\\search.png"));
		
		JButton lookB = new JButton("��ѯ");
		lookB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findUser f = new findUser();
				f.setVisible(true);
				dispose();
			}
		});
		lookB.setFont(new Font("����", Font.PLAIN, 21));
		lookB.setBounds(249, 76, 82, 29);
		contentPane.add(lookB);
		
		JLabel delete = new JLabel("");
		delete.setBounds(101, 148, 32, 41);
		contentPane.add(delete);
		delete.setIcon(new ImageIcon("D:\\STUDY\\�����\\���ݿ�\\�γ����\\clear.png"));
		
		JButton deleteB = new JButton("ע��");
		deleteB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteUser du = new deleteUser();
				du.setVisible(true);
				dispose();
			}
		});
		deleteB.setFont(new Font("����", Font.PLAIN, 21));
		deleteB.setBounds(77, 196, 82, 29);
		contentPane.add(deleteB);
		
		JLabel sta = new JLabel("");
		sta.setBounds(274, 148, 32, 44);
		contentPane.add(sta);
		sta.setIcon(new ImageIcon("D:\\STUDY\\�����\\���ݿ�\\�γ����\\sta.png"));
		
		JButton staB= new JButton("ͳ��");
		staB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bankInfo b = new bankInfo();
//				baoBiao b = new baoBiao();
				b.setVisible(true);
				dispose();
			}
		});
		staB.setFont(new Font("����", Font.PLAIN, 21));
		staB.setBounds(249, 196, 82, 29);
		contentPane.add(staB);

		JButton btnNewButton_1 = new JButton("����");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login l = new login();
				l.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 21));
		btnNewButton_1.setBounds(51, 261, 88, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("�˳�");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 21));
		btnNewButton.setBounds(274, 261, 88, 29);
		contentPane.add(btnNewButton);
	}
}
