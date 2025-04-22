import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

/**
 * GUI window for managing the appointment queue.
 */
public class AppointmentQueue extends JFrame {
    private Queue<String> appointmentQueue = new LinkedList<>(); // Queue of pet names
    private JTextArea queueDisplay;

    public AppointmentQueue() {
        setTitle("Appointment Queue");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center window

        // Create panel with BoxLayout to stack components vertically
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding

        // Create form elements
        JTextField petNameField = new JTextField(15);
        JButton addBtn = createButton("Add to Queue", e -> addPetToQueue(petNameField.getText()));
        JButton serveBtn = createButton("Serve Next Pet", e -> serveNextPet());

        // Display area for current queue
        queueDisplay = new JTextArea(10, 30);
        queueDisplay.setEditable(false);
        JScrollPane scroll = new JScrollPane(queueDisplay);

        // Add components to the panel
        panel.add(new JLabel("Enter Pet Name:"));
        panel.add(petNameField);
        panel.add(addBtn);
        panel.add(serveBtn);
        panel.add(scroll);

        // Add panel to frame and show it
        add(panel);
        setVisible(true);
    }

    // Adds a pet to the queue and updates the display
    private void addPetToQueue(String petName) {
        if (!petName.trim().isEmpty()) {
            appointmentQueue.add(petName);
            updateQueueDisplay();
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a pet name.");
        }
    }

    // Serves the next pet in the queue
    private void serveNextPet() {
        if (!appointmentQueue.isEmpty()) {
            String servedPet = appointmentQueue.poll(); // Dequeue (remove the first pet)
            JOptionPane.showMessageDialog(this, "Serving: " + servedPet);
            updateQueueDisplay();
        } else {
            JOptionPane.showMessageDialog(this, "No pets in the queue.");
        }
    }

    // Updates the queue display area
    private void updateQueueDisplay() {
        StringBuilder sb = new StringBuilder();
        int pos = 1;
        for (String pet : appointmentQueue) {
            sb.append(pos++).append(". ").append(pet).append("\n");
        }
        queueDisplay.setText(sb.toString());
    }

    // Helper method to create styled buttons
    private JButton createButton(String text, ActionListener action) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(33, 150, 243)); // Blue color
        button.setForeground(Color.BLACK); // Black text color
        button.setFocusPainted(false);
        button.addActionListener(action);
        return button;
    }

    public static void main(String[] args) {
        // This will launch the AppointmentQueue when the program runs
        SwingUtilities.invokeLater(AppointmentQueue::new);
    }
}
