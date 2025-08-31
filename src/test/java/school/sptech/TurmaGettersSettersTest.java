package school.sptech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;
import static school.sptech.TurmaUtil.createTurma;

@DisplayName("Testes para os getters e setters da classe Turma")
public class TurmaGettersSettersTest {

    @Test
    @DisplayName("Getter 'getNome' deve retornar o nome correto")
    public void testGetNome() throws Exception {
        Object Turma = createTurma("CCO2024", 1500.0);

        Method getNome = Turma.class.getDeclaredMethod("getNome");
        String nome = (String) getNome.invoke(Turma);
        assertEquals("CCO2024", nome);
    }

    @Test
    @DisplayName("Setter 'setNome' deve alterar o nome corretamente")
    public void testSetNome() throws Exception {
        Object Turma = createTurma("CCO2024", 1500.0);

        Method setNome = Turma.class.getDeclaredMethod("setNome", String.class);
        setNome.invoke(Turma, "SIS2025");

        Method getNome = Turma.class.getDeclaredMethod("getNome");
        String nome = (String) getNome.invoke(Turma);
        assertEquals("SIS2025", nome);
    }

    @Test
    @DisplayName("Getter 'getMensalidade' deve retornar a mensalidade correta")
    public void testGetMensalidade() throws Exception {
        Object Turma = createTurma("CCO2024", 1500.0);

        Field mensalidadeField = Turma.class.getDeclaredField("mensalidade");
        mensalidadeField.setAccessible(true);
        mensalidadeField.set(Turma, 1800.0);

        Method getMensalidade = Turma.class.getDeclaredMethod("getMensalidade");
        Double mensalidade = (Double) getMensalidade.invoke(Turma);
        assertEquals(1800.0, mensalidade);
    }

    @Test
    @DisplayName("Getter 'getQtdAluno' deve retornar a quantidade de alunos correta")
    public void testGetQtdAluno() throws Exception {
        Object Turma = createTurma("CCO2024", 1500.0);

        Field qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);
        qtdAlunoField.set(Turma, 10);

        Method getQtdAluno = Turma.class.getDeclaredMethod("getQtdAluno");
        Integer qtdAluno = (Integer) getQtdAluno.invoke(Turma);
        assertEquals(10, qtdAluno);
    }

    @Test
    @DisplayName("Getter 'getAtiva' deve retornar o status ativo corretamente")
    public void testGetAtiva() throws Exception {
        Object Turma = createTurma("CCO2024", 1500.0);

        Field ativaField = Turma.class.getDeclaredField("ativa");
        ativaField.setAccessible(true);
        ativaField.set(Turma, false);

        Method getAtiva = Turma.class.getDeclaredMethod("getAtiva");
        Boolean ativa = (Boolean) getAtiva.invoke(Turma);
        assertFalse(ativa);

        ativaField.set(Turma, true);
        ativa = (Boolean) getAtiva.invoke(Turma);
        assertTrue(ativa);
    }
}