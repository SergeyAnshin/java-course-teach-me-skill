package com.ans.serg.swaggerpetstore.repository;

import com.ans.serg.swaggerpetstore.entity.Pet;
import com.ans.serg.swaggerpetstore.enums.PetStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findAllByStatusIn(List<PetStatus> petStatuses);

    @Modifying
    @Transactional
    @Query("update Pet p set p.name = :name, p.status = :status where p.id = :id")
    int updateNameAndStatusById(@Param(value = "id") long id, @Param(value = "name") String name,
                                @Param(value = "status") PetStatus status);

}
