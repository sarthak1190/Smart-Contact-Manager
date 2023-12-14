package com.smart.smartcontactmanager.Dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smart.smartcontactmanager.Entities.Contact;

import jakarta.transaction.Transactional;

public interface ContactRepository extends JpaRepository<Contact, Integer>{
    
    //pagination
    @Query("from Contact as d where d.user.id =:userId")
    //current page -page
    //contact per page - 3
    public Page<Contact> findContactsByUser(@Param("userId") int userId, Pageable pageable);

    @Modifying
	@Transactional
	@Query(value="delete from Contact c where c.cId = ?1")
	void deleteByIdCustom(Integer cId);
}
