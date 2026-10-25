package LibraryBoxTellers.LCRetr0.Service;

import LibraryBoxTellers.LCRetr0.DTO.LivroDTO;
import LibraryBoxTellers.LCRetr0.Model.Livro;
import LibraryBoxTellers.LCRetr0.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

public class LivroService {
    @Autowired
    private LivroRepository repositorio;

    public List<LivroDTO> obterTodosOsLivros() {
        List<Livro> livros = repositorio.findAll();
        return livros.stream()
                .map(LivroDTO::new)
                .collect(Collectors.toList());
    }
}
