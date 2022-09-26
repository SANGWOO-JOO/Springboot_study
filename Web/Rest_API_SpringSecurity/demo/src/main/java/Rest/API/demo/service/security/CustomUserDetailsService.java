package Rest.API.demo.service.security;

import Rest.API.demo.advice.exception.CUserNotFoundException;
import Rest.API.demo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepo userJpaRepo;

    @Override
    public UserDetails loadUserByUsername(String userPk){
        return userJpaRepo.findById(Long.parseLong(userPk)).orElseThrow(CUserNotFoundException::new);
    }
}