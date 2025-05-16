package Kofi_Co;

import javax.swing.*;
import javax.swing.border.MatteBorder;

import Kofi_Co_Fundamentals.RoundedToggleButton;
import Kofi_Co_Fundamentals.RoundedButton;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class coldnoncoffee_MatchaTeaLatte extends JFrame {
    
    String name;
    String desc;

    JFrame frame = new JFrame();
    JPanel mainPanel = new JPanel();
    JPanel headerPanel = new JPanel();
    JPanel footerPanel = new JPanel();
    JPanel contentPanel = new JPanel();

    JPanel backPanel = new JPanel();
    JLabel back = new JLabel();
    JLabel arrow = new JLabel();

    JPanel namePanel = new JPanel();
    JPanel addOnPanel = new JPanel();
    JPanel sizePanel = new JPanel();
    JPanel milkPanel = new JPanel();
    JPanel toppingsPanel = new JPanel();

    JPanel logoPanel = new JPanel();
    JPanel drinkNamePanel = new JPanel();
    JPanel drinkDescPanel = new JPanel();

    JLabel K_Co = new JLabel(); 
    JLabel title = new JLabel();
    JLabel description = new JLabel();

    JScrollPane scrollPane = new JScrollPane();

    public String selectedSize = "";
    public String selectedMilk = "";
    public ArrayList<String> selectedToppings = new ArrayList<>();
    public double totalPrice = 0.0;
    public JLabel costLabel;

    public Menu menuReference;
    
    private int quantity = 1;
    private JLabel quantityLabel;
    public ArrayList<RoundedToggleButton[]> optionGroups = new ArrayList<>(); 	
    public ArrayList<JLabel[]> priceLabel = new ArrayList<>();

    public coldnoncoffee_MatchaTeaLatte() {
        mainFrame();
        mainPanel();
        frame.add(mainPanel);
        frame.pack();
    }

    public void mainFrame() {
        frame.setTitle("Kofi Co.");
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.setPreferredSize(new Dimension(700, 775));
    }

    public void mainPanel() {
        setupHeaderPanel();
        BottomHeader(); 
        setupNamePanel();
        setupAddOnPanel();

        mainPanel.setLayout(new BorderLayout());

        headerPanel.setLayout(new BorderLayout());
        headerPanel.setPreferredSize(new Dimension(700, 70));
        headerPanel.setBackground(Color.WHITE);
        headerPanel.add(backPanel, BorderLayout.WEST);

        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBackground(Color.white);

        footerPanel.setLayout(new BorderLayout());
        footerPanel.setPreferredSize(new Dimension(700, 98));
        footerPanel.setBackground(new Color(0xFBFBFB));

        contentPanel.add(namePanel, BorderLayout.NORTH);
        contentPanel.add(addOnPanel, BorderLayout.CENTER);

        scrollPane.setViewportView(contentPanel);
        scrollPane.setBorder(null);

        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);
    }

    public void setupHeaderPanel() {
    	 arrow.setText("<");
         arrow.setForeground(Color.BLACK);
         arrow.setFont(new Font("Advent Pro", Font.PLAIN, 45));
         arrow.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));

         backPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
         backPanel.setOpaque(false);
         
         MouseAdapter goBack = new MouseAdapter() {
             public void mouseClicked(MouseEvent e) {
                 frame.dispose();
             }

             public void mouseEntered(MouseEvent e) {
                 back.setForeground(Color.GRAY);
                 arrow.setForeground(Color.GRAY);
             }

             public void mouseExited(MouseEvent e) {
                 back.setForeground(Color.BLACK);
                 arrow.setForeground(Color.BLACK);
             }
         };

         arrow.addMouseListener(goBack);
         back.addMouseListener(goBack);

         backPanel.add(arrow);
         backPanel.add(Box.createRigidArea(new Dimension(-5, 0)));
         backPanel.add(back);

         backPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
    }

    public void BottomHeader() {
        JLabel total = new JLabel();
        JLabel cost = new JLabel();
        JButton proceed = new RoundedButton();
        this.costLabel = cost;

        footerPanel.removeAll();
        footerPanel.setLayout(null);
        footerPanel.setPreferredSize(new Dimension(700, 98));
        footerPanel.setBackground(new Color(0xFBFBFB));

        JPanel quantityPanel = new JPanel();
        quantityPanel.setLayout(null);
        quantityPanel.setBounds(50, 24, 120, 50);
        quantityPanel.setBackground(new Color(0xFBFBFB));

		JButton minusButton = new RoundedButton();
		minusButton.setText("-");
		minusButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		minusButton.setBounds(0, 10, 45, 30);
		minusButton.setBackground(new Color(0x5e3219));
		minusButton.setForeground(Color.WHITE);
		minusButton.setBorderPainted(false);
		minusButton.setFocusable(false);
		minusButton.addActionListener(e -> {
			if (quantity > 1) {
				quantity--;
				updateQuantityAndPrice();
			}
		});

		quantityLabel = new JLabel("1");
		quantityLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		quantityLabel.setBounds(45, 10, 30, 30);
		quantityLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JButton plusButton = new RoundedButton();
		plusButton.setText("+");
		plusButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		plusButton.setBounds(75, 10, 45, 30);
		plusButton.setBackground(new Color(0x5e3219));
		plusButton.setForeground(Color.WHITE);
		plusButton.setBorderPainted(false);
		plusButton.setFocusable(false);
		plusButton.addActionListener(e -> {
			quantity++;
			updateQuantityAndPrice();
		});

        quantityPanel.add(minusButton);
        quantityPanel.add(quantityLabel);
        quantityPanel.add(plusButton);
        footerPanel.add(quantityPanel);

        total.setText("Total");
        total.setFont(new Font("Poppins", Font.BOLD, 15));
        total.setBounds(342, 24, 100, 30);
        total.setForeground(Color.BLACK);
        footerPanel.add(total);

        cost.setText("P0.00");
        cost.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
        cost.setBounds(320, 45, 100, 30);
        cost.setForeground(Color.BLACK);
        footerPanel.add(cost);

        proceed.setBorderPainted(false);
        proceed.setBackground(new Color(0x5e3219));
        proceed.setText("Proceed");
        proceed.setForeground(Color.WHITE);
        proceed.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        proceed.setBounds(415, 23, 252, 55);
        proceed.setFocusable(false);

        ActionListener proceedAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder orderName = new StringBuilder("Matcha Tea Latte");
                if (!selectedSize.isEmpty())
                    orderName.append(" - ").append(selectedSize);
                if (!selectedMilk.isEmpty())
                    orderName.append(", ").append(selectedMilk);
                if (!selectedToppings.isEmpty())
                    orderName.append(", with ").append(String.join(", ", selectedToppings));

                double singleItemPrice = calculateSingleItemPrice();
                OrderItem newItem = new OrderItem(orderName.toString(), "P" + String.format("%.2f", singleItemPrice), quantity);
                OrderManager.getInstance().addToOrder(newItem);

                if (menuReference != null) {
                    menuReference.updateTotal();
                }

                frame.dispose();
                frame.setVisible(false);
            }
        };
        proceed.addActionListener(proceedAction);
        footerPanel.add(proceed);

        footerPanel.revalidate();
        footerPanel.repaint();
    }

    public double calculateSingleItemPrice() {
        double price = 120.0; // Base price
        
        if (selectedSize.equals("Large")) price += 30.0;
        else if (selectedSize.equals("Medium")) price += 15.0;
        
        price += selectedToppings.size() * 15.0;
        
        return price;
    }

    public void updatePrice() {
        totalPrice = calculateSingleItemPrice();
        if (costLabel != null) {
            costLabel.setText("P" + String.format("%.2f", totalPrice));
        }
    }

    public void setupNamePanel() {
        setupDescription();

        K_Co.setText("K. Co");
        K_Co.setForeground(new Color(0x5e3219));
        K_Co.setFont(new Font("Gugi", Font.BOLD, 35));
        K_Co.setBorder(BorderFactory.createEmptyBorder(10, 50, 0, 0));

        logoPanel.setLayout(new BorderLayout());
        logoPanel.add(K_Co, BorderLayout.WEST);
        logoPanel.setOpaque(false);

        title.setText(name);
        title.setFont(new Font("Poppins SemiBold", Font.BOLD, 45));
        title.setForeground(Color.BLACK);
        title.setBorder(BorderFactory.createEmptyBorder(-15, 0, 0, 0));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        drinkNamePanel.setLayout(new BorderLayout());
        drinkNamePanel.add(title);
        drinkNamePanel.setOpaque(false);

        description.setText(desc);
        description.setFont(new Font("Roboto Flex Regular", Font.BOLD, 15));
        description.setForeground(Color.BLACK);
        description.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        description.setHorizontalAlignment(SwingConstants.CENTER);

        drinkDescPanel.setLayout(new BorderLayout());
        drinkDescPanel.add(description);
        drinkDescPanel.setOpaque(false);

        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));
        namePanel.setBackground(Color.WHITE);
        namePanel.add(logoPanel, BorderLayout.NORTH);
        namePanel.add(drinkNamePanel, BorderLayout.CENTER);
        namePanel.add(drinkDescPanel, BorderLayout.SOUTH);
    }

    public void setupAddOnPanel() {
        sizePanel.setLayout(new BoxLayout(sizePanel, BoxLayout.Y_AXIS));
        sizePanel.add(optionHeaderPanel("Size: ", "Pick 1"));
        
        JPanel sizeOptPanel = new JPanel();
        
        String [] sizeIMG = {"Large Cup.png","Large Cup.png", "Large Cup.png"};
        String [] sizeOption = {"Small", "Medium", "Large"};
        String [] sizePrice = {"120.00", "135.00", "150.00"};
        
        sizeOptPanel.add(setupOptionsPanel(1, 3, 120, 40, 400, 3, sizeIMG, sizeOption, sizePrice));

        milkPanel.setLayout(new BoxLayout(milkPanel, BoxLayout.Y_AXIS));
        milkPanel.add(optionHeaderPanel("Milk Options: ", "Pick 1"));

        JPanel milkOptPanel = new JPanel();
        milkOptPanel.setLayout(new BoxLayout(milkOptPanel, BoxLayout.Y_AXIS));
        
        String [] milkIMG = {"", "", "", ""};
        String [] milkOption = {"Whole Milk", "Chocolate Drizzle", "Caramel Drizzle", "Cinnamon Powder"};
        String [] milkPrice = {"", "", "", ""};
        
        milkOptPanel.add(setupOptionsPanel(2, 2, 175, 40, 375, 4, milkIMG, milkOption, milkPrice));

        toppingsPanel.setLayout(new BoxLayout(toppingsPanel, BoxLayout.Y_AXIS));
        toppingsPanel.add(optionHeaderPanel("Toppings: ", "Pick 1"));

        JPanel toppingsOptPanel = new JPanel();
        toppingsOptPanel.setLayout(new BoxLayout(toppingsOptPanel, BoxLayout.Y_AXIS));
        
        String [] toppingsIMG = {"", "", ""};
        String [] toppingsOption = {"Whipped Cream", "Matcha Powder", "Vanilla Syrup"};
        String [] toppingsPrice = {"15.00", "15.00", "15.00"};
        
        toppingsOptPanel.add(setupOptionsPanel(1, 3, 180, 40, 450, 3, toppingsIMG, toppingsOption, toppingsPrice));

        addOnPanel.setLayout(new BoxLayout(addOnPanel, BoxLayout.Y_AXIS));

        addOnPanel.add(sizePanel);
        addOnPanel.add(sizeOptPanel);
        addOnPanel.add(milkPanel);
        addOnPanel.add(milkOptPanel);
        addOnPanel.add(toppingsPanel);
        addOnPanel.add(toppingsOptPanel);

        sizePanel.setOpaque(false);
        sizeOptPanel.setOpaque(false);
        milkPanel.setOpaque(false);
        milkOptPanel.setOpaque(false);
        toppingsPanel.setOpaque(false);
        toppingsOptPanel.setOpaque(false);
        addOnPanel.setOpaque(false);
    }

    public JPanel setupOptionsPanel(int row, int col, int w, int h, int width, int count, String[] pic, String[] bLabel, String[] sizePrice) {
        Font bFont = new Font("Poppins SemiBold", Font.PLAIN, 17);
        Font pFont = new Font("Open Sans", Font.PLAIN, 14);
        
        RoundedToggleButton[] groupB = new RoundedToggleButton[count];
        JLabel[] groupL = new JLabel[count];

        JPanel gridPanel = new JPanel(new GridLayout(row, col, 10, 0));
        gridPanel.setOpaque(false);
        gridPanel.setMaximumSize(new Dimension(width, Integer.MAX_VALUE));

        ButtonGroup groupBtn = new ButtonGroup(); 
        
        for (int i = 0; i < count; i++) {
        	 JPanel wrapperPanel = new JPanel();
             wrapperPanel.setLayout(new BoxLayout(wrapperPanel, BoxLayout.Y_AXIS));
             wrapperPanel.setOpaque(false);

             String labelB = bLabel[i];
             String labelP = sizePrice[i];
             String picIm = pic[i];

             ImageIcon image = new ImageIcon(picIm);
             JLabel img = new JLabel(image);

             JLabel price = new JLabel();

             RoundedToggleButton button = new RoundedToggleButton(w, h, labelB);
             button.setFont(bFont);
             price.setFont(pFont);

             img.setAlignmentX(Component.CENTER_ALIGNMENT);
             button.setAlignmentX(Component.CENTER_ALIGNMENT);
             price.setAlignmentX(Component.CENTER_ALIGNMENT);

             boolean hasLabelB = labelB != null && !labelB.trim().isEmpty();
             boolean hasLabelP = labelP != null && !labelP.trim().isEmpty();

             if (hasLabelP) {
                 price.setText("₱" + labelP);
             } else {
                 price.setVisible(false);
                 price.setText("null");
             }

             if (!hasLabelB) {
                 button.setVisible(false);
                 img.setVisible(false);
             } else {
                 groupBtn.add(button);
             }
             
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (hasLabelP) {
                        System.out.println("Clicked: " + labelB);
                        System.out.println("Price: ₱" + labelP);
                        
                        if (Arrays.asList("Small", "Medium", "Large").contains(labelB)) {
                            selectedSize = labelB;
                        } else if (Arrays.asList("Whole Milk", "Chocolate Drizzle", "Caramel Drizzle", "Cinnamon Powder").contains(labelB)) {
                            selectedMilk = labelB;
                        } else if (Arrays.asList("Whipped Cream", "Matcha Powder", "Vanilla Syrup").contains(labelB)) {
                            if (button.isSelected()) {
                                if (!selectedToppings.contains(labelB)) {
                                    selectedToppings.add(labelB);
                                }
                            } else {
                                selectedToppings.remove(labelB);
                            }
                        }
                    } else {
                        System.out.println("Clicked: " + labelB);
                        if (Arrays.asList("Whole Milk", "Chocolate Drizzle", "Caramel Drizzle", "Cinnamon Powder").contains(labelB)) {
                            selectedMilk = labelB;
                        }
                    }
                    updatePrice();
                }
            });

            wrapperPanel.add(img);
            wrapperPanel.add(Box.createVerticalStrut(5));
            wrapperPanel.add(button);
            wrapperPanel.add(Box.createVerticalStrut(5));
            wrapperPanel.add(price);

            gridPanel.add(wrapperPanel);

            groupB[i] = button;
            groupL[i] = price;
        }

        optionGroups.add(groupB);
        priceLabel.add(groupL);

        return gridPanel;
    }
        
    public void setupDescription() {
        name = "<html><p style='text-align: center;'>Matcha Tea Latte</p></html>";
        desc = "<html><p style='width: 450px; text-align: center;'>A perfect blend of premium matcha green tea "
                + "and steamed milk, creating a smooth and creamy beverage with the perfect balance of "
                + "earthy tea flavors and rich dairy. Customize with your choice of milk and toppings.</p></html>";
    }

    public JPanel optionHeaderPanel(String option, String pick) {
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.X_AXIS));
        headerPanel.setBorder(new MatteBorder(1, 0, 0, 0, new Color(0xE8E8E8)));

        JLabel optionLabel = new JLabel(option);
        optionLabel.setFont(new Font("Poppins SemiBold", Font.PLAIN, 18));
        optionLabel.setForeground(Color.black);
        optionLabel.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 0));

        JLabel pickLabel = new JLabel(pick);
        pickLabel.setFont(new Font("Poppins SemiBold", Font.PLAIN, 18));
        pickLabel.setForeground(Color.black);
        pickLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 50));

        headerPanel.add(optionLabel);
        headerPanel.add(Box.createHorizontalGlue());
        headerPanel.setOpaque(false);
        headerPanel.add(pickLabel);

        return headerPanel;
    }
    
    public static void main(String[] args) {
        new coldnoncoffee_MatchaTeaLatte();
    }

    public void setMenuReference(Menu menu) {
        this.menuReference = menu;
        frame.pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);
        frame.setVisible(true);
    }

    public void updateQuantityAndPrice() {
        quantityLabel.setText(String.valueOf(quantity));
        double singlePrice = calculateSingleItemPrice();
        totalPrice = singlePrice * quantity;
        if (costLabel != null) {
            costLabel.setText("P" + String.format("%.2f", totalPrice));
        }
    }
}