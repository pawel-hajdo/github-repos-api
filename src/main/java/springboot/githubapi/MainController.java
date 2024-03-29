package springboot.githubapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import springboot.githubapi.model.Repo;

import java.util.List;

@Controller
@RequestMapping(path = "/api")
public class MainController {

    private final UserService userService;
    private final Logger logger = LoggerFactory.getLogger(MainController.class);
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/{userName}")
    public ResponseEntity<?> getUserRepos(@PathVariable String userName){
        try {
            List<Repo> repos = userService.getUserRepos(userName);
            logger.info("Repos for user "+userName+" fetched successfully");
            return ResponseEntity.ok(repos);
        } catch (WebClientResponseException.NotFound e) {
            e.getStatusCode();
            logger.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), "User "+userName+" not found"));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal server error"));
        }
    }
}
