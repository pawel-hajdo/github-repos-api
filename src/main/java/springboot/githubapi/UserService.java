package springboot.githubapi;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import springboot.githubapi.model.Branch;
import springboot.githubapi.model.Repo;

@Service
public class UserService {

    private final WebClient webClient;

    public UserService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.github.com/").build();
    }

    public Repo[] getUserRepos(String name) {
        return webClient
                .get()
                .uri("users/{userName}/repos", name)
                .retrieve()
                .bodyToMono(Repo[].class)
                .block();
    }
}
