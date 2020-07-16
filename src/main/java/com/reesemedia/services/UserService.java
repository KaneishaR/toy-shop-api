package com.reesemedia.services;

import com.reesemedia.Exceptions.AuthenticationException;
import com.reesemedia.Exceptions.BadRequestException;
import com.reesemedia.dtos.Credentials;
import com.reesemedia.entities.AppUsers;
import com.reesemedia.repositories.UserRepository;
import javassist.tools.web.BadHttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository repo){
        super ();
        this.userRepository = repo;
    }


    @Transactional(readOnly = true)
    public List<AppUsers> getUsers(){ return userRepository.findAll(); }

    @Transactional(readOnly = true)
    public AppUsers getUserById(int id){ return userRepository.findById(id);}

    @Transactional
    public AppUsers saveUser(AppUsers users){ return userRepository.save(users);}

    @Transactional
    public AppUsers updatePassword(AppUsers updatedUser){
        AppUsers persistedUser = getUserById(updatedUser.getId());
        persistedUser.setPassword(updatedUser.getPassword());
        return userRepository.save(persistedUser);
    }

    @Transactional
    public AppUsers authenticate(Credentials creds) throws RuntimeException {
        if (creds.getUsername()==null || creds.getUsername().trim().equals("") || creds.getPassword()==null || creds.getPassword().trim().equals("")){
            throw new BadRequestException();
        }
        AppUsers retrievedUser = userRepository.findByUsernameAndPassword(creds.getUsername(),creds.getPassword());

        if (retrievedUser== null){ throw new AuthenticationException();}

        return retrievedUser;
    }

    @Transactional
    public boolean deleteUser(int id){
        userRepository.deleteById(id);
        return true;
    }

}
