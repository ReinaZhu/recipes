package frame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class login extends JFrame{
	private JPanel contentPanel = new JPanel();
	private JLabel label;
	private JButton login = new JButton("Login"), register = new JButton("Register"),guest = new JButton("Guest");
	private JLabel jlb1 = new JLabel("Username:"), jlb2 = new JLabel("Password :"), jlbtitle = new JLabel("Bon Appetit");
	private JTextField admin = new JTextField(), password = new JTextField();
	
	public login() {
		this.init();
		this.addListener();
	}
	
	private void init() {
		this.setTitle("Login");
		this.setSize(600,303);
		ImageIcon image1 = new ImageIcon("./src/frame/login6.jpg");
		JLabel backLabel = new JLabel(image1);
		JPanel jpImageJPanel = (JPanel) this.getContentPane();
		backLabel.setBounds(0, 0, this.getWidth(),this.getHeight());
		backLabel.setSize(image1.getIconWidth(),image1.getIconHeight());
		this.getLayeredPane().add(backLabel, new Integer(Integer.MIN_VALUE+1));
		jpImageJPanel.setOpaque(false);
		jpImageJPanel.setLayout(null);
		((JPanel) this.getContentPane()).setOpaque(false);
		add(admin);
		add(password);
		add(login);
		add(guest);
		add(register);
		add(jlb1);
		add(jlb2);
		add(jlbtitle);

		
		jlb1.setBounds(50, 130, 90, 25);
		jlb1.setForeground(Color.BLACK);
		Font f2 = new Font("BritannicT", Font.BOLD, 15);
		jlb1.setFont(f2);
		admin.setBounds(150, 130, 300, 25);
		password.setBounds(150, 154, 300, 25);
		jlb2.setBounds(50, 154, 90, 25);
		jlb2.setForeground(Color.BLACK);
		jlb2.setFont(f2);
		register.setBounds(125, 225, 90, 20);
		login.setBounds(350, 225, 90, 20);
		guest.setBounds(500, 150, 90, 20);
		jlbtitle.setBounds(210, 65, 230, 50);
		Font f = new Font("Brush Script MT", Font.BOLD, 40);
		jlbtitle.setFont(f);
		jlbtitle.setForeground(Color.BLACK);

		admin.setOpaque(true);
		password.setOpaque(true);
		contentPanel.setOpaque(false);
		getContentPane().add(contentPanel);

		textSet(admin);
		textSet(password);
		ImageIcon icon=new ImageIcon("./src/frame/logo.png");
		this.setIconImage(icon.getImage());

		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	private void textSet(JTextField field) {
		field.setBackground(new Color(255, 255, 255));
		field.setPreferredSize(new Dimension(150, 28));
		MatteBorder border = new MatteBorder(0, 0, 2, 0, new Color(192, 192, 192));
		field.setBorder(border);
	}
	private void addListener() {
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				forLogin(admin.getText(), password.getText());
			}

		});
		register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				forRegister();
			}

		});
		guest.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				forGuest();
			}

		});
	}
	public void forLogin(String admin, String pwd) {
		//改，如果名字不对
		if(admin.length()==0) {
			new registerFeedback("Login failed!","Username does not exist.").setVisible(true);
		}
		//改，如果密码不对
		else if(pwd.length()==0) {
			new registerFeedback("Login failed!","Wrong password.").setVisible(true);
		}
		else {
			//这里后期改成user类
			new whatsNew(admin).setVisible(true);
			dispose();
		}
	}
	public void forRegister() {
		new register().setVisible(true);
		dispose();
	}
	public void forGuest() {
	}
	
	public static void main(String[] args) {
        new login();
        }

}
