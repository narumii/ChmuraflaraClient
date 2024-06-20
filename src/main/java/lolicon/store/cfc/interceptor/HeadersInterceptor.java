package lolicon.store.cfc.interceptor;

import java.io.IOException;
import lolicon.store.cfc.Constants;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

public class HeadersInterceptor implements Interceptor, Constants {

  @NotNull
  @Override
  public Response intercept(@NotNull Chain chain) throws IOException {
    return chain.proceed(new Request.Builder(chain.request())
        .headers(chain.request().headers().newBuilder().addAll(HEADERS).build())
        .build());
  }
}
