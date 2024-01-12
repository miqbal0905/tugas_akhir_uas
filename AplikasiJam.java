import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AplikasiJam extends JFrame {

    private JLabel labelJam;

    public AplikasiJam() {
        setTitle("Aplikasi Jam");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        labelJam = new JLabel();
        labelJam.setHorizontalAlignment(JLabel.CENTER);
        labelJam.setFont(new Font("Arial", Font.PLAIN, 40));

        updateJam();

        Timer timer = new Timer(1000, e -> updateJam());
        timer.start();

        add(labelJam);

        setVisible(true);
    }

    private void updateJam() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String jamSekarang = dateFormat.format(new Date());
        labelJam.setText(jamSekarang);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AplikasiJam());
    }
}
