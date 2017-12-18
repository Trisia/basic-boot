package edu.hznu.cliven.basicboot.service;

import edu.hznu.cliven.basicboot.entity.User;

public interface UserService {

    User findById(Integer id);

    User findByUsername(String username);

    void create(User user);
}
