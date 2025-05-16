package Kofi_Co;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.*;

import Kofi_Co_Fundamentals.ImportedFonts;
import Kofi_Co_Fundamentals.BackButton;
import Kofi_Co_Fundamentals.DiscountManager;

public class Total {

	ImportedFonts IMPFonts = new ImportedFonts();
	private CardLayout cardLayout;
	private JPanel cardPanel;
	private JPanel mainPanel;
	JPanel contentPanel = new JPanel();
	JButton Kofi2 = new JButton();
	JLabel Kofi3 = new JLabel();
	JLabel Kofi4 = new JLabel();
	JLabel Kofi5 = new JLabel();
	JLabel Kofi6 = new JLabel();

	public void Totals() {
		IMPFonts.Fonts();

		mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBackground(Color.WHITE);

		JPanel headerPanel = new JPanel(null);
		headerPanel.setBackground(Color.WHITE);
		headerPanel.setPreferredSize(new Dimension(700, 70));

		BackButton backButton = new BackButton();
		headerPanel.add(backButton);

		contentPanel.setBackground(Color.WHITE);
		contentPanel.setLayout(null);

		Kofi3.setText("K. Co");
		Kofi3.setFont(new Font("Gugi", Font.BOLD, 140));
		Kofi3.setForeground(new Color(0x5e3219));
		Kofi3.setBounds(153, 33, 375, 170);
		contentPanel.add(Kofi3);

		Kofi4.setText("Total");
		Kofi4.setFont(new Font("Poppins Regular", Font.PLAIN, 30));
		Kofi4.setForeground(Color.BLACK);
		Kofi4.setBounds(290, 230, 100, 50);
		contentPanel.add(Kofi4);

		Kofi6.setText("₱");
		Kofi6.setFont(new Font("Arial", Font.PLAIN, 50));
		Kofi6.setForeground(Color.BLACK);
		Kofi6.setBounds(240, 273, 70, 49);
		contentPanel.add(Kofi6);

		Kofi5.setText("00.00");
		Kofi5.setFont(new Font("Poppins Regular", Font.PLAIN, 50));
		Kofi5.setForeground(Color.BLACK);
		Kofi5.setBounds(275, 275, 431, 49);
		contentPanel.add(Kofi5);

		Kofi2.setOpaque(false);
		Kofi2.setContentAreaFilled(false);
		Kofi2.setBorderPainted(false);
		Kofi2.setFocusable(false);
		Kofi2.setBounds(0, 0, 700, 775);
		contentPanel.add(Kofi2);

		mainPanel.add(headerPanel, BorderLayout.NORTH);
		mainPanel.add(contentPanel, BorderLayout.CENTER);

		Kofi2.addActionListener(e -> cardLayout.show(cardPanel, "Payment Options"));

		mainPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
			public void componentShown(java.awt.event.ComponentEvent e) {
				updateTotal();
			}
		});

		updateTotal();
	}

	private void updateTotal() {
		double totalPrice = calculateTotalPrice();
		Kofi5.setText(String.format("%.2f", totalPrice));
	}

	private double calculateTotalPrice() {
		double total = 0.0;
		ArrayList<OrderItem> orders = OrderManager.getInstance().getCurrentOrder();

		// Calculate total using the quantity stored in each OrderItem
		for (OrderItem item : orders) {
			double price = Double.parseDouble(item.price.replace("P", "").replace("₱", ""));
			total += price * item.quantity;
		}

		// Apply any discounts
		total = DiscountManager.getInstance().applyDiscount(total);

		return total;
	}

	public JPanel getKofi1Panel() {
		return mainPanel;
	}

	public JButton getKofi2Button() {
		return Kofi2;
	}

	public void setCardLayout(CardLayout layout, JPanel panel) {
		this.cardLayout = layout;
		this.cardPanel = panel;
		for (Component comp : mainPanel.getComponents()) {
			if (comp instanceof JPanel) {
				for (Component innerComp : ((JPanel) comp).getComponents()) {
					if (innerComp instanceof BackButton) {
						BackButton backButton = (BackButton) innerComp;
						backButton.setNavigation(layout, panel, "Discount Options");
						backButton.addActionListener(e -> {
							DiscountManager.getInstance().setDiscountApplied(false);
							updateTotal();
						});
					}
				}
			}
		}

		panel.addComponentListener(new java.awt.event.ComponentAdapter() {
			public void componentShown(java.awt.event.ComponentEvent e) {
				if (cardPanel.isShowing() && mainPanel.isShowing()) {
					updateTotal();
				}
			}
		});
	}
}