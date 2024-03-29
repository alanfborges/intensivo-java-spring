package com.alandev.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alandev.dslist.dto.GameDto;
import com.alandev.dslist.dto.GameMinDto;
import com.alandev.dslist.entities.Game;
import com.alandev.dslist.projections.GameMinProjection;
import com.alandev.dslist.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;

	@Transactional(readOnly = true)
	public GameDto findById(Long id) {
		Game result = gameRepository.findById(id).get();
		return new GameDto(result);
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDto> findAll() {
		List<Game> result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDto(x)).toList();
	}
	

	@Transactional(readOnly = true)
	public List<GameMinDto> findByList(Long listId) {
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		return result.stream().map(x -> new GameMinDto(x)).toList();
	}
	
}
