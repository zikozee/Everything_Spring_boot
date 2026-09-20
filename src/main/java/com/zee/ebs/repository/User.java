package com.zee.ebs.repository;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @dev : Ezekiel Eromosei
 * @date : 20 Sep, 2026
 */

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private boolean active;
}
