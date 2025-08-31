package school.sptech;

import java.lang.reflect.Constructor;

public class TurmaUtil {

    public static Object createTurma(String nome, Double mensalidade) throws Exception {
        Constructor<?> constructor = Turma.class.getDeclaredConstructor(String.class, Double.class);
        return constructor.newInstance(nome, mensalidade);
    }
}
