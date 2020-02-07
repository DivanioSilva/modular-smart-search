package com.ds.repositories.querydsl;

import com.ds.entities.AbstractBaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BaseQueryDSLRepository<T extends AbstractBaseEntity> extends JpaRepository<T, Long>, QuerydslPredicateExecutor<T> {
}
