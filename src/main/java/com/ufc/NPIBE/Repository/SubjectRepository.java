package com.ufc.NPIBE.Repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.ufc.NPIBE.Entity.Subject;

@RepositoryRestResource(collectionResourceRel = "subject", path = "subject")
@CrossOrigin("http://localhost:5173/")
public interface SubjectRepository extends PagingAndSortingRepository<Subject, Long>, CrudRepository<Subject,Long>{
    List<Subject> findByEmail(@Param("email") String email);

    @Query(value = "DELETE FROM Subject WHERE email = :email and keyword = :keyword",
    nativeQuery = true)
    List<Subject> deleteSubject(String email, String keyword);
}
