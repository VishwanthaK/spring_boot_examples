package com.vacker.example.multiple_db.domain.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondaryTable1Repository extends JpaRepository<SecondaryTable1, Long>{

}
