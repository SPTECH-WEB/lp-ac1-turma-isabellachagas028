[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/BqfP6GJs)
## 🏦 **Classe: `Turma`**

### 🎯 **Objetivo**
Implemente a classe `Turma` conforme as especificações abaixo. Esta classe representa uma turma de uma instituição de ensino superior com funcionalidades de matricular aluno, cancelar aluno, transferir aluno para outra turma, reajustar a mensalidade do aluno e desativar a turma.

### 🔑 **Atributos**
1. **`nome`** (`String`) - Nome ou código da turma.
2. **`mensalidade`** (`Double`) - Valor da mensalidade de cada aluno da turma. 
3. **`qtdAluno`** (`Integer`) - Quantidade atual de alunos da turma.
4. **`ativa`** (`Boolean`) - Status da turma (ativa ou inativa).

### 🛠️ **Construtor**
- **`public Turma(String nome, Double mensalidade)`**
   - Inicializa uma turma com o nome da turma, valor da mensalidade, qtdAluno `0`, e define a turma como `ativa`.

### 💰 **Métodos Públicos**

1. **`public void matricular(Integer qtd)`**
   - Adiciona a qtd de alunos a serem matriculados à qtdAluno da turma, desde que:
      - O valor de qtd seja positivo (não pode ser negativo nem zero) e não seja `null`.
      - A turma esteja ativa.
   - Caso a turma esteja inativa, a matrícula não será realizada.

2. **`public Integer cancelar(Integer qtd)`**
   - Deduz o valor de qtd de alunos a serem cancelados da qtdAluno da turma, desde que:
      - O valor de qtd seja positivo e não seja `null`.
      - O valor de qtd seja menor ou igual à qtdAluno.
      - A turma esteja ativa.
   - Retorna a quantidade de alunos cancelados, caso o cancelamento tenha sido bem sucedido.
   - Retorna `null` caso as condições não sejam atendidas, como qtdAluno menor do que qtd, valor de qtd inválido, ou turma inativa.

3. **`public Integer desativar()`**
   - Se a turma já estava desativada, não faz nada e retorna null.
   - Desativa a turma (`ativa` se torna `false`).
   - Retorna a quantidade de alunos que estava presente na turma, não esquecendo de zerar `qtdAluno` antes de retornar. 

4. **`public void transferir(Turma destino, Integer qtdATransferir)`**
   - Transfere uma quantidade de alunos (`qtdATransferir`) para outra turma (`destino`), desde que:
      - A turma destino seja válida e esteja ativa.
      - O valor de qtdATransferir seja positivo e não seja `null`.
      - Haja quantidade de alunos suficiente para a transferência na turma de origem.
      - A turma origem esteja ativa.
   - Caso as condições não sejam atendidas, a transferência não ocorrerá.

5. **`public Boolean reajustarMensalidade(Double reajuste)`**
   - Se `reajuste` for zero ou negativo ou `null`, não faz nada e retorna `false`  
   - Atualiza o valor de `mensalidade`, supondo que se a mensalidade for reajustada em 20%, o valor passado em `reajuste` será de `0.20`
   - Caso tenha reajustado a mensalidade, retorna `true`.

6. **`public String getNome()`**
   - Retorna o nome da turma.

7. **`public Double getMensalidade()`**
   - Retorna o valor da mensalidade.

8. **`public Integer getQtdAluno()`**
   - Retorna a quantidade de alunos.

9. **`public Boolean getAtiva()`**
   - Retorna o status da turma (`true` para ativa, `false` para inativa).

10. **`public void setNome(String nome)`**
    - Define o nome do aluno.

### ❌ **Setters que não devem existir**
- **`setMensalidade(Double mensalidade)`**: Não deve existir um setter para o atributo `mensalidade`.
- **`setQtdAluno(Integer qtdAluno)`**: Não deve existir um setter para o atributo `qtdAluno`.
- **`setAtiva(Boolean ativa)`**: Não deve existir um setter para o atributo `ativa`.

### ⚠️ **Atenção aos Nomes e Assinaturas**
- **Nomes dos Atributos e Métodos**: É necessário seguir rigorosamente os nomes dos atributos e métodos conforme especificado.
- **Assinaturas dos Métodos**: As assinaturas dos métodos (nome, tipo de retorno, parâmetros) devem ser exatamente como descritas.
- **Impacto nos Testes**: Qualquer desvio nos nomes ou assinaturas pode causar falhas nos testes automáticos.

### 📦 **Extensões e Classes Auxiliares**
- **Adição de métodos e atributos**: Você pode criar mais métodos e/ou atributos além dos especificados, desde que todas as funcionalidades descritas acima sejam implementadas corretamente.
- **Classes auxiliares**: Já existe uma classe `Main` com um método `main` para auxiliar nos testes manuais, caso deseje testar o comportamento da classe manualmente. No entanto, o que será contabilizado é a lógica empregada na classe `Turma`.

### 📝 **Como enviar seu código para o Classroom**
1. **Adicionar os arquivos modificados**:
   ```bash
   git add .
   ```
2. **Fazer o commit com seu RA e nome**:
   ```bash
   git commit -m "RA: 123456 - Fulano de Tal"
   ```
3. **Enviar o commit para o repositório**:
   ```bash
   git push
   ```

### 🧪 **Testes do projeto**
- #### <span style="color:red;">**Os testes serão utilizados para atribuir uma nota ao seu trabalho, portanto é essencial que a classe siga rigorosamente o que é pedido.**</span>
- Rode os testes para garantir que a implementação está correta antes de enviar.

---

### 📚 **Lembre-se**: "Aprender não é sobre alcançar a perfeição, mas sobre crescer e evoluir a cada desafio superado." 🌱

### Boa sorte! 🚀

---