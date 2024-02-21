//questao 1
//Alternativa a
class Bublesort{
    public static void main(String[]args){
        Funcionario[] funcionarios = new Funcionario[5];

        funcionarios[0] = new Funcionario("Marcos", 2500.0);
        funcionarios[1] = new Funcionario("Maria", 3000.0);
        funcionarios[2] = new Funcionario("Victor", 1900.0);
        funcionarios[3] = new Funcionario("Isabela", 4000.0);
        funcionarios[4] = new Funcionario("Paulo", 2000.0);

        boolean trocado = true;
    
        while(trocado){
            trocado = false;
            for(int i=0;i<funcionarios.length-1;i++){
              if(funcionarios[i].getSalario()>funcionarios[i+1].getSalario(){
                  Funcionario temp = funcionarios[i];
                  funcionarios[i] = funcionarios[i+1];
                  funcionarios[i+1] = temp;
                  trocado = true;
              }
            }
        }

        for(Funcionario funcionario:funcionarios){
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Salario: " + funcionario.getSalario());
            System.out.println();
        }
    }
}

 class Funcionario {
  private String nome;
  private double salario;

  public Funcionario(String nome, double salario) {
    this.nome = nome;
    this.salario = salario;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getSalario() {
    return salario;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }


  }

public class insertionSort{
  public static void main(String[]args){
    Funcionario[] funcionarios = new Funcionario[5];

    funcionarios[0] = new Funcionario("Marcos", 2500.0);
    funcionarios[1] = new Funcionario("Maria", 3000.0);
    funcionarios[2] = new Funcionario("Victor", 1900.0);
    funcionarios[3] = new Funcionario("Isabela", 4000.0);
    funcionarios[4] = new Funcionario("Paulo", 2000.0);
    
    for(int i=1;i<funcionarios.length-1;i++){
      int atual = funcionarios[i].getSalario();
      int j = i-1;

      while(j>=0 && atual[j] < funcionarios[j]{
        funcionarios[j+1] = funcionarios[j];
        j--;
      }
      funcionarios[j+1] = atual;

    for(Funcionario funcionario:funcionarios){
          System.out.println("Nome: " + funcionario.getNome());
          System.out.println("Salario: " + funcionario.getSalario());
          System.out.println();
      }
    }
  }
}

//Alternativa b

class Funcionario {
  private String nome;
  private double salario;

  public Funcionario(String nome, double salario) {
    this.nome = nome;
    this.salario = salario;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getSalario() {
    return salario;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }

  }

//Alternativa c
public class Main {

    public static void main(String[] args) {

        List<Funcionario> funcionarios = Arrays.asList(
            new Funcionario("Marcos", 2500.0),
            new Funcionario("Maria", 3000.0),
            new Funcionario("Victor", 1900.0),
            new Funcionario("Isabela", 4000.0),
            new Funcionario("Paulo", 2000.0)
        );

        Collections.sort(funcionarios, Comparator.comparing(Funcionario::getNome);
      
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getNome());
        }
    }
}

