package Kofi_Co;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import Kofi_Co_Fundamentals.ImportedFonts;
import Kofi_Co_Fundamentals.RoundedButton;

public class Receipt {

	private static int receiptCounter = 1;
	private JButton receiptnumber;
	ImportedFonts IMPFonts = new ImportedFonts();

	CardLayout cardLayout = new CardLayout();

	JPanel cardPanel = new JPanel(cardLayout);
	JPanel Kofi1 = new JPanel();

	JLabel Kofi3 = new JLabel();
	JLabel Kofi4 = new JLabel();
	JLabel Kofi5 = new JLabel();

	JButton Kofi2 = new RoundedButton();

	public void Receipts() {
		Kofi1.setBackground(Color.WHITE);
		Kofi1.setLayout(null);

		JLabel title = new JLabel("K. Co");
		title.setFont(new Font("Gugi", Font.BOLD, 140));
		title.setForeground(new Color(0x5e3219));
		title.setBounds(153, 103, 400, 170);
		Kofi1.add(title);

		JLabel subtitle = new JLabel();
		subtitle.setText("Receipt No.");
		subtitle.setFont(new Font("Poppins Regular", Font.PLAIN, 40));
		subtitle.setBounds(225, 270, 400, 100);
		Kofi1.add(subtitle);

		receiptnumber = new RoundedButton();
        receiptnumber.setFocusPainted(false);
        receiptnumber.setBorderPainted(false);
        receiptnumber.setFocusable(false);
		updateReceiptNumber();
        receiptnumber.setFont(new Font("Poppins Regular", Font.PLAIN, 50));
        receiptnumber.setBounds(260, 350, 150, 150);
        receiptnumber.setBackground(new Color(0x5e3219));
        receiptnumber.setForeground(Color.WHITE);
        Kofi1.add(receiptnumber);

		Kofi2.setOpaque(false);
		Kofi2.setContentAreaFilled(false);
		Kofi2.setBorderPainted(false);
		Kofi2.setFocusable(false);
		Kofi2.setBounds(0, 0, 700, 775);
		Kofi2.setBackground(Color.WHITE);
		Kofi1.add(Kofi2);
		
		receiptnumber.addActionListener(e -> {
			cardLayout.show(cardPanel, "End");
			receiptCounter++;
			updateReceiptNumber();
		});

		Kofi2.addActionListener(e -> {
			cardLayout.show(cardPanel, "End");
			receiptCounter++;
			updateReceiptNumber();
		});
	}

	private void updateReceiptNumber() {
		String formattedNumber = String.format("%03d", receiptCounter);
		receiptnumber.setText(formattedNumber);
	}

	public JButton getKofi2ReceiptButton() {
		return Kofi2;
	}

	public JPanel getKofi1ReceiptPanel() {
		return Kofi1;
	}

	public void setCardLayout(CardLayout layout, JPanel panel) {
		this.cardLayout = layout;
		this.cardPanel = panel;
		
		panel.addComponentListener(new java.awt.event.ComponentAdapter() {
			@Override
			public void componentShown(java.awt.event.ComponentEvent e) {
				if (e.getComponent() == Kofi1) {
					updateReceiptNumber();
				}
			}
		});
	}
}