import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


/**
 * Main application window for VetCare.
 * Provides buttons to open different features.
 */
public class VetCareApp {
    public static void main(String[] args) {
        // Set the look and feel to modern style
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create main window
        JFrame frame = new JFrame("VetCare Management System");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center window

        // Panel for buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10)); // 3 buttons with space between them
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30)); // Padding

        // Buttons with action listeners
        JButton petBtn = createButton("Manage Pets", e -> new PetForm());
        JButton queueBtn = createButton("Live Appointment Queue", e -> new AppointmentQueue());
        JButton vetBtn = createButton("Vet Info", e -> new VetInfo());

        // Add buttons to panel
        panel.add(petBtn);
        panel.add(queueBtn);
        panel.add(vetBtn);

        // Add panel to frame
        frame.add(panel);
        frame.setVisible(true);
    }

    // Helper method to create buttons with a consistent style
    private static JButton createButton(String text, ActionListener action) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(new Color(33, 150, 243)); // Blue color
        button.setForeground(Color.BLACK); // Black text
        button.setFocusPainted(false);
        button.setToolTipText("Click to " + text.toLowerCase());
        button.addActionListener(action);
        return button;
    }
}
