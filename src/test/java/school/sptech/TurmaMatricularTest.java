package school.sptech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static school.sptech.TurmaUtil.createTurma;

@DisplayName("Testes de matrícula para a classe Turma")
public class TurmaMatricularTest {

    @Test
    @DisplayName("Matrícula de 10 alunos em uma turma com zero alunos. Quantidade de alunos esperado: 10")
    public void testMatricularQtdPositivo() throws Exception {
        Object turma = createTurma("CCO2024", 1500.0);

        Method matricular = Turma.class.getDeclaredMethod("matricular", Integer.class);
        matricular.invoke(turma, 10);

        Field qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);
        Integer qtdAluno = (Integer) qtdAlunoField.get(turma);

        assertEquals(10, qtdAluno);
    }

    @Test
    @DisplayName("Tentativa de matricular -10 alunos em uma turma com zero alunos. Quantidade de alunos esperado: 0 (matrícula inválida)")
    public void testMatricularQtdNegativo() throws Exception {
        Object turma = createTurma("CCO2024", 1500.0);

        Method matricular = Turma.class.getDeclaredMethod("matricular", Integer.class);
        matricular.invoke(turma, -10);

        Field qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);
        Integer qtdAluno = (Integer) qtdAlunoField.get(turma);

        assertEquals(0, qtdAluno); // Quantidade de alunos deve permanecer a mesma
    }

    @Test
    @DisplayName("Tentativa de matricular zero alunos em uma turma com zero alunos. Quantidade de alunos esperado: 0 (matrícula inválida)")
    public void testMatricularQtdZero() throws Exception {
        Object turma = createTurma("CCO2024", 1500.0);

        Method matricular = Turma.class.getDeclaredMethod("matricular", Integer.class);
        matricular.invoke(turma, 0);

        Field qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);
        Integer qtdAluno = (Integer) qtdAlunoField.get(turma);

        assertEquals(0, qtdAluno); // Quantidade de alunos deve permanecer a mesma
    }

    @Test
    @DisplayName("Tentativa de matricular quantidade com valor nulo de alunos em uma turma com zeros alunos. Quantidade de alunos esperado: 0 (matrícula inválida)")
    public void testMatricularQtdNulo() throws Exception {
        Object turma = createTurma("CCO2024", 1500.0);

        Method matricular = Turma.class.getDeclaredMethod("matricular", Integer.class);
        matricular.invoke(turma, (Object) null);

        Field qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);
        Integer qtdAluno = (Integer) qtdAlunoField.get(turma);

        assertEquals(0, qtdAluno); // Quantidade de alunos deve permanecer a mesma
    }

    @Test
    @DisplayName("Matrícula de 10 alunos em uma turma inativa com zero alunos. Quantidade de alunos esperado: 0 (matrícula não realizada devido à turma inativa)")
    public void testMatricularTurmaInativa() throws Exception {
        Object turma = createTurma("CCO2024", 1500.0);

        Field ativaField = Turma.class.getDeclaredField("ativa");
        ativaField.setAccessible(true);
        ativaField.set(turma, false);

        Method matricular = Turma.class.getDeclaredMethod("matricular", Integer.class);
        matricular.invoke(turma, 10);

        Field qtdAlunoField = Turma.class.getDeclaredField("qtdAluno");
        qtdAlunoField.setAccessible(true);
        Integer qtdAluno = (Integer) qtdAlunoField.get(turma);

        assertEquals(0, qtdAluno);
    }
}