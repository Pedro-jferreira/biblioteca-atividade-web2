package com.example.atividade2.config;


import com.example.atividade2.entity.AutorEntity;
import com.example.atividade2.entity.EditoraEntity;
import com.example.atividade2.entity.LivroEntity;
import com.example.atividade2.service.AutorService;
import com.example.atividade2.service.EditoraService;
import com.example.atividade2.service.LivroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    private final AutorService autorService;
    private final EditoraService editoraService;
    private final LivroService livroService;
    Scanner scanner = new Scanner(System.in);

    @Autowired
    public TestConfig(AutorService autorService, EditoraService editoraService, LivroService livroService) {
        this.autorService = autorService;
        this.editoraService = editoraService;
        this.livroService = livroService;
    }

    @Override
    public void run(String... args) {
        insertDados();

        while (true){
            switch (escolha()){

                case 1 -> {
                    livroService.displayFindAll();
                    autorService.findAutoresByLivro(getEntityIsPresent(livroService.buscarPorId(lerId()),
                            "Livro não encontrado no banco de dados. tente novamente: "));
                }
                case 2 -> {
                    autorService.displayFindAll();
                    livroService.findLivrosByAutor(getEntityIsPresent(autorService.buscarPorId(lerId()),
                            "Autor não encontrado no banco de dados. tente novamente: "));


                }
                case 3 -> {
                    livroService.displayFindAll();
                    editoraService.findAutoresByLivro(getEntityIsPresent(livroService.buscarPorId(lerId()),
                            "Livro não encontrado no banco de dados. tente novamente: "));
                }
                case 4 -> {
                    editoraService.displayFindAll();
                    livroService.findLivrosByEditora(getEntityIsPresent(editoraService.buscarPorId(lerId()),
                            "Editora não encontrado no banco de dados. tente novamente: "));
                }
                case 5 -> {
                    editoraService.displayFindAll();
                    autorService.findAutoresByEditora(getEntityIsPresent(editoraService.buscarPorId(lerId()),
                            "Editora não encontrado no banco de dados. tente novamente: "));

                }
                case 6 -> {
                    autorService.displayFindAll();
                    editoraService.findEditorasByAutor(getEntityIsPresent(autorService.buscarPorId(lerId()),
                            "Autor não encontrado no banco de dados. tente novamente: "));

                }
                case 7 -> livroService.displayFindAll();
                case 8 -> autorService.displayFindAll();
                case 9 -> editoraService.displayFindAll();
                case 10 -> System.exit(0);
                default -> System.out.println("numero invalido. tente de novo");

            }
        }

    }
    private void insertDados() {
        // Inserir Editoras Reais (substitua pelos nomes reais)
        EditoraEntity editora1 = new EditoraEntity(null, "Companhia das Letras");
        EditoraEntity editora2 = new EditoraEntity(null, "Record");
        EditoraEntity editora3 = new EditoraEntity(null, "Intrínseca");
        EditoraEntity editora4 = new EditoraEntity(null, "Objetiva");

        editoraService.salvarEditora(editora1);
        editoraService.salvarEditora(editora2);
        editoraService.salvarEditora(editora3);
        editoraService.salvarEditora(editora4);

        // Inserir Autores Reais (substitua pelos nomes reais)
        AutorEntity autor1 = new AutorEntity(null, "Machado de Assis");
        AutorEntity autor2 = new AutorEntity(null, "Clarice Lispector");
        AutorEntity autor3 = new AutorEntity(null, "Guimarães Rosa");
        AutorEntity autor4 = new AutorEntity(null, "Cecília Meireles");
        AutorEntity autor5 = new AutorEntity(null, "Carlos Drummond de Andrade");
        AutorEntity autor6 = new AutorEntity(null, "Lya Luft");

        autorService.salvarAutor(autor1);
        autorService.salvarAutor(autor2);
        autorService.salvarAutor(autor3);
        autorService.salvarAutor(autor4);
        autorService.salvarAutor(autor5);
        autorService.salvarAutor(autor6);

        // Inserir Livros Reais (substitua pelos nomes reais e ajuste os ISBNS)
        LivroEntity livro1 = new LivroEntity(null, "Dom Casmurro", 1899, "9788574801412", editora1, Arrays.asList(autor1));
        LivroEntity livro2 = new LivroEntity(null, "Grande Sertão: Veredas", 1956, "9788535908068", editora1, Arrays.asList(autor3));
        LivroEntity livro3 = new LivroEntity(null, "A Hora da Estrela", 1977, "9788535908068", editora2, Arrays.asList(autor2));
        LivroEntity livro4 = new LivroEntity(null, "Romanceiro da Inconfidência", 1953, "9788535911587", editora2, Arrays.asList(autor4));
        LivroEntity livro5 = new LivroEntity(null, "Sentimento do Mundo", 1940, "9788520937603", editora1, Arrays.asList(autor5));
        LivroEntity livro6 = new LivroEntity(null, "Reinações de Narizinho", 1931, "9788520925709", editora2, Arrays.asList(autor6));
        LivroEntity livro7 = new LivroEntity(null, "A Metamorfose", 1915, "9788573261288", editora3, Arrays.asList(autor2));
        LivroEntity livro8 = new LivroEntity(null, "O Cortiço", 1890, "9788573261288", editora3, Arrays.asList(autor1));
        LivroEntity livro9 = new LivroEntity(null, "Memórias Póstumas de Brás Cubas", 1881, "9788520937078", editora4, Arrays.asList(autor5));
        LivroEntity livro10 = new LivroEntity(null, "Quincas Borba", 1891, "9788573262346", editora4, Arrays.asList(autor1));
        LivroEntity livro11 = new LivroEntity(null, "O Alienista", 1882, "9788572326101", editora1, Arrays.asList(autor3));
        LivroEntity livro12 = new LivroEntity(null, "O Primo Basílio", 1878, "9788525408167", editora2, Arrays.asList(autor4));

        livroService.salvarLivro(livro1);
        livroService.salvarLivro(livro2);
        livroService.salvarLivro(livro3);
        livroService.salvarLivro(livro4);
        livroService.salvarLivro(livro5);
        livroService.salvarLivro(livro6);
        livroService.salvarLivro(livro7);
        livroService.salvarLivro(livro8);
        livroService.salvarLivro(livro9);
        livroService.salvarLivro(livro10);
        livroService.salvarLivro(livro11);
        livroService.salvarLivro(livro12);
    }

    private int escolha() {
        while (true) {
            System.out.println("""
                Faça uma escolha:

                (1) Quais autores por livro
                (2) Quais livros por autor
                (3) Quais editoras por livro
                (4) Quais livros por editora
                (5) Quais autores por editora
                (6) Quais editoras por autor
                (7) Listar todos os livros
                (8) Listar todos os autores
                (9) Listar todas as editoras
                (10) Sair""");

            String input = scanner.next();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
            }
        }
    }
    private  Long lerId() {
        while (true) {
            System.out.println("Digite um ID:");
            String input = scanner.next();

            try {
                return Long.parseLong(input);
            } catch (NumberFormatException e) {
                System.out.println("ID inválido. Por favor, digite um número long válido.");
            }
        }
    }
    public <T> T getEntityIsPresent(Optional<T> optional, String mensagemErro) {
        try {
            return optional.orElseThrow(() -> new IllegalArgumentException(mensagemErro));
        } catch (IllegalArgumentException e) {
            System.out.println(mensagemErro);
            return null;
        }
    }


}
