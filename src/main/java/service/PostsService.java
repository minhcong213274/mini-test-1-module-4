package service;


import model.Posts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostsService implements IPostsService {
    private static final Map<Integer, Posts> postses;

    static {

        postses = new HashMap<>();
        postses.put(1, new Posts(1, "John", "john@codegym.vn", "1-1-2012"));
        postses.put(2, new Posts(2, "Bill", "bill@codegym.vn", "2-2-2023"));
        postses.put(3, new Posts(3, "Alex", "alex@codegym.vn", "3-3-2021"));
        postses.put(4, new Posts(4, "Adam", "adam@codegym.vn", "12-12-2022"));
        postses.put(5, new Posts(5, "Sophia", "sophia@codegym.vn", "11-11-2023"));
        postses.put(6, new Posts(6, "Rose", "rose@codegym.vn", "15-12-2020"));
    }

    @Override
    public List<Posts> findAll() {
        return new ArrayList<>(postses.values());
    }

    @Override
    public void save(Posts posts) {
        postses.put(posts.getId(), posts);
    }

    @Override
    public Posts findById(int id) {
        return postses.get(id);
    }

    @Override
    public void update(int id, Posts customer) {
        postses.put(id, customer);

    }

    @Override
    public void remove(int id) {
        postses.remove(id);
    }
}