package com.course.librarymanagement.repository;

import com.course.librarymanagement.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher,Long> {
}
