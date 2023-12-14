import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private JButton vatDisplayButton;
    private JButton totalCostCalculatorButton;
    private JButton itemSelectionButton;

    private JPanel vatDisplayPanel;
    private JPanel totalCostCalculatorPanel;
    private JPanel itemSelectionPanel;

    public MainGUI() {
        setTitle("Multi GUI Interface");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        // Create instances of your GUI classes (replace with your classes)
        vatDisplayPanel = new VATDisplayGUI().createMainPanel();
        totalCostCalculatorPanel = new TotalCostCalculatorGUI().createMainPanel();
        itemSelectionPanel = new ItemSelectionGUI().createMainPanel();

        // Add GUI panels to the main panel with unique names
        mainPanel.add(vatDisplayPanel, "VAT_DISPLAY");
        mainPanel.add(totalCostCalculatorPanel, "TOTAL_COST_CALCULATOR");
        mainPanel.add(itemSelectionPanel, "ITEM_SELECTION");

        // Buttons to switch between different GUIs
        vatDisplayButton = new JButton("VAT Display");
        totalCostCalculatorButton = new JButton("Total Cost Calculator");
        itemSelectionButton = new JButton("Item Selection");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(vatDisplayButton);
        buttonPanel.add(totalCostCalculatorButton);
        buttonPanel.add(itemSelectionButton);

        getContentPane().add(buttonPanel, BorderLayout.NORTH);
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        // Button actions to switch between GUIs
        vatDisplayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "VAT_DISPLAY");
            }
        });

        totalCostCalculatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "TOTAL_COST_CALCULATOR");
            }
        });

        itemSelectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "ITEM_SELECTION");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainGUI());
    }
}

