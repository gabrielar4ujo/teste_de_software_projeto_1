import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class Sistema implements FuncionalidadesIF {

  // Falta restringir o cadastro para verificar se está sendo passado dados
  // permitidos
  public Usuario cadastraUsuario(String nome, String email, String senha) throws Exception {
    Usuario usuario = new Usuario(nome, email, senha);
    if (usuario.sucessoNaCriacaoDeUsuario()) {
      return usuario;
    } else {
      throw new Exception("Erro ao cadastrar usuário!");
    }
  }

  public String calculaFuncaoSegundoGrau(double a, double b, double c) throws Exception {
    try {
      Raizes raizes = new Raizes(a, b, c);
      return (raizes.getRaizes());
    } catch (Exception ex) {
      return ex.getMessage();
    }
  }

  public boolean ehTriangulo(double angulo1, double angulo2, double angulo3) throws Exception {
    if ((angulo1 <= 0 || angulo1 > 180) || (angulo2 <= 0 || angulo2 > 180) || (angulo3 <= 0 || angulo3 > 180)) {
      throw new Exception("Erro angulo incorreto!");
    }
    return angulo1 + angulo2 + angulo3 == 180;
  }

  public boolean ehTrianguloRetangulo(double lado1, double lado2, double lado3) throws Exception {
    if(lado1 == 0 || lado2 == 0 || lado3 == 0) return false;
    if ((Math.pow(lado1, 2) + Math.pow(lado2, 2) == Math.pow(lado3, 2))
        || (Math.pow(lado3, 2) + Math.pow(lado2, 2) == Math.pow(lado1, 2))
        || (Math.pow(lado1, 2) + Math.pow(lado3, 2) == Math.pow(lado2, 2)))
      return true;
    return false;
  }

  public boolean ehRetangulo(double angulo1, double angulo2, double angulo3, double angulo4) throws Exception {
    if ((angulo1 <= 0) || (angulo2 <= 0) || (angulo3 <= 0) || (angulo4 <= 0)) {
      throw new Exception("Erro existe ângulo invalido");
    }
    return angulo1 == 90 && angulo2 == 90 && angulo3 == 90 && angulo4 == 90;
  }

  public String classificaTriangulo(double angulo1, double angulo2, double angulo3) throws Exception {
    if (ehTriangulo(angulo1, angulo2, angulo3)) {
      if (ehTrianguloRetangulo(angulo1, angulo2, angulo3))
        return "É um Triângulo Retângulo";
      if ((angulo1 > 90) || (angulo2 > 90) || (angulo3 > 90))
        return "É um Triângulo Obtusângulo";
      else
        return "É um Triângulo Acutângulo";
    }
    return "Os Ângulos informados, não formam um triângulo!";
  }

  public double perimetroRetangulo(double lado1, double lado2) throws Exception {
    if (lado1 > 0 && lado2 > 0) {
      return (lado1 * 2) + (lado2 * 2);
    } else {
      throw new Exception("Erro não é possivel calcular a aréa pois os lados nao formam um retângulo");
    }

  }

  public double areaRetangulo(double lado1, double lado2) throws Exception {
    if (lado1 > 0 && lado2 > 0) {
      return lado1 * lado2;
    } else {
      throw new Exception("Erro não é possivel calcular a aréa pois os lados nao formam um retangulo");
    }
  }

  public double calculadora(String expressao) throws Exception {

    String[] op = expressao.trim().split("\\s+");

    if (op.length != 3) {
      throw new Exception("Erro a expressão não possui todos os elementos necessarios para calcular");
    }
    else if (op[0].isEmpty() || op[1].isEmpty() || op[2].isEmpty()) {
      throw new Exception("Erro não é possivel calcular pode haver um erro de digitação");
    }

    double resultado, valorUm = Double.parseDouble(op[0]), valorDois = Double.parseDouble(op[2]);
    switch (op[1]) {
      case "-":
        resultado = valorUm - valorDois;
        break;
      case "+":
        resultado = valorUm + valorDois;
        break;
      case "/":
        if (valorDois != 0) {
          resultado = valorUm / valorDois;
        } else {
          throw new Exception("Erro não é possivel divisão por zero!");
        }
        break;
      case "**":
        boolean aux = op[2].matches("-?[0-9]*"); // verifica se expoente é inteiro
        if (valorDois < 0 && valorUm == 0 || !aux) {
          throw new Exception("Erro não é possivel calcular a potencia com os valores informados!");
        }
        resultado = Math.pow(valorUm, valorDois);
        break;
      case "*":
        resultado = valorUm * valorDois;
        break;
      default:
        throw new Exception("Erro ao tentar calcular expressão!");
    }
    return resultado;
  }

  public double areaCirculo(double raio) throws Exception {
    if (raio > 0) {
      double pi = 3.14;
      double area = pi * Math.pow(raio, 2);
      return area;
    } else {
      throw new Exception("Erro raio menor ou igual a zero!");
    }

  }

  public double perimetroCirculo(double raio) throws Exception {
    if (raio > 0) {
      double pi = 3.14;
      double perimetro = 2 * pi * raio;
      return perimetro;
    } else {
      throw new Exception("Erro raio menor ou igual a zero!");
    }
  }

  public double distanciaEntreDoisPontos(double x1, double y1, double x2, double y2) {
    double diferençaX = Math.pow((x2 - x1), 2);
    double diferençaY = Math.pow((y2 - y1), 2);
    double distancia = Math.sqrt(diferençaX + diferençaY);
    return distancia;
  }
}
