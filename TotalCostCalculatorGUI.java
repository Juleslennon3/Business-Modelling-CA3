import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.HashMap;

public class TotalCostCalculatorGUI extends JPanel {
    private HashMap<String, Double> itemPrices;
    private JLabel totalCostLabel;
    private JLabel vatLabel;
    private double totalCost;

    public TotalCostCalculatorGUI() {
        itemPrices = new HashMap<>();
        itemPrices.put("Luxury Item 1", 50.0);
        itemPrices.put("Luxury Item 2", 60.0);
        itemPrices.put("Essential Item 1", 30.0);
        itemPrices.put("Essential Item 2", 25.0);
        itemPrices.put("Gift Item 1", 20.0);
        itemPrices.put("Gift Item 2", 15.0);

        totalCost = 0.0;

   
        JPanel panel = createMainPanel();
        add(panel); // Add the constructed panel to this TotalCostCalculatorGUI JPanel
    }

    public JPanel createMainPanel() {
        JPanel panel = new JPanel();

        JComboBox<String> itemsDropDown = new JComboBox<>(itemPrices.keySet().toArray(new String[0]));
        JButton addItemButton = new JButton("Add Item");

        totalCostLabel = new JLabel("Total Cost: ");
        vatLabel = new JLabel("VAT: ");

        panel.add(new JLabel("Select Item: "));
        panel.add(itemsDropDown);
        panel.add(addItemButton);
        panel.add(totalCostLabel);
        panel.add(vatLabel);

        JButton confirmButton = new JButton("Confirm");
        panel.add(confirmButton);

        DecimalFormat df = new DecimalFormat("#.##");

        addItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) itemsDropDown.getSelectedItem();
                double itemPrice = itemPrices.get(selectedItem);
                totalCost += itemPrice;

                totalCostLabel.setText("Total Cost: $" + df.format(totalCost));
            }
        });

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vatLabel.setText("VAT: $" + df.format(totalCost * 0.2)); // Assuming VAT is 20%, can be altered
            }
        });

        return panel;
    }

}


