package StudetnskaPlatforma.Moodle.Controller;

import StudetnskaPlatforma.Moodle.Entity.Users;
import StudetnskaPlatforma.Moodle.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class LoginController {
    @Autowired
    private userRepository repo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping("/")
    @ResponseBody
    public String goH0me(){
        return "This is publickly accesible withing needing authentication ";
    }
    @GetMapping("/users/single")
    public ResponseEntity<Object> getMyDetails(){
        return ResponseEntity.ok(repo.findUserByUsername(getLoggedInUserDetails().getUsername()));
    }
    public UserDetails getLoggedInUserDetails(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.getPrincipal() instanceof UserDetails){
            return (UserDetails) authentication.getPrincipal();
        }
        return null;
    }
    @PostMapping("/user/save")
    public ResponseEntity<Object> saveUSer(@RequestBody Users ourUser){
        ourUser.setPassword(passwordEncoder.encode(ourUser.getPassword()));
        Users result = repo.save(ourUser);

            return ResponseEntity.ok("USer Was Saved");


    }
    @GetMapping("/proba")
    public String htmllink(){
        return "hello.html";
    }
        @GetMapping("/login")
        String login() {
            return "login";
        }
    @PostMapping("/register")
    public String registerUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("email") String email) {
        String sifrovanasifra=passwordEncoder.encode(password);
        repo.saveUser(username, sifrovanasifra, email);
        return "login";
    }
    }

