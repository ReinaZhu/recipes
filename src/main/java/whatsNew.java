package frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class whatsNew extends JFrame {
	private JLabel title = new JLabel("Welcome back!"),recommendation = new JLabel("Recommendation: ");
	private JButton home = new JButton("Home"),search = new JButton("Search"),up = new JButton("Upload Recipe"), details = new JButton("Details");
	private String user;
	private JButton back = new JButton("Log out");
	public whatsNew(String name) {
		this.init(name);
		this.addListener();
		user = name;
	}
	private void init(String name) {
		this.setTitle("What's new");
		this.setSize(428,615);
		JLabel namelb = new JLabel(name);
		namelb.setText(name+",");
		//title.setText(name+", welcome back!");
		Font f = new Font("Apple Chancery", Font.BOLD, 40);
		namelb.setFont(new Font("Apple Chancery", Font.BOLD, 30));
		title.setFont(f);
		namelb.setBounds(80, 80, 400, 70);
		title.setBounds(80, 140, 400, 70);
		search.setBounds(80, 210, 120, 40);
		home.setBounds(250, 210, 120, 40);
		up.setBounds(80, 265, 120, 40);
		recommendation.setBounds(50,300,200,50);
		back.setBounds(290, 520, 90, 30);
		
		
		
		Font f2 = new Font("BritannicT", Font.BOLD, 15);
		recommendation.setFont(f2);
		
		ImageIcon image1 = new ImageIcon("./src/frame/back2.jpg");
		JLabel backLabel = new JLabel(image1);
		JPanel jpImageJPanel = (JPanel) this.getContentPane();
		backLabel.setBounds(0, 0, this.getWidth(),this.getHeight());
		backLabel.setSize(image1.getIconWidth(),image1.getIconHeight());
		this.getLayeredPane().add(backLabel, new Integer(Integer.MIN_VALUE+1));
		jpImageJPanel.setOpaque(false);
		jpImageJPanel.setLayout(null);
		((JPanel) this.getContentPane()).setOpaque(false);
		
		add(namelb);
		add(title);
		add(home);
		add(search);
		add(up);
		add(recommendation);
		add(back);
		
		
		
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	private void addListener() {
		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new search(user).setVisible(true);
				dispose();
			}

		});
		home.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new home(user).setVisible(true);
				dispose();
			}

		});
		up.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new up(user).setVisible(true);
				dispose();
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

}
