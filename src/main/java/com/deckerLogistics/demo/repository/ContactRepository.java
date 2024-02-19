package com.deckerLogistics.demo.repository;

import com.deckerLogistics.demo.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    @Query("SELECT COUNT(c) FROM Contact c WHERE c.companyName LIKE 'Valueshipr%'")
    long countByCompanyNameLikeValueshipr();

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Contact c WHERE c.number = :number")
    boolean existsByNumber(String number);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Contact c WHERE c.alternativeNumbers LIKE %:number%")
    boolean existsByAlternativeNumbers(String number);

}
