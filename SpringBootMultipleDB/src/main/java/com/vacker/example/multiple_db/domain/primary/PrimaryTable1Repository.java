package com.vacker.example.multiple_db.domain.primary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryTable1Repository extends JpaRepository<PrimaryTable1, Long>{

}
