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
		this.setLocationRelativeTo(null);//窗体居中显示
		this.setTitle("银行系统-用户端");
		ImageIcon img = new ImageIcon("D:\\STUDY\\大二上\\数据库\\课程设计\\admin2.png");
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
		
		JLabel look = new JLabel("");
		look.setBounds(101, 32, 32, 40);
		contentPane.add(look);
		look.setIcon(new ImageIcon("D:\\STUDY\\大二上\\数据库\\课程设计\\search.png"));
		
		JButton lookB = new JButton("查询");
		lookB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findUser2 fu = new findUser2(str);
				fu.setVisible(true);
				dispose();
			}
		});
		lookB.setFont(new Font("宋体", Font.PLAIN, 21));
		lookB.setBounds(77, 75, 82, 29);
		contentPane.add(lookB);
		
		JLabel transfer = new JLabel("");
		transfer.setBounds(274, 32, 32, 40);
		contentPane.add(transfer);
		transfer.setIcon(new ImageIcon("D:\\STUDY\\大二上\\数据库\\课程设计\\transfer.png"));
		
		JButton transferB = new JButton("转账");
		transferB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remittance r = new remittance(str);
				r.setVisible(true);
				dispose();
			}
		});
		transferB.setFont(new Font("宋体", Font.PLAIN, 21));
		transferB.setBounds(250, 76, 81, 29);
		contentPane.add(transferB);
		
		JLabel deposit = new JLabel("");
		deposit.setBounds(101, 140, 32, 49);
		contentPane.add(deposit);
		deposit.setIcon(new ImageIcon("D:\\STUDY\\大二上\\数据库\\课程设计\\add.png"));
		
		JButton depositB = new JButton("存款");
		depositB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.println(str);//检验
				inputMoney im = new inputMoney(str);
				im.setVisible(true);
				dispose();
			}
		});
		depositB.setFont(new Font("宋体", Font.PLAIN, 21));
		depositB.setBounds(77, 196, 82, 29);
		contentPane.add(depositB);
		
		JLabel withdraw = new JLabel("");
		withdraw.setBounds(274, 140, 32, 52);
		contentPane.add(withdraw);
		withdraw.setIcon(new ImageIcon("D:\\STUDY\\大二上\\数据库\\课程设计\\withdraw.png"));
		
		JButton withdrawB= new JButton("取款");
		withdrawB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outputMoney om = new outputMoney(str);
				om.setVisible(true);
				dispose();
			}
		});
		withdrawB.setFont(new Font("宋体", Font.PLAIN, 21));
		withdrawB.setBounds(249, 196, 82, 29);
		contentPane.add(withdrawB);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login l = new login();
				l.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton_1.setBounds(50, 263, 88, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("退出");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 21));
		btnNewButton.setBounds(284, 262, 88, 29);
		contentPane.add(btnNewButton);
	}
}
