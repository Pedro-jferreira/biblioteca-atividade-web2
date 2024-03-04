package com.example.atividade2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "livro")
public class LivroEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "o titulo do livro não pode ser nulo")
    @NotBlank(message ="o titulo do livro pode estar em branco")
    private String titulo;
    @NotNull(message = "o ano de publicação não pode ser nulo")
    @NotBlank(message ="o ano de publicação não pode estar em branco")
    private  int anoPub;
    @NotNull(message = "o isbn do livro não pode ser nulo")
    @NotBlank(message ="o isbn do livro não pode estar em branco")
    @Column(unique = true)
    private String isbn;
    @ManyToOne
    @JoinColumn(name = "editora_id",nullable = false)
    private EditoraEntity editora;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "livro_autor",
            joinColumns = @JoinColumn(name = "livro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id"))
    private List<AutorEntity> autoresEntities;
    public LivroEntity() {
    }

    public LivroEntity(Long id, String titulo, int anoPub, String isbn) {
        this.id = id;
        this.titulo = titulo;
        this.anoPub = anoPub;
        this.isbn = isbn;
    }

    public LivroEntity(Long id, String titulo, int anoPub, String isbn, EditoraEntity editora) {
        this.id = id;
        this.titulo = titulo;
        this.anoPub = anoPub;
        this.isbn = isbn;
        this.editora = editora;
    }

    public LivroEntity(Long id, String titulo, int anoPub, String isbn, List<AutorEntity> autoresEntities) {
        this.id = id;
        this.titulo = titulo;
        this.anoPub = anoPub;
        this.isbn = isbn;
        this.autoresEntities = autoresEntities;
    }

    public LivroEntity(Long id, String titulo, int anoPub, String isbn, EditoraEntity editora, List<AutorEntity> autoresEntities) {
        this.id = id;
        this.titulo = titulo;
        this.anoPub = anoPub;
        this.isbn = isbn;
        this.editora = editora;
        this.autoresEntities = autoresEntities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoPub() {
        return anoPub;
    }

    public void setAnoPub(int anoPub) {
        this.anoPub = anoPub;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public EditoraEntity getEditora() {
        return editora;
    }

    public void setEditora(EditoraEntity editora) {
        this.editora = editora;
    }

    public List<AutorEntity> getAutoresEntities() {
        return autoresEntities;
    }

    public void setAutoresEntities(List<AutorEntity> autoresEntities) {
        this.autoresEntities = autoresEntities;
    }

    @Override
    public boolean equals(Object o) {
      if (  this == o) return true;
        if (!(o instanceof LivroEntity that)) return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "LivroEntity{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", anoPub=" + anoPub +
                ", isbn='" + isbn + '\'' +
                ", editora=" + editora +
                ", autoresEntities=" + autoresEntities +
                '}';
    }
}
