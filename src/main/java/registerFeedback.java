package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class registerFeedback extends JFrame{
	private JLabel  jlbtitle = new JLabel();
	private JLabel  jlbtitle2 = new JLabel();
	private JButton ok= new JButton("OK!");
	public registerFeedback(String s1, String s2) {
		this.init(s1, s2);
		this.addListener();
	}
	private void init(String s1, String s2) {
		JPanel jp = new JPanel();
		jp.setLayout(null);
		jlbtitle.setText(s1);
		jlbtitle2.setText(s2);
		this.setSize(320, 130);
		add(jlbtitle);
		add(jlbtitle2);
		jp.add(ok);
		add(jp);
		jlbtitle.setBounds(5, 5, 180, 30);
		jlbtitle2.setBounds(5, 20, 310, 30);
		ok.setSize(50, 30);
		ok.setLocation(120, 65);
		if(s1.equals("Registration is successful!")) {
			ok.setText("OK. Let's back!");
			ok.setSize(150, 30);
			ok.setLocation(60, 65);
		}
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	private void addListener() {
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

}
