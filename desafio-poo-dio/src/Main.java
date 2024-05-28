import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Conteudo;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        try {

            System.out.println("Bem vindo nosso sistema de bootcamps");
            Set<Conteudo> conteudos = criarListaConteudo();

            Bootcamp bootcamp = criarBootcamp();

            ecolherListaCurso(conteudos, bootcamp);

            adicionarDev(bootcamp);

            progredirDev(bootcamp);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }

    }

    private static Set<Conteudo> criarListaConteudo() {

        Set<Conteudo> conteudos = new LinkedHashSet<>();
        while (true) {
            Curso curso = null;
            Mentoria mentoria = null;
            System.out.println("Cadastre os cursos e mentorias que serão usados para os bootcamps:");

            System.out.println("Curso ou mentoria? C/M");
            String option = sc.nextLine().toUpperCase();

            if (option.equals("C")) {
                curso = new Curso();
                System.out.println("Digite o titulo do curso");
                curso.setTitulo(sc.nextLine());

                System.out.println("Digite a descrição do curso");
                curso.setDescricao(sc.nextLine());

                System.out.println("Digite a carga horária do curso");
                curso.setCargaHoraria(sc.nextInt());
                sc.nextLine();
                conteudos.add(curso);
            }
            if (option.equals("M")) {
                mentoria = new Mentoria();
                System.out.println("Digite o titulo da mentoria");
                mentoria.setTitulo(sc.nextLine());

                System.out.println("Digite a descrição da mentoria");
                mentoria.setDescricao(sc.nextLine());

                mentoria.setData(LocalDate.now());
                conteudos.add(mentoria);
            }

            if (!conteudos.isEmpty()) {
                System.out.println("Deseja cadastrar outro curso? S/N");
                if (sc.nextLine().toUpperCase().equals("N")) {
                    break;
                }
            }
            

        }
        return conteudos;
    }

    private static Bootcamp criarBootcamp() {
        Bootcamp bootcamp = null;
        System.out.println("Cadastre um bootcamp:");

        System.out.println("Digite o nome do bootcamp");
        String nomeBoootcamp = sc.nextLine();
        System.out.println("Digite a descrição do bootcamp");
        String descricaoBootcamp = sc.nextLine();
        bootcamp = new Bootcamp(nomeBoootcamp, descricaoBootcamp);

        return bootcamp;

    }

    private static void adicionarDev(Bootcamp bootcamp) {
        while (true) {
            System.out.println("Adicionar devs aos bootcamps");
            System.out.println("Digite o nome do dev");

            Dev dev = new Dev();
            dev.setNome(sc.nextLine().toLowerCase());
            dev.inscreverBootcamp(bootcamp);
            System.out.printf("Dev %s inscrito no bootcamp %s \n", dev.getNome(), bootcamp.getNome());

            System.out.println("Adicionar mais devs? S/N");

            if (sc.nextLine().toUpperCase().equals("N")) {
                break;
            }
        }

    }

    private static void ecolherListaCurso(Set<Conteudo> conteudos, Bootcamp bootcamp) {
        if (conteudos.isEmpty()) {
            System.out.println("Lista de cursos vazia!");
            bootcamp.getConteudos().addAll(criarListaConteudo());
        }

        System.out.println("Adicionar lista atual de cursos a este bootcamp");

        conteudos.stream().forEach(c -> System.out.println(">>" + c.getTitulo()));
        System.out.println("Adicionar? S/N");

        if (sc.nextLine().toUpperCase().equals("S")) {
            bootcamp.getConteudos().addAll(conteudos);
            System.out.println("Lista adicionada....");
        } else {
            System.out.println("Crie nova lista de conteudos");
            bootcamp.getConteudos().addAll(criarListaConteudo());
            System.out.println("Nova lista adicionada");
        }
    }

    private static void progredirDev(Bootcamp bootcamp) {
        while (true) {
            System.out.println("Progredir Dev:");
            System.out.println("Escolha um Dev da lista pelo nome:");
            bootcamp.getDevsInscritos().forEach(System.out::println);
            String dev = sc.nextLine().toLowerCase();

            Optional<Dev> devSelecionado = bootcamp.getDevsInscritos()
                    .stream()
                    .filter(d -> d.getNome().equals(dev)).findFirst();

            if (devSelecionado.isPresent()) {
                devSelecionado.get().progredir();
                devSelecionado.get().calcularTotalXp();

            }
            else {
                System.out.println("Bootcamp já foi concluido!");
            }

            System.out.println("Deseja progredir outro dev? S/N");
            String option = sc.nextLine();

            if (option.toUpperCase().charAt(0) == 'N') {
                break;
            }
        }

    }
}
