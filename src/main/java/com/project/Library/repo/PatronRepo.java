package com.project.Library.repo;

import com.project.Library.entity.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatronRepo extends JpaRepository<Patron, Integer> {

}
