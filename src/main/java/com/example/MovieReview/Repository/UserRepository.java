package com.example.MovieReview.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.MovieReview.Entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findByUsername(String username);

    @Query(value = "select * from user where role=?1",nativeQuery = true)
    List<User> findAllByRole(String role);
    
     @Query(value="select email from user where user_id=?1",nativeQuery = true)
     String finduseemail(int user_id);
  
}

