package retrofit_ex;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class SynchronousRequest implements IRequest {

    private static final Logger logger =
            LogManager.getLogger(SynchronousRequest.class);
    // Not required with GithubServiceBuilder in place.
    // private Retrofit mRetrofit;

    /**
     * Problem! The constructor here and the constructor in (@SynchronousRequest}
     * are the same. We refactor this object building code later.
     */
    SynchronousRequest() {
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
        Call<User> callSync = service.getUser(login);
        Response<User> response = null;

        try {
            response = callSync.execute();
            if (response.body() != null)
                logger.info(response.body().toString());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
