package StudetnskaPlatforma.Moodle.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoggedInUserService {

    @Autowired
    private SessionRegistry sessionRegistry;

    public List<String> getAllLoggedInUsers() {
        List<Object> principals = sessionRegistry.getAllPrincipals();
        List<String> usernames = new ArrayList<>();

        for (Object principal : principals) {
            if (principal instanceof UserDetails) {
                usernames.add(((UserDetails) principal).getUsername());
            } else {
                usernames.add(principal.toString());
            }
        }

        return usernames;
    }
}
