package lolicon.store.cfc;

import java.util.Collections;
import java.util.function.Consumer;
import lolicon.store.cfc.interceptor.HeadersInterceptor;
import lolicon.store.cfc.interceptor.UnzippingInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Protocol;

public class ChmuraflaraClient implements Constants {

  public static OkHttpClient.Builder apply(OkHttpClient.Builder builder) {
    return builder
        .protocols(Collections.singletonList(Protocol.HTTP_1_1))
        .connectionSpecs(Collections.singletonList(CONNECTION_SPEC))
        .addInterceptor(new HeadersInterceptor())
        .addInterceptor(new UnzippingInterceptor());
  }

  public static OkHttpClient apply(OkHttpClient client) {
    return apply(new OkHttpClient.Builder(client)).build();
  }

  public static OkHttpClient.Builder newBuilder() {
    return new Builder().protocols(Collections.singletonList(Protocol.HTTP_1_1))
        .connectionSpecs(Collections.singletonList(CONNECTION_SPEC))
        .addInterceptor(new HeadersInterceptor())
        .addInterceptor(new UnzippingInterceptor());
  }

  public OkHttpClient create(Consumer<OkHttpClient.Builder> builderConsumer) {
    OkHttpClient.Builder builder = new Builder();
    builderConsumer.accept(builder);
    return apply(builder).build();
  }
}
