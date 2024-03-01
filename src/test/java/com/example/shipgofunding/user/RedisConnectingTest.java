package com.example.shipgofunding.user;

import com.example.shipgofunding.config.Redis.RedisUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(properties = "spring.profiles.active:local")
public class RedisConnectingTest {


        @Autowired
        private RedisUtils redisUtil;


        @Test
        public void redisTest () throws Exception {
            //given
            String email = "test@test.com";
            String code = "aaa111";

            //when
            redisUtil.setDataExpire(email, code, 60 * 60L);

            //then
            Assertions.assertTrue(redisUtil.existData("test@test.com"));
            Assertions.assertFalse(redisUtil.existData("test1@test.com"));
            Assertions.assertEquals(redisUtil.getData(email), "aaa111");

        }
}