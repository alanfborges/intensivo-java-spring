package com.alandev.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alandev.dslist.dto.GameListDto;
import com.alandev.dslist.entities.GameList;
import com.alandev.dslist.repositories.GameListRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;

	@Transactional(readOnly = true)
	public List<GameListDto> findAll() {
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDto(x)).toList();
	}
}
