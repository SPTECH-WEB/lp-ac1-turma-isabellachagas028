package school.sptech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static school.sptech.TurmaUtil.createTurma;

@DisplayName("Testes de reajuste de mensalidade para a classe Turma")
public class TurmaReajustarMensalidadeTest {

    @Test
    @DisplayName("Reajusta a mensalidade em 15%. Valor da mensalidade esperado após o reajuste: 1150.0")
    public void testReajustarMensalidadeReajusteValido() throws Exception {
        Object turma = createTurma("CCO2024", 1000.0);

        Method reajustarMensalidade = Turma.class.getDeclaredMethod("reajustarMensalidade", Double.class);
        Boolean reajustou = (Boolean) reajustarMensalidade.invoke(turma, 0.15);

        Field mensalidadeField = Turma.class.getDeclaredField("mensalidade");
        mensalidadeField.setAccessible(true);
        Double mensalidade = (Double) mensalidadeField.get(turma);

        assertEquals(1150.0, mensalidade);
        assertTrue(reajustou);
    }

    @Test
    @DisplayName("Tentativa de reajustar a mensalidade com valor de reajuste negativo. Reajuste deve falhar e mensalidade deve permanecer inalterada")
    public void testReajustarMensalidadeReajusteNegativo() throws Exception {
        Object turma = createTurma("CCO2024", 1000.0);

        Method reajustarMensalidade = Turma.class.getDeclaredMethod("reajustarMensalidade", Double.class);
        Boolean reajustou = (Boolean) reajustarMensalidade.invoke(turma, -0.15);

        Field mensalidadeField = Turma.class.getDeclaredField("mensalidade");
        mensalidadeField.setAccessible(true);
        Double mensalidade = (Double) mensalidadeField.get(turma);

        assertEquals(1000.0, mensalidade);
        assertFalse(reajustou);
    }

    @Test
    @DisplayName("Tentativa de reajustar a mensalidade com valor de reajuste zero. Reajuste deve falhar e mensalidade deve permanecer inalterada")
    public void testReajustarMensalidadeReajusteZero() throws Exception {
        Object turma = createTurma("CCO2024", 1000.0);

        Method reajustarMensalidade = Turma.class.getDeclaredMethod("reajustarMensalidade", Double.class);
        Boolean reajustou = (Boolean) reajustarMensalidade.invoke(turma, 0.0);

        Field mensalidadeField = Turma.class.getDeclaredField("mensalidade");
        mensalidadeField.setAccessible(true);
        Double mensalidade = (Double) mensalidadeField.get(turma);

        assertEquals(1000.0, mensalidade);
        assertFalse(reajustou);
    }

    @Test
    @DisplayName("Tentativa de reajustar a mensalidade com valor de reajuste nulo. Reajuste deve falhar e mensalidade deve permanecer inalterada")
    public void testReajustarMensalidadeReajusteNulo() throws Exception {
        Object turma = createTurma("CCO2024", 1000.0);

        Method reajustarMensalidade = Turma.class.getDeclaredMethod("reajustarMensalidade", Double.class);
        Boolean reajustou = (Boolean) reajustarMensalidade.invoke(turma, (Object) null);

        Field mensalidadeField = Turma.class.getDeclaredField("mensalidade");
        mensalidadeField.setAccessible(true);
        Double mensalidade = (Double) mensalidadeField.get(turma);

        assertEquals(1000.0, mensalidade);
        assertFalse(reajustou);
    }

}