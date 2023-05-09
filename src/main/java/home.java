package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class home extends JFrame {
	private String user;
	private JLabel title = new JLabel("Hi!");
	private JButton back = new JButton("Back");
	public home(String name) {
		this.init(name);
		this.addListener();
		user = name;
	}
	private void init(String name) {
		this.setTitle("Home");
		this.setSize(428,615);
		title.setText("Hi, "+name);
		
		back.setBounds(290, 520, 90, 30);
		
		
		add(back);
		
		
		ImageIcon image1 = new ImageIcon("./src/frame/back2.jpg");
		JLabel backLabel = new JLabel(image1);
		JPanel jpImageJPanel = (JPanel) this.getContentPane();
		backLabel.setBounds(0, 0, this.getWidth(),this.getHeight());
		backLabel.setSize(image1.getIconWidth(),image1.getIconHeight());
		this.getLayeredPane().add(backLabel, new Integer(Integer.MIN_VALUE+1));
		jpImageJPanel.setOpaque(false);
		jpImageJPanel.setLayout(null);
		((JPanel) this.getContentPane()).setOpaque(false);
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	private void addListener() {
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new whatsNew(user).setVisible(true);
				dispose();
			}

		});
		
	}

}
