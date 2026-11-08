package LibraryBoxTellers.LCRetr0.Model;

import LibraryBoxTellers.LCRetr0.DTO.LivroDTO;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String autor;

    private Integer ano;

    private String editora;

    public Livro() {
    }

    public Livro(Long id, String titulo, String autor, Integer ano, String editora) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.editora = editora;
    }

    // Construtor que converte o DTO para Entidade (Agora usando .get...() pois o DTO é uma class)
    public Livro(LivroDTO dto) {
        this.titulo = dto.getTitulo();
        this.autor = dto.getAutor();
        this.editora = dto.getEditora();

        // Converte o ano de String (do DTO) para Integer (da Entidade) com segurança
        if (dto.getAno() != null && !dto.getAno().isEmpty()) {
            try {
                this.ano = Integer.parseInt(dto.getAno());
            } catch (NumberFormatException e) {
                this.ano = null;
            }
        }
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

    // Mantemos os nomes compatíveis com o resto do código (anoPublicacao aponta para 'ano')
    public Integer getAnoPublicacao() {
        return ano;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.ano = ano;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    // Mapeamento para equals e hashCode baseados no ID
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
                ", ano=" + ano +
                ", editora='" + editora + '\'' +
                '}';
    }
}


//package LibraryBoxTellers.LCRetr0.Model;
//
//import LibraryBoxTellers.LCRetr0.DTO.LivroDTO;
//import jakarta.persistence.*;
//
//import java.util.Objects;
//
//@Entity
//@Table(name = "Livros")
//public class Livro {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
//
//    private String titulo;
//
//    private String autor;
//
////    @Column(unique = true)
////    private String isbn;
//
//    private Integer ano;
//
//    private String editora;
//
////    private String sinopse;
////
////    private String idioma;
////
////    private Integer numeroPaginas;
//
////    @Enumerated(EnumType.STRING)
////    private Categoria categoria;
//
//    // Novo campo para armazenar a URL da capa da imagem
////    private String capaUrl;
//
//    public Livro() {
//    }
//
//    public Livro(Long id, String titulo, String autor, String isbn, Integer ano,
//                 String editora, String sinopse, String idioma, Integer numeroPaginas,
//                 Categoria categoria, String capaUrl) {
////        this.id = id;
//        this.titulo = titulo;
//        this.autor = autor;
////        this.isbn = isbn;
//        this.ano = ano;
//        this.editora = editora;
////        this.sinopse = sinopse;
////        this.idioma = idioma;
////        this.numeroPaginas = numeroPaginas;
////        this.categoria = categoria;
////        this.capaUrl = capaUrl;
//    }
//
//    public Livro(LivroDTO dto) {
////        this.id = dto.id();
//        this.titulo = dto.titulo();
//        this.autor = dto.autor();
////        this.isbn = dto.isbn();
////        this.anoPublicacao = dto.anoPublicacao();
//        this.editora = dto.editora();
////        this.sinopse = dto.sinopse();
////        this.idioma = dto.idioma();
////        this.numeroPaginas = dto.numeroPaginas();
////        this.categoria = dto.categoria();
////        this.capaUrl = dto.capaUrl();
//        this.ano
//    }
//
//    // Getters e Setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitulo() {
//        return titulo;
//    }
//
//    public void setTitulo(String titulo) {
//        this.titulo = titulo;
//    }
//
//    public String getAutor() {
//        return autor;
//    }
//
//    public void setAutor(String autor) {
//        this.autor = autor;
//    }
//
//    public String getIsbn() {
//        return isbn;
//    }
//
//    public void setIsbn(String isbn) {
//        this.isbn = isbn;
//    }
//
//    public Integer getAnoPublicacao() {
//        return anoPublicacao;
//    }
//
//    public void setAnoPublicacao(Integer anoPublicacao) {
//        this.anoPublicacao = anoPublicacao;
//    }
//
//    public String getEditora() {
//        return editora;
//    }
//
//    public void setEditora(String editora) {
//        this.editora = editora;
//    }
//
//    public String getSinopse() {
//        return sinopse;
//    }
//
//    public void setSinopse(String sinopse) {
//        this.sinopse = sinopse;
//    }
//
//    public String getIdioma() {
//        return idioma;
//    }
//
//    public void setIdioma(String idioma) {
//        this.idioma = idioma;
//    }
//
//    public Integer getNumeroPaginas() {
//        return numeroPaginas;
//    }
//
//    public void setNumeroPaginas(Integer numeroPaginas) {
//        this.numeroPaginas = numeroPaginas;
//    }
//
//    public Categoria getCategoria() {
//        return categoria;
//    }
//
//    public void setCategoria(Categoria categoria) {
//        this.categoria = categoria;
//    }
//
//    public String getCapaUrl() {
//        return capaUrl;
//    }
//
//    public void setCapaUrl(String capaUrl) {
//        this.capaUrl = capaUrl;
//    }
//
//    // Mapeamento para não dar erro no banco
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Livro livro = (Livro) o;
//        return Objects.equals(id, livro.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
//
//    @Override
//    public String toString() {
//        return "Livro{" +
//                "id=" + id +
//                ", titulo='" + titulo + '\'' +
//                ", autor='" + autor + '\'' +
//                ", isbn='" + isbn + '\'' +
//                ", anoPublicacao=" + anoPublicacao +
//                ", editora='" + editora + '\'' +
//                ", sinopse='" + sinopse + '\'' +
//                ", idioma='" + idioma + '\'' +
//                ", numeroPaginas=" + numeroPaginas +
//                ", categoria=" + categoria +
//                ", capaUrl='" + capaUrl + '\'' +
//                '}';
//    }
//}