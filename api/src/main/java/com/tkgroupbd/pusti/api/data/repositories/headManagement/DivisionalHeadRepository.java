package com.tkgroupbd.pusti.api.data.repositories.headManagement;
import com.tkgroupbd.pusti.api.data.models.entity.headManagement.DivisionalHead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionalHeadRepository extends JpaRepository<DivisionalHead,Integer> {


}
