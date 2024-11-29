package com.ChatApp.ChatApp.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository repository;
    public void saveUser(User user){
        user.setStatus(Status.ONLINE);
        repository.save(user);
    }
    public void disconnectUser(User user){
        var storedUser=repository.findById(user.getNicKName())
                .orElse(null);
        if(storedUser!=null){
            storedUser.setStatus(Status.OFFLINE);
            repository.save(user);
        }
    }
    public List<User> findConnectedUsers(){
        return repository.findByStatus(Status.ONLINE);
    }
}
