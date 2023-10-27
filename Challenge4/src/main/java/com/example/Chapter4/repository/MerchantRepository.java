package com.example.Chapter4.repository;

import com.example.Chapter4.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, UUID> {
    @Procedure("edit_merchant_status")
    void editStatus(@Param("merchant_name") String name, @Param("status") int status);

    @Procedure("delete_merchant")
    void deleteMerchant(@Param("merchant_name") String name);
}
