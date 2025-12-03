package com.eduard.librarymanagementproject.repository;

import com.eduard.librarymanagementproject.model.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
}
