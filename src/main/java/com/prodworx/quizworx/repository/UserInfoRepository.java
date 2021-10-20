package com.prodworx.quizworx.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.prodworx.quizworx.model.UserInfo;


public interface UserInfoRepository extends ReactiveCrudRepository<UserInfo,Integer> {
}
