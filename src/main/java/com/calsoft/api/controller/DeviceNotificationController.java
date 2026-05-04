package com.calsoft.api.controller;

import com.calsoft.api.model.Device;
import com.calsoft.api.service.DeviceNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DeviceNotificationController {

    @Autowired
    private DeviceNotificationService notificationService;

    @GetMapping("/deviceConfigNotification")
    public ResponseEntity<Map<String, Object>> deviceConfigNotification() {
        List<Device> notifiedDevices = notificationService.getAndResetConfigChangedDevices();
        
        Map<String, Object> response = new HashMap<>();
        if (notifiedDevices.isEmpty()) {
            response.put("message", "No configuration changes detected.");
            response.put("notifications", notifiedDevices);
            return ResponseEntity.ok(response);
        }
        
        response.put("message", "Configuration changes detected. Notifications triggered.");
        response.put("notifications", notifiedDevices);
        return ResponseEntity.ok(response);
    }
}
