package com.galvanize.data_example.entities;

import javax.persistence.*;

@Entity
public class Encounter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long heroId;

    @ManyToOne  //'many' encounters (or Encounter objects) for 'one' Hero
    private Hero hero;

}
