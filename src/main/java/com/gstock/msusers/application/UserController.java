package com.gstock.msusers.application;

import com.gstock.msusers.application.representation.UsersSaveRequest;
import com.gstock.msusers.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping
    public String status(){
        return "ok";
    }

    @PostMapping
    public ResponseEntity save(@RequestBody UsersSaveRequest request){
        Users user = request.toModel();
        service.create(user);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(user.getCpf())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity getUserByCpf(@RequestParam("cpf") String cpf){
        Optional<Users> user = service.getByCpf(cpf);

        if(user.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user);
    }
}
