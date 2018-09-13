package retrofit_ex;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.UnsupportedEncodingException;

public class User {

    private String login;
    private int id;
    private String node_id;
    private String gravatar_id;
    private String url;
    private String html_url;
    private String followers_url;
    private String following_url;
    private String gists_url;
    private String starred_url;
    private String subscription_url;
    private String organizations_url;
    private String repos_url;
    private String events_url;
    private String received_events_url;
    private String type;
    private boolean site_admin;
    private String name;
    private String company;
    private String blog;
    private String location;
    private String email;
    private boolean hirable;
    private String bio;
    private int public_repos;
    private int public_gists;
    private int followers;
    private int following;
    private String created_at;
    private String updated_at;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNodeId() {
        return node_id;
    }

    public void setNodeId(String node_id) {
        this.node_id = node_id;
    }

    public String getGravatarId() {
        return gravatar_id;
    }

    public void setGravatarId(String gravatar_id) {
        this.gravatar_id = gravatar_id;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtmlUrl() {
        return html_url;
    }

    public void setHtmlUrl(String html_url) {
        this.html_url = html_url;
    }

    public String getFollowersUrl() {
        return followers_url;
    }

    public void setFollowersUrl(String followers_url) {
        this.followers_url = followers_url;
    }

    public String getFollowingUrl() {
        return following_url;
    }

    public void setFollowingUrl(String following_url) {
        this.following_url = following_url;
    }

    public String getGistsUrl() {
        return gists_url;
    }

    public void setGistsUrl(String gists_url) {
        this.gists_url = gists_url;
    }

    public String getStarredUrl() {
        return starred_url;
    }

    public void setStarredUrl(String starred_url) {
        this.starred_url = starred_url;
    }

    public String getSubscriptionUrl() {
        return subscription_url;
    }

    public void setSubscriptionUrl(String subscription_url) {
        this.subscription_url = subscription_url;
    }

    public String getOrganizationsUrl() {
        return organizations_url;
    }

    public void setOrganizationsUrl(String organizations_url) {
        this.organizations_url = organizations_url;
    }

    public String getReposUrl() {
        return repos_url;
    }

    public void setReposUrl(String repos_url) {
        this.repos_url = repos_url;
    }

    public String getEventsUrl() {
        return events_url;
    }

    public void setEventsUrl(String events_url) {
        this.events_url = events_url;
    }

    public String getReceivedEventsUrl() {
        return received_events_url;
    }

    public void setReceivedEventsUrl(String received_events_url) {
        this.received_events_url = received_events_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isSiteAdmin() {
        return site_admin;
    }

    public void setSiteAdmin(boolean site_admin) {
        this.site_admin = site_admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getPublicRepos() {
        return public_repos;
    }

    public void setPublicRepos(int public_repos) {
        this.public_repos = public_repos;
    }

    public int getPublicGists() {
        return public_gists;
    }

    public void setPublicGists(int public_gists) {
        this.public_gists = public_gists;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public String getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdatedAt() {
        return updated_at;
    }

    public void setUpdatedAt(String updated_at) {
        this.updated_at = updated_at;
    }

    public boolean isHirable() {
        return hirable;
    }

    public void setHirable(boolean hirable) {
        this.hirable = hirable;
    }

    /**
     * This is BS! We could have used the received JSON Object from the service.
     * But the point here is to learn a few things. So we get the JSON using
     * Retrofit and throw out the Retrofit POJO back as JSON.
     * @return String, Json object.
     */
    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
