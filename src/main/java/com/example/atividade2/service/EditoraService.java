package com.example.atividade2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atividade2.entity.AutorEntity;
import com.example.atividade2.entity.EditoraEntity;
import com.example.atividade2.entity.LivroEntity;
import com.example.atividade2.repository.EditoraRepository;

@Service
public class EditoraService {
    @Autowired
    private EditoraRepository repository;
    
    public List<EditoraEntity> listarEditoras() {
        return repository.findAll();
    }

    public Optional<EditoraEntity> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void salvarEditora(EditoraEntity editora) {
        repository.save(editora);
    }

    public EditoraEntity atualizarEditora(Long id, EditoraEntity editoraAtualizada) {
        Optional<EditoraEntity> editoraExistente = repository.findById(id);

        if (editoraExistente.isPresent()) {
            EditoraEntity editora = editoraExistente.get();
            editora.setNome(editoraAtualizada.getNome());
            return repository.save(editora);
        } else {
            return null;
        }
    }

    public void deletarEditora(Long id) {
        repository.deleteById(id);
    }

    public void deletarTodasEditoras() {
        repository.deleteAll();
    }

    public List<EditoraEntity> buscarTodas() {
        return repository.findAll();
    }

    public void displayFindAll(){
        for (EditoraEntity editora: repository.findAll()) System.out.println(editora);
    }

   public void findAutoresByLivro(LivroEntity livro){
        for (EditoraEntity editora:repository.findEditorasByLivro(livro)) System.out.println(editora);
   }
   public void findEditorasByAutor(AutorEntity autor){
        for (EditoraEntity editora: repository.findAll()) System.out.println(editora);
   }
}
