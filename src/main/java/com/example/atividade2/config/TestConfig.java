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
    private void insertDados(){

        EditoraEntity editora1 = new EditoraEntity(null, "Editora 1");
        EditoraEntity editora2 = new EditoraEntity(null, "Editora 2");

        editoraService.salvarEditora(editora1);
        editoraService.salvarEditora(editora2);


        AutorEntity autor1 = new AutorEntity(null, "Autor 1");
        AutorEntity autor2 = new AutorEntity(null, "Autor 2");
        AutorEntity autor3 = new AutorEntity(null, "Autor 3");
        AutorEntity autor4 = new AutorEntity(null, "Autor 4");

        autorService.salvarAutor(autor1);
        autorService.salvarAutor(autor2);
        autorService.salvarAutor(autor3);
        autorService.salvarAutor(autor4);


        LivroEntity livro1 = new LivroEntity(null, "Livro 1", 2022, "ISBN1", editora1, Arrays.asList(autor1, autor2));
        LivroEntity livro2 = new LivroEntity(null, "Livro 2", 2022, "ISBN2", editora1, Arrays.asList(autor3, autor4));
        LivroEntity livro3 = new LivroEntity(null, "Livro 3", 2022, "ISBN3", editora2, Arrays.asList(autor1, autor4));
        LivroEntity livro4 = new LivroEntity(null, "Livro 4", 2022, "ISBN4", editora2, Arrays.asList(autor2, autor3));
        LivroEntity livro5 = new LivroEntity(null, "Livro 5", 2022, "ISBN5", editora1, Arrays.asList(autor1, autor3));
        LivroEntity livro6 = new LivroEntity(null, "Livro 6", 2022, "ISBN6", editora2, Arrays.asList(autor2, autor4));
        LivroEntity livro7 = new LivroEntity(null, "Livro 7", 2022, "ISBN7", editora1, Arrays.asList(autor3, autor4));
        LivroEntity livro8 = new LivroEntity(null, "Livro 8", 2022, "ISBN8", editora2, Arrays.asList(autor1, autor2));

        livroService.salvarLivro(livro1);
        livroService.salvarLivro(livro2);
        livroService.salvarLivro(livro3);
        livroService.salvarLivro(livro4);
        livroService.salvarLivro(livro5);
        livroService.salvarLivro(livro6);
        livroService.salvarLivro(livro7);
        livroService.salvarLivro(livro8);

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
