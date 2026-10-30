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
    private final LivroRepository repositorio;
    private final RestClient restClient;


    public ChamadaDeApi(LivroRepository repositorio, RestClient.Builder restClientBuilder) {
        this.repositorio = repositorio;

        // Aqui configuramos a URL base da API externa que você está consumindo
        this.restClient = restClientBuilder.baseUrl("http://localhost:8080").build();
    }

    public List<LivroDTO> buscarLivrosDaApiExterna() {
        try {
            // Como a baseUrl já foi definida no construtor, passamos apenas o endpoint correto
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