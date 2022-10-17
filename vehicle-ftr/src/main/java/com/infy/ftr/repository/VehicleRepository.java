package com.infy.ftr.repository;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//import com.infy.ftr.dto.VehicleDTO;
import com.infy.ftr.entity.Vehicle;



public interface VehicleRepository extends JpaRepository<Vehicle, String> {
	
	@Query("select v from Vehicle v where v.vehicleName = ?1")
	List<Vehicle> findByVehicleName(String vehicleName);
	
	@Query("select v1 from Vehicle v1 where v1.vehicleNumber = ?1")
	Vehicle findByVehicleNumber(String vehicleNumber);
	
	@Query("select v from Vehicle v where v.harborLocation= ?1 ")
	public List<Vehicle> findByHarborLocation(String harborLocation);


	
}
