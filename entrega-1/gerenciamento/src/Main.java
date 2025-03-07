
import domain.Funcionario;
import domain.GerenciadorFuncionarios;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorFuncionarios gerenciador = new GerenciadorFuncionarios();

        while (true) {
            System.out.println("\n1. Adicionar Funcionário");
            System.out.println("2. Listar Funcionários");
            System.out.println("3. Atualizar Salário");
            System.out.println("4. Remover Funcionário");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Salário: ");
                    double salario = scanner.nextDouble();
                    gerenciador.adicionarFuncionario(new Funcionario(id, nome, salario));
                    break;
                case 2:
                    System.out.println("Lista de Funcionários:");
                    for (Funcionario f : gerenciador.listarFuncionarios()) {
                        System.out.println(f);
                    }
                    break;
                case 3:
                    System.out.print("ID do funcionário: ");
                    int idAtualizar = scanner.nextInt();
                    if(!gerenciador.isFuncionarioExistente(idAtualizar)) {
                        System.out.println("Funcionário não encontrado!");
                        break;
                    }
                    System.out.print("Novo salário: ");
                    double novoSalario = scanner.nextDouble();
                    gerenciador.atualizarSalario(idAtualizar, novoSalario);
                    System.out.println("Salário atualizado com sucesso!");
                    break;
                case 4:
                    System.out.print("ID do funcionário a remover: ");
                    int idRemover = scanner.nextInt();
                    if(!gerenciador.isFuncionarioExistente(idRemover)) {
                        System.out.println("Funcionário não encontrado!");
                        break;
                    }
                    gerenciador.removerFuncionario(idRemover);
                    System.out.println("Funcionário removido com sucesso!");
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
