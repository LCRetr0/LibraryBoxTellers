package LibraryBoxTellers.LCRetr0.Client;

import LibraryBoxTellers.LCRetr0.DTO.LivroDTO;
import LibraryBoxTellers.LCRetr0.Service.ConsumoApi;
import LibraryBoxTellers.LCRetr0.repository.LivroRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

// Api googles Books
@Service
public class ChamadaDeApi {

    private final ObjectMapper mapper = new ObjectMapper();
    private static final Logger logger = Logger.getLogger(ChamadaDeApi.class.getName());
    private final ConsumoApi consumoApi;
    private static final Logger LOGGER = Logger.getLogger(ChamadaDeApi.class.getName());
    private final String ENDERECO =  "https://www.googleapis.com/books/v1/volumes?q=";
//    private final LivroRepository repositorio;

    public ChamadaDeApi(ConsumoApi consumoApi) {
        this.consumoApi = consumoApi;
    }
    public List<LivroDTO> buscarLivrosDaApiExterna(String termo) {
        try {
            logger.log(Level.INFO,"Buscando na API externa para o termo: " + termo + "&key=AIzaSyAH2OpV6QQr2NayU3Pbit-yR1WpoYu42UM");

            String json = consumoApi.obterDasdos(ENDERECO+termo.replace(" ", "+"));

            JsonNode rootNode = mapper.readTree(json);
            JsonNode itemsNode = rootNode.get("items");

            List<LivroDTO> livros = new ArrayList<>();
            if(itemsNode != null && itemsNode.isArray()) {
                for(JsonNode item : itemsNode) {
                    LivroDTO livro = mapper.treeToValue(item, LivroDTO.class);
                    System.out.println(">>> TERMO DE BUSCADO: " + livro);
                    livros.add(livro);
                }
            }

            logger.log(Level.INFO, "Livros buscados com sucesso da API externa!");


            return livros;

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao chamar a API: " + e.getMessage(), e);
            return List.of();
        }
    }
}



//    public ChamadaDeApi(LivroRepository repositorio) {
//        this.repositorio = repositorio;
//
//        this.restClient = RestClient.builder().baseUrl("https://www.googleapis.com/books/v1/").build();
//    }

//    public List<LivroDTO> buscarLivrosDaApiExterna(String termo) {
//        try {
//            logger.log(Level.INFO,"Inicializando sistema de chamada de api");
//
//            LivroDTO[] livrosApi = this.restClient.get()
//                    .uri("/volumes?q=" + termo)
//                    .retrieve()
//                    .body(LivroDTO[].class);
//            logger.log(Level.INFO, "Livros buscados com sucesso da API externa!");
//            return livrosApi != null ? Arrays.asList(livrosApi) : List.of();
//
//        } catch (Exception e) {
//            logger.log(Level.SEVERE, "Erro ao chamar a API: " + e.getMessage(), e);
//            return List.of();
//        }
//    }
//}