import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DetectorInteligente extends JFrame {

    private JTextArea inputArea;
    private JTextArea logArea;
    private JProgressBar progressBar;
    private JLabel statusLabel;

    public DetectorInteligente() {
        // Configuración de la Ventana
        setTitle("🕵️‍♂️ Scanner de Patrones - V2.0");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(26, 26, 46));

        // Panel Superior: Título y Estado
        JPanel headerPanel = new JPanel(new GridLayout(2, 1));
        headerPanel.setBackground(new Color(22, 33, 62));
        
        JLabel titleLabel = new JLabel("ANALIZADOR FORENSE", SwingConstants.CENTER);
        titleLabel.setForeground(new Color(233, 69, 96));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        
        statusLabel = new JLabel("ESTADO: LISTO PARA ESCANEO", SwingConstants.CENTER);
        statusLabel.setForeground(Color.GREEN);
        
        headerPanel.add(titleLabel);
        headerPanel.add(statusLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Panel Central: Entrada de texto
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setOpaque(false);
        
        inputArea = new JTextArea("Pega aquí el chat sospechoso...");
        inputArea.setBackground(new Color(15, 23, 42));
        inputArea.setForeground(new Color(0, 255, 65));
        inputArea.setCaretColor(Color.WHITE);
        inputArea.setLineWrap(true);
        JScrollPane inputScroll = new JScrollPane(inputArea);
        
        centerPanel.add(new JLabel("  ENTRADA DE TEXTO:", SwingConstants.LEFT), BorderLayout.NORTH);
        centerPanel.getComponent(0).setForeground(Color.LIGHT_GRAY);
        centerPanel.add(inputScroll, BorderLayout.CENTER);
        
        add(centerPanel, BorderLayout.CENTER);

        // Panel Inferior: Botón y Resultados
        JPanel footerPanel = new JPanel(new BorderLayout());
        footerPanel.setOpaque(false);

        JButton scanBtn = new JButton("EJECUTAR ANÁLISIS");
        scanBtn.setBackground(new Color(233, 69, 96));
        scanBtn.setForeground(Color.WHITE);
        scanBtn.setFocusPainted(false);
        scanBtn.setFont(new Font("Arial", Font.BOLD, 14));

        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);

        logArea = new JTextArea(8, 20);
        logArea.setEditable(false);
        logArea.setBackground(Color.BLACK);
        logArea.setForeground(Color.CYAN);
        JScrollPane logScroll = new JScrollPane(logArea);

        footerPanel.add(scanBtn, BorderLayout.NORTH);
        footerPanel.add(progressBar, BorderLayout.CENTER);
        footerPanel.add(logScroll, BorderLayout.SOUTH);

        add(footerPanel, BorderLayout.SOUTH);

        // Lógica del Botón
        scanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarAnalisis();
            }
        });
    }

    private void iniciarAnalisis() {
        String texto = inputArea.getText().toLowerCase();
        logArea.setText("");
        progressBar.setValue(0);
        statusLabel.setText("ESTADO: PROCESANDO...");
        statusLabel.setForeground(Color.YELLOW);

        // Simulación de carga con un Timer
        Timer timer = new Timer(50, new ActionListener() {
            int p = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                p += 5;
                progressBar.setValue(p);
                if (p >= 100) {
                    ((Timer)e.getSource()).stop();
                    mostrarResultados(texto);
                }
            }
        });
        timer.start();
    }

    private void mostrarResultados(String texto) {
        int riesgo = 0;
        String tiempo = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        logArea.append("[" + tiempo + "] INICIANDO REPORTE\n");

        // Diccionario de patrones
        String[] patrones = {"ya se fue", "paso por ti", "borra", "novia", "estoy solo", "nos vemos"};
        String[] desc = {"Oportunidad", "Logística", "Ocultamiento", "Tercero", "Disponibilidad", "Cita"};

        for (int i = 0; i < patrones.length; i++) {
            if (texto.contains(patrones[i])) {
                riesgo += 20;
                logArea.append("🚩 Detectado: " + desc[i] + " (" + patrones[i] + ")\n");
            }
        }

        riesgo = Math.min(riesgo, 100);
        logArea.append("\nNIVEL DE RIESGO: " + riesgo + "%");
        statusLabel.setText("ESCANEO FINALIZADO");
        statusLabel.setForeground(Color.GREEN);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DetectorInteligente().setVisible(true);
        });
    }
}