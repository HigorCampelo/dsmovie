package com.devsuperior.dsmovie.services;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import com.devsuperior.dsmovie.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {
    
	@Autowired
	private MovieRepository repository;
	
	@Transactional(readOnly = true )
	public List<MovieDTO> findAll(){
		List<Movie> list = repository.findAll();
		
		return list.stream().map(x -> new MovieDTO(x)).collect(Collectors.toList());
			
		/*List<MovieDTO> movieDto = new ArrayList<>();
		for (Movie mov : list) {
			movieDto.add(new MovieDTO(mov));
		}
		return listDto;
		*/
	}
	
	@Transactional(readOnly = true )
	public Page<MovieDTO> findAllPaged(Pageable pageable){
		Page<Movie> list = repository.findAll(pageable);
		return list.map(x -> new MovieDTO(x));
	}
	
	@Transactional(readOnly = true )
	public MovieDTO findById(Long id) {
		Optional<Movie> obj = repository.findById(id);
		Movie entity = obj.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado"));
		return new MovieDTO(entity);
	}
}
