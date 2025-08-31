package school.sptech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static school.sptech.TurmaUtil.createTurma;

@DisplayName("Testes de cancelamento de alunos para a classe Turma")
public class TurmaCancelarTest {

    @Test
    @DisplayName("Cancela 5 alunos de uma turma com 10 alunos. Quantidade de alunos esperado após cancelar: 5")
    public void testCancelarQtdAlunoValida() throws Exception {
        Object turma = createTurma("CCO2024", 1500.0);

        // Iniciando a turma com um qtdAluno de 10 para os testes
        Field qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);
        qtdAlunoField.set(turma, 10);

        Method cancelar = Turma.class.getDeclaredMethod("cancelar", Integer.class);
        Integer qtdCancelado = (Integer) cancelar.invoke(turma, 5);

        qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);
        Integer qtdAluno = (Integer) qtdAlunoField.get(turma);

        assertEquals(5, qtdAluno);
        assertEquals(5, qtdCancelado);
    }

    @Test
    @DisplayName("Tentativa de cancelar 15 alunos em uma turma com qtdAluno de 10. Cancelamento deve falhar e qtdAluno deve permanecer 10")
    public void testCancelarQtdMaiorQueQtdAluno() throws Exception {
        Object turma = createTurma("CCO2024", 1500.0);

        // Iniciando a turma com um qtdAluno de 10 para os testes
        Field qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);
        qtdAlunoField.set(turma, 10);

        Method cancelar = Turma.class.getDeclaredMethod("cancelar", Integer.class);
        Integer qtdCancelado = (Integer) cancelar.invoke(turma, 15);

        qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);
        Integer qtdAluno = (Integer) qtdAlunoField.get(turma);

        assertEquals(10, qtdAluno);
        assertNull(qtdCancelado); // Deve retornar null quando o qtdAluno é insuficiente
    }

    @Test
    @DisplayName("Tentativa de cancelar zero alunos em uma turma com 10 alunos. Cancelamento deve falhar e qtdAluno deve permanecer 10")
    public void testCancelarQtdZero() throws Exception {
        Object turma = createTurma("CCO2024", 1500.0);

        // Iniciando a turma com um qtdAluno de 10 para os testes
        Field qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);
        qtdAlunoField.set(turma, 10);

        Method cancelar = Turma.class.getDeclaredMethod("cancelar", Integer.class);
        Integer qtdCancelado = (Integer) cancelar.invoke(turma, 0);

        qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);
        Integer qtdAluno = (Integer) qtdAlunoField.get(turma);

        assertEquals(10, qtdAluno);
        assertNull(qtdCancelado); // Deve retornar null quando a quantidade a cancelar é zero
    }

    @Test
    @DisplayName("Tentativa de cancelar quantidade negativa de alunos (-5) em uma turma com 10 alunos. Cancelamento deve falhar e qtdAluno deve permanecer 10")
    public void testCancelarQtdNegativo() throws Exception {
        Object turma = createTurma("CCO2024", 1500.0);

        // Iniciando a turma com um qtdAluno de 10 para os testes
        Field qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);
        qtdAlunoField.set(turma, 10);

        Method cancelar = Turma.class.getDeclaredMethod("cancelar", Integer.class);
        Integer qtdCancelado = (Integer) cancelar.invoke(turma, -5);

        qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);
        Integer qtdAluno = (Integer) qtdAlunoField.get(turma);

        assertEquals(10, qtdAluno);
        assertNull(qtdCancelado); // Deve retornar null quando a quantidade a cancelar é negativa
    }

    @Test
    @DisplayName("Tentativa de cancelar quantidade com valor nulo em uma turma com 10 alunos. Cancelamento deve falhar e qtdAluno deve permanecer 10")
    public void testCancelarQtdNulo() throws Exception {
        Object turma = createTurma("CCO2024", 1500.0);

        // Iniciando a turma com um qtdAluno de 10 para os testes
        Field qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);
        qtdAlunoField.set(turma, 10);

        Method cancelar = Turma.class.getDeclaredMethod("cancelar", Integer.class);
        Integer qtdCancelado = (Integer) cancelar.invoke(turma, (Object) null);

        qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);
        Integer qtdAluno = (Integer) qtdAlunoField.get(turma);

        assertEquals(10, qtdAluno);
        assertNull(qtdCancelado); // Deve retornar null quando a quantidade a cancelar é nula
    }

    @Test
    @DisplayName("Tentativa de cancelar 5 alunos em uma turma inativa com 10 alunos. Cancelamento deve falhar e qtdAluno deve permanecer 10")
    public void testCancelarTurmaInativa() throws Exception {
        Object turma = createTurma("CCO2024", 1500.0);

        // Iniciando a turma com um qtdAluno de 10
        Field qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);
        qtdAlunoField.set(turma, 10);

        Field ativaField = Turma.class.getDeclaredField("ativa");
        ativaField.setAccessible(true);
        ativaField.set(turma, false);

        Method cancelar = Turma.class.getDeclaredMethod("cancelar", Integer.class);
        Integer qtdCancelado = (Integer) cancelar.invoke(turma, 5);

        qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);
        Integer qtdAluno = (Integer) qtdAlunoField.get(turma);

        assertEquals(10, qtdAluno);
        assertNull(qtdCancelado); // Deve retornar null quando a turma está inativa
    }
}