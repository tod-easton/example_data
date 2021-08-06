package com.galvanize.data_example.repositories;


import com.galvanize.data_example.entities.Stats;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatsRepository extends CrudRepository<Stats, Long> {
}
