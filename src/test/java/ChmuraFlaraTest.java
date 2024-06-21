import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import lolicon.store.cfc.ChmuraflaraClient;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ChmuraFlaraTest {

  private static OkHttpClient chmuraflaraClient;
//  private static OkHttpClient normalClient;

  @BeforeAll
  static void setupClient() {
    chmuraflaraClient = ChmuraflaraClient.newBuilder()
        .followRedirects(true)
        .followSslRedirects(true)
        .build();

//    normalClient = new OkHttpClient.Builder()
//        .followRedirects(true)
//        .followSslRedirects(true)
//        .build();
  }

  /*
  https://github.com/makindotcc/boringhyper/blob/master/tests/cf_test.rs
   */
  @Test
  void canvaChmuraflara() throws IOException {
    try (Response response = chmuraflaraClient.newCall(
        new Request.Builder().url("https://www.canva.com/pl_pl/").build()).execute()) {
      assertEquals(200, response.code());
    }
  }

//  @Test
//  void canvaNormal() throws IOException {
//    try (Response response = normalClient.newCall(
//        new Request.Builder().url("https://www.canva.com/pl_pl/").build()).execute()) {
//      System.out.println(response.code());
//    }
//  }
}
