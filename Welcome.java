package Kofi_Co;

import javax.swing.*;
import java.awt.*;
import Kofi_Co_Fundamentals.ImportedFonts;

public class Welcome {
	
	JPanel Contains = new JPanel();
	JLabel Logo = new JLabel();
	JLabel Welcome = new JLabel();
	JLabel Line = new JLabel();
	JLabel Welcome2 = new JLabel();
	JLabel Welcome3 = new JLabel();
	JButton Home = new JButton();
	ImportedFonts ImpFonts = new ImportedFonts();

	public void HomeComp() {
		ImpFonts.Fonts();

		Contains.setBackground(Color.WHITE);
		Contains.setLayout(null);

		Logo.setText("K. Co");
		Logo.setForeground(new Color(0x5e3219));
		Logo.setFont(new Font("Gugi", Font.BOLD, 140));
		Logo.setBounds(153, 103, 400, 170);
		Contains.add(Logo);

		Welcome.setText("Welcome!");
		Welcome.setForeground(Color.BLACK);
		Welcome.setFont(new Font("Baloo", Font.BOLD, 70));
		Welcome.setBounds(175, 320, 400, 100);
		Contains.add(Welcome);

		Line.setText("♦──────────────────♦");
		Line.setForeground(Color.BLACK);
		Line.setFont(new Font("Arial", Font.PLAIN, 40));
		Line.setBounds(70, 353, 600, 100);
		Contains.add(Line);

		Welcome2.setText("What would you");
		Welcome2.setForeground(Color.BLACK);
		Welcome2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 35));
		Welcome2.setBounds(208, 395, 350, 80);
		Contains.add(Welcome2);

		Welcome3.setText("like today?");
		Welcome3.setForeground(Color.BLACK);
		Welcome3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 35));
		Welcome3.setBounds(253, 430, 250, 80);
		Contains.add(Welcome3);

		Home.setOpaque(false);
		Home.setContentAreaFilled(false);
		Home.setBorderPainted(false);
		Home.setBounds(0, 0, 700, 775);
		Home.setForeground(new Color(0x000000));
		Contains.add(Home);
	}
	
	public JPanel getWelcomePanel() {
	    return Contains;
	}

	public JButton getHomeButton() {
	    return Home;
	}
}