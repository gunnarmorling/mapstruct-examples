package org.mapstruct.bedcon.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.bedcon.dto.AnimalDto;
import org.mapstruct.bedcon.dto.DirectorDto;
import org.mapstruct.bedcon.dto.ZooDto;
import org.mapstruct.bedcon.model.Animal;
import org.mapstruct.bedcon.model.Director;
import org.mapstruct.bedcon.model.VisitorAndFavoriteAnimalDto;
import org.mapstruct.bedcon.model.Zoo;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="cdi", uses=DateMapper.class)
public interface ZooMapper {

	@Mappings({
		@Mapping(source = "dateOfBirth", dateFormat="dd.MM.yyyy"),
		@Mapping(source = "weightInPounds", target="weight")
	})
	AnimalDto animalToAnimalDto(Animal animal);

	List<AnimalDto> animalsToAnimalDtos(List<Animal> animals);

	ZooDto zooToZooDto(Zoo zoo);

	Animal animalDtoToAnimal(AnimalDto animal);
	
	@Mappings({
		@Mapping(source="visitor.name", target="name"),
		@Mapping(source="animal.name", target="animalName")
	})
	VisitorAndFavoriteAnimalDto visitorAndAnimalToDto(Director visitor, Animal animal);
	
	DirectorDto directorToDirectorDto(Director director);
}
