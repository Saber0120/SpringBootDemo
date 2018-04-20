package com.saber.repository.s;

import com.saber.entity.s.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sheng on 2018/4/20.
 */
public interface MessageRepository extends JpaRepository<Message, Long> {
}
