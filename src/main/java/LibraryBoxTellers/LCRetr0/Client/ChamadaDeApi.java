package LibraryBoxTellers.LCRetr0.Client;

import LibraryBoxTellers.LCRetr0.DTO.LivroDTO;
import LibraryBoxTellers.LCRetr0.repository.LivroRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
import java.util.List;

// https://github.com/ailsonguedes/API-Catalogo-de-Livros
@Service
public class ChamadaDeApi {
    private LivroRepository repositorio;
    private  RestClient restClient;

    public ChamadaDeApi(LivroRepository repositorio) {

        this.repositorio = repositorio;
        LivroDTO[] livrosApi = this.restClient.get()
                .uri("ttp://localhost:8080")
                .retrieve()
                .body(LivroDTO[].class);
    }
    public List<LivroDTO> buscarLivrosDaApiExterna() {
        try {
            LivroDTO[] livrosApi = this.restClient.get()
                    .uri("/api/livros")
                    .retrieve()
                    .body(LivroDTO[].class);

            return livrosApi != null ? Arrays.asList(livrosApi) : List.of();

        } catch (Exception e) {
            System.out.println("Erro ao chamar a API: " + e.getMessage());
            return List.of();
        }
    }
}
