package school.sptech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static school.sptech.TurmaUtil.createTurma;

@DisplayName("Testes de desativação de turma para a classe Turma")
public class TurmaDesativarTest {

    @Test
    @DisplayName("Desativar turma com quantidade de alunos positivo.")
    public void testDesativarTurmaComAluno() throws Exception {
        Object turma = createTurma("CCO2024", 1500.0);

        Field qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);
        qtdAlunoField.set(turma, 10);

        Method desativar = Turma.class.getDeclaredMethod("desativar");
        Integer qtdAlunoFinal = (Integer) desativar.invoke(turma);

        Integer qtdAluno = (Integer) qtdAlunoField.get(turma);
        Field ativaField = Turma.class.getDeclaredField("ativa");
        ativaField.setAccessible(true);
        Boolean ativa = (Boolean) ativaField.get(turma);

        assertEquals(10, qtdAlunoFinal);
        assertEquals(0, qtdAluno, "A quantidade de alunos da turma deve ser zerada após a desativação");
        assertFalse(ativa); // Verifica se a turma foi inativada
    }

    @Test
    @DisplayName("Desativar turma com zero alunos. Quantidade de alunos esperado: 0")
    public void testDesativarTurmaComZeroAluno() throws Exception {
        Object turma = createTurma("CCO2024", 1500.0);

        Field qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);
        qtdAlunoField.set(turma, 0);

        Method desativar = Turma.class.getDeclaredMethod("desativar");
        Integer qtdAlunoFinal = (Integer) desativar.invoke(turma);

        Integer qtdAluno = (Integer) qtdAlunoField.get(turma);
        Field ativaField = Turma.class.getDeclaredField("ativa");
        ativaField.setAccessible(true);
        Boolean ativa = (Boolean) ativaField.get(turma);

        assertEquals(0, qtdAlunoFinal);
        assertEquals(0, qtdAluno, "A quantidade de alunos da turma deve ser zerado após a desativação");
        assertFalse(ativa); // Verifica se a turma foi inativada
    }

}