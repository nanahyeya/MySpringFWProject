package mylab.user.di.annot;

import org.springframework.stereotype.Component;

@Component("userServiceBean")
public class UserService {
	
    private UserRepository userRepository;
        
    private SecurityService securityService;
        
    public UserRepository getUserRepository() { return userRepository; }
    public SecurityService getSecurityService() { return securityService; }
    
    public boolean registerUser(String userId, String name, String password) {
        if (securityService.authenticate(userId, password)) {
            return userRepository.saveUser(userId, name);
        }
        return false;
    }
}