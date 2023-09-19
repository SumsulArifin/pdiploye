package com.tkgroupbd.pusti.api.data.repositories.notices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tkgroupbd.pusti.api.data.models.entity.notices.Notice;

@Repository
public interface NoticesRepository extends JpaRepository<Notice, Integer> {
}
