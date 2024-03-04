package com.example.atividade2.repository;

import com.example.atividade2.entity.AutorEntity;
import com.example.atividade2.entity.EditoraEntity;
import com.example.atividade2.entity.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository  extends JpaRepository<LivroEntity, Long> {
    @Query("SELECT a FROM LivroEntity a JOIN a.autoresEntities l WHERE l = ?1")
    List<LivroEntity> findLivrosByAutor(AutorEntity autor);
    @Query("SELECT a FROM LivroEntity a JOIN a.editora l where l = ?1")
    List<LivroEntity> findLivrosByEditora(EditoraEntity editora);
}
