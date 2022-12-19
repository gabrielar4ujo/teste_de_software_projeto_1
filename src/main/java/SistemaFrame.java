import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaFrame extends JFrame{
    private JPanel sistemaPanel;
    private JButton calcularRaizesButton;
    private JButton classificarTrianguloButton;
    private JButton ehUmRetanguloButton;
    private JButton calculadoraButton;
    private JButton formaUmTrianguloButton;
    private JButton ehTrianguloRetanguloButton;
    private JButton calcularAreaEPerimetroRetanguloButton;
    private JButton calcularAreaEPerimetroCirculoButton;
    private JButton distanciaEntreDoisPontosButton;
    private JLabel sistemaText;

    public SistemaFrame (String name) {
        JFrame raizesFrame =  new RaizesFrame(this);
        JFrame ehTrianguloFrame =  new EhTrianguloFrame(this);
        JFrame classificarTrianguloFrame =  new ClassificarTrianguloFrame(this);
        JFrame ehTrianguloRetanguloFrame =  new EhTrianguloRetanguloFrame(this);
        JFrame perimetroRetanguloFrame =  new PerimetroRetanguloFrame(this);
        JFrame ehRetanguloFrame =  new EhRetanguloFrame(this);
        JFrame perimetroCirculoFrame =  new PerimetroCirculoFrame(this);
        JFrame distanciaDoisPontos =  new DistanciaDoisPontosFrame(this);
        JFrame calculadora =  new CalculadoraFrame(this);
        raizesFrame.setVisible(false);
        ehTrianguloFrame.setVisible(false);
        classificarTrianguloFrame.setVisible(false);
        ehTrianguloRetanguloFrame.setVisible(false);
        perimetroRetanguloFrame.setVisible(false);
        ehRetanguloFrame.setVisible(false);
        perimetroCirculoFrame.setVisible(false);
        distanciaDoisPontos.setVisible(false);
        calculadora.setVisible(false);

        char newName[] = new char[name.length()];
        setContentPane(sistemaPanel);
        if (name.length() > 20) {
            int i = 0;
            for (char c : name.toCharArray()) {
                if (i < 20) {
                    newName[i] = c;
                } else {
                    newName[i] = '.';
                    newName[i + 1] = '.';
                    newName[i + 2] = '.';
                    break;
                }
                i++;
            }
            name =  new String(newName);
        }
        sistemaText.setText(name+", escolha uma função");
        setTitle("Sistema");
        setSize(800,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setBackground(new Color(56, 56, 56));

        calcularRaizesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                raizesFrame.setVisible(true);
                setVisible(false);
            }
        });
        formaUmTrianguloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ehTrianguloFrame.setVisible(true);
                setVisible(false);
            }
        });
        classificarTrianguloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                classificarTrianguloFrame.setVisible(true);
                setVisible(false);
            }
        });
        ehTrianguloRetanguloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ehTrianguloRetanguloFrame.setVisible(true);
                setVisible(false);
            }
        });
        calcularAreaEPerimetroRetanguloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perimetroRetanguloFrame.setVisible(true);
                setVisible(false);
            }
        });
        ehUmRetanguloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ehRetanguloFrame.setVisible(true);
                setVisible(false);
            }
        });
        calcularAreaEPerimetroCirculoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perimetroCirculoFrame.setVisible(true);
                setVisible(false);
            }
        });
        distanciaEntreDoisPontosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                distanciaDoisPontos.setVisible(true);
                setVisible(false);
            }
        });
        calculadoraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculadora.setVisible(true);
                setVisible(false);
            }
        });
    }
}
