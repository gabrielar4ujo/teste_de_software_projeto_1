import java.math.BigDecimal;
public class Raizes {
    private double a,b,c;

    public Raizes(double a, double b, double c) throws Exception {
        if(ehFuncaoQuadratica(a)){
            this.a = a;
            this.b = b;
            this.c = c;
        } else {
            throw  new Exception("error");
        }
    }
    private boolean ehFuncaoQuadratica(double number_A){
        if(number_A != 0) return true;
        else return false;
    }

    public String getRaizes(){
        double delta = Math.pow(b,2) - (4*a*c);
        String resultado;
        if(delta == 0){
            resultado = Double.toString(-b/(2*a));
            return resultado;
        }
        if(delta>0){
            double x1 = (-b + Math.sqrt(delta))/(2*a);
            double x2 = (-b - Math.sqrt(delta))/(2*a);
            resultado = Double.toString(x1) +" e "+ Double.toString(x2);
            return resultado;
        }
        return "Sem raizes";
    }

}