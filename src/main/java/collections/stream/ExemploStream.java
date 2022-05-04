package main.java.collections.stream;


import java.math.BigDecimal;
import java.security.Identity;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

public class ExemploStream {

    public static void main(String[] args) {

        record Funcionario(String nome, Integer idade, Double salario) {
        }

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Vitor", 21, 2.000));
        funcionarios.add(new Funcionario("João", 20, 2.100));
        funcionarios.add(new Funcionario("Pedro", 33, 3.200));
        funcionarios.add(new Funcionario("Amanda", 21, 2.300));
        funcionarios.add(new Funcionario("Isabeli", 25, 6.000));
        funcionarios.add(new Funcionario("Daniela", 21, 2.050));
        funcionarios.add(new Funcionario("Will", 19, 1.800));
        funcionarios.add(new Funcionario("Jorge", 55, 1.900));

        /// Retorna uma lista filtrada segunda a verificação.
        List<Funcionario> funcionariosMaior3000 = funcionarios.stream().filter(f -> f.salario > 3000).toList();

        // Mapear atributo dentro da lista.
        List<String> listNomes = funcionarios.stream().map(Funcionario::nome).toList();
        List<Integer> listIdades = funcionarios.stream().map(Funcionario::idade).toList();
        List<Double> listSalarios = funcionarios.stream().map(Funcionario::salario).toList();
    
        // Retorna lista ordenada por idade.
        List<Funcionario> funcionariosOrdenadaPorIdade = funcionarios.stream().sorted(Comparator.comparingInt(Funcionario::idade).thenComparing(Funcionario::nome)).toList();

        /// Retorna o Optional contendo o Funcionário mais velho.
        var funcionarioMaisVelho = funcionarios.stream().max(Comparator.comparingInt(Funcionario::idade));

        /// Retorna o Optional contendo o Funcionário mais novo.
        var funcionarioMaisNovo = funcionarios.stream().min(Comparator.comparingInt(Funcionario::idade));

        /// Retorna soma dos salários.
        var somaSalario = funcionarios.stream().mapToDouble(Funcionario::salario).sum();

        var totalSalario = funcionarios.stream().map(Funcionario::salario).reduce(Double::sum);

        // Verifica se dentro da lista se existe algum salário maior que 3000.
        boolean salarioMaior3000 = funcionarios.stream().anyMatch(f -> f.salario > 3000);

        // Verifica se dentro da lista se todos os salários são que 1000.
        boolean todosAcimaDe1000 = funcionarios.stream().allMatch(f -> f.salario > 1000);

        // Agrupar List de salários por idade.
        var agrupado =  funcionarios.stream().collect(Collectors.groupingBy(Funcionario::idade ,  mapping(Funcionario::salario , toList())));

    }
}
