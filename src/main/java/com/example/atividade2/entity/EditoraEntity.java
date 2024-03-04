package com.example.atividade2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "editora")
public class EditoraEntity  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "o nome da editora não pode ser nula")
    @NotBlank(message ="o nme da editora não pode estar em barnco")
    private String nome;
    @OneToMany(mappedBy = "editora", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LivroEntity> livros;

    public EditoraEntity() {
    }

    public EditoraEntity(Long id, String nome) {
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

    public List<LivroEntity> getLivros() {
        return livros;
    }

    public void setLivros(List<LivroEntity> livros) {
        this.livros = livros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EditoraEntity that)) return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "EditoraEntity{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
