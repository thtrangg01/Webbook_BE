package com.example.qlsach.repository;

import com.example.qlsach.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

//kết nối dữ liệu
public interface IAccountRepository extends JpaRepository<Account, Integer> {

    public Account findByUsername(String username);
    public Account findByEmail(String email);

    public boolean existsByUsername(String name);
    public boolean existsByEmail(String email);

}
