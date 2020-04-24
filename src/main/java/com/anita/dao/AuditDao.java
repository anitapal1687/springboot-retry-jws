package com.anita.dao;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anita.dto.AuditDto;
import com.anita.entity.AuditEntity;
import com.anita.entity.UserEntity;

@Repository
public interface AuditDao  extends CrudRepository<AuditEntity, Integer>{

	AuditEntity save(AuditDto auditdto);
}
