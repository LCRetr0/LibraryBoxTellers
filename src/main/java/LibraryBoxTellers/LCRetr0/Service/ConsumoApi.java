package LibraryBoxTellers.LCRetr0.Service;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Component // Para transformar a classe em um component gerido pelo Spring
public class ConsumoApi {

    //  Realiza o consumo de API e retorna a String JSON
    public String obterDasdos(String endereco) {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response;

        try {

            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao fazeer a requisicao HTTP: " + e.getMessage());
        }
        String jsonResposta = response.body();
        System.out.println(">>> JSON BRUTO DA API: " + jsonResposta);

        return response.body();
    }
}