package com.galvanize.data_example.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long heroId;

    @ManyToMany(fetch = FetchType.EAGER)  //'fetch = ...'; means get the inventory too
    private List<Item> inventory;

    @OneToOne(fetch = FetchType.EAGER)  //'fetch = ...'; means fill in stats block too
    private Stats stats;

    public Long getHeroIdId() {
        return heroId;
    }

    public void setId(Long id) {
        this.heroId = id;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }
}
