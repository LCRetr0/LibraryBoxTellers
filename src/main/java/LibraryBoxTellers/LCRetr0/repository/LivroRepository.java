package LibraryBoxTellers.LCRetr0.repository;

import LibraryBoxTellers.LCRetr0.Model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro,Long>{
    Optional<Livro> findByTituloContainingIgnoreCase(String Titulo);

}
