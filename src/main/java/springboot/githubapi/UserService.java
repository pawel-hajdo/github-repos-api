package springboot.githubapi;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import springboot.githubapi.model.Branch;
import springboot.githubapi.model.Repo;

import java.util.List;

@Service
public class UserService {

    private final WebClient webClient;

    public UserService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.github.com/").build();
    }

    public List<Repo> getUserRepos(String userName) {
        return webClient
                .get()
                .uri("users/{userName}/repos", userName)
                .retrieve()
                .bodyToFlux(Repo.class)
                .filter(repo -> !repo.getFork())
                .flatMap(repo -> addBranchesToRepo(userName, repo))
                .collectList()
                .block();
    }

    private Mono<Repo> addBranchesToRepo(String userName, Repo repo) {
        return webClient
                .get()
                .uri("repos/{userName}/{repoName}/branches", userName, repo.getName())
                .retrieve()
                .bodyToFlux(Branch.class)
                .collectList()
                .map(branches -> {
                    repo.setBranches(branches);
                    return repo;
                });
    }
}
