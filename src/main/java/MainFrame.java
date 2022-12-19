import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainFrame extends JFrame{
    private JTextField emailInput;
    private JTextField senhaInput;
    private JButton cadastrarButton;
    private JPanel cadastrarPanel;
    private JLabel errorEmail;
    private JLabel errorSenha;
    private JTextField nomeInput;
    private JLabel errorNome;
    private JLabel senhaText;
    private JLabel emailText;
    private JLabel nomeText;
    private JLabel cadastroText;
    private JLabel senhaInfoText;

    private static boolean emailIsValid(String emailAddress) {
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    private static boolean passwordIsValid(final String password) {
        final String PASSWORD_PATTERN =
                "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,}$";
        final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    public MainFrame () {
        setContentPane(cadastrarPanel);
        setBackground(new Color(56, 56, 56));
        setTitle("Cadastrar");
        setSize(800,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nomeInput.getText();
                String email = emailInput.getText();
                String password = senhaInput.getText();
                if (name.length() < 2) {
                    errorNome.setText("Nome Inválido");
                    errorNome.setSize(100,15);
                } else {
                    errorNome.setText("");
                }
                if (!emailIsValid(email)) {
                    errorEmail.setText("Email Inválido");
                    errorEmail.setSize(100,15);
                } else {
                    errorEmail.setText("");
                }
                if (!passwordIsValid(password)) {
                    errorSenha.setText("Senha Inválida");
                    errorSenha.setSize(100,15);
                } else {
                    errorSenha.setText("");
                }
                if (emailIsValid(email) && passwordIsValid(password)) {
                    try {
                        Usuario usuario = new Usuario(name, email, password);
                        setVisible(false);
                        new SistemaFrame(name).setVisible(true);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }

                }
            }
        });
    }


}
