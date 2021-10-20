package com.prodworx.quizworx.controller;

import com.prodworx.quizworx.model.UserInfo;
import com.prodworx.quizworx.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/UserInfo")
public class UserInfoController {

    @Autowired
    private UserInfoRepository repository;

    @GetMapping
    public Flux<UserInfo> getAllUserInfo() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<UserInfo> getUserInfo(@PathVariable Integer id) {
        return repository.findById(id);
    }

    @PostMapping
    public Mono<UserInfo> createUserInfo(@RequestBody UserInfo userInfo) {
        return repository.save(userInfo);
    }

    @PutMapping("/{id}")
    public Mono<UserInfo> updateUserInfo(@PathVariable Integer id, @RequestBody UserInfo userInfo) {
        return repository.findById(id)
                .map( (c) -> {
                    c.setEmailAddress(userInfo.getEmailAddress());
                    c.setPassword(userInfo.getPassword());
                    c.setUserType(userInfo.getUserType());
                    return c;
                })
                .flatMap(c -> repository.save(c));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteUserInfo(@PathVariable Integer id) {
        return repository.deleteById(id);
    }
}
