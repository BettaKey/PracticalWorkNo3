package com.example.project2.repository;

import com.example.project2.model.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a WHERE a.name LIKE %:keyword% AND a.deleted = FALSE")
    List<Author> findByName(@Param("keyword") String keyword);

    @Modifying
    @Query("UPDATE Author a SET a.deleted = TRUE WHERE a.id = :id")
    void softDelete(@Param("id") Long id);

    @Query("SELECT a FROM Author a WHERE a.deleted = FALSE")
    List<Author> findAllNotDeleted();

    @Override
    Page<Author> findAll(Pageable pageable);
}