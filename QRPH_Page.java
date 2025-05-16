package Kofi_Co;

import java.awt.*;
import javax.swing.*;

import Kofi_Co_Fundamentals.ImportedFonts;
import Kofi_Co_Fundamentals.BackButton;

public class QRPH_Page {
	
	private CardLayout cardLayout;
	private JPanel cardPanel;
	private final JPanel mainPanel;
	private final BackButton backButton;
	private final ImageIcon qrphImage;
	
	public QRPH_Page() {
		new ImportedFonts();
		mainPanel = new JPanel(new BorderLayout());
		backButton = new BackButton();
		qrphImage = new ImageIcon("QRPH.png");
		initializeComponents();
	}
	
	public void initializeComponents() {
		mainPanel.setBackground(Color.WHITE);
		
		JPanel headerPanel = createHeaderPanel();
		mainPanel.add(headerPanel, BorderLayout.NORTH);
		
		JPanel contentPanel = new JPanel(null);
		contentPanel.setBackground(Color.WHITE);
		
		JLabel logoLabel = createLogoLabel();
		contentPanel.add(logoLabel);
		
		JLabel qrLabel = new JLabel(qrphImage);
		qrLabel.setBounds(140, 190, 400, 400);
		contentPanel.add(qrLabel);
		
		JButton qrButton = createTransparentButton();
		contentPanel.add(qrButton);
		
		mainPanel.add(contentPanel, BorderLayout.CENTER);
	}
	
	private JPanel createHeaderPanel() {
		JPanel headerPanel = new JPanel(null);
		headerPanel.setBackground(Color.WHITE);
		headerPanel.setPreferredSize(new Dimension(700, 70));
		backButton.setBounds(30, 40, 60, 30);
		headerPanel.add(backButton);
		return headerPanel;
	}
	
	private JLabel createLogoLabel() {
		JLabel logo = new JLabel("K. Co");
		logo.setForeground(new Color(0x5e3219));
		logo.setFont(new Font("Gugi", Font.BOLD, 140));
		logo.setBounds(153, 33, 400, 170);
		return logo;
	}
	
	private JButton createTransparentButton() {
		JButton button = new JButton();
		button.setBounds(0, 0, 700, 775);
		button.setBackground(Color.WHITE);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setFocusable(false);
		
		button.addActionListener(e -> {
			if (cardLayout != null && cardPanel != null) {
				cardLayout.show(cardPanel, "Receipt");
			}
		});
		return button;
	}
	
	public JPanel getQRPHPanel() {
		return mainPanel;
	}
	
	public void setCardLayout(CardLayout layout, JPanel panel) {
		this.cardLayout = layout;
		this.cardPanel = panel;
		backButton.setNavigation(layout, panel, "Credit");
	}
}