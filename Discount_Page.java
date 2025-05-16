package Kofi_Co;

import javax.swing.*;
import java.awt.*;
import Kofi_Co_Fundamentals.*;

public class Discount_Page {
    private static final Color BROWN_COLOR = new Color(0x5e3219);
    private static final Color LIGHT_GRAY = new Color(0xE7E5E5);
    private static final Color BORDER_GRAY = new Color(220, 220, 220);
    private static final int MAX_CARD_LENGTH = 16;
    
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JPanel mainPanel;
    private final Topheader topheader = new Topheader();

    public Discount_Page() {
        mainPanel = new JPanel(new CardLayout());
        mainPanel.setBackground(Color.WHITE);
        mainPanel.add(getRegisterPanel(), "Senior");
        mainPanel.add(getRegisterPanel(), "PWD");
        mainPanel.add(getRegisterPanel(), "Member");
        ((CardLayout)mainPanel.getLayout()).show(mainPanel, "Senior");
    }

    private JPanel getRegisterPanel() {
        new ImportedFonts().Fonts();
        topheader.Topheadercomps();

        JPanel panel = new JPanel(null);
        panel.setBackground(Color.WHITE);
        panel.add(topheader);

        if (cardLayout != null && cardPanel != null) {
            BackButton backButton = new BackButton();
            backButton.setNavigation(cardLayout, cardPanel, "Discount Options");
            panel.add(backButton);
        }

        JLabel titleLabel = new JLabel("K. Co", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Gugi", Font.BOLD, 140));
        titleLabel.setForeground(BROWN_COLOR);
        titleLabel.setBounds(153, 103, 372, 170);
        panel.add(titleLabel);

        JLabel apiLabel = new JLabel("Type API No.", SwingConstants.CENTER);
        apiLabel.setFont(new Font("Poppins Regular", Font.PLAIN, 35));
        apiLabel.setForeground(Color.BLACK);
        apiLabel.setBounds(140, 260, 400, 100);
        panel.add(apiLabel);

        JTextField inputField = createInputField();
        panel.add(inputField);

        JPanel keypad = new JPanel(new GridLayout(4, 3, 10, 10));
        keypad.setBackground(Color.WHITE);
        keypad.setBounds(161, 420, 350, 200);
        
        String[] keys = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "C", "0", "X" };
        for (String key : keys) {
            keypad.add(createKeyButton(key, inputField));
        }
        panel.add(keypad);

        JButton confirmButton = new RoundedButton();
        confirmButton.setText("Confirm");
        confirmButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        confirmButton.setBounds(237, 640, 200, 50);
        confirmButton.setFocusable(false);
        confirmButton.setBorderPainted(false);
        confirmButton.setBackground(BROWN_COLOR);
        confirmButton.setForeground(Color.WHITE);
        confirmButton.addActionListener(e -> {
            String input = inputField.getText().trim();
            if (!input.isEmpty() && input.length() >= 4) {  // Basic validation for ID number
                DiscountManager.getInstance().setDiscountApplied(true);
                cardLayout.show(cardPanel, "Total");
            } else {
                JOptionPane.showMessageDialog(panel, 
                    "Please enter a valid ID number", 
                    "Invalid Input", 
                    JOptionPane.WARNING_MESSAGE);
            }
        });
        panel.add(confirmButton);

        return panel;
    }

    private JTextField createInputField() {
        JTextField field = new RoundedJtextfield(20);
        field.setFont(new Font("Poppins Regular", Font.PLAIN, 30));
        field.setBounds(140, 335, 400, 50);
        field.setHorizontalAlignment(JTextField.CENTER);
        field.setEditable(false);
        field.setFocusable(false);
        field.setBackground(LIGHT_GRAY);
        field.setForeground(Color.BLACK);
        field.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(BORDER_GRAY, 1),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        return field;
    }

    private JButton createKeyButton(String label, JTextField input) {
        JButton button = new JButton(label);
        button.setFont(new Font("Poppins Regular", Font.PLAIN, 28));
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusable(false);
        button.setForeground(Color.BLACK);
        button.addActionListener(e -> handleInput(label, input));
        return button;
    }

    private void handleInput(String input, JTextField field) {
        String current = field.getText().replaceAll("[\\s/]", "");
        switch (input) {
            case "C" -> field.setText("");
            case "X" -> {
                if (!current.isEmpty()) {
                    field.setText(current.substring(0, current.length() - 1));
                }
            }
            default -> {
                if (current.length() < MAX_CARD_LENGTH && input.matches("\\d")) {
                    field.setText(current + input);
                }
            }
        }
    }

    public void setCardLayout(CardLayout layout, JPanel panel) {
        this.cardLayout = layout;
        this.cardPanel = panel;
        for (Component comp : mainPanel.getComponents()) {
            if (comp instanceof JPanel) {
                BackButton backButton = new BackButton();
                backButton.setNavigation(layout, panel, "Discount Options");
                ((JPanel) comp).add(backButton);
                ((JPanel) comp).revalidate();
                ((JPanel) comp).repaint();
            }
        }
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JPanel getBlankPanel() {
        JPanel blank = new JPanel();
        blank.setBackground(Color.WHITE);
        return blank;
    }
}