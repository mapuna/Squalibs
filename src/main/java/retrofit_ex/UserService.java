package retrofit_ex;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface UserService {

    /**
     * The @GET annotation tells the client which HTTP method to use
     * and on which resource, so for example, by providing a base URL
     * of “https://api.github.com” it will send the request to
     * "https://api.github.com/users".
     * @param perPage: int, number of results per page in the paginated response
     * @param page: int, the page number in the paginated response
     * @return {@retrofit2.Call} list of users.
     */
    @GET("/users")
    public Call<List<User>> getUsers(
            @Query("per_page") int perPage,
            @Query("page") int page
    );

    /**
     * @param login: String, user login name
     * @return {@retrofit2.Call} object on a user
     */
    @GET("/users/{login}")
    public Call<User> getUser(@Path("login") String login);
}
