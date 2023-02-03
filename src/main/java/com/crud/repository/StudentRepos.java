package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.entity.Student;

public interface StudentRepos extends JpaRepository<Student, Integer> {

}
