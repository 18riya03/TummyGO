package com.riya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riya.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
