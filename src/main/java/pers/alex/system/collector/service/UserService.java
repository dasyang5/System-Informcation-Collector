package pers.alex.system.collector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.alex.system.collector.repository.UserRepository;

/**
 * @author Alex
 * @date 2019/9/20 16:51
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

}
