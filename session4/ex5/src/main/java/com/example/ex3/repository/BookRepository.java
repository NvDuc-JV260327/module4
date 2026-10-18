package com.example.ex3.repository;

import com.example.ex3.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    public List<Book> findBookByTitleContainingIgnoreCase(String title);

    @Query("SELECT b FROM Book b WHERE b.price > (SELECT AVG(b2.price) FROM Book b2)")
    public List<Book> findBooksAboveAveragePrice();

    @Query(value = "SELECT a.name AS Author_name, COUNT(b.id) AS Total_books " +
            "FROM authors a JOIN books b " +
            "ON a.id = b.author_id " +
            "GROUP BY a.id", nativeQuery = true)
    public List<Map<String, Object>> countBooksByAuthor();
}
