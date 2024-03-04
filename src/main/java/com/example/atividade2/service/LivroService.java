package com.example.atividade2.service;

import com.example.atividade2.entity.AutorEntity;
import com.example.atividade2.entity.EditoraEntity;
import com.example.atividade2.entity.LivroEntity;
import com.example.atividade2.repository.LivroRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
    @Autowired
    private LivroRepository repository;
    
    public List<LivroEntity> listarLivros() {
        return repository.findAll();
    }

    public Optional<LivroEntity> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public LivroEntity salvarLivro(LivroEntity livro) {
        if (livro.getAutoresEntities() == null || livro.getAutoresEntities().isEmpty()) {
            throw new IllegalArgumentException("Pelo menos um autor deve ser especificado");
        } else return repository.save(livro);
    }

    public LivroEntity atualizarLivro(Long id, LivroEntity livroAtualizado) {
        Optional<LivroEntity> livroExistente = repository.findById(id);

        if (livroExistente.isPresent()) {
            if (livroAtualizado.getAutoresEntities() == null || livroAtualizado.getAutoresEntities().isEmpty()) {
                throw new IllegalArgumentException("Pelo menos um autor deve ser especificado");
            }else{
            LivroEntity livro = livroExistente.get();
            livro.setTitulo(livroAtualizado.getTitulo());
            livro.setAnoPub(livroAtualizado.getAnoPub());
            livro.setIsbn(livroAtualizado.getIsbn());
            livro.setEditora(livroAtualizado.getEditora());
            livro.setAutoresEntities(livroAtualizado.getAutoresEntities());

            return repository.save(livro);}
        } else {
            System.out.println("Livro não existe");

            return null;
        }
    }

    public void deletarLivro(Long id) {
        repository.deleteById(id);
    }

    public void deletarTodosLivros() {
        repository.deleteAll();
    }

    public List<LivroEntity> buscarTodos() {
        return repository.findAll();
    }

    public void displayFindAll() {
        for (LivroEntity livro: repository.findAll()) System.out.println(livro);
    }

    public void findLivrosByAutor(AutorEntity autor){
        for (LivroEntity livro: repository.findLivrosByAutor(autor)) System.out.println(livro);

    }
    public void  findLivrosByEditora(EditoraEntity editora){
        for (LivroEntity livro: repository.findLivrosByEditora(editora)) System.out.println(livro);
    }


}
