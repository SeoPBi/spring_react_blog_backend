package com.example.spring_react_blog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PopularSearch")
@Table(name = "PopularSearch")
public class PopularSearchEntity {

    @Id
    private String popularTerm;
    private int popularSearchCount;
}
