package Kofi_Co;

import javax.swing.*;
import java.awt.*;
import Kofi_Co_Fundamentals.ImportedFonts;
import Kofi_Co_Fundamentals.DiscountManager;

public class End {
	
	CardLayout cardLayout = new CardLayout();
	JPanel cardPanel = new JPanel(cardLayout);
	JPanel endpanel = new JPanel();
	JLabel logo = new JLabel();
	JLabel thankyou = new JLabel();
	JLabel line = new JLabel();
	JLabel thankyou2 = new JLabel();
	JButton endbutton = new JButton();
	ImportedFonts impfonts = new ImportedFonts();

	public void EndComps() {
		impfonts.Fonts();
		
		endpanel.setBounds(0, 60, 700, 775);
		endpanel.setBackground(Color.WHITE);
		endpanel.setLayout(null);

		logo.setText("K. Co");
		logo.setForeground(new Color(0x5e3219));
		logo.setFont(new Font("Gugi", Font.BOLD, 140));
		logo.setBounds(153, 103, 400, 170);
		endpanel.add(logo);

		thankyou.setText("Thank You!");
		thankyou.setForeground(Color.BLACK);
		thankyou.setFont(new Font("Poppins Regular", Font.PLAIN, 40));
		thankyou.setBounds(227, 320, 400, 100);
		endpanel.add(thankyou);

		line.setText("♦──────────────────♦");
		line.setForeground(Color.BLACK);
		line.setFont(new Font("Arial", Font.PLAIN, 40));
		line.setBounds(70, 353, 600, 100);
		endpanel.add(line);

		thankyou2.setText("Please Come Back Again!");
		thankyou2.setForeground(Color.BLACK);
		thankyou2.setFont(new Font("Poppins Regular", Font.PLAIN, 25));
		thankyou2.setBounds(182, 390, 350, 80);
		endpanel.add(thankyou2);
		
		endbutton.setOpaque(false);
		endbutton.setContentAreaFilled(false);
		endbutton.setBorderPainted(false);
		endbutton.setBounds(0, 0, 700, 775);
		endbutton.setForeground(new Color(0x000000));
		endpanel.add(endbutton);

		cardPanel.add(endpanel);
		
		endbutton.addActionListener(e -> {
			OrderManager.getInstance().clearOrder();
			DiscountManager.getInstance().setDiscountApplied(false);
			cardLayout.show(cardPanel, "Welcome");
		});
	}
	
	public JPanel getEndPanel() {
		return endpanel;
	}
	
	public JButton getEndButton() {
		return endbutton;
	}

	public void setCardLayout(CardLayout layout, JPanel panel) {
		this.cardLayout = layout;
		this.cardPanel = panel;
	}
}