package Kofi_Co;

import java.awt.*;
import javax.swing.*;

import Kofi_Co_Fundamentals.ImportedFonts;
import Kofi_Co_Fundamentals.RoundedButton;
import Kofi_Co_Fundamentals.BackButton;

public class Credit {
	
	private CardLayout cardLayout;
	private JPanel cardPanel;
	private JPanel mainPanel;
	JLabel K_Co = new JLabel();
	JLabel Select_Credit_Option = new JLabel();
	JButton QRPHButton = new RoundedButton();
	JButton CARDBtn = new RoundedButton();
	ImportedFonts IMPFonts = new ImportedFonts();

	public void CreditComps() {
		IMPFonts.Fonts();
		
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBackground(Color.WHITE);
		
		JPanel headerPanel = new JPanel(null);
		headerPanel.setBackground(Color.WHITE);
		headerPanel.setPreferredSize(new Dimension(700, 70));
		
		BackButton backButton = new BackButton();
		headerPanel.add(backButton);
		
		JPanel contentPanel = new JPanel(null);
		contentPanel.setBackground(Color.WHITE);

		K_Co.setText("K. Co");
		K_Co.setForeground(new Color(0x5e3219));
		K_Co.setFont(new Font("Gugi", Font.BOLD, 140));
		K_Co.setBounds(153, 33, 400, 170);
		contentPanel.add(K_Co);

		Select_Credit_Option.setText("Select Credit Options");
		Select_Credit_Option.setForeground(Color.BLACK);
		Select_Credit_Option.setFont(new Font("Poppins Regular", Font.PLAIN, 40));
		Select_Credit_Option.setHorizontalAlignment(SwingConstants.CENTER);
		Select_Credit_Option.setBounds(123, 220, 431, 49);
		contentPanel.add(Select_Credit_Option);

		QRPHButton.setText("<html><center>QR<br>PH</center></html>");
		QRPHButton.setFont(new Font("Poppins Regular", Font.PLAIN, 30));
		QRPHButton.setBackground(new Color(0x5e3219));
		QRPHButton.setForeground(Color.WHITE);
		QRPHButton.setFocusPainted(false);
		QRPHButton.setBorderPainted(false);
		QRPHButton.setBounds(125, 300, 200, 200);
		contentPanel.add(QRPHButton);

		CARDBtn.setText("<html><center>CREDIT<br>DEBIT<br>CARD</center></html>");
		CARDBtn.setFont(new Font("Poppins Regular", Font.PLAIN, 30));
		CARDBtn.setBackground(new Color(0x5e3219));
		CARDBtn.setForeground(Color.WHITE);
		CARDBtn.setFocusPainted(false);
		CARDBtn.setBorderPainted(false);
		CARDBtn.setBounds(350, 300, 200, 200);
		contentPanel.add(CARDBtn);
		
		mainPanel.add(headerPanel, BorderLayout.NORTH);
		mainPanel.add(contentPanel, BorderLayout.CENTER);
		
		CARDBtn.addActionListener(e -> cardLayout.show(cardPanel, "Credit Page"));
		QRPHButton.addActionListener(e -> cardLayout.show(cardPanel, "QRPH Page"));
	}
	
	public JPanel getCreditPanel() {
		return mainPanel;
	}
	
	public void setCardLayout(CardLayout layout, JPanel panel) {
		this.cardLayout = layout;
		this.cardPanel = panel;
		for (Component comp : mainPanel.getComponents()) {
			if (comp instanceof JPanel) {
				for (Component innerComp : ((JPanel) comp).getComponents()) {
					if (innerComp instanceof BackButton) {
						((BackButton) innerComp).setNavigation(layout, panel, "Payment Options");
					}
				}
			}
		}
	}
}