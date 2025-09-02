package school.sptech;

public class Main {
    public static void main(String[] args) {
        System.out.println("Boa sorte!");
        System.out.println("Você pode testar manualmente a classe Turma aqui se quiser....");
        Turma turmaA=new Turma("teste",2.2);
        Turma turmaB=new Turma("teste1",2.3);
        turmaB.desativar();
        turmaA.matricular(10);
        turmaA.transferir(turmaB,5);
        System.out.println(turmaA.getQtdAluno());
        System.out.println(turmaB.getQtdAluno());
    }
}