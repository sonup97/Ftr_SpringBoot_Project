package com.infy.ftr.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infy.ftr.entity.WorkItem;

@Repository
public interface WorkItemRepository extends JpaRepository<WorkItem, String> {

	@Query("Select w.sourceCountry from WorkItem w where w.sourceCountry=?1")
	public Set<Object> findBySourceCountry(String sourceCountry);
	
	
	@Query("Select w from WorkItem w where w.userId=?1")
	public List<WorkItem> findByUserId(long userId);
}
