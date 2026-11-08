package LibraryBoxTellers.LCRetr0.DTO;

import LibraryBoxTellers.LCRetr0.Model.Livro;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LivroDTO {
        private String titulo;
        private String autor;
        private String editora;
        private String ano;

        //Construitor vazio
        public LivroDTO() {}

        public LivroDTO(Livro livro) {
                this.titulo = livro.getTitulo();
                this.autor = livro.getAutor();
                this.editora = livro.getEditora();
                this.ano = livro.getAnoPublicacao() != null ? livro.getAnoPublicacao().toString() : null;
        }

        @JsonProperty("volumeInfo")
        private void unpackNested(java.util.Map<String, Object> volumeInfo) {
                this.titulo = (String) volumeInfo.get("titulo");

                //Os autores do google
                @SuppressWarnings("unchecked")
                java.util.List<String> authors = (java.util.List<String>) volumeInfo.get("authors");
                if(authors != null && !authors.isEmpty()) {
                        this.autor = authors.get(0);
                } else  {
                        this.autor = "Autor Desconhecido";
                }

                this.editora = (String) volumeInfo.get("publisher");

                String publishedDate = (String) volumeInfo.get("publishedDate");
                if(publishedDate != null && publishedDate.length() >= 4) {
                        this.ano = publishedDate.substring(0, 4);
                }else   {
                        this.ano = publishedDate;
                }
        }

        public String getTitulo() {
            return titulo;
        }
        public void setTitulo(String titulo) {this.titulo = titulo;}

        public String getAutor() {return autor;}
        public void setAutor(String autor) {this.autor = autor;}

        public String getEditora() {return editora;}
        public void setEditora(String editora) {this.editora = editora;}

        public String getAno() {return ano;}
        public void setAno(String ano) {this.ano = ano;}
}








//package LibraryBoxTellers.LCRetr0.DTO;
//
//import LibraryBoxTellers.LCRetr0.Model.Categoria;
//import LibraryBoxTellers.LCRetr0.Model.Livro;
//import com.fasterxml.jackson.annotation.JsonAlias;
//import com.fasterxml.jackson.annotation.JsonProperty;
//
//public record LivroDTO(
//        @JsonProperty("id")
//        @JsonAlias({"bookId", "codigo"})
//        Long id,
//
//        @JsonProperty("titulo")
//        @JsonAlias("title")
//        String titulo,
//
//        @JsonProperty("autor")
//        @JsonAlias("author")
//        String autor,
//
//        @JsonProperty("isbn")
//        @JsonAlias("codigoIsbn")
//        String isbn,
//
//        @JsonProperty("anoPublicacao")
//        @JsonAlias({"publicationYear", "year"})
//        Integer anoPublicacao,
//
//        @JsonProperty("editora")
//        @JsonAlias("publisher")
//        String editora,
//
//        @JsonProperty("sinopse")
//        @JsonAlias({"synopsis", "description", "descricao"})
//        String sinopse,
//
//        @JsonProperty("idioma")
//        @JsonAlias("language")
//        String idioma,
//
//        @JsonProperty("numeroPaginas")
//        @JsonAlias({"pages", "pageCount", "qtdPaginas"})
//        Integer numeroPaginas,
//
//        @JsonProperty("categorias")
//        @JsonAlias({"category", "categoria"})
//        Categoria categoria,
//
//        @JsonProperty("capaUrl")
//        @JsonAlias({"thumbnail", "coverUrl", "image", "capa"})
//        String capaUrl
//)
//{
//    public LivroDTO(Livro livro) {
//        this(
//                livro.getId(),
//                livro.getTitulo(),
//                livro.getAutor(),
//                livro.getIsbn(),
//                livro.getAnoPublicacao(),
//                livro.getEditora(),
//                livro.getSinopse(),
//                livro.getIdioma(),
//                livro.getNumeroPaginas(),
//                livro.getCategoria(),
//                livro.getCapaUrl()
//        );
//    }
//}/