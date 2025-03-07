package domain;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorFuncionarios {
    private List<Funcionario> funcionarios = new ArrayList<>();

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public List<Funcionario> listarFuncionarios() {
        return new ArrayList<>(funcionarios);
    }

    public boolean isFuncionarioExistente(int id) {
        return funcionarios.stream().anyMatch(f -> id == f.getId());
    }

    public void atualizarSalario(int id, double novoSalario) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id) {
                funcionario.setSalario(novoSalario);
            }
        }
    }

    public void removerFuncionario(int id) {
        funcionarios.removeIf(funcionario -> funcionario.getId() == id);
    }
}
