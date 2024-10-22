package com.codewithhims.blog_app_apis.repositories;

import com.codewithhims.blog_app_apis.entities.Category;
import com.codewithhims.blog_app_apis.entities.Post;
import com.codewithhims.blog_app_apis.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

   List<Post> searchByTitle(String Title);


}
