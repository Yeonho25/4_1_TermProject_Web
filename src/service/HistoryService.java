package service;

import java.util.ArrayList;

import domain.History;
import domain.Member;
import domain.Paging;
import persistence.HistoryRepository;

public class HistoryService {
	private final HistoryRepository historyRepository = new HistoryRepository();
	
	public int getTotalCount()
	{
		return historyRepository.getTotalCount();
	}
	
	public ArrayList<History> findHistory(Member member, Paging page)
	{
		return historyRepository.findHistory(member, page);
	}
}
