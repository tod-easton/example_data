package com.galvanize.data_example;

import com.galvanize.data_example.entities.Hero;
import com.galvanize.data_example.entities.Item;
import com.galvanize.data_example.entities.Stats;
import com.galvanize.data_example.repositories.HeroRepository;
import com.galvanize.data_example.repositories.ItemRepository;
import com.galvanize.data_example.repositories.StatsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DataExampleApplicationTests {

	@Autowired
	private HeroRepository heroRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private StatsRepository statsRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void canSaveHero() {

		Hero tod = new Hero();
		assertNull(tod.getHeroIdId());

		heroRepository.save(tod);
		assertNotNull(tod.getHeroIdId());
		System.out.println("Tod's ID = " + tod.getHeroIdId());

		List<Item> inventory = Arrays.asList(
			new Item(),
			new Item(),
			new Item()
		);

		inventory.forEach(i -> assertNull(i.getItemId()));
		itemRepository.saveAll(inventory);
		inventory.forEach(i -> assertNotNull(i.getItemId()));

		tod.setInventory(inventory);
		heroRepository.save(tod);

		Optional<Hero> tod2 = heroRepository.findById(1L);  // Optional needed due to findById() in CrudRepository returns and Optional object
		assertTrue(tod2.isPresent());
		assertEquals(tod.getHeroIdId(), tod2.get().getHeroIdId());
		assertEquals(3, tod2.get().getInventory().size());
		assertNotEquals(tod, tod2.get());

		Stats heroStats = new Stats(1, 5, 1, 2);
		statsRepository.save(heroStats);

		tod.setStats(heroStats);
		heroRepository.save(tod);
	}
}