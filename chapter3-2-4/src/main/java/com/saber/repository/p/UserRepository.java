package com.saber.repository.p;

import com.saber.entity.p.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sheng on 2018/4/20.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
