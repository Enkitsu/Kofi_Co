package Kofi_Co;

import javax.swing.*;
import java.awt.*;
import Kofi_Co_Fundamentals.ImportedFonts;
import Kofi_Co_Fundamentals.RoundedButton;
import Kofi_Co_Fundamentals.BackButton;

public class Payment_Options {

	ImportedFonts IMPfonts = new ImportedFonts();
	private CardLayout cardLayout;
	private JPanel cardPanel;
	private JPanel mainPanel;
	JButton cashButton = button();
	JButton cashlessButton = button();
	
	private JButton button() {
		JButton btn2 = new RoundedButton();
		btn2.setFont(new Font("Poppins Regular", Font.PLAIN, 30));
		btn2.setBackground(new Color(0x5e3219));
		btn2.setForeground(Color.WHITE);
		btn2.setFocusPainted(false);
		btn2.setBorderPainted(false);
		return btn2;
	}

	public void paymentcomps() {
		IMPfonts.Fonts();
		
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBackground(Color.WHITE);
		
		JPanel headerPanel = new JPanel(null);
		headerPanel.setBackground(Color.WHITE);
		headerPanel.setPreferredSize(new Dimension(700, 70));
		
		BackButton backButton = new BackButton();
		headerPanel.add(backButton);
		
		JPanel contentPanel = new JPanel(null);
		contentPanel.setBackground(Color.WHITE);

		JLabel title = new JLabel("K. Co");
		title.setFont(new Font("Gugi", Font.BOLD, 140));
		title.setForeground(new Color(0x5e3219));
		title.setBounds(153, 33, 400, 170);
		contentPanel.add(title);

		JLabel subtitle = new JLabel("Payment Options");
		subtitle.setFont(new Font("Poppins Regular", Font.PLAIN, 40));
		subtitle.setHorizontalAlignment(SwingConstants.CENTER);
		subtitle.setForeground(Color.BLACK);
		subtitle.setBounds(125, 220, 431, 49);
		contentPanel.add(subtitle);

		cashButton.setText("Cash");
		cashButton.setBounds(145, 300, 180, 170);
		contentPanel.add(cashButton);

		cashlessButton.setText("Cashless");
		cashlessButton.setBounds(350, 300, 180, 170);
		contentPanel.add(cashlessButton);

		mainPanel.add(headerPanel, BorderLayout.NORTH);
		mainPanel.add(contentPanel, BorderLayout.CENTER);

		cashlessButton.addActionListener(e -> cardLayout.show(cardPanel, "Credit"));
		cashButton.addActionListener(e -> cardLayout.show(cardPanel, "Receipt"));
	}

	public JPanel getPaymentPanel() {
		return mainPanel;
	}

	public void setCardLayout(CardLayout layout, JPanel panel) {
		this.cardLayout = layout;
		this.cardPanel = panel;
		for (Component comp : mainPanel.getComponents()) {
			if (comp instanceof JPanel) {
				for (Component innerComp : ((JPanel) comp).getComponents()) {
					if (innerComp instanceof BackButton) {
						((BackButton) innerComp).setNavigation(layout, panel, "Total");
					}
				}
			}
		}
	}
}