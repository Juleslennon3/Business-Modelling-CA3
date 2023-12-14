import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ItemSelectionGUI extends JPanel {
    private ArrayList<String> luxury;
    private ArrayList<String> essential;
    private ArrayList<String> gift;

    public ItemSelectionGUI() {
        luxury = new ArrayList<>();
        luxury.add("Luxury Item 1");
        luxury.add("Luxury Item 2");
        luxury.add("Luxury Item 3");

        essential = new ArrayList<>();
        essential.add("Essential Item 1");
        essential.add("Essential Item 2");
        essential.add("Essential Item 3");

        gift = new ArrayList<>();
        gift.add("Gift Item 1");
        gift.add("Gift Item 2");
        gift.add("Gift Item 3");

        // Construct the main panel
        JPanel panel = createMainPanel();
        add(panel); // Add the constructed panel to this ItemSelectionGUI JPanel
    }

    public JPanel createMainPanel() {
        JPanel panel = new JPanel();

        JComboBox<String> luxuryDropDown = new JComboBox<>(luxury.toArray(new String[0]));
        JComboBox<String> essentialDropDown = new JComboBox<>(essential.toArray(new String[0]));
        JComboBox<String> giftDropDown = new JComboBox<>(gift.toArray(new String[0]));

        panel.add(new JLabel("Luxury:"));
        panel.add(luxuryDropDown);

        panel.add(new JLabel("Essential:"));
        panel.add(essentialDropDown);

        panel.add(new JLabel("Gift:"));
        panel.add(giftDropDown);

        JButton selectButton = new JButton("Select");
        panel.add(selectButton);

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedLuxury = (String) luxuryDropDown.getSelectedItem();
                String selectedEssential = (String) essentialDropDown.getSelectedItem();
                String selectedGift = (String) giftDropDown.getSelectedItem();

                // Perform actions based on the selected items
                // For example:
                System.out.println("Selected Luxury: " + selectedLuxury);
                System.out.println("Selected Essential: " + selectedEssential);
                System.out.println("Selected Gift: " + selectedGift);
            }
        });

        return panel;
    }

    // Other methods and components specific to ItemSelectionGUI class
}


