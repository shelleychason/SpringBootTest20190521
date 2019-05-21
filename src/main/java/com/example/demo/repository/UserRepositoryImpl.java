package com.example.demo.repository;

import com.example.demo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository //标识UserRepositoryImpl类是一个可注入的bean
public class UserRepositoryImpl implements UserRepository {

    //生成一个递增的id，作为唯一编号
    private static AtomicLong counterId = new AtomicLong();

    // 模拟数据存储
    private final ConcurrentMap<Long, User> userConcurrentMap = new ConcurrentHashMap<Long, User>();

    @Override
    public User saveOrUpdateUser(User user) {
        if (user.getName() != null){
            Long id = user.getId();
            if (id == null){
                id=counterId.incrementAndGet();
                user.setId(id);
            }
            this.userConcurrentMap.put(id,user);
        }
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        this.userConcurrentMap.remove(id);
    }

    @Override
    public User getUserById(Long id) {
        return this.userConcurrentMap.get(id);
    }

    @Override
    public List<User> userList() {
        return new ArrayList<User>(this.userConcurrentMap.values());
    }
}
