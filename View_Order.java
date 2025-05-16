package Kofi_Co;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.*;
import Kofi_Co_Fundamentals.RoundedButton;

public class View_Order {
    CardLayout cardLayout = new CardLayout();
    JPanel cardPanel = new JPanel(cardLayout);
    
    JPanel mainPanel = new JPanel();
    JPanel headerPanel = new JPanel();
    JPanel footerPanel = new JPanel();
    JPanel contentPanel = new JPanel();

    JPanel backPanel = new JPanel();
    JLabel arrow = new JLabel();

    JPanel namePanel = new JPanel();
    JPanel upperPanel = new JPanel(new BorderLayout());
    JPanel logoPanel = new JPanel(new BorderLayout());
    JLabel logoLabel = new JLabel("K.Co");

    JPanel myOrderPanel = new JPanel(new BorderLayout());
    JLabel myOrderLabel = new JLabel();
    JPanel myOrderPanel2 = new JPanel(new BorderLayout());
    JLabel myOrderLabel2 = new JLabel();

    JScrollPane scrollPane = new JScrollPane();
    JPanel orderContainer = new JPanel();
    JLabel cost = new JLabel();

    public void setupHeaderPanel() {
        headerPanel.setBackground(Color.WHITE);
        
        arrow.setText("<");
        arrow.setForeground(Color.BLACK);
        arrow.setFont(new Font("Advent Pro", Font.PLAIN, 45));
        arrow.setBorder(BorderFactory.createEmptyBorder(13, 47, 0, 0));

        backPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        backPanel.setOpaque(false);

        MouseAdapter goBack = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(cardPanel, "Menu");
            }

            public void mouseEntered(MouseEvent e) {
                arrow.setForeground(Color.GRAY);
            }

            public void mouseExited(MouseEvent e) {
                arrow.setForeground(Color.BLACK);
            }
        };

        arrow.addMouseListener(goBack);
        backPanel.add(arrow);
        backPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
    }

    public void BottomHeader() {
        JLabel total = new JLabel("Total");
        JButton buynow = new RoundedButton();

        total.setFont(new Font("Poppins", Font.BOLD, 15));
        total.setBounds(342, 24, 100, 30);
		total.setForeground(Color.BLACK);
        footerPanel.add(total);

        cost.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
        cost.setBounds(320, 45, 100, 30);
        footerPanel.add(cost);

        buynow.setBorderPainted(false);
        buynow.setBackground(new Color(0x5e3219));
        buynow.setText("Buy Now");
        buynow.setForeground(Color.WHITE);
        buynow.setFont(new Font("Arial", Font.BOLD, 15));
        buynow.setBounds(415, 23, 237, 55);
		buynow.addActionListener(e -> cardLayout.show(cardPanel, "Discount Options"));
        footerPanel.setLayout(null);
        footerPanel.add(buynow);

        // Show total
        double totalPrice = calculateTotalPrice();
        cost.setText("P" + String.format("%.2f", totalPrice));
    }

    public void upper() {
        logoLabel.setFont(new Font("Gugi", Font.BOLD, 140));
        logoLabel.setForeground(new Color(0x5e3219));
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        logoLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, -10, 0));
        logoPanel.add(logoLabel);

        myOrderLabel.setText("My");
        myOrderLabel.setFont(new Font("Poppins SemiBold", Font.BOLD, 40));
        myOrderLabel.setForeground(Color.black);
        myOrderLabel.setBorder(BorderFactory.createEmptyBorder(0, 80, -10, 0));
        myOrderPanel.add(myOrderLabel, BorderLayout.CENTER);

        myOrderLabel2.setText("Order");
        myOrderLabel2.setFont(new Font("Poppins SemiBold", Font.BOLD, 40));
        myOrderLabel2.setForeground(Color.black);
        myOrderLabel2.setBorder(BorderFactory.createEmptyBorder(-10, 80, 0, 0));
        myOrderPanel2.add(myOrderLabel2, BorderLayout.CENTER);

        upperPanel.add(logoPanel, BorderLayout.NORTH);
        upperPanel.add(myOrderPanel, BorderLayout.CENTER);
        upperPanel.add(myOrderPanel2, BorderLayout.SOUTH);

        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));
        namePanel.add(upperPanel);

        logoPanel.setOpaque(false);
        myOrderPanel.setOpaque(false);
        myOrderPanel2.setOpaque(false);
        upperPanel.setOpaque(false);
        namePanel.setOpaque(false);
    }

    public void populateOrders() {
        orderContainer.removeAll();
        ArrayList<OrderItem> orders = OrderManager.getInstance().getCurrentOrder();
        
        for (OrderItem item : orders) {
            orderContainer.add(createOrderItemPanel(item));
            orderContainer.add(Box.createVerticalStrut(10));
        }

        double totalPrice = calculateTotalPrice();
        cost.setText("P" + String.format("%.2f", totalPrice));

        orderContainer.revalidate();
        orderContainer.repaint();
        contentPanel.revalidate();
        contentPanel.repaint();
        mainPanel.revalidate();
        mainPanel.repaint();
        
        if (scrollPane != null) {
            scrollPane.getViewport().setViewPosition(new Point(0, 0));
            scrollPane.revalidate();
            scrollPane.repaint();
        }
    }

    public JPanel createOrderItemPanel(OrderItem item) {
        JPanel itemPanel = new JPanel(new BorderLayout());
        itemPanel.setPreferredSize(new Dimension(620, 120));
        itemPanel.setMaximumSize(new Dimension(620, 120));
        itemPanel.setBackground(Color.WHITE);
        itemPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0xDDDDDD)));

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setOpaque(false);
        textPanel.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0));
        
        String[] parts = item.name.split(" - ", 2);
        String coffeeName = parts[0];
        String addOns = parts.length > 1 ? parts[1] : "";
        
        JLabel nameLabel = new JLabel(coffeeName);
        nameLabel.setFont(new Font("Poppins", Font.PLAIN, 18));
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel addOnsLabel = null;
        if (!addOns.isEmpty()) {
            addOnsLabel = new JLabel(addOns);
            addOnsLabel.setFont(new Font("Poppins", Font.PLAIN, 14));
            addOnsLabel.setForeground(new Color(0x666666));
            addOnsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        }
        
        JLabel priceLabel = new JLabel(item.price.replace("₱", "P"));
        priceLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
        priceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        textPanel.add(nameLabel);
        if (addOnsLabel != null) {
            textPanel.add(Box.createVerticalStrut(5));
            textPanel.add(addOnsLabel);
        }
        textPanel.add(Box.createVerticalStrut(5));
        textPanel.add(priceLabel);

        JPanel controlsPanel = new JPanel();
        controlsPanel.setOpaque(false);
        controlsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 20));
        controlsPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 50));

        // Create remove button
        JButton removeButton = new RoundedButton();
        removeButton.setText("-");
        removeButton.setFocusable(false);
        removeButton.setFont(new Font("Arial", Font.BOLD, 16));
        removeButton.setBackground(new Color(0x5e3219));
        removeButton.setForeground(Color.WHITE);
        removeButton.setBorderPainted(false);
        removeButton.setPreferredSize(new Dimension(45, 30));
        removeButton.addActionListener(e -> {
            OrderManager.getInstance().updateQuantity(item.name, item.quantity - 1);
            populateOrders();
        });

        // Create quantity label
        JLabel quantityLabel = new JLabel(String.valueOf(item.quantity));
        quantityLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
        quantityLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        // Create add button
        JButton addButton = new RoundedButton();
        addButton.setText("+");
        addButton.setFocusable(false);
        addButton.setFont(new Font("Arial", Font.BOLD, 16));
        addButton.setBackground(new Color(0x5e3219));
        addButton.setForeground(Color.WHITE);
        addButton.setBorderPainted(false);
        addButton.setPreferredSize(new Dimension(45, 30));
        addButton.addActionListener(e -> {
            OrderManager.getInstance().updateQuantity(item.name, item.quantity + 1);
            populateOrders();
        });

        controlsPanel.add(removeButton);
        controlsPanel.add(quantityLabel);
        controlsPanel.add(addButton);

        itemPanel.add(textPanel, BorderLayout.CENTER);
        itemPanel.add(controlsPanel, BorderLayout.EAST);

        return itemPanel;
    }

    public double calculateTotalPrice() {
        double total = 0.0;
        ArrayList<OrderItem> orders = OrderManager.getInstance().getCurrentOrder();
        
        for (OrderItem item : orders) {
            double price = Double.parseDouble(item.price.replace("P", "").replace("₱", ""));
            total += price * item.quantity;
        }
        return total;
    }

    public void CardLayout() {
        setupHeaderPanel();
        populateOrders(); 
        BottomHeader();
        upper();

        mainPanel.setLayout(new BorderLayout());

        headerPanel.setLayout(new BorderLayout());
        headerPanel.setPreferredSize(new Dimension(700, 70));
        headerPanel.setBackground(Color.WHITE);
        headerPanel.add(backPanel, BorderLayout.WEST);

        orderContainer.setLayout(new BoxLayout(orderContainer, BoxLayout.Y_AXIS));
        orderContainer.setBackground(Color.WHITE);

        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);
        contentPanel.add(namePanel, BorderLayout.NORTH);
        contentPanel.add(orderContainer, BorderLayout.CENTER);

        scrollPane.setViewportView(contentPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setOpaque(false);

        footerPanel.setPreferredSize(new Dimension(700, 98));
        footerPanel.setBackground(new Color(0xFBFBFB));

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        cardPanel.add(mainPanel, "ViewOrder");

        mainPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent e) {
                populateOrders();
                double totalPrice = calculateTotalPrice();
                cost.setText("P" + String.format("%.2f", totalPrice));
                orderContainer.revalidate();
                orderContainer.repaint();
            }
        });
    }

    public void setCardLayout(CardLayout layout, JPanel panel) {
        this.cardLayout = layout;
        this.cardPanel = panel;
        
        mainPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent e) {
                populateOrders();
                double totalPrice = calculateTotalPrice();
                cost.setText("P" + String.format("%.2f", totalPrice));
                orderContainer.revalidate();
                orderContainer.repaint();
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
        
        panel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent e) {
                if (cardPanel.isShowing() && mainPanel.isShowing()) {
                    populateOrders();
                    double totalPrice = calculateTotalPrice();
                    cost.setText("P" + String.format("%.2f", totalPrice));
                    orderContainer.revalidate();
                    orderContainer.repaint();
                    mainPanel.revalidate();
                    mainPanel.repaint();
                }
            }
        });
    }

    public JPanel getViewOrderPanel() {
        return mainPanel;
    }
}