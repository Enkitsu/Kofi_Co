package Kofi_Co;

import javax.swing.*;
import java.awt.*;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {

			ImageIcon KofiIcon = new ImageIcon("Kofi.png");
			JFrame Kofi = new JFrame("Kofi Co.");
			Kofi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Kofi.setSize(700, 775);
			Kofi.setLocationRelativeTo(null);
			Kofi.setResizable(false);
			Kofi.setIconImage(KofiIcon.getImage());

			CardLayout cardLayout = new CardLayout();
			JPanel cardPanel = new JPanel(cardLayout);																													

			Welcome welcome = new Welcome();
			Menu menu = new Menu();
			View_Order vieworder = new View_Order();
			Discount_Options discounts = new Discount_Options();     
			Discount_Page discountPage = new Discount_Page();
			Payment_Options paymentoptions = new Payment_Options();
			Credit credit = new Credit();
			QRPH_Page qrph = new QRPH_Page();
			Credit_Page creditpage = new Credit_Page();
			Total total = new Total();
			Receipt receipt = new Receipt();
			End end = new End();

			welcome.HomeComp();
			menu.CardLayout();
			vieworder.CardLayout();
			discounts.initialize();
			total.Totals();
			paymentoptions.paymentcomps();
			credit.CreditComps();
			qrph.initializeComponents();
			creditpage.creditpagecomps();
			receipt.Receipts();
			end.EndComps();

			menu.setCardLayout(cardLayout, cardPanel);
			vieworder.setCardLayout(cardLayout, cardPanel);
			discounts.setCardLayout(cardLayout, cardPanel);
			discountPage.setCardLayout(cardLayout, cardPanel);
			total.setCardLayout(cardLayout, cardPanel);
			paymentoptions.setCardLayout(cardLayout, cardPanel);
			credit.setCardLayout(cardLayout, cardPanel);
			qrph.setCardLayout(cardLayout, cardPanel);
			creditpage.setCardLayout(cardLayout, cardPanel);
			receipt.setCardLayout(cardLayout, cardPanel);
			end.setCardLayout(cardLayout, cardPanel);

			cardPanel.add(welcome.getWelcomePanel(), "Welcome");
			cardPanel.add(menu.getMenuPanel(), "Menu");
			cardPanel.add(vieworder.getViewOrderPanel(), "ViewOrder");
			cardPanel.add(discounts.getDiscountOptionsPanel(), "Discount Options");
			cardPanel.add(discountPage.getMainPanel(), "Discount Register");
			cardPanel.add(total.getKofi1Panel(), "Total");
			cardPanel.add(paymentoptions.getPaymentPanel(), "Payment Options");
			cardPanel.add(credit.getCreditPanel(), "Credit");
			cardPanel.add(qrph.getQRPHPanel(), "QRPH Page");
			cardPanel.add(creditpage.getCreditPageMainPanel(), "Credit Page");
			cardPanel.add(receipt.getKofi1ReceiptPanel(), "Receipt");
			cardPanel.add(end.getEndPanel(), "End");

			welcome.getHomeButton().addActionListener(e -> {
				cardLayout.show(cardPanel, "Menu");
			});

			Kofi.add(cardPanel);
			Kofi.setVisible(true);
		});
	}
}
