package pers.alex.system.collector.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pers.alex.system.collector.entity.User;

/**
 * @author Alex
 * @date 2019/9/20 16:49
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
