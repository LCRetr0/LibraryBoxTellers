package LibraryBoxTellers.LCRetr0.Model;

import LibraryBoxTellers.LCRetr0.DTO.LivroRecord;

import java.util.Objects;

public class Livro {


    private Long id;
    private String titulo;
    private String autor;
    private String isbn;
    private Integer anoPublicacao;
    private String editora;
    private String sinopse;
    private String idioma;
    private Integer numeroPaginas;


    public Livro() {
    }


    public Livro(Long id, String titulo, String autor, String isbn, Integer anoPublicacao,
                 String editora, String sinopse, String idioma, Integer numeroPaginas) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.editora = editora;
        this.sinopse = sinopse;
        this.idioma = idioma;
        this.numeroPaginas = numeroPaginas;
    }

    public Livro(LivroRecord dto) {
        this.id = dto.id();
        this.titulo = dto.titulo();
        this.autor = dto.autor();
        this.isbn = dto.isbn();
        this.anoPublicacao = dto.anoPublicacao();
        this.editora = dto.editora();
        this.sinopse = dto.sinopse();
        this.idioma = dto.idioma();
        this.numeroPaginas = dto.numeroPaginas();
    }

    // Getters e Setters
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    //mapeamento para não dar erro no banco
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(id, livro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                ", anoPublicacao=" + anoPublicacao +
                ", editora='" + editora + '\'' +
                ", sinopse='" + sinopse + '\'' +
                ", idioma='" + idioma + '\'' +
                ", numeroPaginas=" + numeroPaginas +
                '}';
    }
}