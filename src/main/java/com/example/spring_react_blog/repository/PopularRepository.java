package com.example.spring_react_blog.repository;

import com.example.spring_react_blog.entity.PopularSearchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PopularRepository extends JpaRepository<PopularSearchEntity, String> {
}
