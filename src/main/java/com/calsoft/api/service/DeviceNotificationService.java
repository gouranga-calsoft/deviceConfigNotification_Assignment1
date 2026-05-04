package com.calsoft.api.service;

import com.calsoft.api.model.Device;
import com.calsoft.api.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeviceNotificationService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Transactional
    public List<Device> getAndResetConfigChangedDevices() {
        // Fetch all devices where config_changed is true
        List<Device> changedDevices = deviceRepository.findByConfigChangedTrue();
        
        if (!changedDevices.isEmpty()) {
            // Reset the flag so we don't notify again for the same change
            for (Device device : changedDevices) {
                device.setConfigChanged(false);
            }
            deviceRepository.saveAll(changedDevices);
        }
        
        return changedDevices;
    }
}
