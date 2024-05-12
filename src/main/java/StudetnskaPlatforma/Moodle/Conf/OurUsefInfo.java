package StudetnskaPlatforma.Moodle.Conf;

import StudetnskaPlatforma.Moodle.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import StudetnskaPlatforma.Moodle.Repository.userRepository;

import java.util.Optional;

@Configuration
public class OurUsefInfo implements UserDetailsService {
    @Autowired
    private userRepository repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user= repo.findUserByUsername(username);
        return user.map(OurUserInfoDetails::new).orElseThrow(()->new UsernameNotFoundException("User Does Not Exist"));
    }
}
