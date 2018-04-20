package com.saber.repository;

import com.saber.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by sheng on 2018/4/20.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

    User findByNameAndAge(String name, Integer age);

    @Query("select u from user u where u.name = ?1")
    User findUser(String name);

    @Query(value = "select u.* from t_user u where u.age = ?1", nativeQuery = true)
    List<User> findUserByAge(Integer age);
}
