package vip.xuejike.spring.boot.multidatasource.demo.db2.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "_user_d2")
public class UserD2 {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

}
