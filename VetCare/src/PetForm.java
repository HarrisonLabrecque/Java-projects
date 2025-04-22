import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;

/**
 * GUI form for adding a pet to the database.
 */
public class PetForm extends JFrame {
    public PetForm() {
        setTitle("Manage Pets");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center window

        // Create panel with GridLayout for form fields
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding

        // Create labels and text fields
        JLabel nameLabel = new JLabel("Pet Name:");
        JTextField nameField = new JTextField(15);
        JLabel speciesLabel = new JLabel("Species:");
        JTextField speciesField = new JTextField(15);
        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField(5);

        // Add components to panel
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(speciesLabel);
        panel.add(speciesField);
        panel.add(ageLabel);
        panel.add(ageField);

        // Save button
        JButton saveBtn = new JButton("Save Pet");
        saveBtn.setFont(new Font("Arial", Font.BOLD, 14));
        saveBtn.setBackground(new Color(33, 150, 243)); // Blue color
        saveBtn.setForeground(Color.WHITE);
        saveBtn.addActionListener((ActionEvent e) -> {
            String name = nameField.getText();
            String species = speciesField.getText();
            int age = Integer.parseInt(ageField.getText());

            try (Connection conn = DBHelper.connect();
                 PreparedStatement stmt = conn.prepareStatement("INSERT INTO pets (name, species, age) VALUES (?, ?, ?)")) {
                stmt.setString(1, name);
                stmt.setString(2, species);
                stmt.setInt(3, age);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Pet added successfully!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error saving pet: " + ex.getMessage());
            }
        });

        // Add save button to panel
        panel.add(new JLabel()); // Empty label for spacing
        panel.add(saveBtn);

        // Add panel to the window and show it
        add(panel);
        setVisible(true);
    }
}
