package com.example.atividade2.repository;

import com.example.atividade2.entity.AutorEntity;
import com.example.atividade2.entity.EditoraEntity;
import com.example.atividade2.entity.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EditoraRepository extends JpaRepository<EditoraEntity, Long> {
    @Query("SELECT a FROM EditoraEntity a JOIN a.livros l WHERE l = ?1")
    List<EditoraEntity> findEditorasByLivro(LivroEntity livro);
    @Query("SELECT DISTINCT e FROM EditoraEntity e JOIN e.livros l JOIN l.autoresEntities a WHERE a = ?1")
    List<EditoraEntity> findEditorasByAutor(AutorEntity autor);
}
