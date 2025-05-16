package Kofi_Co;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import Kofi_Co_Fundamentals.ImportedFonts;
import Kofi_Co_Fundamentals.RoundedButton;

public class Menu {

	ImageIcon americanoicon = new ImageIcon("AmericanoPic.png");
	ImageIcon espressoicon = new ImageIcon("EspressoPic.png");
	ImageIcon cappucinoicon = new ImageIcon("CappucinoPic.png");
	ImageIcon mochapic = new ImageIcon("MochaPic.png");
	ImageIcon spanishlattepic = new ImageIcon("SpanishLattePic.png");
	ImageIcon macchiatopic = new ImageIcon("MacchiatoPic.png");
	ImageIcon icedteapic = new ImageIcon("IcedTeaPic.png");
	ImageIcon matchatealattepic = new ImageIcon("MatchaTeaLattePic.png");
	ImageIcon icedchocolatemilkpic = new ImageIcon("IcedChocolateMilkPic.png");
	ImageIcon cookiescreampic = new ImageIcon("Cookies&CreamPic.png");
	ImageIcon matchapic = new ImageIcon("MatchaPic.png");
	ImageIcon javachipic = new ImageIcon("JavaChipPic.png");

	CardLayout categoryselectioncard = new CardLayout();
	CardLayout cardLayout = new CardLayout();

	JPanel cardPanel = new JPanel(cardLayout);
	JPanel MainPanel = new JPanel();
	JPanel MenuCategoryPanel = new JPanel();
	JPanel drinkselectiontrspanel = new JPanel();
	JPanel MainDrinkSelectionHotCoffee = MainDrinkSelectionComps();
	JPanel MainDrinkSelectionIcedCoffee = MainDrinkSelectionComps();
	JPanel MainDrinkSelectionFrappe = MainDrinkSelectionComps();
	JPanel MainDrinkSelectionColdNonCoffee = MainDrinkSelectionComps();
	JPanel BottomHeaderPanel = new JPanel();

	JButton CoffeeSelectionHotCoffee = CoffeeTypesListComps();
	JButton CoffeeSelectionIcedCoffee = CoffeeTypesListComps();
	JButton CoffeeSelectionFrappe = CoffeeTypesListComps();
	JButton CoffeeSelectionColdNonCoffee = CoffeeTypesListComps();

	ImportedFonts IMPFonts = new ImportedFonts();
	public JLabel menuCostLabel;

	private JButton CoffeeTypesListComps() {
		JButton btn2 = new JButton();
		btn2.setOpaque(false);
		btn2.setContentAreaFilled(false);
		btn2.setBorderPainted(false);
		btn2.setFocusable(false);
		btn2.setFont(new Font("Poppins SemiBold", Font.BOLD, 17));
		btn2.setVerticalTextPosition(JLabel.BOTTOM);
		btn2.setHorizontalTextPosition(JLabel.CENTER);
		btn2.setIconTextGap(-5);
		return btn2;
	}

	private JPanel MainDrinkSelectionComps() {
		JPanel pnl = new JPanel();
		pnl.setBackground(Color.WHITE);
		pnl.setLayout(null);
		return pnl;
	}

	private JButton DrinkSelectionComps(String text) {
		JButton btn = new JButton(text);
		btn.setOpaque(false);
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		btn.setFocusable(false);
		btn.setFont(new Font("Poppins Regular", Font.PLAIN, 15));
		btn.setVerticalTextPosition(JLabel.BOTTOM);
		btn.setVerticalAlignment(JLabel.BOTTOM);
		btn.setHorizontalTextPosition(JLabel.CENTER);
		btn.setIconTextGap(-12);
		return btn;
	}

	public void CoffeeTypesList() {

		JLabel KoficoLabel = new JLabel();

		MenuCategoryPanel.setBackground(new Color(0xFBFBFB));
		MenuCategoryPanel.setBounds(0, 0, 200, 775);
		MenuCategoryPanel.setLayout(null);

		KoficoLabel.setText("K. Co");
		KoficoLabel.setForeground(new Color(0x5e3219));
		KoficoLabel.setFont(new Font("Gugi", Font.PLAIN, 55));
		KoficoLabel.setBounds(30, 30, 140, 70);
		MenuCategoryPanel.add(KoficoLabel);

		CoffeeSelectionHotCoffee.setText("Hot Coffee");
		CoffeeSelectionHotCoffee.setIcon(americanoicon);
		CoffeeSelectionHotCoffee.setBounds(0, 150, 200, 130);
		MenuCategoryPanel.add(CoffeeSelectionHotCoffee);

		CoffeeSelectionIcedCoffee.setText("Iced Coffee");
		CoffeeSelectionIcedCoffee.setIcon(mochapic);
		CoffeeSelectionIcedCoffee.setBounds(0, 280, 200, 130);
		MenuCategoryPanel.add(CoffeeSelectionIcedCoffee);

		CoffeeSelectionFrappe.setText("Frappe");
		CoffeeSelectionFrappe.setIcon(cookiescreampic);
		CoffeeSelectionFrappe.setBounds(0, 410, 200, 130);
		MenuCategoryPanel.add(CoffeeSelectionFrappe);

		CoffeeSelectionColdNonCoffee.setText("Cold Non-Coffee");
		CoffeeSelectionColdNonCoffee.setIcon(icedteapic);
		CoffeeSelectionColdNonCoffee.setBounds(0, 540, 200, 130);
		MenuCategoryPanel.add(CoffeeSelectionColdNonCoffee);

		MenuCategoryPanel.setPreferredSize(new Dimension(200, 850));

	}

	public void Coffee() {

		JLabel coffeelabel = new JLabel();
		JButton americano = DrinkSelectionComps("Americano");
		JButton espresso = DrinkSelectionComps("Espresso");
		JButton cappucino = DrinkSelectionComps("Cappucino");

		coffeelabel.setText("Hot Coffee");
		coffeelabel.setFont(new Font("Poppins Bold", Font.PLAIN, 40));
		coffeelabel.setBounds(25, 125, 250, 80);
		MainDrinkSelectionHotCoffee.add(coffeelabel);

		americano.setBounds(35, 200, 120, 120);
		americano.setIcon(americanoicon);
		americano.setIconTextGap(-5);
		americano.addActionListener(e -> {
			hotcoffee_Americano americanoCustomization = new hotcoffee_Americano();
			americanoCustomization.setMenuReference(this);
			americanoCustomization.frame.pack();
		});
		MainDrinkSelectionHotCoffee.add(americano);

		cappucino.setBounds(180, 200, 120, 120);
		cappucino.setIcon(cappucinoicon);
		cappucino.setIconTextGap(-21);
		cappucino.addActionListener(e -> {
			hotcoffee_Cappuccino cappucinoCustomization = new hotcoffee_Cappuccino();
			cappucinoCustomization.setMenuReference(this);
			cappucinoCustomization.frame.pack();
		});
		MainDrinkSelectionHotCoffee.add(cappucino);

		espresso.setBounds(325, 200, 120, 120);
		espresso.setIcon(espressoicon);
		espresso.setIconTextGap(-2);
		espresso.addActionListener(e -> {
			hotcoffee_Espresso espressoCustomization = new hotcoffee_Espresso();
			espressoCustomization.setMenuReference(this);
			espressoCustomization.mainFrame();
			espressoCustomization.frame.pack();
			espressoCustomization.frame.setVisible(true);
		});
		MainDrinkSelectionHotCoffee.add(espresso);

	}

	public void IcedCoffee() {

		JLabel frappucinolabel = new JLabel();
		JButton mocha = DrinkSelectionComps("Mocha");
		JButton macchiato = DrinkSelectionComps("Macchiato");
		JButton spanishlatte = DrinkSelectionComps("<html><center>Spanish<br>Latte</center></html>");

		frappucinolabel.setText("Iced Cofffee");
		frappucinolabel.setFont(new Font("Poppins Bold", Font.PLAIN, 40));
		frappucinolabel.setBounds(25, 125, 280, 80);
		MainDrinkSelectionIcedCoffee.add(frappucinolabel);

		mocha.setBounds(35, 200, 120, 150);
		mocha.setIcon(mochapic);
		mocha.setIconTextGap(5);
		mocha.addActionListener(e -> {
			icedcoffee_Mocha mochaCustomization = new icedcoffee_Mocha();
			mochaCustomization.setMenuReference(this);
			mochaCustomization.frame.pack();
		});
		MainDrinkSelectionIcedCoffee.add(mocha);
		macchiato.setBounds(180, 200, 120, 150);
		macchiato.setIcon(macchiatopic);
		macchiato.setIconTextGap(5);
		macchiato.addActionListener(e -> {
			icedcoffee_Macchiato macchiatoCustomization = new icedcoffee_Macchiato();
			macchiatoCustomization.setMenuReference(this);
			macchiatoCustomization.frame.pack();
		});
		MainDrinkSelectionIcedCoffee.add(macchiato);
		spanishlatte.setBounds(325, 203, 125, 168);
		spanishlatte.setIcon(spanishlattepic);
		spanishlatte.setIconTextGap(2);
		spanishlatte.addActionListener(e -> {
			icedcoffee_SpanishLatte spanishLatteCustomization = new icedcoffee_SpanishLatte();
			spanishLatteCustomization.setMenuReference(this);
			spanishLatteCustomization.frame.pack();
		});
		MainDrinkSelectionIcedCoffee.add(spanishlatte);

	}

	public void Frappe() {

		JLabel hotnoncoffeelabel = new JLabel();
		JButton cookiescream = DrinkSelectionComps("<html><center>Cookies &<br>Cream</center></html>");
		JButton matcha = DrinkSelectionComps("Matcha");
		JButton javachip = DrinkSelectionComps("Java Chip");

		hotnoncoffeelabel.setText("Frappe");
		hotnoncoffeelabel.setFont(new Font("Poppins Bold", Font.PLAIN, 40));
		hotnoncoffeelabel.setBounds(25, 125, 400, 80);
		MainDrinkSelectionFrappe.add(hotnoncoffeelabel);

		cookiescream.setBounds(35, 203, 120, 169);
		cookiescream.setIcon(cookiescreampic);
		cookiescream.setIconTextGap(5);
		cookiescream.addActionListener(e -> {
			frappe_CookiesnCream cookiesnCreamCustomization = new frappe_CookiesnCream();
			cookiesnCreamCustomization.setMenuReference(this);
			cookiesnCreamCustomization.frame.pack();
		});
		MainDrinkSelectionFrappe.add(cookiescream);

		matcha.setBounds(180, 200, 120, 150);
		matcha.setIcon(matchapic);
		matcha.setIconTextGap(5);
		matcha.addActionListener(e -> {
			frappe_Matcha matchaCustomization = new frappe_Matcha();
			matchaCustomization.setMenuReference(this);
			matchaCustomization.frame.pack();
		});
		MainDrinkSelectionFrappe.add(matcha);

		javachip.setBounds(325, 200, 120, 150);
		javachip.setIcon(javachipic);
		javachip.setIconTextGap(-3);
		javachip.addActionListener(e -> {
			frappe_JavaChip javaChipCustomization = new frappe_JavaChip();
			javaChipCustomization.setMenuReference(this);
			javaChipCustomization.frame.pack();
		});
		MainDrinkSelectionFrappe.add(javachip);

	}

	public void Cold_Non_Coffee() {

		JLabel coldnoncoffeelabel = new JLabel();
		JButton icedgreentea = DrinkSelectionComps("<html><center>Green<br>Tea</center></html>");
		JButton matchatealatte = DrinkSelectionComps("<html><center>Matcha<br>Latte</center></html>");
		JButton icedchocolatemilk = DrinkSelectionComps("<html><center>Chocolate<br>Milk</center></html>");

		coldnoncoffeelabel.setText("Cold Non - Coffee");
		coldnoncoffeelabel.setFont(new Font("Poppins Bold", Font.PLAIN, 40));
		coldnoncoffeelabel.setBounds(25, 125, 400, 80);
		MainDrinkSelectionColdNonCoffee.add(coldnoncoffeelabel);

		icedgreentea.setBounds(35, 207, 120, 150);
		icedgreentea.setIcon(icedteapic);
		icedgreentea.setIconTextGap(-3);
		icedgreentea.addActionListener(e -> {
			coldnoncoffee_GreenTea greenTeaCustomization = new coldnoncoffee_GreenTea();
			greenTeaCustomization.setMenuReference(this);
			greenTeaCustomization.frame.pack();
		});
		MainDrinkSelectionColdNonCoffee.add(icedgreentea);

		matchatealatte.setBounds(180, 207, 120, 150);
		matchatealatte.setIcon(matchatealattepic);
		matchatealatte.setIconTextGap(-3);
		matchatealatte.addActionListener(e -> {
			coldnoncoffee_MatchaTeaLatte matchaTeaLatteCustomization = new coldnoncoffee_MatchaTeaLatte();
			matchaTeaLatteCustomization.setMenuReference(this);
			matchaTeaLatteCustomization.frame.pack();
		});
		
		MainDrinkSelectionColdNonCoffee.add(matchatealatte);

		icedchocolatemilk.setBounds(325, 207, 125, 150);
		icedchocolatemilk.setIcon(icedchocolatemilkpic);
		icedchocolatemilk.setIconTextGap(-3);
		icedchocolatemilk.addActionListener(e -> {
			coldnoncoffee_IcedChocolateMilk icedChocolateMilkCustomization = new coldnoncoffee_IcedChocolateMilk();
			icedChocolateMilkCustomization.setMenuReference(this);
			icedChocolateMilkCustomization.frame.pack();
		});
		MainDrinkSelectionColdNonCoffee.add(icedchocolatemilk);

	}

	public void BottomHeader() {

		JLabel total = new JLabel();
		JLabel cost = new JLabel();
		this.menuCostLabel = cost;
		JButton vieworder = new RoundedButton();
		JButton buynow = new RoundedButton();

		BottomHeaderPanel.setBackground(new Color(0xFBFBFB));
		BottomHeaderPanel.setBounds(0, 640, 700, 200);
		BottomHeaderPanel.setLayout(null);

		total.setText("Total");
		total.setFont(new Font("Poppins SemiBold", Font.PLAIN, 15));
		total.setBounds(342, 24, 100, 30);
		total.setForeground(Color.BLACK);
		BottomHeaderPanel.add(total);

		cost.setText("P00.00");
		cost.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		cost.setBounds(320, 45, 100, 30);
		cost.setForeground(Color.BLACK);
		BottomHeaderPanel.add(cost);

		vieworder.setBorderPainted(false);
		vieworder.setBackground(new Color(0x5e3219));
		vieworder.setText("<html><center>View<br>Order<html>");
		vieworder.setForeground(Color.WHITE);
		vieworder.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		vieworder.setBounds(415, 23, 85, 55);
		BottomHeaderPanel.add(vieworder);

		buynow.setBorderPainted(false);
		buynow.setBackground(new Color(0x5e3219));
		buynow.setText("Next");
		buynow.setForeground(Color.WHITE);
		buynow.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		buynow.setBounds(512, 23, 140, 55);
		BottomHeaderPanel.add(buynow);

		vieworder.addActionListener(e -> {
			cardLayout.show(cardPanel, "ViewOrder");
			cardPanel.validate();
			cardPanel.repaint();
			for (java.awt.event.ComponentListener listener : cardPanel.getComponentListeners()) {
				listener.componentShown(
						new java.awt.event.ComponentEvent(cardPanel, java.awt.event.ComponentEvent.COMPONENT_SHOWN));
			}
		});
		buynow.addActionListener(e -> cardLayout.show(cardPanel, "ViewOrder"));

		MainPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
			public void componentShown(java.awt.event.ComponentEvent e) {
				updateTotal();
			}
		});

	}

	public void updateTotal() {
		if (menuCostLabel != null) {
			double total = 0.0;
			ArrayList<OrderItem> orders = OrderManager.getInstance().getCurrentOrder();
			for (OrderItem item : orders) {
				String priceStr = item.price.replace("P", "").trim();
				try {
					double itemPrice = Double.parseDouble(priceStr);
					total += itemPrice * item.quantity;
				} catch (NumberFormatException e) {
					System.out.println("Error parsing price: " + item.price);
				}
			}

			menuCostLabel.setText("P" + String.format("%.2f", total));
		}
	}

	public void CardLayout() {

		CoffeeTypesList();
		Coffee();
		Frappe();
		IcedCoffee();
		Cold_Non_Coffee();
		BottomHeader();

		MainPanel.setLayout(null);
		MainPanel.setBounds(0, 0, 700, 775);

		JScrollPane scrollmenu = new JScrollPane(MenuCategoryPanel);
		scrollmenu.setBounds(0, 0, 200, 775);
		scrollmenu.setBorder(null);
		scrollmenu.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollmenu.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		scrollmenu.getVerticalScrollBar().setUnitIncrement(10);
		MainPanel.add(scrollmenu);

		drinkselectiontrspanel.setLayout(categoryselectioncard);
		drinkselectiontrspanel.setBounds(200, 0, 500, 640);
		drinkselectiontrspanel.setBackground(Color.WHITE);

		drinkselectiontrspanel.add(MainDrinkSelectionHotCoffee, "Coffee");
		drinkselectiontrspanel.add(MainDrinkSelectionIcedCoffee, "Frappucinos");
		drinkselectiontrspanel.add(MainDrinkSelectionFrappe, "Hot Non - Coffee");
		drinkselectiontrspanel.add(MainDrinkSelectionColdNonCoffee, "Cold Non - Coffee");

		MainPanel.add(drinkselectiontrspanel);
		MainPanel.add(BottomHeaderPanel);

		CoffeeSelectionHotCoffee.addActionListener(e -> categoryselectioncard.show(drinkselectiontrspanel, "Coffee"));
		CoffeeSelectionIcedCoffee
				.addActionListener(e -> categoryselectioncard.show(drinkselectiontrspanel, "Frappucinos"));
		CoffeeSelectionFrappe
				.addActionListener(e -> categoryselectioncard.show(drinkselectiontrspanel, "Hot Non - Coffee"));
		CoffeeSelectionColdNonCoffee
				.addActionListener(e -> categoryselectioncard.show(drinkselectiontrspanel, "Cold Non - Coffee"));

		cardPanel.add(MainPanel, "Menu");

	}

	public JPanel getMenuPanel() {
		return MainPanel;
	}

	public void setCardLayout(CardLayout layout, JPanel panel) {
		this.cardLayout = layout;
		this.cardPanel = panel;
	}

	public void addToCart(OrderItem item) {
		OrderManager.getInstance().addToOrder(item);
		updateTotal();
	}
}