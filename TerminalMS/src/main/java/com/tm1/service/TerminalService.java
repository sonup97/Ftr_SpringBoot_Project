package com.tm1.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;

import com.tm1.dto.TerminalDTO;

import exception.TerminalMSException;

public interface TerminalService {
	
	public List<TerminalDTO> fetchFTRTerminals() throws ServiceException;
	public List<TerminalDTO> fetchTerminalsByItemType(String itemType) throws TerminalMSException ;
	public String insertNewTerminal(TerminalDTO terminalDTO);
	public String updateTerminal(String terminalId, Integer newCapacity) throws ServiceException ;
	public TerminalDTO  fetchFTRTerminalByTerminalId(String terminalId) throws TerminalMSException;
	public String removeTerminal(String terminalId) throws TerminalMSException;
}
