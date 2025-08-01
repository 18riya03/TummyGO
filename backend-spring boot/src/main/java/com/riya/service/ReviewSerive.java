package com.riya.service;

import java.util.List;

import com.riya.Exception.ReviewException;
import com.riya.model.Review;
import com.riya.model.User;
import com.riya.request.ReviewRequest;

public interface ReviewSerive {
	
    public Review submitReview(ReviewRequest review,User user);
    public void deleteReview(Long reviewId) throws ReviewException;
    public double calculateAverageRating(List<Review> reviews);
}
