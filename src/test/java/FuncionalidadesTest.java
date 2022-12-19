import org.junit.Assert;
import org.junit.Test;

public class FuncionalidadesTest {
        @Test
        public void novoUsuarioTest() throws Exception {
                // Criação de instância de um usuário válido
                Usuario user = new Usuario("Esthelio ", "esthelio@natalia.com", "Password@1");

                // Verificação do método de sucesso da instancia de usuário
                Assert.assertTrue(user.sucessoNaCriacaoDeUsuario());

                // verificação do lançamento de exceção para um usuário inválido
                Throwable exception = Assert.assertThrows(Exception.class,
                                () -> new Usuario("zeca", "zeca@pagodinho.com", "senhainvalida"));
                Assert.assertEquals(exception.getMessage(), "Erro ao cadastrar");
        }

        @Test
        public void cadastroTest() throws Exception {
                Sistema cadastro = new Sistema();

                Usuario teste = cadastro.cadastraUsuario("Esthelio", "esthelio@natalia.com", "Password@1");

                // Verificação do método de sucesso da instancia de usuário
                Assert.assertTrue(teste.sucessoNaCriacaoDeUsuario());

                // verificação do lançamento de exceção para um usuário inválido
                // -> exceção aninhada, é lançada apenas a primeira instancia do tipo de
                // Exception definida <-
                Throwable exception = Assert.assertThrows(Exception.class,
                                () -> cadastro.cadastraUsuario("zeca", "zeca@pagodinho.com", "senhainvalida"));
                Assert.assertEquals(exception.getMessage(), "Erro ao cadastrar");
        }

        @Test
        public void testarRaizesTest() throws Exception {
                Sistema sistema = new Sistema();

                // Teste de exceção para o valor 0, inválido por definição para 'a'
                String exception = sistema.calculaFuncaoSegundoGrau(0, 2, 1);
                Assert.assertEquals(exception, "error");

                // Teste para validar funcionamento de coeficientes cujo delta > 0
                Assert.assertEquals(sistema.calculaFuncaoSegundoGrau(1, -2, -8), "4.0 e -2.0");

                // Teste para validar funcionamento de coeficientes cujo delta = 0
                Assert.assertEquals(sistema.calculaFuncaoSegundoGrau(-2, 20, -50), "5.0");

                // Teste para validar funcionamento de coeficientes cujo delta < 0
                Assert.assertEquals(sistema.calculaFuncaoSegundoGrau(1, -4, 10), "Sem raizes");
        }

        @Test
        public void trianguloTest() throws Exception {
                Sistema sistema = new Sistema();

                // Teste de exceção para angulos inválidos por definição
                Throwable exception = Assert.assertThrows(Exception.class, () -> sistema.ehTriangulo(0, 90, 90));
                Assert.assertEquals(exception.getMessage(), "Erro angulo incorreto!");

                // Teste de angulos válidos para um triangulo
                Assert.assertTrue(sistema.ehTriangulo(20, 90, 70));

                // Testes de angulos válidos po definição, porem que nao formam um traingulo
                Assert.assertFalse(sistema.ehTriangulo(20, 80, 70));
                Assert.assertFalse(sistema.ehTriangulo(20, 100, 70));
        }

        @Test
        public void trianguloRetanguloTest() throws Exception {
                Sistema sistema = new Sistema();

                // Teste de angulos inválidos por definição, sem exceção
                Assert.assertFalse(sistema.ehTrianguloRetangulo(0, 0, 0));

                // Testes para triangulo retangulo válido
                Assert.assertTrue(sistema.ehTrianguloRetangulo(3, 4, 5));
                Assert.assertTrue(sistema.ehTrianguloRetangulo(8, 15, 17));

                // Testes para triangulo retangulo inválido
                Assert.assertFalse(sistema.ehTrianguloRetangulo(0, 4, 5));
                Assert.assertFalse(sistema.ehTrianguloRetangulo(3, 4, 0));
        }

        @Test
        public void ehRetanguloTest() throws Exception {
                Sistema sistema = new Sistema();

                // Teste de exceção para ângulo inválido por definição
                Throwable exception = Assert.assertThrows(Exception.class, () -> sistema.ehRetangulo(0, 120, 120, 120));
                Assert.assertEquals(exception.getMessage(), "Erro existe ângulo invalido");

                // Teste de um retangulo válido
                Assert.assertTrue(sistema.ehRetangulo(90, 90, 90, 90));

                // Teste de um retangulo inválido
                Assert.assertFalse(sistema.ehRetangulo(4, 5, 7, 4));
        }

        @Test
        public void classificaTrianguloTest() throws Exception {
                Sistema sistema = new Sistema();

                Assert.assertEquals("É um Triângulo Obtusângulo",
                                sistema.classificaTriangulo(100, 40, 40));
                Assert.assertEquals("É um Triângulo Acutângulo",
                                sistema.classificaTriangulo(60, 60, 60));
                Assert.assertEquals("Os Ângulos informados, não formam um triângulo!",
                                sistema.classificaTriangulo(50, 40, 40));

                // Teste quando o angulo1 for ZERO
                Throwable exception1 = Assert.assertThrows(Exception.class,
                                () -> sistema.classificaTriangulo(0, 40, 40));
                Assert.assertEquals(exception1.getMessage(),
                                "Erro angulo incorreto!");

                // Teste quando o angulo2 for ZERO
                exception1 = Assert.assertThrows(Exception.class, () -> sistema.classificaTriangulo(40, 0, 40));
                Assert.assertEquals(exception1.getMessage(),
                                "Erro angulo incorreto!");

                // Teste quando o angulo3 for ZERO
                exception1 = Assert.assertThrows(Exception.class, () -> sistema.classificaTriangulo(40, 40, 0));
                Assert.assertEquals(exception1.getMessage(),
                                "Erro angulo incorreto!");

                // Teste quando o angulo1 for MENOR QUE ZERO
                exception1 = Assert.assertThrows(Exception.class, () -> sistema.classificaTriangulo(-4, 40, 40));
                Assert.assertEquals(exception1.getMessage(),
                                "Erro angulo incorreto!");

                // Teste quando o angulo2 for MENOR QUE ZERO
                exception1 = Assert.assertThrows(Exception.class, () -> sistema.classificaTriangulo(40, -4, 40));
                Assert.assertEquals(exception1.getMessage(),
                                "Erro angulo incorreto!");

                // Teste quando o angulo3 for MENOR QUE ZERO
                exception1 = Assert.assertThrows(Exception.class, () -> sistema.classificaTriangulo(40, 40, -4));
                Assert.assertEquals(exception1.getMessage(),
                                "Erro angulo incorreto!");

                // #ERRO ENCONTRADO: Teste quebrando por erro no sistema, o retorno deveria ser
                // 'É um Triângulo Retângulo'
                // A soma dos angulos é 180, há um ângulo obtuso e os outros angulos são agudos
                Assert.assertEquals(
                                "É um Triângulo Retângulo",
                                sistema.classificaTriangulo(
                                                90,
                                                45,
                                                45));

        }

        @Test
        public void perimetroRetanguloTest() throws Exception {
                Sistema sistema = new Sistema();
                Assert.assertEquals(18, sistema.perimetroRetangulo(5, 4), 0);
                Assert.assertEquals(32, sistema.perimetroRetangulo(10, 6), 0);

                // Teste quando o lado1 for ZERO
                Throwable exception1 = Assert.assertThrows(Exception.class, () -> sistema.perimetroRetangulo(0, 4));
                Assert.assertEquals(exception1.getMessage(),
                                "Erro não é possivel calcular a aréa pois os lados nao formam um retângulo");

                // Teste quando o lado2 for ZERO
                Throwable exception2 = Assert.assertThrows(Exception.class, () -> sistema.perimetroRetangulo(4, 0));
                Assert.assertEquals(exception2.getMessage(),
                                "Erro não é possivel calcular a aréa pois os lados nao formam um retângulo");

                // Teste quando o lado1 for MENOR QUE ZERO
                Throwable exception3 = Assert.assertThrows(Exception.class, () -> sistema.perimetroRetangulo(-10, 4));
                Assert.assertEquals(exception3.getMessage(),
                                "Erro não é possivel calcular a aréa pois os lados nao formam um retângulo");

                // Teste quando o lado2 for MENOR QUE ZERO
                Throwable exception4 = Assert.assertThrows(Exception.class, () -> sistema.perimetroRetangulo(4, -5));
                Assert.assertEquals(exception4.getMessage(),
                                "Erro não é possivel calcular a aréa pois os lados nao formam um retângulo");
        }

        @Test
        public void areaRetanguloTest() throws Exception {
                Sistema sistema = new Sistema();
                Assert.assertEquals(20, sistema.areaRetangulo(5, 4), 0);
                Assert.assertEquals(60, sistema.areaRetangulo(10, 6), 0);

                // Teste quando o lado1 for ZERO
                Throwable exception1 = Assert.assertThrows(Exception.class, () -> sistema.areaRetangulo(0, 4));
                Assert.assertEquals(exception1.getMessage(),
                                "Erro não é possivel calcular a aréa pois os lados nao formam um retangulo");

                // Teste quando o lado2 for ZERO
                Throwable exception2 = Assert.assertThrows(Exception.class, () -> sistema.areaRetangulo(4, 0));
                Assert.assertEquals(exception2.getMessage(),
                                "Erro não é possivel calcular a aréa pois os lados nao formam um retangulo");

                // Teste quando o lado1 for MENOR QUE ZERO
                Throwable exception3 = Assert.assertThrows(Exception.class, () -> sistema.areaRetangulo(-10, 4));
                Assert.assertEquals(exception3.getMessage(),
                                "Erro não é possivel calcular a aréa pois os lados nao formam um retangulo");

                // Teste quando o lado2 for MENOR QUE ZERO
                Throwable exception4 = Assert.assertThrows(Exception.class, () -> sistema.areaRetangulo(4, -5));
                Assert.assertEquals(exception4.getMessage(),
                                "Erro não é possivel calcular a aréa pois os lados nao formam um retangulo");
        }

        @Test
        public void calculadoraTest() throws Exception {
                Sistema sistema = new Sistema();
                Assert.assertEquals(505, sistema.calculadora("500 + 5"), 0.0);
                Assert.assertEquals(25, sistema.calculadora("5 * 5"), 0.0);
                Assert.assertEquals(0, sistema.calculadora("5 - 5"), 0.0);
                Assert.assertEquals(1, sistema.calculadora("5 / 5"), 0.0);
                Assert.assertEquals(125, sistema.calculadora("5 ** 3"), 0.0);

                // Teste quando expressão passada for de tamanho inválido
                Throwable exception1 = Assert.assertThrows(Exception.class, () -> sistema.calculadora("500 + 51 +"));
                Assert.assertEquals(exception1.getMessage(),
                                "Erro a expressão não possui todos os elementos necessarios para calcular");

                // Teste quando expressão passada for inválida
                exception1 = Assert.assertThrows(Exception.class, () -> sistema.calculadora("500 + a"));

                // Teste quando expressão passada for de uma divisão por ZERO
                exception1 = Assert.assertThrows(Exception.class, () -> sistema.calculadora("500 / 0"));
                Assert.assertEquals(exception1.getMessage(),
                                "Erro não é possivel divisão por zero!");

                // Teste quando expressão passada o expoente NÃO for INTEIRO
                exception1 = Assert.assertThrows(Exception.class, () -> sistema.calculadora("500 ** 1.5"));
                Assert.assertEquals(exception1.getMessage(),
                                "Erro não é possivel calcular a potencia com os valores informados!");

                // Teste quando expressão passada o expoente FOR MENOR QUE ZERO e a base for
                // ZERO
                exception1 = Assert.assertThrows(Exception.class, () -> sistema.calculadora("0 ** -5"));
                Assert.assertEquals(exception1.getMessage(),
                                "Erro não é possivel calcular a potencia com os valores informados!");

                // Teste quando expressão passada o expoente FOR ZERO e a base for ZERO
                Assert.assertEquals(
                                1, sistema.calculadora("0 ** 0"),
                                0.0);

                // Teste quando expressão passada o expoente FOR MENOR QUE ZERO e a base for 0
                exception1 = Assert.assertThrows(Exception.class, () -> sistema.calculadora("5 x 5"));
                Assert.assertEquals(exception1.getMessage(),
                                "Erro ao tentar calcular expressão!");
        }

        @Test
        public void areaCirculoTest() throws Exception {
                Sistema sistema = new Sistema();
                Assert.assertEquals(78.5, sistema.areaCirculo(5), 0.5);
                Assert.assertEquals(50.24, sistema.areaCirculo(4), 0.01);

                // Teste quando raio for ZERO
                Throwable exception1 = Assert.assertThrows(Exception.class, () -> sistema.areaCirculo(0));
                Assert.assertEquals(exception1.getMessage(), "Erro raio menor ou igual a zero!");

                // Teste quando raio for MENOR QUE ZERO
                Throwable exception2 = Assert.assertThrows(Exception.class, () -> sistema.areaCirculo(-5));
                Assert.assertEquals(exception2.getMessage(), "Erro raio menor ou igual a zero!");
        }

        @Test
        public void perimetroCirculoTest() throws Exception {
                Sistema sistema = new Sistema();
                Assert.assertEquals(31.4, sistema.perimetroCirculo(5), 0.5);
                Assert.assertEquals(25.12, sistema.perimetroCirculo(4), 0.01);

                // Teste quando raio for ZERO
                Throwable exception1 = Assert.assertThrows(Exception.class, () -> sistema.perimetroCirculo(0));
                Assert.assertEquals(exception1.getMessage(), "Erro raio menor ou igual a zero!");

                // Teste quando raio for MENOR QUE ZERO
                Throwable exception2 = Assert.assertThrows(Exception.class, () -> sistema.perimetroCirculo(-5));
                Assert.assertEquals(exception2.getMessage(), "Erro raio menor ou igual a zero!");
        }

        @Test
        public void distanciaEntrePontosTest() {
                Sistema sistema = new Sistema();
                Assert.assertEquals(8.24, sistema.distanciaEntreDoisPontos(2, -3, 4, 5), 0.5);
                Assert.assertEquals(12.36, sistema.distanciaEntreDoisPontos(-2, 3, -5, -9), 0.5);
        }

}
