package LibraryBoxTellers.LCRetr0.Service;

import LibraryBoxTellers.LCRetr0.Client.ChamadaDeApi;
import LibraryBoxTellers.LCRetr0.DTO.LivroDTO;
import LibraryBoxTellers.LCRetr0.Model.Livro;
import LibraryBoxTellers.LCRetr0.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

public class LivroService {
    @Autowired
    private LivroRepository repositorio;
    private final ChamadaDeApi chamadaDeApi;


    public LivroService(LivroRepository repositorio, ChamadaDeApi chamadaDeApi) {
        this.repositorio = repositorio;
        this.chamadaDeApi = chamadaDeApi;
    }

    // Método que busca do banco de dados local
    public List<LivroDTO> obterTodosOsLivros() {
        List<Livro> livros = repositorio.findAll();
        return livros.stream()
                .map(LivroDTO::new)
                .collect(Collectors.toList());
    }

    // Puxa da API externa (usando o "/api/livros")
    public List<LivroDTO> obterLivrosDaApi() {
        return chamadaDeApi.buscarLivrosDaApiExterna();
    }
}