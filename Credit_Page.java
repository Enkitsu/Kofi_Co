package Kofi_Co;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

import Kofi_Co_Fundamentals.RoundedButton;
import Kofi_Co_Fundamentals.RoundedJtextfield;
import Kofi_Co_Fundamentals.ImportedFonts;
import Kofi_Co_Fundamentals.BackButton;

public class Credit_Page {

	private CardLayout cardLayout;
	private JPanel cardPanel;
	private JPanel mainPanel;

	public JTextField creditField = new RoundedJtextfield(20);
	public JTextField activeField = creditField;
	public int activeFieldType = 0;
	
	ImportedFonts IMPFonts = new ImportedFonts();

	public void creditpagecomps() {
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
		
		JLabel title = new JLabel("K. Co");
		title.setForeground(new Color(0x5e3219));
		title.setFont(new Font("Gugi", Font.BOLD, 140));
		title.setBounds(153, 33, 372, 170);
		contentPanel.add(title);

		JLabel cardLabel = new JLabel("Register Card No.");
		cardLabel.setForeground(Color.black);
		cardLabel.setFont(new Font("Poppins Regular", Font.PLAIN, 30));
		cardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cardLabel.setBounds(190, 220, 300, 60);
		contentPanel.add(cardLabel);

		creditField.setFont(new Font("Poppins Regular", Font.PLAIN, 30));
		creditField.setBounds(140, 280, 400, 50);
		creditField.setHorizontalAlignment(JTextField.CENTER);
		creditField.setEditable(false);
		creditField.setFocusable(false);
		creditField.setBackground(new Color(0xE7E5E5));
		creditField.setBorder(
			BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		contentPanel.add(creditField);

		JPanel padPanel = new JPanel(new GridLayout(4, 3, 10, 10));
		padPanel.setBounds(161, 350, 350, 200);
		padPanel.setBackground(Color.WHITE);
		contentPanel.add(padPanel);

		String[] buttons = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "C", "0", "X" };

		for (String label : buttons) {
			JButton btn = new JButton(label);
			btn.setFont(new Font("Poppins Regular", Font.PLAIN, 28));
			btn.setOpaque(false);
			btn.setContentAreaFilled(false);
			btn.setBorderPainted(false);
			btn.setFocusable(false);
			btn.addActionListener(e -> handleInput(label));
			padPanel.add(btn);
		}

		JButton confirmButton = new RoundedButton();
		confirmButton.setFocusable(false);
		confirmButton.setBorderPainted(false);
		confirmButton.setText("Confirm");
		confirmButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		confirmButton.setBounds(237, 570, 200, 50);
		confirmButton.setBackground(new Color(0x5e3219));
		confirmButton.setForeground(Color.WHITE);
		contentPanel.add(confirmButton);
		
		confirmButton.addActionListener(e -> cardLayout.show(cardPanel, "Receipt"));

		mainPanel.add(headerPanel, BorderLayout.NORTH);
		mainPanel.add(contentPanel, BorderLayout.CENTER);
	}

	public void handleInput(String input) {
		String current = activeField.getText().replaceAll(" ", "").replaceAll("/", "");

		switch (input) {
		case "C":
			activeField.setText("");
			break;
		case "X":
			if (!current.isEmpty()) {
				current = current.substring(0, current.length() - 1);
				activeField.setText(formatWithSpaces(current));
			}
			break;
		default:
			int maxLength = (activeFieldType == 0) ? 16 : (activeFieldType == 1) ? 4 : 3;
			if (current.length() < maxLength) {
				current += input;
				activeField.setText(formatWithSpaces(current));
			}
			break;
		}
	}

	private String formatWithSpaces(String digitsOnly) {
		StringBuilder formatted = new StringBuilder();

		if (activeFieldType == 0) {
			for (int i = 0; i < digitsOnly.length(); i++) {
				if (i > 0 && i % 4 == 0)
					formatted.append(" ");
				formatted.append(digitsOnly.charAt(i));
			}
		} else if (activeFieldType == 1) {
			for (int i = 0; i < digitsOnly.length(); i++) {
				if (i == 2)
					formatted.append("/");
				formatted.append(digitsOnly.charAt(i));
			}
		} else {
			formatted.append(digitsOnly);
		}

		return formatted.toString();
	}

	public JPanel getCreditPageMainPanel() {
		return mainPanel;
	}

	public void setCardLayout(CardLayout layout, JPanel panel) {
		this.cardLayout = layout;
		this.cardPanel = panel;
		for (Component comp : mainPanel.getComponents()) {
			if (comp instanceof JPanel) {
				for (Component innerComp : ((JPanel) comp).getComponents()) {
					if (innerComp instanceof BackButton) {
						((BackButton) innerComp).setNavigation(layout, panel, "Credit");
					}
				}
			}
		}
	}
}