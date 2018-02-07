package vip.xuejike.spring.boot.multidatasource.demo.db1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import vip.xuejike.spring.boot.multidatasource.demo.db1.entity.User;

public interface UserDao extends JpaRepository<User,Long> {
}
