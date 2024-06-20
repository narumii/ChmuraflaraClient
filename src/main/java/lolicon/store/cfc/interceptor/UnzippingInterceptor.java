package lolicon.store.cfc.interceptor;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.internal.http.RealResponseBody;
import okio.GzipSource;
import okio.Okio;
import org.jetbrains.annotations.NotNull;

public class UnzippingInterceptor implements Interceptor {

  @NotNull
  @Override
  public Response intercept(@NotNull Chain chain) throws IOException {
    Response response = chain.proceed(chain.request());
    if (!"gzip".equals(response.header("content-encoding"))) {
      return response;
    }

    return new Response.Builder(response)
        .body(
            new RealResponseBody(
                response.body().contentType().toString(),
                response.body().contentLength(),
                Okio.buffer(new GzipSource(response.body().source()))))
        .build();
  }
}
