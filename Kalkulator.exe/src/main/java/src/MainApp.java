package src;

import javax.swing.*;

public class MainApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Kalkulator.exe");
        frame.setSize(414, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String imagePath = "C:\\Users\\bagas\\OneDrive\\Dokumen\\Tugas Telkom\\Tugas Semester 3\\AKA\\Latihan Java\\SimpleGUI\\src\\main\\java\\image\\latarBelakang.jpg";

        BackgroundPanel backgroundPanel = new BackgroundPanel(imagePath);
        frame.setContentPane(backgroundPanel);

        KalkulatorPanel kalkulatorPanel = new KalkulatorPanel();
        kalkulatorPanel.setBounds(0, 0, 400, 500);
        backgroundPanel.setLayout(null);
        backgroundPanel.add(kalkulatorPanel);

        frame.setVisible(true);
    }
}
