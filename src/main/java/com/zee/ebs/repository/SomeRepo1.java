package com.zee.ebs.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @dev : Ezekiel Eromosei
 * @date : 20 Sep, 2026
 */

public interface SomeRepo1 extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
}
