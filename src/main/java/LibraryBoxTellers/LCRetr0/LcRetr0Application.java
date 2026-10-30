package LibraryBoxTellers.LCRetr0;

import LibraryBoxTellers.LCRetr0.Client.ChamadaDeApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@SpringBootApplication
public class LcRetr0Application implements CommandLineRunner {

    public static void main(String[] args) {
        // Chamando a configuração do log antes de subir o Spring Boot
        configurarArquivoDeLog();

        SpringApplication.run(LcRetr0Application.class, args);
    }

    private static void configurarArquivoDeLog() {
        try {
            FileHandler fileHandler = new FileHandler("LibraryBox.txt", true);
            fileHandler.setFormatter(new SimpleFormatter());

            // Pega o logger raiz e adiciona o arquivo de saída
            Logger rootLogger = Logger.getLogger("");
            rootLogger.addHandler(fileHandler);
            rootLogger.setLevel(Level.INFO);

        } catch (IOException e) {
            System.err.println("Não foi possível configurar o arquivo de logs: " + e.getMessage());
        }
    }

    @Override
    public void run(String... args) throws Exception {

    }
}