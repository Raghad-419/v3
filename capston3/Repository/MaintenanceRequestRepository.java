package com.example.capston3.Repository;

import com.example.capston3.Model.MaintenanceRequest;
import com.example.capston3.Model.Motorcycle;
import com.example.capston3.Model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MaintenanceRequestRepository extends JpaRepository<MaintenanceRequest,Integer> {
    MaintenanceRequest findMaintenanceRequestById(Integer id);

    List<MaintenanceRequest> findMaintenanceRequestByStatus(String status);
    List<MaintenanceRequest> findByOwner(Owner owner);

    @Query("SELECT m FROM MaintenanceRequest m WHERE m.expert_name = :expertName AND m.pickupDate > :today")
    List<MaintenanceRequest> findUpcomingRequestsByExpert(String expertName,  LocalDate today);


   // List<MaintenanceRequest> findMaintenanceRequestByMotorcycle_id(Integer id);

}
