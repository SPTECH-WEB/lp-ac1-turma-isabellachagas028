package school.sptech;

public class Turma {



    private String nome;
    private  Double mensalidade;
private   Integer qtdAluno;
private Boolean ativa;
 public Turma(String nome, Double mensalidade){
     this.nome=nome;
     this.mensalidade=mensalidade;
     qtdAluno=0;
     ativa=true;
 }
 public void matricular(Integer qtd){
     if(qtd!=null && qtd>0 && ativa==true){
         qtdAluno+=qtd;
     }
 }
 public  Integer cancelar(Integer qtd){
     if (qtd!=null && qtd>0 && qtd<=qtdAluno && ativa==true){
         qtdAluno-=qtd;
         return qtd;
     }
     else{
     return null;}
 }
 public Integer desativar(){
     if(ativa==true){
         ativa=false;
        Integer qtdAntiga=qtdAluno;
         qtdAluno=0;
         return qtdAntiga;

     }
     else {
         return null;
     }
 }


 public Boolean reajustarMensalidade(Double reajuste){
     if(reajuste!=null && reajuste>0){
         mensalidade=(mensalidade*(1+reajuste));
         return true;
     }
     else{
         return false;
     }
 }

    public String getNome() {
        return nome;
    }

    public Double getMensalidade() {
        return mensalidade;
    }

    public Integer getQtdAluno() {
        return qtdAluno;
    }

    public Boolean getAtiva() {
        return ativa;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void transferir(Turma destino, Integer qtdATransferir){
     if(qtdATransferir!=null &&  qtdATransferir>0 && ativa==true && destino.ativa==true && qtdAluno<=qtdATransferir){
         qtdAluno=qtdAluno- qtdATransferir;
         destino.qtdAluno= destino.qtdAluno-qtdATransferir;
     }
    }
}
