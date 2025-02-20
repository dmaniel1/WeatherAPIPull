import java.util.Scanner;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.lang.InterruptedException;
// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;

@SuppressWarnings("unused")
public class Main {
  public static void main(String[] args) throws IOException, InterruptedException {
    @SuppressWarnings("resource")
    Scanner scorn = new Scanner(System.in);
    System.out.println("What would you like to find?");
    String selection = scorn.next();
    System.out.println("What city?");
    String city = scorn.next();
    HttpRequest request = HttpRequest.newBuilder()
       .uri(URI.create("https://open-weather13.p.rapidapi.com/city/" + city.toLowerCase() + "/EN"))
       .header("x-rapidapi-key", "2dfce233a4msh7ab7b2341f9304bp1db9c7jsn938689e18a82")
       .header("x-rapidapi-host", "open-weather13.p.rapidapi.com")
       .method("GET", HttpRequest.BodyPublishers.noBody())
       .build();
    HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    System.out.println(response.body());
    String outcome = response.body();
    String[] data = outcome.split(":");
    int contr = 0;
      while (contr < data.length) {
          if (data[contr].contains(selection)) {
            String feelsLike = data[contr+1];
            String[] thisString3 = feelsLike.split(",");
            System.out.println(thisString3[0]);
          }
          contr++;
      }
  }
}
