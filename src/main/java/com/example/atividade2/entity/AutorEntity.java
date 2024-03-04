package com.example.atividade2.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "autor")
public class AutorEntity  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "o nome do autor não pode ser nulo")
    @NotBlank(message = "o nome do autor tem que estar branco")
    private String nome;
    @ManyToMany(mappedBy = "autoresEntities", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LivroEntity> livrosEntities;

    public AutorEntity() {
    }

    public AutorEntity(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<LivroEntity> getLivrosEntities() {
        return livrosEntities;
    }

    public void setLivrosEntities(List<LivroEntity> livrosEntities) {
        this.livrosEntities = livrosEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AutorEntity that)) return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "AutorEntity{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
