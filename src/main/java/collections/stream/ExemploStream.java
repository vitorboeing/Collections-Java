package main.java.collections.stream;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ExemploStream {

    public static void main(String[] args) {

        record Funcionario(String nome, Integer idade, Double salario) {
        }

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Vitor", 21, 2.000));
        funcionarios.add(new Funcionario("João", 20, 2.500));
        funcionarios.add(new Funcionario("Pedro", 21, 2.000));
        funcionarios.add(new Funcionario("Vitor", 21, 2.000));
        funcionarios.add(new Funcionario("Vitor", 21, 2.000));
        funcionarios.add(new Funcionario("Vitor", 21, 2.000));
        funcionarios.add(new Funcionario("Vitor", 21, 2.000));
        funcionarios.add(new Funcionario("Vitor", 21, 2.000));

        /// Retorna o Optional contendo o Funcionário mais velho.
        var funcionarioMaisVelho = funcionarios.stream().max(Comparator.comparing(Funcionario::idade));


    }

}
