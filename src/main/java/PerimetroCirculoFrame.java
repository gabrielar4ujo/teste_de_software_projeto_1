import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class PerimetroCirculoFrame extends JFrame{
    private JButton voltarButton;
    private JTextField valorAInput;
    private JTextField valorBInput;
    private JLabel errorCText;
    private JLabel errorAText;
    private JButton calcularButton;
    private JLabel resultadoText;
    private JTextField valorCInput;
    private JLabel valorAText;
    private JLabel errorBText;
    private JPanel perimetroCirculoFrame;
    private JTextField valorDInput;

    public PerimetroCirculoFrame (JFrame sistema) {
        setContentPane(perimetroCirculoFrame);
        setTitle("Perímetro e área de um circulo    ");
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
                resultadoText.setText("Resultado ira aparecer aqui...");
                valorAInput.setText("");
            }
        });
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valorA = 0;
                try {
                    valorA = Double.parseDouble(valorAInput.getText());
                    if (valorAInput.getText() != ""){
                        Sistema sistema = new Sistema();
                        try {
                            resultadoText.setText("Perímetro: " + new DecimalFormat("#,##0.00").format(sistema.perimetroCirculo(valorA)) + " Área: " + new DecimalFormat("#,##0.00").format(sistema.areaCirculo(valorA)));
                        } catch (Exception ex) {
                            throw new RuntimeException(ex.getMessage());
                        }
                    } else {
                        resultadoText.setText("Valor inválido");
                    }
                } catch (Exception ex) {
                    resultadoText.setText(ex.getMessage());
                }

                resultadoText.setSize(350,30);

            }
        });
    }
}
