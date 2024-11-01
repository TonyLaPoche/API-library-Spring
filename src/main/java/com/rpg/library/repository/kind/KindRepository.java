package com.rpg.library.repository.kind;

import com.rpg.library.entity.kind.Kind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KindRepository extends JpaRepository<Kind, Long> {
    Optional<Kind> findByName(String name);
}
