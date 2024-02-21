import java.util.Scanner;

public class CadastroProduto {

    private static final int TAMANHO = 12;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Produto[] produtos = new Produto[TAMANHO];

        for (int i = 0; i < TAMANHO; i++) {
            System.out.printf("Digite o código do %dº produto: ", i + 1);
            int codigo = scanner.nextInt();

            System.out.printf("Digite a descrição do %dº produto: ", i + 1);
            String descricao = scanner.next();

            System.out.printf("Digite o preço do %dº produto: ", i + 1);
            double preco = scanner.nextDouble();

            produtos[i] = new Produto(codigo, descricao, preco);
        }

        for (int i = 0; i < TAMANHO - 1; i++) {
            for (int j = 0; j < TAMANHO - i - 1; j++) {
                if (produtos[j].getCodigo() > produtos[j + 1].getCodigo()) {
                    Produto aux = produtos[j];
                    produtos[j] = produtos[j + 1];
                    produtos[j + 1] = aux;
                }
            }
        }

        System.out.println("\nProdutos ordenados por código:");
        for (Produto produto : produtos) {
            System.out.println(produto);
        }

        
        int codigoPesquisa = 123;
        int comparacoesSequencial = buscaSequencial(produtos, codigoPesquisa);
        System.out.printf("\nNúmero de comparações usando busca sequencial: %d", comparacoesSequencial);

        int comparacoesBinaria = buscaBinaria(produtos, codigoPesquisa);
        System.out.printf("\nNúmero de comparações usando busca binária: %d", comparacoesBinaria);
    }

    private static int buscaSequencial(Produto[] produtos, int codigo) {
        int comparacoes = 0;
        for (Produto produto : produtos) {
            comparacoes++;
            if (produto.getCodigo() == codigo) {
                return comparacoes;
            }
        }
        return -1;
    }

    private static int buscaBinaria(Produto[] produtos, int codigo) {
        int comparacoes = 0;
        int inicio = 0;
        int fim = TAMANHO - 1;

        while (inicio <= fim) {
            comparacoes++;
            int meio = (inicio + fim) / 2;

            if (produtos[meio].getCodigo() == codigo) {
                return comparacoes;
            } else if (produtos[meio].getCodigo() < codigo) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return -1;
    }
}

class Produto {

    private int codigo;
    private String descricao;
    private double preco;

    public Produto(int codigo, String descricao, double preco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public String toString() {
        return String.format("Código: %d - Descrição: %s - Preço: R$%.2f", codigo, descricao, preco);
    }
}
