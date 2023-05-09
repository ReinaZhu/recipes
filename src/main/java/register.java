package frame;
import java.awt.Color;
import java.awt.Dimension;
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


public class register extends JFrame {
	private JPanel contentPanel = new JPanel();
	private JLabel label;
	private JButton ok = new JButton("Register"), back = new JButton("Back to login");

	private JLabel jlb1 = new JLabel("Username:"), jlb2 = new JLabel("Password:"), jlb3 = new JLabel("Confirm \n Password:"),
			jlbtitle = new JLabel("REGISTER");
	private JTextField admin = new JTextField(), password1 = new JTextField(), password2 = new JTextField();
	private JLabel tipsues = new JLabel("Username must contain 3-20 characters.");
	private JLabel tipspa = new JLabel("Password must contain 5-20 characters.");
	
	public register() {
		this.init();
		this.addListener();
	}
	private void init() {
		this.setTitle("Register");
		this.setSize(600, 303);
		ImageIcon image1 = new ImageIcon("./src/frame/login5.jpg");
		JLabel backLabel = new JLabel(image1);
		JPanel jpImageJPanel = (JPanel) this.getContentPane();
		backLabel.setBounds(0, 0, this.getWidth(),this.getHeight());
		backLabel.setSize(image1.getIconWidth(),image1.getIconHeight());
		this.getLayeredPane().add(backLabel, new Integer(Integer.MIN_VALUE+1));
		jpImageJPanel.setOpaque(false);
		jpImageJPanel.setLayout(null);
		((JPanel) this.getContentPane()).setOpaque(false);
		contentPanel.setLayout(null);
		add(admin);
		add(password1);
		add(password2);
		add(ok);
		add(back);
		add(jlb1);
		add(jlb2);
		add(jlb3);
		add(jlbtitle);
		add(tipsues);
		add(tipspa);

		jlb1.setBounds(50, 100, 90, 25);
		jlb1.setForeground(Color.BLACK);
		Font f2 = new Font("BritannicT", Font.BOLD, 15);
		jlb1.setFont(f2);
		admin.setBounds(220, 100, 300, 25);

		password1.setBounds(220, 134, 300, 25);
		jlb2.setBounds(50, 134, 90, 25);
		jlb2.setFont(f2);
		jlb2.setForeground(Color.BLACK);

		password2.setBounds(220, 168, 300, 25);
		jlb3.setBounds(50, 168, 200, 25);
		jlb3.setFont(f2);
		jlb3.setForeground(Color.BLACK);

		ok.setBounds(315, 225, 90, 20);
		back.setBounds(95, 225, 90, 20);
		
		tipspa.setBounds(400, 100, 150, 25);
		tipsues.setBounds(400, 134, 150, 25);

		jlbtitle.setBounds(220, 50, 200, 50);
		Font f = new Font("BritannicT", Font.BOLD, 30);
		jlbtitle.setFont(f);
		jlbtitle.setForeground(Color.BLACK);
		admin.setOpaque(true);
		password1.setOpaque(true);
		password2.setOpaque(true);
		contentPanel.setOpaque(false);
		getContentPane().add(contentPanel);
		textSet(admin);
		textSet(password1);
		textSet(password2);
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
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(admin.getText().length()<3) {
					new registerFeedback("Registration failed!","Username must contain 3-20 characters.").setVisible(true);
				}
				//用户名重复
				else if(admin.getText().length()==0) {
					new registerFeedback("Registration failed!","Username already exists.").setVisible(true);
				}
				else if(password1.getText().length()<5||password1.getText().length()>20) {
					new registerFeedback("Registration failed!","Password must contain 5-20 characters.").setVisible(true);
				}
				else if(password1.getText().equals(password2.getText())) {
					new registerFeedback("Registration is successful!","Please return to login.").setVisible(true);
				}
				else {
					new registerFeedback("Registration failed!","Confirm password is different from password.").setVisible(true);
				}
				setRegister(admin.getText(), password1.getText(), password2.getText());
			}
		});
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new login().setVisible(true);
				dispose();
			}
		});
	}
	public void setRegister(String admin, String pwd1, String pwd2) {
		
	}
}

