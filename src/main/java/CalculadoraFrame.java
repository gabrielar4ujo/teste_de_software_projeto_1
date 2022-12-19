import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraFrame extends JFrame{
    private JButton voltarButton;
    private JTextField valorAInput;
    private JTextField valorBInput;
    private JLabel errorCText;
    private JLabel errorAText;
    private JButton calcularButton;
    private JLabel resultadoText;
    private JTextField valorCInput;
    private JLabel errorBText;
    private JPanel calculadoraFrame;
    private JTextField valorDInput;

    public CalculadoraFrame (JFrame sistema) {
        setContentPane(calculadoraFrame);
        setTitle("Calculadora");
        setSize(800,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setBackground(new Color(56, 56, 56));

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sistema.setVisible(true);
                setVisible(false);
                resultadoText.setText("Resultado irá aparecer aqui...");
                valorAInput.setText("");
            }
        });
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valorA = "";
                try {
                    valorA = valorAInput.getText();
                    if (valorAInput.getText() != ""){
                        Sistema sistema = new Sistema();
                        try {
                            resultadoText.setText(Double.toString(sistema.calculadora(valorA)));
                        } catch (Exception ex) {
                            throw new RuntimeException(ex.getMessage());
                        }
                    } else {
                        resultadoText.setText("Valor inválido");
                    }
                } catch (Exception ex) {
                    resultadoText.setText(ex.getMessage());
                }

                resultadoText.setSize(600,30);

            }
        });
    }
}
