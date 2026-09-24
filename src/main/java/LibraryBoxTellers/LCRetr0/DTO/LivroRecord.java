package LibraryBoxTellers.LCRetr0.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public record LivroRecord(
        @JsonProperty("id")
        @JsonAlias({"bookId", "codigo"})
        Long id,

        @JsonProperty("titulo")
        @JsonAlias("title")
        String titulo,

        @JsonProperty("autor")
        @JsonAlias("author")
        String autor,

        @JsonProperty("isbn")
        @JsonAlias("codigoIsbn")
        String isbn,

        @JsonProperty("anoPublicacao")
        @JsonAlias({"publicationYear", "year"})
        Integer anoPublicacao,



        @JsonProperty("editora")
        @JsonAlias("publisher")
        String editora,

        @JsonProperty("sinopse")
        @JsonAlias({"synopsis", "description", "descricao"})
        String sinopse,

        @JsonProperty("idioma")
        @JsonAlias("language")
        String idioma,

        @JsonProperty("numeroPaginas")
        @JsonAlias({"pages", "pageCount", "qtdPaginas"})
        Integer numeroPaginas
) {}
