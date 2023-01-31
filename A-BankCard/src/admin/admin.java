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
		this.setLocationRelativeTo(null);//窗体居中显示
		this.setTitle("银行系统-管理员端");
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
		
		JLabel addLabel = new JLabel("");
		addLabel.setBounds(101, 28, 32, 44);
		contentPane.add(addLabel);
		addLabel.setIcon(new ImageIcon("D:\\STUDY\\大二上\\数据库\\课程设计\\add.png"));
		
		JButton addLabelB = new JButton("开户");
		addLabelB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addUser au = new addUser();
				au.setVisible(true);
				dispose();
			}
		});
		addLabelB.setFont(new Font("宋体", Font.PLAIN, 21));
		addLabelB.setBounds(77, 75, 82, 29);
		contentPane.add(addLabelB);
		
		JLabel look = new JLabel("");
		look.setBounds(274, 28, 43, 50);
		contentPane.add(look);
		look.setIcon(new ImageIcon("D:\\STUDY\\大二上\\数据库\\课程设计\\search.png"));
		
		JButton lookB = new JButton("查询");
		lookB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findUser f = new findUser();
				f.setVisible(true);
				dispose();
			}
		});
		lookB.setFont(new Font("宋体", Font.PLAIN, 21));
		lookB.setBounds(249, 76, 82, 29);
		contentPane.add(lookB);
		
		JLabel delete = new JLabel("");
		delete.setBounds(101, 148, 32, 41);
		contentPane.add(delete);
		delete.setIcon(new ImageIcon("D:\\STUDY\\大二上\\数据库\\课程设计\\clear.png"));
		
		JButton deleteB = new JButton("注销");
		deleteB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteUser du = new deleteUser();
				du.setVisible(true);
				dispose();
			}
		});
		deleteB.setFont(new Font("宋体", Font.PLAIN, 21));
		deleteB.setBounds(77, 196, 82, 29);
		contentPane.add(deleteB);
		
		JLabel sta = new JLabel("");
		sta.setBounds(274, 148, 32, 44);
		contentPane.add(sta);
		sta.setIcon(new ImageIcon("D:\\STUDY\\大二上\\数据库\\课程设计\\sta.png"));
		
		JButton staB= new JButton("统计");
		staB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bankInfo b = new bankInfo();
//				baoBiao b = new baoBiao();
				b.setVisible(true);
				dispose();
			}
		});
		staB.setFont(new Font("宋体", Font.PLAIN, 21));
		staB.setBounds(249, 196, 82, 29);
		contentPane.add(staB);

		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login l = new login();
				l.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton_1.setBounds(51, 261, 88, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("退出");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton.setBounds(274, 261, 88, 29);
		contentPane.add(btnNewButton);
	}
}
