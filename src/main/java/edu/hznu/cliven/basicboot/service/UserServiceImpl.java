package edu.hznu.cliven.basicboot.service;

import edu.hznu.cliven.basicboot.entity.User;
import edu.hznu.cliven.basicboot.mapper.UseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UseMapper useMapper;

    @Override
    public User findById(Integer id) {
        return useMapper.getOne(id);
    }

    @Override
    public User findByUsername(String username) {
        return useMapper.getByUsername(username);
    }

    @Override
    public void create(User user) {
        useMapper.insert(user);
    }
}
