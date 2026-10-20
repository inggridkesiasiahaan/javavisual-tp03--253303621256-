package view;

import javax.swing.*;
import java.awt.Component;
import java.awt.Dimension;
import java.util.List;
import com.unpri.charactermanager.model.Character;

public class MainWindow extends JFrame {
    private List<Character> characterList;
    private JPanel mainPanel;

    public MainWindow(List<Character> characterList) {
        super("Character Manager - Sprint 3 (GUI)");
        this.characterList = characterList;
        
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        JLabel titleLabel = new JLabel("=== DAFTAR KARAKTER (GUI) ===");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        for (Character c : characterList) {
            JLabel charLabel = new JLabel(
                c.getName() + " (Tipe: " + c.getType()
                    + " | Level: " + c.getLevel() + ")"
            );
            charLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            mainPanel.add(charLabel);
            mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        }

        int totalLevel = 0;
        for (Character c : characterList) {
            totalLevel += c.getLevel();
        }
        double averageLevel = characterList.isEmpty()
            ? 0
            : (double) totalLevel / characterList.size();

        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        JLabel separatorLabel = new JLabel(
            "--------------------------------------------------"
        );
        separatorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(separatorLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        JLabel statsLabel = new JLabel(
            "Rata-rata Level Karakter: "
                + String.format("%.2f", averageLevel)
        );
        statsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(statsLabel);

        add(mainPanel);
    }
}