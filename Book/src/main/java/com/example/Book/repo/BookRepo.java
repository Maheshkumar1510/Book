package com.example.Book.repo;

import com.example.Book.entity.BookEntity;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<BookEntity,Long> {
}
