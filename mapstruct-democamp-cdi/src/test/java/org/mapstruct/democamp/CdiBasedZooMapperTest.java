package org.mapstruct.democamp;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.democamp.dto.AnimalDto;
import org.mapstruct.democamp.dto.ZooDto;
import org.mapstruct.democamp.mapper.ZooMapper;
import org.mapstruct.democamp.model.Animal;
import org.mapstruct.democamp.model.Zoo;

@RunWith(Arquillian.class)
public class CdiBasedZooMapperTest {

	@Inject
	private ZooMapper mapper;

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create( JavaArchive.class )
				.addPackage( ZooMapper.class.getPackage() )
				.addAsManifestResource( EmptyAsset.INSTANCE, "beans.xml" );
	}

	@Test
	public void shouldMapAnimal() {
		Animal animal = new Animal("Bruno", new GregorianCalendar( 1980, 0, 1 ).getTime(), 1000);

		AnimalDto animalDto = mapper.animalToAnimalDto(animal);

		assertThat(animalDto).isNotNull();
		assertThat(animalDto.getName()).isEqualTo("Bruno");
		assertThat(animalDto.getDateOfBirth()).isEqualTo("01.01.1980");
		assertThat(animalDto.getWeight()).isEqualTo(1000);
	}

	@Test
	public void shouldMapList() {
		Animal bruno = new Animal("Bruno", new GregorianCalendar( 1980, 0, 1 ).getTime(), 1000);
		Animal cassandra = new Animal("Cassandra", new GregorianCalendar( 1995, 4, 15 ).getTime(), 500);

		List<AnimalDto> animalDtos = mapper.animalsToAnimalDtos(Arrays.asList(bruno, cassandra));

		assertThat(animalDtos).isNotNull();
		assertThat(animalDtos).onProperty("name").containsExactly("Bruno", "Cassandra");
		assertThat(animalDtos).onProperty("dateOfBirth").containsExactly("01.01.1980", "15.05.1995");
		assertThat(animalDtos).onProperty("weight").containsExactly(1000L, 500L);
	}

	@Test
	public void shouldMapReferencedCollection() {
		Animal bruno = new Animal("Bruno", new GregorianCalendar( 1980, 0, 1 ).getTime(), 1000);
		Animal cassandra = new Animal("Cassandra", new GregorianCalendar( 1995, 4, 15 ).getTime(), 500);

		Zoo zoo = new Zoo();
		zoo.setName("Bagenhecks Tierpark");
		zoo.setAnimals(Arrays.asList(bruno, cassandra));
		ZooDto zooDto = mapper.zooToZooDto(zoo);

		assertThat(zooDto).isNotNull();
		assertThat(zooDto.getName()).isEqualTo("Bagenhecks Tierpark");
		assertThat(zooDto.getAnimals()).onProperty("name").containsExactly("Bruno", "Cassandra");
	}
}
