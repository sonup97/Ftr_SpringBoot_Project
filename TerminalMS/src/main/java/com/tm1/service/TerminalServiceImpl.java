package com.tm1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.tm1.dto.TerminalDTO;
import com.tm1.entity.Terminal;
import com.tm1.repository.TerminalRepository;

import exception.TerminalMSException;

@Service
public class TerminalServiceImpl implements TerminalService {
	
	@Autowired
	TerminalRepository terminalRepo;
	
	@Autowired
	MessageSource messageSource;
	
	@Override
	public String insertNewTerminal(TerminalDTO terminalDTO) {
		terminalRepo.save(TerminalDTO.prepareTerminal(terminalDTO));
		return " ";
	}
	
	@Override
	public List<TerminalDTO> fetchFTRTerminals(){

		Optional<List<Terminal>> optionalTermList = Optional.of(terminalRepo.findAll());
		if(optionalTermList.map(List::size).get()!=0) {
			List<TerminalDTO> termDTOList = new ArrayList<>();
			optionalTermList.get().forEach(val -> {
				termDTOList.add(Terminal.prepareTerminalDTO(val));
			});
			return termDTOList;
		}
		throw new ServiceException(messageSource.getMessage("terminal.empty", 
				null, Locale.ENGLISH));
	}


	@Override
	public String updateTerminal(String terminalId, Integer newCapacity) throws ServiceException {
		
		Optional<Terminal> entityOpt = terminalRepo.findById(terminalId);
		if(entityOpt.isPresent()) {
			Integer currCapacity = entityOpt.get().getAvailableCapacity();
			if(newCapacity>currCapacity) {
				// Throw CAPACITY_EXCEEDED
				return "Capacity exceeded";
			}
			entityOpt.get().setAvailableCapacity(currCapacity - newCapacity);
			currCapacity = entityOpt.get().getAvailableCapacity();
			if(currCapacity.equals(newCapacity)) entityOpt.get().setStatus("NotAvailable");
			terminalRepo.saveAndFlush(entityOpt.get());
			return "Updated successfully for terminal "+terminalId;
		}
		// Throw TERMINAL_NOT_FOUND
		else {
			return "Terminal not found with given ID";
		}
	}

	@Override
	public List<TerminalDTO> fetchTerminalsByItemType(String itemType) throws TerminalMSException {
		List<Terminal> terminals=terminalRepo.findByItemType(itemType);
		if(terminals.isEmpty())
			throw new TerminalMSException("terminal.itemtype.notFound");
		List<TerminalDTO> terminalDTOs=new ArrayList<>();
		for(Terminal terminal:terminals)
			terminalDTOs.add(Terminal.prepareTerminalDTO(terminal));
		return terminalDTOs;
	}

	@Override
	public TerminalDTO fetchFTRTerminalByTerminalId(String terminalId) throws TerminalMSException {
		Optional<Terminal> terminal=terminalRepo.findById(terminalId);
		if(terminal.isEmpty())
			throw new TerminalMSException("terminal.notFound");
		return Terminal.prepareTerminalDTO(terminal.get());
	}

	@Override
	public String removeTerminal(String terminalId) throws TerminalMSException {
		Optional<Terminal> terminal=terminalRepo.findById(terminalId);
		if(terminal.isEmpty())
			throw new TerminalMSException("terminal.notFound");
		terminalRepo.deleteById(terminalId);
		return "Successfully Deleted";
	}

}