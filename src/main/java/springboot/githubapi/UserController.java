package springboot.githubapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import springboot.githubapi.model.Repo;

import java.util.List;

@Controller
@RequestMapping(path = "/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/{userName}")
    public ResponseEntity<?> getUserRepos(@PathVariable String userName){
        try {
            List<Repo> userRepos = List.of(userService.getUserRepos(userName));
            return ResponseEntity.ok(userRepos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
}
