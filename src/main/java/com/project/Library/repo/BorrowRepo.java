package com.project.Library.repo;

import com.project.Library.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Borrow, Integer> {

}
