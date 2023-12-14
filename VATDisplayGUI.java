import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class VATDisplayGUI extends JPanel {
    private HashMap<String, Double> vatRates;
    private JLabel vatLabel;

    public VATDisplayGUI() {
        vatRates = new HashMap<>();
        vatRates.put("Luxury Item 1", 0.20);
        vatRates.put("Luxury Item 2", 0.15);
        vatRates.put("Essential Item 1", 0.10);
        vatRates.put("Essential Item 2", 0.08);
        vatRates.put("Gift Item 1", 0.05);
        vatRates.put("Gift Item 2", 0.03);

        // Construct the main panel
        JPanel panel = createMainPanel();
        add(panel); // Add the constructed panel to this VATDisplayGUI JPanel
    }

    public JPanel createMainPanel() {
        JPanel panel = new JPanel();

        String[] items = vatRates.keySet().toArray(new String[0]);
        JComboBox<String> itemsDropDown = new JComboBox<>(items);

        vatLabel = new JLabel("VAT Rate: ");

        panel.add(new JLabel("Select Item: "));
        panel.add(itemsDropDown);
        panel.add(vatLabel);

        JButton selectButton = new JButton("Select");
        panel.add(selectButton);

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) itemsDropDown.getSelectedItem();
                double vatRate = vatRates.get(selectedItem);

                vatLabel.setText("VAT Rate: " + (vatRate * 100) + "%");
            }
        });

        return panel;
    }

    // Other methods and components specific to VATDisplayGUI class
}
