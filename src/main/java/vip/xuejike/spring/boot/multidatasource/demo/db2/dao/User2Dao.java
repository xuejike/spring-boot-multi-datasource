package vip.xuejike.spring.boot.multidatasource.demo.db2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import vip.xuejike.spring.boot.multidatasource.demo.db2.entity.UserD2;

public interface User2Dao extends JpaRepository<UserD2,Long> {
}
