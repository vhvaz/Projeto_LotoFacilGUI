import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class LotoFacilGUI extends JFrame {

    private Random random = new Random();
    private JButton apostarNumeroBtn, apostarLetraBtn, apostarParImparBtn, sairBtn;
    private JLabel statusLabel;

    public LotoFacilGUI() {
        super("LOTO FÁCIL");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setLocationRelativeTo(null);

        inicializarComponentes();
        configurarEventos();
    }
    private void inicializarComponentes() {
        apostarNumeroBtn = new JButton("Apostar de 0 a 100");
        apostarLetraBtn = new JButton("Apostar de A a Z");
        apostarParImparBtn = new JButton("Apostar em número par");
        sairBtn = new JButton("Sair");
        statusLabel = new JLabel("Escolha uma opção:");

        // define alinhamento e adiciona espaçamento vertical
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        apostarNumeroBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        apostarLetraBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        apostarParImparBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        sairBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        // adiciona componentes ao JFrame
        add(Box.createVerticalStrut(10));
        add(statusLabel);
        add(Box.createVerticalStrut(10));
        add(apostarNumeroBtn);
        add(Box.createVerticalStrut(5));
        add(apostarLetraBtn);
        add(Box.createVerticalStrut(5));
        add(apostarParImparBtn);
        add(Box.createVerticalStrut(10));
        add(sairBtn);
    }

    private void configurarEventos() {
        apostarNumeroBtn.addActionListener(e -> apostarNumero());
        apostarLetraBtn.addActionListener(e -> apostarLetra());
        apostarParImparBtn.addActionListener(e -> apostarParImpar());
        sairBtn.addActionListener(e -> System.exit(0));
    }

    private void apostarNumero() {
        String input = JOptionPane.showInputDialog(this, "Digite um número de 0 a 100:");
        try {
            int aposta = Integer.parseInt(input);
            if (aposta < 0 || aposta > 100) {
                JOptionPane.showMessageDialog(this, "Aposta inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int numeroSorteado = random.nextInt(101);
            if (aposta == numeroSorteado) {
                JOptionPane.showMessageDialog(this, "Você ganhou R$1.000,00 reais", "Vitória", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Que pena! O número sorteado foi: " + numeroSorteado + ".", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Aposta inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void apostarLetra() {
        String input = JOptionPane.showInputDialog(this, "Digite uma letra de A a Z:");
        if (input != null && input.length() == 1 && Character.isLetter(input.charAt(0))) {
            char aposta = Character.toUpperCase(input.charAt(0));
            char letraPremiada = 'V'; // Letra fixa para exemplo
            if (aposta == letraPremiada) {
                JOptionPane.showMessageDialog(this, "Você ganhou R$500,00 reais", "Vitória", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Que pena! A letra sorteada foi: " + letraPremiada + ".", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Aposta inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void apostarParImpar() {
        String input = JOptionPane.showInputDialog(this, "Digite um número para apostar em número par:");
        try {
            int numero = Integer.parseInt(input);
            if (numero % 2 == 0) {
                JOptionPane.showMessageDialog(this, "Você ganhou R$100,00 reais.", "Vitória", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Você escolheu um número ímpar. Tente novamente!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, digite um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LotoFacilGUI().setVisible(true));
    }
}
