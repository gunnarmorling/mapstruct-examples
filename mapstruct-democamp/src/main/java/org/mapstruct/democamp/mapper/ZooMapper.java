package org.mapstruct.democamp.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.democamp.dto.AnimalDto;
import org.mapstruct.democamp.dto.DirectorDto;
import org.mapstruct.democamp.dto.ZooDto;
import org.mapstruct.democamp.model.Animal;
import org.mapstruct.democamp.model.Director;
import org.mapstruct.democamp.model.VisitorAndFavoriteAnimalDto;
import org.mapstruct.democamp.model.Zoo;
import org.mapstruct.factory.Mappers;

@Mapper(uses=DateMapper.class)
public interface ZooMapper {

	ZooMapper INSTANCE = Mappers.getMapper( ZooMapper.class );
	
	@Mapping(source = "dateOfBirth", dateFormat="dd.MM.yyyy")
	@Mapping(source = "weightInPounds", target="weight")
	AnimalDto animalToAnimalDto(Animal animal);

	List<AnimalDto> animalsToAnimalDtos(List<Animal> animals);

	ZooDto zooToZooDto(Zoo zoo);

	Animal animalDtoToAnimal(AnimalDto animal);
	
	@Mapping(source="visitor.name", target="name")
	@Mapping(source="animal.name", target="animalName")
	VisitorAndFavoriteAnimalDto visitorAndAnimalToDto(Director visitor, Animal animal);
	
	DirectorDto directorToDirectorDto(Director director);
}
