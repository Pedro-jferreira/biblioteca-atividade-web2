package com.example.atividade2.repository;

import com.example.atividade2.entity.AutorEntity;
import com.example.atividade2.entity.EditoraEntity;
import com.example.atividade2.entity.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<AutorEntity, Long> {

    @Query("SELECT a FROM AutorEntity a JOIN a.livrosEntities l WHERE l = ?1")
    List<AutorEntity> findAutoresByLivro(LivroEntity livro);

    @Query("SELECT a FROM AutorEntity a JOIN a.livrosEntities l WHERE l.editora = ?1")
    List<AutorEntity> findAutoresByEditora(EditoraEntity editora);


}
