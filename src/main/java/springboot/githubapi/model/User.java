package springboot.githubapi.model;

import java.util.List;

public class User {

    String login;
    Integer id;
    List<Repository> userRepos;

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Repository> getUserRepos() {
        return userRepos;
    }

    public void setUserRepos(List<Repository> userRepos) {
        this.userRepos = userRepos;
    }
}
