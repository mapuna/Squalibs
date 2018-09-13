package retrofit_ex;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AsynchronousRequest implements IRequest {

    private static final Logger logger =
            LogManager.getLogger(AsynchronousRequest.class);
    // Not required with GithubServiceBuilder in place.
    // private Retrofit mRetrofit;

    /**
     * Problem! The constructor here and the constructor in (@SynchronousRequest}
     * are the same. We refactor this object building code later.
     */
    AsynchronousRequest() {
        // Not required with GithubServiceBuilder
        /*OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();*/
    }

    @Override
    public void printUserResponse(String login) {
        // We can replace the following code with the GithubServiceGenerator's
        // createService method.
        // UserService service = mRetrofit.create(UserService.class);
        UserService service = GithubServiceBuilder
                .createService(UserService.class);
        Call<User> callASync = service.getUser(login);

        callASync.enqueue(
                new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.body() != null)
                            logger.info(response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        logger.error(t.getMessage());
                    }
                }
        );
    }
}
