package com.quanle.nnnnnnnnginx;

import com.quanle.dao.ResumeDao;
import com.quanle.pojo.Resume;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class NnnnnnnnginxApplicationTests {

    @Autowired
    private ResumeDao resumeDao;

    @Test
    void contextLoads() {
        List<Resume> all = resumeDao.findAll();
        all.forEach(a -> System.out.println(a.getAddress()));
    }

}
