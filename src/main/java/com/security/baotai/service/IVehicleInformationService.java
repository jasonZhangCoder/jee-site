package com.security.baotai.service;

import java.util.List;

import com.security.baotai.bean.VehicleInformationSearch;
import com.security.baotai.model.vehicle.VehicleInformation;

public interface IVehicleInformationService {

    VehicleInformation getVehicleInformation(long id);

    void addVehicleInformation(VehicleInformation vehicleInformation);

    void updateVehicleInformation(VehicleInformation vehicleInformation);

    void deleteVehicleInformation(long id);

    List<VehicleInformation> getVehicleInformations(VehicleInformationSearch search);

    int countVehicleInformations(VehicleInformationSearch search);
}
