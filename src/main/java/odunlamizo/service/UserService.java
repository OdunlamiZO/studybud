package odunlamizo.service;

import odunlamizo.model.User;
import odunlamizo.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    private UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private static class UserServiceHelper {

        private static final UserService INSTANCE = new UserService(UserRepository.getInstance());

    }

    public static UserService getInstance() {
        return UserServiceHelper.INSTANCE;
    }

    public User register(User user) {
        if(userExists(user.getUsername(), user.getEmail())) {
            throw new RuntimeException();
        }
        return userRepository.save(user);
    }

    private boolean userExists(String username, String email) {
        return userRepository.exists(username, email);
    }
    
}