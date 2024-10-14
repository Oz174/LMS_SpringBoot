package com.project.Library.repo;

import com.project.Library.entity.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatronRepo extends JpaRepository<Patron, Integer> {

    Optional<Patron> findByMembershipNo(int membership_no);

}
