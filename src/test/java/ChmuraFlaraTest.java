import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.Objects;
import lolicon.store.cfc.ChmuraflaraClient;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ChmuraFlaraTest {

  private static OkHttpClient chmuraflaraClient;
  private static OkHttpClient normalClient;

  @BeforeAll
  static void setupClient() {
    chmuraflaraClient = ChmuraflaraClient.newBuilder()
        .followRedirects(true)
        .followSslRedirects(true)
        .build();

    normalClient = new OkHttpClient.Builder()
        .followRedirects(true)
        .followSslRedirects(true)
        .build();
  }

  @Test
  void nHentaiChmuraflara() throws IOException {
    try (Response response = chmuraflaraClient.newCall(
            new Request.Builder().url("https://nhentai.net/g/515409").build())
        .execute()) {
      assertEquals(200, response.code());
      assertTrue(response.body().string().contains("window._gallery"));
    }
  }

  @Test
  void nHentaiApiChmuraflara() throws IOException {
    try (Response response = chmuraflaraClient.newCall(
        new Request.Builder().url("https://nhentai.net/api/gallery/515409").build()).execute()) {
      assertEquals(200, response.code());
      assertEquals("application/json",
          Objects.requireNonNull(response.body().contentType()).toString());
    }
  }

  @Test
  void nHentaiNormal() throws IOException {
    try (Response response = normalClient.newCall(
            new Request.Builder().url("https://nhentai.net/g/515409").build())
        .execute()) {
      assertEquals(200, response.code());
      assertFalse(response.body().string().contains("window._gallery"));
    }
  }

  @Test
  void nHentaiApiNormal() throws IOException {
    try (Response response = normalClient.newCall(
        new Request.Builder().url("https://nhentai.net/api/gallery/515409").build()).execute()) {
      assertEquals(200, response.code());
      assertNotEquals("application/json",
          Objects.requireNonNull(response.body().contentType()).toString());
    }
  }
}
