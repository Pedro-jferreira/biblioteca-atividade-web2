package com.example.atividade2.service;

import com.example.atividade2.entity.AutorEntity;
import com.example.atividade2.entity.EditoraEntity;
import com.example.atividade2.entity.LivroEntity;
import com.example.atividade2.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    @Autowired
    private AutorRepository repository;

    public List<AutorEntity> listarAutores() {
        return repository.findAll();
    }
    public void displayFindAll(){
        for (AutorEntity autor: repository.findAll()) System.out.println(autor);
    }

    public Optional<AutorEntity> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public AutorEntity salvarAutor(AutorEntity autor) {
        return repository.save(autor);
    }

    public AutorEntity atualizarAutor(Long id, AutorEntity autorAtualizado) {
        Optional<AutorEntity> autorExistente = repository.findById(id);

        if (autorExistente.isPresent()) {
            AutorEntity autor = autorExistente.get();
            autor.setNome(autorAtualizado.getNome());
            return repository.save(autor);
        } else {

            System.out.println("autor não existe");
            return null;
        }
    }

    public void deletarAutor(Long id) {
        repository.deleteById(id);
    }

    public void deletarTodosAutores() {
        repository.deleteAll();
    }

    public List<AutorEntity> buscarTodos() {
        return repository.findAll();
    }

    public void findAutoresByLivro(LivroEntity livro){
        for (AutorEntity livroEntity: repository.findAutoresByLivro(livro))System.out.println(livroEntity);
        }

    public void findAutoresByEditora(EditoraEntity editora){
        for (AutorEntity autor: repository.findAutoresByEditora(editora)) System.out.println(autor);
    }


}
