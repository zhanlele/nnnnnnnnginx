package com.quanle.dao;

import com.quanle.pojo.Resume;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author quanle
 * @date 2020/3/23 10:56 PM
 */
public interface ResumeDao extends JpaRepository<Resume, Integer>, JpaSpecificationExecutor<Resume> {


}
