import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Usuario {
    private String nome, email, senha;
    public Usuario(String nome, String email, String senha) throws Exception {
        this.nome = null;
        if(emailIsValid(email) && passwordIsValid(senha)) {
            this.email = email;
            this.senha = senha;
            this.nome = nome;
        } else {
            throw new Exception("Erro ao cadastrar");
        }
    }

    //Falta mudar a regex para restringir mínimo de 2 dígitos na senha
    private static boolean passwordIsValid(final String password) {
        final String PASSWORD_PATTERN =
                "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,}$";
        final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    private static boolean emailIsValid(String emailAddress) {
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    public boolean sucessoNaCriacaoDeUsuario(){
        if(getNome()!=null) return true;
        return false;
    }
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}