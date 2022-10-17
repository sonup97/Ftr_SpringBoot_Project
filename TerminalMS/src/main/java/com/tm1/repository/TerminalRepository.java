package com.tm1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tm1.entity.Terminal;

public interface TerminalRepository extends JpaRepository<Terminal, String >{
	
	public List<Terminal> findByItemType(String itemType);

}
