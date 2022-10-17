package com.infy.ftr.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.infy.ftr.entity.VechicleWorkItem;
 
@Repository
public interface VechicleWorkItemRepository extends JpaRepository<VechicleWorkItem, String> {

}
