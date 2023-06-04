package service;
import model.Posts;
import java.util.List;

public interface IPostsService {
    List<Posts> findAll();

    void save(Posts posts);

    Posts findById(int id);

    void update(int id, Posts posts);

    void remove(int id);
}