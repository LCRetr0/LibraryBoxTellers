package LibraryBoxTellers.LCRetr0.Service;

import LibraryBoxTellers.LCRetr0.Client.ChamadaDeApi;
import LibraryBoxTellers.LCRetr0.DTO.LivroDTO;
import LibraryBoxTellers.LCRetr0.Model.Livro;
import LibraryBoxTellers.LCRetr0.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;

public class LivroService {
    @Autowired
    private LivroRepository repositorio;
    private final ChamadaDeApi chamadaDeApi;
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