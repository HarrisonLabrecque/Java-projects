import javax.swing.*;

// Static info panel for the veterinarian
public class VetInfo extends JFrame {
    public VetInfo() {
        setTitle("Veterinarian Info");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Static text about the vet
        JTextArea info = new JTextArea("Dr. Jane Smith\nSpecialty: Small Animals\nExperience: 10+ Years\nContact: dr.jane@vetcare.com");
        info.setEditable(false);
        add(info);
        setVisible(true);
    }
}
