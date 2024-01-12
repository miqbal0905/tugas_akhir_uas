import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    private JLabel labelWaktu;
    private JButton tombolStartStop;
    private JButton tombolReset;

    private Timer timer;
    private int detik;

    public Main() {
        setTitle("Stopwatch");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        labelWaktu = new JLabel("00:00:00");
        labelWaktu.setHorizontalAlignment(JLabel.CENTER);
        labelWaktu.setFont(new Font("Arial", Font.PLAIN, 40));

        tombolStartStop = new JButton("Start");
        tombolReset = new JButton("Reset");

        tombolStartStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleStartStopButtonClick();
            }
        });

        tombolReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleResetButtonClick();
            }
        });

        JPanel tombolPanel = new JPanel();
        tombolPanel.add(tombolStartStop);
        tombolPanel.add(tombolReset);

        add(labelWaktu, BorderLayout.CENTER);
        add(tombolPanel, BorderLayout.SOUTH);

        detik = 0;
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleTimerTick();
            }
        });

        setVisible(true);
    }

    private void handleStartStopButtonClick() {
        if (timer.isRunning()) {
            timer.stop();
            tombolStartStop.setText("Start");
        } else {
            timer.start();
            tombolStartStop.setText("Stop");
        }
    }

    private void handleResetButtonClick() {
        timer.stop();
        detik = 0;
        updateWaktuLabel();
        tombolStartStop.setText("Start");
    }

    private void handleTimerTick() {
        detik++;
        updateWaktuLabel();
    }

    private void updateWaktuLabel() {
        int jam = detik / 3600;
        int sisaDetik = detik % 3600;
        int menit = sisaDetik / 60;
        int detikSisa = sisaDetik % 60;

        String waktuFormat = String.format("%02d:%02d:%02d", jam, menit, detikSisa);
        labelWaktu.setText(waktuFormat);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}
