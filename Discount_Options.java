package Kofi_Co;

import javax.swing.*;
import java.awt.*;
import Kofi_Co_Fundamentals.ImportedFonts;
import Kofi_Co_Fundamentals.BackButton;
import Kofi_Co_Fundamentals.DiscountManager;

public class Discount_Options {
	
	private CardLayout cardLayout;
	private JPanel cardPanel;
	private JPanel mainPanel;
	public static String selectedDiscount = "No Discount";
	private final ImportedFonts IMPFonts = new ImportedFonts();

	public void initialize() {
		IMPFonts.Fonts();
		mainPanel = createDiscountOptionsPanel();
	}

	private JPanel createDiscountOptionsPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBackground(Color.WHITE);
		
		JPanel headerPanel = new JPanel(null);
		headerPanel.setBackground(Color.WHITE);
		headerPanel.setPreferredSize(new Dimension(700, 70));
		panel.add(headerPanel, BorderLayout.NORTH);
		
		BackButton backButton = new BackButton();
		headerPanel.add(backButton);

		JPanel center = new JPanel();
		center.setBackground(Color.WHITE);
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		center.setAlignmentX(Component.CENTER_ALIGNMENT);
		center.setBorder(BorderFactory.createEmptyBorder(20, -5, 20, 0));

		JLabel title = new JLabel("K. Co");
		title.setFont(new Font("Gugi", Font.BOLD, 140));
		title.setForeground(new Color(0x5e3219));
		title.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel subtitle = new JLabel("Discount Options");
		subtitle.setFont(new Font("Poppins Regular", Font.PLAIN, 35));
		subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		subtitle.setForeground(Color.BLACK);

		JButton pwdBtn = menuButton("PWD", "Discount Page");
		JButton seniorBtn = menuButton("Senior", "Discount Page");
		JButton memberBtn = menuButton("Member", "Discount Page");
		JButton skipBtn = menuButton("No Discount", "Total");

		center.add(Box.createVerticalStrut(10));
		center.add(title);
		center.add(Box.createVerticalStrut(5));
		center.add(subtitle);
		center.add(Box.createVerticalStrut(20));
		center.add(pwdBtn);
		center.add(Box.createVerticalStrut(10));
		center.add(seniorBtn);
		center.add(Box.createVerticalStrut(10));
		center.add(memberBtn);
		center.add(Box.createVerticalStrut(10));
		center.add(skipBtn);
		panel.add(center, BorderLayout.CENTER);
		
		return panel;
	}

	private JButton menuButton(String text, String cardName) {
		JButton button = new JButton(text) {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setColor(getBackground());
				g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
				super.paintComponent(g);
				g2.dispose();
			}

			@Override
			public boolean isContentAreaFilled() {
				return false;
			}
		};

		Dimension size = new Dimension(240, 60);
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setPreferredSize(size);
		button.setMaximumSize(size);
		button.setMinimumSize(size);
		button.setFont(new Font("Poppins Regular", Font.PLAIN, 25));
		button.setFocusPainted(false);
		button.setBackground(new Color(0x5e3219));
		button.setForeground(Color.WHITE);
		button.setOpaque(false);
		button.setBorderPainted(false);
		button.setHorizontalAlignment(SwingConstants.CENTER);
		button.setVerticalAlignment(SwingConstants.CENTER);
		
		button.addActionListener(e -> {
			selectedDiscount = text;
			if (text.equals("Senior")) {
				selectedDiscount = "Senior Citizen";
			}
			if (text.equals("No Discount")) {
				DiscountManager.getInstance().setDiscountApplied(false);
			}
			cardLayout.show(cardPanel, cardName);
		});
		
		return button;
	}
	

	public JPanel getDiscountOptionsPanel() {
		return mainPanel;
	}

	public void setCardLayout(CardLayout layout, JPanel panel) {
		this.cardLayout = layout;
		this.cardPanel = panel;
		for (Component comp : mainPanel.getComponents()) {
			if (comp instanceof JPanel) {
				for (Component innerComp : ((JPanel) comp).getComponents()) {
					if (innerComp instanceof BackButton) {
						((BackButton) innerComp).setNavigation(layout, panel, "Menu");
					}
				}
			}
		}
	}
}