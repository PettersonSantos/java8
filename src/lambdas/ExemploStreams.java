package lambdas;

import java.util.*;
import java.util.stream.Collectors;

class Curso {
    private String name;
    private int alunos;

    public Curso(String name, int alunos) {
        this.name = name;
        this.alunos = alunos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlunos() {
        return alunos;
    }

    public void setAlunos(int alunos) {
        this.alunos = alunos;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "name='" + name + '\'' +
                ", alunos=" + alunos +
                '}';
    }
}

public class ExemploStreams {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 55));

        cursos.sort(Comparator.comparing(Curso::getAlunos));
        //cursos.forEach(System.out::println);

        //imprimindo numero de alunos dos cursos com mais de 100 alunos
        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .map(Curso::getAlunos)
                .forEach(System.out::println);

        //somando e devolvendo numero de alunos dos cursos com mais de 100 alunos;
        int sum = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .mapToInt(Curso::getAlunos)
                .sum();
        System.out.println("soma: " + sum);

        //imprimindo qualquer curso com mais de 100 alunos. Usando o ifPresent que não retorna nullpointer ou excepcion
        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .findAny()
                .ifPresent(c -> System.out.println(c.getName()));

        //usando collector para transformar Stream em Collector list
        cursos = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .collect(Collectors.toList());
        cursos.forEach(System.out::println);

        //usando collector para transformar Stream em Map e imprimindo
        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .collect(Collectors.toMap(
                        Curso::getName,
                        Curso::getAlunos
                ))
                .forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));
    }
}
