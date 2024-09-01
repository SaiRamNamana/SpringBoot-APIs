package com.task.LoadManagement.Service;

import com.task.LoadManagement.Model.Load;
import com.task.LoadManagement.Repo.LoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LoadService {

    @Autowired
    private LoadRepository loadRepository;

    public Load addLoad(Load load) {
        String uniqueShipperId = "shipper:" + UUID.randomUUID().toString();
        load.setShipperId(uniqueShipperId);
        return loadRepository.save(load);
    }

    public List<Load> getLoadsByShipperId(String shipperId) {
        return loadRepository.findByShipperId(shipperId);
    }

    public Load getLoadById(int loadId) {
        return loadRepository.findById(loadId).orElse(null);
    }

    public Load updateLoad(int loadId, Load load) {
        Load existingLoad = loadRepository.findById(loadId).orElse(null);
        if (existingLoad != null) {
            existingLoad.setLoadingPoint(load.getLoadingPoint());
            existingLoad.setUnloadingPoint(load.getUnloadingPoint());
            existingLoad.setProductType(load.getProductType());
            existingLoad.setTruckType(load.getTruckType());
            existingLoad.setNoOfTrucks(load.getNoOfTrucks());
            existingLoad.setWeight(load.getWeight());
            existingLoad.setComment(load.getComment());
            existingLoad.setDate(load.getDate());
            return loadRepository.save(existingLoad);
        }
        return null;
    }

    public void deleteLoad(int loadId) {
        loadRepository.deleteById(loadId);
    }
}
