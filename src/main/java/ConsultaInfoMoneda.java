import com.google.gson.Gson;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ConsultaInfoMoneda {

    // Método para obtener la API key desde el archivo de configuración para protegerla
    private String getApiKey() {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream("src/config.properties")) { // Ruta al archivo de configuración
            properties.load(input);
            return properties.getProperty("api.key");
        } catch (IOException ex) {
            throw new RuntimeException("No se pudo cargar el archivo de configuración", ex);
        }
    }

    public Conversor buscarMoneda(String denominacionBase) {
        String apiKey = getApiKey(); // Obtener la API key desde el archivo de configuración
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + denominacionBase);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Conversor.class);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo realizar la conversión");
        }
    }
}