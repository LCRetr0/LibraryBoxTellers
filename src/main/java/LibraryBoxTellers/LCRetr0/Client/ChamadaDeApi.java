package LibraryBoxTellers.LCRetr0.Client;

import LibraryBoxTellers.LCRetr0.DTO.LivroDTO;
import LibraryBoxTellers.LCRetr0.repository.LivroRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

// https://github.com/ailsonguedes/API-Catalogo-de-Livros
@Service
public class ChamadaDeApi {
    private final LivroRepository repositorio;
    private final RestClient restClient;
    private static final Logger logger = Logger.getLogger(ChamadaDeApi.class.getName());

    public ChamadaDeApi(LivroRepository repositorio) {
        this.repositorio = repositorio;


        this.restClient = RestClient.builder().baseUrl("http://localhost:8080").build();
    }

    public List<LivroDTO> buscarLivrosDaApiExterna() {
        try {
            logger.log(Level.INFO,"Inicializando sistema de chamada de api");
            // Como a baseUrl já foi definida no construtor, passamos apenas o endpoint correto
            LivroDTO[] livrosApi = this.restClient.get()
                    .uri("/api/livros")
                    .retrieve()
                    .body(LivroDTO[].class);
            logger.log(Level.INFO, "Livros buscados com sucesso da API externa!");
            return livrosApi != null ? Arrays.asList(livrosApi) : List.of();

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao chamar a API: " + e.getMessage(), e);
            return List.of();
        }
    }
}