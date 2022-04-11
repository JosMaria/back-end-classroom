package org.michisoft.backendclassroom.repository;

import org.michisoft.backendclassroom.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    @Query("SELECT CASE " +
            "WHEN COUNT(subject) > 0 THEN TRUE " +
            "ELSE FALSE END " +
            "FROM Subject subject " +
            "WHERE subject.code = :code")
    Boolean existsByCode(@Param("code") String code);
}
