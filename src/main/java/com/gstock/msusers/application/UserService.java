package com.gstock.msusers.application;

import com.gstock.msusers.domain.Users;
import com.gstock.msusers.infra.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Users create(Users user){
        return userRepository.save(user);
    }

    public Optional<Users> getByCpf(String cpf){
        return userRepository.getByCpf(cpf);
    }
}
