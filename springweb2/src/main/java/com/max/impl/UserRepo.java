package com.max.impl;

import com.max.interfaces.Repo;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepo implements Repo {
//    @Secured("ROLE_ADMIN")
//    @RolesAllowed("ROLE_ADMIN")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @PostAuthorize("hasRole('ROLE_ADMIN')")
    public void createTable() {
        System.out.println("user table was created");
    }
}
