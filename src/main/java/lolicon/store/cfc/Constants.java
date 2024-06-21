package lolicon.store.cfc;

import okhttp3.ConnectionSpec;
import okhttp3.Headers;
import okhttp3.TlsVersion;

public interface Constants {

  String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36";

  Headers HEADERS = Headers.of(
      "accept",
      "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
      "accept-encoding", "gzip",
      "accept-language", "pl",
      "cache-control", "max-age=0",
      "sec-fetch-dest", "document",
      "sec-fetch-mode", "navigate",
      "sec-fetch-site", "none",
      "sec-fetch-user", "?1",
      "upgrade-insecure-requests", "1",
      "user-agent", USER_AGENT
  );

  String[] CIPHERS = {
      "TLS_AES_128_GCM_SHA256",
      "TLS_AES_256_GCM_SHA384",
      "TLS_CHACHA20_POLY1305_SHA256",
      "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256",
      "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256",
      "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384",
      "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384",
      "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256",
      "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256",
      "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA",
      "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA",
      "TLS_RSA_WITH_AES_128_GCM_SHA256",
      "TLS_RSA_WITH_AES_256_GCM_SHA384",
      "TLS_RSA_WITH_AES_128_CBC_SHA",
      "TLS_RSA_WITH_AES_256_CBC_SHA"
  };

//  String[] CURVES = {
//      "ecdsa_secp256r1_sha256",
//      "rsa_pss_rsae_sha256",
//      "rsa_pkcs1_sha256",
//      "ecdsa_secp384r1_sha384",
//      "rsa_pss_rsae_sha384",
//      "rsa_pkcs1_sha384",
//      "rsa_pss_rsae_sha512",
//      "rsa_pkcs1_sha512"
//  };

  ConnectionSpec CONNECTION_SPEC = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
      .tlsVersions(TlsVersion.TLS_1_2, TlsVersion.TLS_1_3)
      .cipherSuites(CIPHERS)
      .build();


}
