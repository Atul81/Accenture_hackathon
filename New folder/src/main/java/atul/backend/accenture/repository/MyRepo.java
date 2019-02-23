package atul.backend.accenture.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MyRepo<T, ID extends Serializable> extends JpaRepository<T, ID> {
}
