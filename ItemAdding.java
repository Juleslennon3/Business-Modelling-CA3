import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ItemAdding extends JFrame {
    private List<Item> stock = new ArrayList<>();
    private JComboBox<String> itemsDropdown;

    public ItemAdding() {
        setTitle("Item Management");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main home screen
        JPanel mainPanel = new JPanel();
        JButton addItemButton = new JButton("Add Items");
        JButton viewItemsButton = new JButton("View All Items");
//action listener to call the correct method on click
        addItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAddItemScreen();
            }
        });
    
//add main two buttons to the main panel
        mainPanel.add(addItemButton);
        mainPanel.add(viewItemsButton); //not in use yet

        add(mainPanel);
        setVisible(true);
    }
//new JFrame for adding items 
    private void showAddItemScreen() {
        JFrame addItemFrame = new JFrame("Add Item");
        addItemFrame.setSize(300, 200);
        addItemFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel addItemPanel = new JPanel();
        JLabel nameLabel = new JLabel("Item Name:");
        JTextField nameField = new JTextField(20);
        JLabel typeLabel = new JLabel("Item Type:");
        JComboBox<String> typeDropdown = new JComboBox<>(new String[]{"Luxury", "Essential", "Gift"});
        JLabel expirationLabel = new JLabel("Expiration Date:");
        JTextField expirationField = new JTextField(10);
        JButton addButton = new JButton("Add");
        
        
//ADDS Items to the ArrayList if The fields are filled + item type is set by user with drop down list
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemName = nameField.getText();
                String itemType = (String) typeDropdown.getSelectedItem();
                String expirationDate = expirationField.getText();

                if (!itemName.isEmpty() && !expirationDate.isEmpty()) {
                    Item newItem = new Item(itemName, itemType, expirationDate);
                    stock.add(newItem);
                    JOptionPane.showMessageDialog(null, "Item added successfully!");
                    addItemFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields.");
                }
            }
        });

        addItemPanel.add(nameLabel);
        addItemPanel.add(nameField);
        addItemPanel.add(typeLabel);
        addItemPanel.add(typeDropdown);
        addItemPanel.add(expirationLabel);
        addItemPanel.add(expirationField);
        addItemPanel.add(addButton);

        addItemFrame.add(addItemPanel);
        addItemFrame.setVisible(true);
    }



    public static void main(String[] args) {
        new ItemAdding();
    }
}
