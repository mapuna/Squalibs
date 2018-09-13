package retrofit_ex;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class GithubServiceBuilder {
    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .addConverterFactory(GsonConverterFactory.create());

    private static OkHttpClient.Builder httpClientBuilder =
            new OkHttpClient.Builder();

    private static Retrofit retrofit;

    private static HttpLoggingInterceptor logging
            = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.HEADERS);

    static <S> S createService(Class<S> serviceClass) {
        // Added a logging interceptor
        if (!httpClientBuilder.interceptors().contains(logging)) {
            httpClientBuilder.addInterceptor(logging);
            retrofitBuilder.client(httpClientBuilder.build());
            retrofit = retrofitBuilder.build();
        }
        return retrofit.create(serviceClass);
    }

    static <S> S createService(Class<S> serviceClass, final String token) {
        if (token != null) {
            httpClientBuilder.interceptors().clear();
            httpClientBuilder.addInterceptor(
                    chain -> {
                        Request original = chain.request();
                        Request request = original.newBuilder()
                                .header("Authorization", token)
                                .build();
                        return chain.proceed(request);
                    }
            );

            if (!httpClientBuilder.interceptors().contains(logging)) {
                httpClientBuilder.addInterceptor(logging);
                retrofitBuilder.client(httpClientBuilder.build());
                retrofit = retrofitBuilder.build();
            }
        }
        return retrofit.create(serviceClass);
    }
}
