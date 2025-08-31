package school.sptech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes de especificação para a classe Turma")
public class FidelidadeEspecificacaoTest {

    @Test
    @DisplayName("Construtor deve ser public, ter nome 'Turma', aceitar um argumento do tipo String e um argumento do tipo Double")
    public void testConstrutorTurma() {
        try {
            Constructor<?> construtor = Turma.class.getDeclaredConstructor(String.class, Double.class);
            assertTrue(Modifier.isPublic(construtor.getModifiers()), "Falha: Construtor 'Turma' deve ser public");
        } catch (NoSuchMethodException e) {
            fail("Construtor 'Turma(String, Double)' não encontrado ou com assinatura incorreta: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Campo 'nome' deve ser private e do tipo String")
    public void testCampoNome() {
        try {
            Field campoNome = Turma.class.getDeclaredField("nome");
            assertTrue(Modifier.isPrivate(campoNome.getModifiers()), "Falha: Campo 'nome' deve ser private");
            assertEquals(String.class, campoNome.getType(), "Falha: Campo 'nome' deve ser do tipo String");
        } catch (NoSuchFieldException e) {
            fail("Campo 'nome' não encontrado: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Campo 'mensalidade' deve ser private e do tipo Double")
    public void testCampoMensalidade() {
        try {
            Field campoMensalidade = Turma.class.getDeclaredField("mensalidade");
            assertTrue(Modifier.isPrivate(campoMensalidade.getModifiers()), "Falha: Campo 'mensalidade' deve ser private");
            assertEquals(Double.class, campoMensalidade.getType(), "Falha: Campo 'mensalidade' deve ser do tipo Double");
        } catch (NoSuchFieldException e) {
            fail("Campo 'mensalidade' não encontrado: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Campo 'qtdAluno' deve ser private e do tipo Integer")
    public void testCampoQtdALuno() {
        try {
            Field campoQtdAluno = Turma.class.getDeclaredField("qtdAluno");
            assertTrue(Modifier.isPrivate(campoQtdAluno.getModifiers()), "Falha: Campo 'qtdAluno' deve ser private");
            assertEquals(Integer.class, campoQtdAluno.getType(), "Falha: Campo 'qtdAluno' deve ser do tipo Integer");
        } catch (NoSuchFieldException e) {
            fail("Campo 'qtdAluno' não encontrado: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Campo 'ativa' deve ser private e do tipo Boolean")
    public void testCampoAtiva() {
        try {
            Field campoAtiva = Turma.class.getDeclaredField("ativa");
            assertTrue(Modifier.isPrivate(campoAtiva.getModifiers()), "Falha: Campo 'ativa' deve ser private");
            assertEquals(Boolean.class, campoAtiva.getType(), "Falha: Campo 'ativa' deve ser do tipo Boolean");
        } catch (NoSuchFieldException e) {
            fail("Campo 'ativa' não encontrado: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Método 'setMensalidade' não deve existir para o campo 'mensalidade'")
    public void testNaoExistenciaDeSetMensalidade() {
        try {
            Turma.class.getDeclaredMethod("setMensalidade", Double.class);
            fail("Falha: Método 'setMensalidade' não deveria existir");
        } catch (NoSuchMethodException e) {
            // Sucesso: Método 'setMensalidade' não existe
        }
    }

    @Test
    @DisplayName("Método 'setQtdAluno' não deve existir para o campo 'qtdAluno'")
    public void testNaoExistenciaDeSetQtdAluno() {
        try {
            Turma.class.getDeclaredMethod("setQtdAluno", Integer.class);
            fail("Falha: Método 'setQtdAluno' não deveria existir");
        } catch (NoSuchMethodException e) {
            // Sucesso: Método 'setQtdAluno' não existe
        }
    }

    @Test
    @DisplayName("Método 'setAtiva' não deve existir para o campo 'ativa'")
    public void testNaoExistenciaDeSetAtiva() {
        try {
            Turma.class.getDeclaredMethod("setAtiva", Boolean.class);
            fail("Falha: Método 'setAtiva' não deveria existir");
        } catch (NoSuchMethodException e) {
            // Sucesso: Método 'setAtiva' não existe
        }
    }

    @Test
    @DisplayName("Método 'matricular' deve ser public, ter nome 'matricular', aceitar um argumento do tipo Integer e retornar void")
    public void testMetodoMatricular() {
        try {
            Method metodoMatricular = Turma.class.getDeclaredMethod("matricular", Integer.class);
            assertTrue(Modifier.isPublic(metodoMatricular.getModifiers()), "Falha: Método 'matricular' deve ser public");
            assertEquals(void.class, metodoMatricular.getReturnType(), "Falha: Método 'matricular' deve retornar void");
        } catch (NoSuchMethodException e) {
            fail("Método 'matricular' não encontrado ou com assinatura incorreta: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Método 'cancelar' deve ser public, ter nome 'cancelar', aceitar um argumento do tipo Integer e retornar Integer")
    public void testMetodoCancelar() {
        try {
            Method metodoCancelar = Turma.class.getDeclaredMethod("cancelar", Integer.class);
            assertTrue(Modifier.isPublic(metodoCancelar.getModifiers()), "Falha: Método 'cancelar' deve ser public");
            assertEquals(Integer.class, metodoCancelar.getReturnType(), "Falha: Método 'cancelar' deve retornar Integer");
        } catch (NoSuchMethodException e) {
            fail("Método 'cancelar' não encontrado ou com assinatura incorreta: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Método 'desativar' deve ser public, ter nome 'desativar', não aceitar argumentos e retornar Integer")
    public void testMetodoDesativar() {
        try {
            Method metodoDesativar = Turma.class.getDeclaredMethod("desativar");
            assertTrue(Modifier.isPublic(metodoDesativar.getModifiers()), "Falha: Método 'desativar' deve ser public");
            assertEquals(Integer.class, metodoDesativar.getReturnType(), "Falha: Método 'desativaar' deve retornar Integer");
        } catch (NoSuchMethodException e) {
            fail("Método 'desativar' não encontrado ou com assinatura incorreta: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Método 'transferir' deve ser public, ter nome 'transferir', aceitar dois argumentos (Turma e Integer) e retornar void")
    public void testMetodoTransferir() {
        try {
            Method metodoTransferir = Turma.class.getDeclaredMethod("transferir", Turma.class, Integer.class);
            assertTrue(Modifier.isPublic(metodoTransferir.getModifiers()), "Falha: Método 'transferir' deve ser public");
            assertEquals(void.class, metodoTransferir.getReturnType(), "Falha: Método 'transferir' deve retornar void");
        } catch (NoSuchMethodException e) {
            fail("Método 'transferir' não encontrado ou com assinatura incorreta: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Método 'reajustarMensalidade' deve ser public, ter nome 'reajustarMensalidade', aceitar um argumento Double e retornar Boolean")
    public void testReajustarMensalidade() {
        try {
            Method metodoReajustarMensalidade = Turma.class.getDeclaredMethod("reajustarMensalidade", Double.class);
            assertTrue(Modifier.isPublic(metodoReajustarMensalidade.getModifiers()), "Falha: Método 'reajustarMensalidade' deve ser public");
            assertEquals(Boolean.class, metodoReajustarMensalidade.getReturnType(), "Falha: Método 'reajustarMensalidade' deve retornar Boolean");
        } catch (NoSuchMethodException e) {
            fail("Método 'reajustarMensalidade' não encontrado ou com assinatura incorreta: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Método 'getNome' deve ser public, ter nome 'getNome', não aceitar argumentos e retornar String")
    public void testMetodoGetNome() {
        try {
            Method metodoGetNome = Turma.class.getDeclaredMethod("getNome");
            assertTrue(Modifier.isPublic(metodoGetNome.getModifiers()), "Falha: Método 'getNome' deve ser public");
            assertEquals(String.class, metodoGetNome.getReturnType(), "Falha: Método 'getNome' deve retornar String");
        } catch (NoSuchMethodException e) {
            fail("Método 'getNome' não encontrado ou com assinatura incorreta: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Método 'getMensalidade' deve ser public, ter nome 'getMensalidade', não aceitar argumentos e retornar Double")
    public void testMetodoGetMensalidade() {
        try {
            Method metodoGetMensalidade = Turma.class.getDeclaredMethod("getMensalidade");
            assertTrue(Modifier.isPublic(metodoGetMensalidade.getModifiers()), "Falha: Método 'getMensalidade' deve ser public");
            assertEquals(Double.class, metodoGetMensalidade.getReturnType(), "Falha: Método 'getMensalidade' deve retornar Double");
        } catch (NoSuchMethodException e) {
            fail("Método 'getMensalidade' não encontrado ou com assinatura incorreta: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Método 'getQtdALuno' deve ser public, ter nome 'getQtdAluno', não aceitar argumentos e retornar Integer")
    public void testMetodoGetQtdAluno() {
        try {
            Method metodoGetQtdAluno = Turma.class.getDeclaredMethod("getQtdAluno");
            assertTrue(Modifier.isPublic(metodoGetQtdAluno.getModifiers()), "Falha: Método 'getQtdAluno' deve ser public");
            assertEquals(Integer.class, metodoGetQtdAluno.getReturnType(), "Falha: Método 'getQtdAluno' deve retornar Integer");
        } catch (NoSuchMethodException e) {
            fail("Método 'getQtdAluno' não encontrado ou com assinatura incorreta: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Método 'getAtiva' deve ser public, ter nome 'getAtiva', não aceitar argumentos e retornar Boolean")
    public void testMetodoGetAtiva() {
        try {
            Method metodoGetAtiva = Turma.class.getDeclaredMethod("getAtiva");
            assertTrue(Modifier.isPublic(metodoGetAtiva.getModifiers()), "Falha: Método 'getAtiva' deve ser public");
            assertEquals(Boolean.class, metodoGetAtiva.getReturnType(), "Falha: Método 'getAtiva' deve retornar Boolean");
        } catch (NoSuchMethodException e) {
            fail("Método 'getAtiva' não encontrado ou com assinatura incorreta: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Método 'setNome' deve ser public, ter nome 'setNome', aceitar um argumento do tipo String e retornar void")
    public void testMetodoSetNome() {
        try {
            Method metodoSetNome = Turma.class.getDeclaredMethod("setNome", String.class);
            assertTrue(Modifier.isPublic(metodoSetNome.getModifiers()), "Falha: Método 'setNome' deve ser public");
            assertEquals(void.class, metodoSetNome.getReturnType(), "Falha: Método 'setNome' deve retornar void");
        } catch (NoSuchMethodException e) {
            fail("Método 'setNome' não encontrado ou com assinatura incorreta: " + e.getMessage());
        }
    }
}