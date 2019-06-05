package com;

import com.entity.User;
import com.mapper.UserMapper;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.mapper")
public class PetApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
        User user = new User();
        user.setUsername("Yom");
        user.setPassword("123456");
        LocalDate createTime = LocalDate.now();
        System.out.println("123456:"+createTime.getDayOfMonth());
        System.out.println("当前时间:"+createTime);
        user.setCreateTime(createTime);
        System.out.println("user:"+user);
        userMapper.insert(user);
        userMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    public void testMD5(){
        Md5Hash md5Hash = new Md5Hash("123");
        System.out.println(md5Hash.toString());
    }

}
