package com.riya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riya.model.PasswordResetToken;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Integer> {
	PasswordResetToken findByToken(String token);
}
