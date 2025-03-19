import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        Map<Integer, Produto> produtos = new HashMap<>();
        int opcao;

        do {
            System.out.println("----- Menu -----");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Buscar produto por código");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = leia.nextInt();
            leia.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.println("Cadastrar produto");
                    System.out.print("Código: ");
                    int cod = leia.nextInt();
                    leia.nextLine();

                    // Verifica se já existe um produto com o mesmo código
                    if(produtos.containsKey(cod)) {
                        System.out.println("Produto com este código já existe.");
                        break;
                    }

                    System.out.print("Nome: ");
                    String nome = leia.nextLine();
                    System.out.print("Preço: ");
                    double preco = leia.nextDouble();
                    leia.nextLine();

                    Produto prod = new Produto(cod, nome, preco);
                    produtos.put(cod, prod);
                    System.out.println("Produto cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.println("Buscar produto");
                    System.out.print("Digite o código do produto: ");
                    int busca = leia.nextInt();
                    leia.nextLine();

                    if(produtos.containsKey(busca)) {
                        System.out.println("Produto encontrado: ");
                        System.out.println(produtos.get(busca));
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);

        leia.close();
    }
}
