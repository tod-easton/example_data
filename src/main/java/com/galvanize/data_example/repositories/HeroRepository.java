package com.galvanize.data_example.repositories;

import com.galvanize.data_example.entities.Hero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends CrudRepository<Hero, Long> {
}
