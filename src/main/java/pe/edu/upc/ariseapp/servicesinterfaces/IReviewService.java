package pe.edu.upc.ariseapp.servicesinterfaces;


import pe.edu.upc.ariseapp.entities.Review;

import java.util.List;

public interface IReviewService {
    public List<Review> list();
    public void insert(Review r);
    public Review listId(int idReview);
    public void update(Review r);
    public void delete(int idReview);
}

