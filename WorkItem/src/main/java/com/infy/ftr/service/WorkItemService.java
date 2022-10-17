package com.infy.ftr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.ftr.controller.WorkItemFeign;
import com.infy.ftr.dto.VehicleDTO;
import com.infy.ftr.dto.WorkItemDTO;
import com.infy.ftr.entity.VechicleWorkItem;
import com.infy.ftr.entity.WorkItem;
import com.infy.ftr.exception.FTRException;
import com.infy.ftr.repository.VechicleWorkItemRepository;
import com.infy.ftr.repository.WorkItemRepository;

@Service
public class WorkItemService {

	@Autowired
	WorkItemRepository workItemRepository;

	@Autowired
	VechicleWorkItemRepository vechicleWorkItemRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
    WorkItemFeign vehicleFeign;

	public WorkItemDTO createWorkItem(WorkItemDTO workItemDTO) {

		WorkItem workItem = workItemRepository.saveAndFlush(modelMapper.map(workItemDTO, WorkItem.class));
		return modelMapper.map(workItem, WorkItemDTO.class);
	}

	public List<String> fetchAvailableHarborLocations(String sourceCountry) {
		Set<Object> list = workItemRepository.findBySourceCountry(sourceCountry);
		List<String> sourceList = new ArrayList(list);
		return sourceList;
	}

	public String updateWorkItem(String workItemId, WorkItemDTO workItemDTO) throws FTRException{
//		Optional<WorkItem> workItem = workItemRepository.findById(workItemId);
//		if (workItem.isPresent()) {
//			workItemRepository.saveAndFlush(modelMapper.map(workItemDTO, WorkItem.class));
//
//			return "WorkItem Updated";
//		} else {
//			throw new FTRException("Workitem details not found for given workitem id");
//		}
		Optional<WorkItem> workItem = workItemRepository.findById(workItemId);
        if (workItem.isPresent()) {
            WorkItem workIt=workItem.get();
            if(Objects.nonNull(workItemDTO.getSelectedHarborLocations())) {
                workIt.setSelectedHarborLocations(workItemDTO.getSelectedHarborLocations());
            }
            if(Objects.nonNull(workItemDTO.getShippingDate())) {
                workIt.setShippingDate(workItemDTO.getShippingDate());
            }
            workItemRepository.save(workIt);



           return "WorkItem Updated";
        } else {
            throw new FTRException("Workitem details not found for given workitem id");
        }
	}

	public List<WorkItemDTO> fetchWorkItemDetails() {
		List<WorkItem> workItemList = workItemRepository.findAll();
		List<WorkItemDTO> WorkItemDTOList = new ArrayList<>();
		if (workItemList.isEmpty()) {
			return List.of(new WorkItemDTO());
		} else {
			for (WorkItem workIt : workItemList) {
				WorkItemDTOList.add(modelMapper.map(workIt, WorkItemDTO.class));
			}
			return WorkItemDTOList;
		}

	}

	public List<WorkItemDTO> trackWorkitemByUser(long userId) {
		List<WorkItem> workItemEntityList = workItemRepository.findByUserId(userId);
		List<WorkItemDTO> WorkItemDTOList = new ArrayList<>();
		if (workItemEntityList.isEmpty()) {
			return List.of(new WorkItemDTO());
		} else {
			for (WorkItem workIt : workItemEntityList) {
				WorkItemDTOList.add(modelMapper.map(workIt, WorkItemDTO.class));
			}
			return WorkItemDTOList;
		}

	}
	/*public String allocateVehicle(String workitemId) throws FTRException {
        WorkItemDriverVehicleEntity workItemDriverVehicleEntity = workItemDriverVehicleRepository.findById(workitemId).orElse(null);
        if(Objects.isNull(workItemDriverVehicleEntity)) {
            WorkItemEntity workItemEntity =  workItemRepository.findById(workitemId).orElse(null);
            List<VehicleDTO> vehicleList = null;
            try {
                vehicleList = vehicleFeign.fetchVehicleByHarbor(workItemEntity.getAvailableHarborLocations());
            } catch(Exception e) {
                
            }
            if(CollectionUtils.isEmpty(vehicleList)) {
                throw new FTRException("Vehicle not available");
            } else {
                workItemDriverVehicleEntity = new WorkItemDriverVehicleEntity();
                workItemDriverVehicleEntity.setWorkItemId(workitemId);
                workItemDriverVehicleEntity.setVehicleNumber(vehicleList.get(0).getVehicleNumber());
                workItemDriverVehicleEntity.setDriverId("AWQ12312YT76");
                workItemDriverVehicleEntity.setAssignedWorkitemStatus("InProgress");
                workItemDriverVehicleRepository.saveAndFlush(workItemDriverVehicleEntity);
                
                VehicleDTO vehicle = new VehicleDTO();
                vehicle.setVehicleStatus("InProgress");
                vehicleFeign.updateVehicleStatus(vehicleList.get(0).getVehicleNumber(), vehicle);
            }
        } else {
            throw new FTRException("Workitem is already allocated with Vehicle");
        }
        return "Workitem is allocated with Vehicle successfully.";
    }*/

	public String allocateVehicle(String workitemId) throws FTRException{
		VechicleWorkItem VechicleWorkItemEntity = vechicleWorkItemRepository.findById(workitemId).orElse(null);
		if (Objects.isNull(VechicleWorkItemEntity)) {
			WorkItem workItemEntity = workItemRepository.findById(workitemId).orElse(null);
//			WorkItemEntity workItemEntity =  workIt
            List<VehicleDTO> vehicleList = null;
            try {
                vehicleList = vehicleFeign.fetchVehicleByHarbor(workItemEntity.getSelectedHarborLocations());
                System.out.println(vehicleList.toString());
            } catch(Exception e) {
                
            }  

			

		} else {
			throw new FTRException("Workitem is already allocated with Vehicle");
		}
		return "Workitem is allocated with Vehicle successfully.";
	}

}
