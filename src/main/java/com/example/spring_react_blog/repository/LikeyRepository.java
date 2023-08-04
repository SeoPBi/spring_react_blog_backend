package com.example.spring_react_blog.repository;

import com.example.spring_react_blog.entity.LikyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeyRepository extends JpaRepository<LikyEntity, Integer> {
}
