package school.sptech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static school.sptech.TurmaUtil.createTurma;

@DisplayName("Testes de transferência para a classe Turma")
public class TurmaTransferirTest {

    @Test
    @DisplayName("Transferência de 5 alunos de uma turma com 10 alunos para uma turma com 5 alunos. Quantidades de alunos esperadas: origem 5; destino 10")
    public void testTransferirQuantidadeValido() throws Exception {
        Object turmaOrigem = createTurma("CCO2024", 1500.0);
        Object turmaDestino = createTurma("SIS2025", 1400.0);

        Field qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);
        qtdAlunoField.set(turmaOrigem, 10);
        qtdAlunoField.set(turmaDestino, 5);

        Method transferir = Turma.class.getDeclaredMethod("transferir", Turma.class, Integer.class);
        transferir.invoke(turmaOrigem, turmaDestino, 5);

        qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);

        Integer qtdAlunoOrigem = (Integer) qtdAlunoField.get(turmaOrigem);
        Integer qtdAlunoDestino = (Integer) qtdAlunoField.get(turmaDestino);

        assertEquals(5, qtdAlunoOrigem);
        assertEquals(10, qtdAlunoDestino);
    }

    @Test
    @DisplayName("Tentativa de transferir 15 alunos (valor superior ao qtdAluno) de uma turma com 10 alunos. Quantidadea de alunos esperados: origem 10; destino 5")
    public void testTransferirValorSuperiorAQtdAluno() throws Exception {
        Object turmaOrigem = createTurma("CCO2024", 1500.0);
        Object turmaDestino = createTurma("SIS2025", 1400.0);

        Field qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);
        qtdAlunoField.set(turmaOrigem, 10);
        qtdAlunoField.set(turmaDestino, 5);

        Method transferir = Turma.class.getDeclaredMethod("transferir", Turma.class, Integer.class);
        transferir.invoke(turmaOrigem, turmaDestino, 15);

        qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);

        Integer qtdAlunoOrigem = (Integer) qtdAlunoField.get(turmaOrigem);
        Integer qtdAlunoDestino = (Integer) qtdAlunoField.get(turmaDestino);

        assertEquals(10, qtdAlunoOrigem);  // Sem alteração na origem
        assertEquals(5, qtdAlunoDestino);  // Sem alteração no destino
    }

    @Test
    @DisplayName("Tentativa de transferir 5 alunos de uma turma com 10 alunos para uma turma inativa. A quantidade de alunos da turma origem deve permanecer inalterado.")
    public void testTransferirParaTurmaInativa() throws Exception {
        Object turmaOrigem = createTurma("CCO2024", 1500.0);
        Object turmaDestino = createTurma("SIS2025", 1400.0);

        Field qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);
        qtdAlunoField.set(turmaOrigem, 10);
        qtdAlunoField.set(turmaDestino, 5);

        Field ativaField = Turma.class.getDeclaredField("ativa");
        ativaField.setAccessible(true);
        ativaField.set(turmaDestino, false);

        Method transferir = Turma.class.getDeclaredMethod("transferir", Turma.class, Integer.class);
        transferir.invoke(turmaOrigem, turmaDestino, 5);

        qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);

        Integer qtdAlunoOrigem = (Integer) qtdAlunoField.get(turmaOrigem);
        Integer qtdAlunoDestino = (Integer) qtdAlunoField.get(turmaDestino);

        assertEquals(10, qtdAlunoOrigem);  // Transferência falha, sem alteração na origem
        assertEquals(5, qtdAlunoDestino);  // Sem alteração no destino
    }

    @Test
    @DisplayName("Tentativa de transferir 5 alunos de uma turma inativa para uma turma ativa. A quantidade de alunos da turma origem deve permanecer inalterado.")
    public void testTransferirDeTurmaInativa() throws Exception {
        Object turmaOrigem = createTurma("CCO2024", 1500.0);
        Object turmaDestino = createTurma("SIS2025", 1400.0);

        Field qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);
        qtdAlunoField.set(turmaOrigem, 10);
        qtdAlunoField.set(turmaDestino, 5);

        Field ativaField = Turma.class.getDeclaredField("ativa");
        ativaField.setAccessible(true);
        ativaField.set(turmaOrigem, false);

        Method transferir = Turma.class.getDeclaredMethod("transferir", Turma.class, Integer.class);
        transferir.invoke(turmaOrigem, turmaDestino, 5);

        qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);

        Integer qtdAlunoOrigem = (Integer) qtdAlunoField.get(turmaOrigem);
        Integer qtdAlunoDestino = (Integer) qtdAlunoField.get(turmaDestino);

        assertEquals(10, qtdAlunoOrigem);  // Transferência falha, sem alteração na origem
        assertEquals(5, qtdAlunoDestino);  // Sem alteração no destino
    }

    @Test
    @DisplayName("Tentativa de transferir zero alunos de uma turma com 10 alunos. Quantidades de alunos esperados: origem 10; destino 5")
    public void testTransferirValorZero() throws Exception {
        Object turmaOrigem = createTurma("CCO2024", 1500.0);
        Object turmaDestino = createTurma("SIS2025", 1400.0);

        Field qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);
        qtdAlunoField.set(turmaOrigem, 10);
        qtdAlunoField.set(turmaDestino, 5);

        Method transferir = Turma.class.getDeclaredMethod("transferir", Turma.class, Integer.class);
        transferir.invoke(turmaOrigem, turmaDestino, 0);

        qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);

        Integer qtdAlunoOrigem = (Integer) qtdAlunoField.get(turmaOrigem);
        Integer qtdAlunoDestino = (Integer) qtdAlunoField.get(turmaDestino);

        assertEquals(10, qtdAlunoOrigem);  // Sem alteração na origem
        assertEquals(5, qtdAlunoDestino);  // Sem alteração no destino
    }

    @Test
    @DisplayName("Tentativa de transferir quantidade negativa de alunos (-5) de uma turma com 10 alunos. Quantidades de alunos esperados: origem 10; destino 5")
    public void testTransferirQuantidadeNegativa() throws Exception {
        Object turmaOrigem = createTurma("CCO2024", 1500.0);
        Object turmaDestino = createTurma("SIS2025", 1400.0);

        Field qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);
        qtdAlunoField.set(turmaOrigem, 10);
        qtdAlunoField.set(turmaDestino, 5);

        Method transferir = Turma.class.getDeclaredMethod("transferir", Turma.class, Integer.class);
        transferir.invoke(turmaOrigem, turmaDestino, -5);

        qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);

        Integer qtdAlunoOrigem = (Integer) qtdAlunoField.get(turmaOrigem);
        Integer qtdAlunoDestino = (Integer) qtdAlunoField.get(turmaDestino);

        assertEquals(10, qtdAlunoOrigem);  // Sem alteração na origem
        assertEquals(5, qtdAlunoDestino);  // Sem alteração no destino
    }

    @Test
    @DisplayName("Tentativa de transferir 5 alunos de uma turma com 10 alunos para uma turma nula. Quantidade de alunos esperado: origem 10")
    public void testTransferirParaTurmaNula() throws Exception {
        Object turmaOrigem = createTurma("CCO2024", 1500.0);

        Field qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);
        qtdAlunoField.set(turmaOrigem, 10);

        Method transferir = Turma.class.getDeclaredMethod("transferir", Turma.class, Integer.class);
        transferir.invoke(turmaOrigem, null, 5);

        qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);

        Integer qtdAlunoOrigem = (Integer) qtdAlunoField.get(turmaOrigem);

        assertEquals(10, qtdAlunoOrigem);  // Sem alteração na origem, pois o destino é nulo
    }

    @Test
    @DisplayName("Tentativa de transferir valor nulo de uma turma com 10 alunos. Quantidades de alunos esperados: origem 10; destino 5")
    public void testTransferirValorNulo() throws Exception {
        Object turmaOrigem = createTurma("CCO2024", 1500.0);
        Object turmaDestino = createTurma("SIS2025", 1400.0);

        Field qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);
        qtdAlunoField.set(turmaOrigem, 10);
        qtdAlunoField.set(turmaDestino, 5);

        Method transferir = Turma.class.getDeclaredMethod("transferir", Turma.class, Integer.class);
        transferir.invoke(turmaOrigem, turmaDestino, (Object) null);

        qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);

        Integer qtdAlunoOrigem = (Integer) qtdAlunoField.get(turmaOrigem);
        Integer qtdAlunoDestino = (Integer) qtdAlunoField.get(turmaDestino);

        assertEquals(10, qtdAlunoOrigem);  // Sem alteração na origem
        assertEquals(5, qtdAlunoDestino);  // Sem alteração no destino
    }
}