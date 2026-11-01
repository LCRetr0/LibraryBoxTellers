package LibraryBoxTellers.LCRetr0.Client;

import LibraryBoxTellers.LCRetr0.DTO.LivroDTO;
import LibraryBoxTellers.LCRetr0.repository.LivroRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

// https://github.com/ailsonguedes/API-Catalogo-de-Livros
@Service
public class ChamadaDeApi {
    private final LivroRepository repositorio;
    private final RestClient restClient;
    private static final Logger logger = Logger.getLogger(ChamadaDeApi.class.getName());
    private static void configurarArquivoDeLog() {
        try {
            FileHandler fileHandler = new FileHandler("LibraryBoxTellers/LCRetr0/logs/LibraryBox.txt", true);
            fileHandler.setFormatter(new SimpleFormatter());

            // Pega o logger raiz e adiciona o arquivo de saída
            Logger rootLogger = Logger.getLogger("");
            rootLogger.addHandler(fileHandler);
            rootLogger.setLevel(Level.INFO);
            rootLogger.setLevel(Level.WARNING);

        } catch (IOException e) {
            System.err.println("Não foi possível configurar o arquivo de logs: " + e.getMessage());
        }
    }
    public ChamadaDeApi(LivroRepository repositorio) {
        this.repositorio = repositorio;

//A api roda na porta 8000
        this.restClient = RestClient.builder().baseUrl("http://localhost:8000").build();
    }

    public List<LivroDTO> buscarLivrosDaApiExterna() {
        try {
            logger.log(Level.INFO,"Inicializando sistema de chamada de api");

            LivroDTO[] livrosApi = this.restClient.get()
                    .uri("/livros")
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