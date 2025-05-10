package pe.edu.upc.ariseapp.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.ariseapp.entities.Review;
import pe.edu.upc.ariseapp.repositories.IReviewRepository;
import pe.edu.upc.ariseapp.servicesinterfaces.IReviewService;

import java.util.List;

@Service
public class ReviewServiceImplement implements IReviewService {
    @Autowired
    private IReviewRepository rR;

    @Override
    public List<Review> list() {return rR.findAll();}

    @Override
    public void insert(Review r) {
        rR.save(r);
    }

    @Override
    public Review listId(int idReview) {return rR.findById(idReview).orElse(new Review());}

    @Override
    public void update(Review r) {
        rR.save(r);
    }

    @Override
    public void delete(int idReview) {
        rR.deleteById(idReview);
    }
}