import java.util.Scanner;
public class SistemaRestaurante {
    private static final String LOGIN_CORRETO = "cliente";
    private static final String SENHA_CORRETA = "123";

    private final Scanner scanner;
    private final Carrinho carrinho;

    public SistemaRestaurante() {
        scanner = new Scanner(System.in);
        carrinho = new Carrinho();
    }

    public void iniciar() {
        if (fazerLogin()) {
            menuPrincipal();
        }
        System.out.println("Programa encerrado.");
    }

    private boolean fazerLogin() {
        while (true) {
            System.out.println("--- LOGIN ---");
            System.out.println("1 - Entrar");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 0) {
                return false;
            }

            System.out.print("Usuário: ");
            String login = scanner.nextLine();

            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            if (login.equals(LOGIN_CORRETO) && senha.equals(SENHA_CORRETA)) {
                System.out.println("Login realizado com sucesso!");
                return true;
            } else {
                System.out.println("Credenciais inválidas. Tente novamente.");
            }
        }
    }

    private void menuPrincipal() {
        int opcao;

        do {
            System.out.println("--- MENU PRINCIPAL ---");
            System.out.println("1 - Incluir pedido");
            System.out.println("2 - Consultar carrinho");
            System.out.println("3 - Editar item do carrinho");
            System.out.println("4 - Excluir item do carrinho");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    incluirPedido();
                    break;
                case 2:
                    carrinho.listarItens();
                    break;
                case 3:
                    editarPedido();
                    break;
                case 4:
                    excluirPedido();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void incluirPedido() {
        ItemCardapio itemEscolhido = escolherItemCardapio();
        if (itemEscolhido != null) {
            carrinho.adicionarItem(itemEscolhido);
            System.out.println("Item adicionado ao carrinho.");
        }
    }

    private void editarPedido() {
        if (carrinho.estaVazio()) {
            System.out.println("Carrinho vazio. Nada para editar.");
            return;
        }

        carrinho.listarItens();
        System.out.print("Digite o número do item que deseja editar: ");
        int posicao = scanner.nextInt();
        scanner.nextLine();

        ItemCardapio novoItem = escolherItemCardapio();
        if (novoItem != null) {
            carrinho.editarItem(posicao - 1, novoItem);
        }
    }

    private void excluirPedido() {
        if (carrinho.estaVazio()) {
            System.out.println("Carrinho vazio. Nada para excluir.");
            return;
        }

        carrinho.listarItens();
        System.out.print("Digite o número do item que deseja remover: ");
        int posicao = scanner.nextInt();
        scanner.nextLine();

        carrinho.removerItem(posicao - 1);
    }

    private ItemCardapio escolherItemCardapio() {
        System.out.println("--- CARDÁPIO ---");
        System.out.println("1 - Cachorro-Quente");
        System.out.println("2 - Sushi");
        System.out.println("3 - Pizza");
        System.out.println("4 - Baguncinha");
        System.out.print("Escolha um item: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                return new ItemCardapio(1, "Cachorro-Quente", 12.00);
            case 2:
                return new ItemCardapio(2, "Sushi", 25.00);
            case 3:
                return new ItemCardapio(3, "Pizza", 35.00);
            case 4:
                return new ItemCardapio(4, "Baguncinha", 18.00);
            default:
                System.out.println("Opção inválida.");
                return null;
        }
    }
}
