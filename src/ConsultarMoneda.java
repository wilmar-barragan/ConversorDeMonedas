
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class ConsultarMoneda {
    public Monedas buscarMoneda(String monedaBase, String monedaTarget) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/bf70f62611418dd58a76178e/pair/"+monedaBase+"/"+monedaTarget);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response);
            return new Gson().fromJson(response.body(), Monedas.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré la moneda");
        }
    }

}
