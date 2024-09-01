package com.task.LoadManagement.Controller;

import com.task.LoadManagement.Model.Load;
import com.task.LoadManagement.Service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/load")
public class LoadController {

    @Autowired
    private LoadService loadService;

    @PostMapping
    public ResponseEntity<String> addLoad(@RequestBody Load load) {
        loadService.addLoad(load);
        return ResponseEntity.ok("Load details added successfully");
    }

    @GetMapping
    public ResponseEntity<List<Load>> getLoadsByShipperId(@RequestParam String shipperId) {
        List<Load> loads = loadService.getLoadsByShipperId(shipperId);
        return ResponseEntity.ok(loads);
    }

    @GetMapping("/{loadId}")
    public ResponseEntity<Load> getLoadById(@PathVariable int loadId) {
        Load load = loadService.getLoadById(loadId);
        if (load != null) {
            return ResponseEntity.ok(load);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{loadId}")
    public ResponseEntity<Load> updateLoad(@PathVariable int loadId, @RequestBody Load load) {
        Load updatedLoad = loadService.updateLoad(loadId, load);
        if (updatedLoad != null) {
            return ResponseEntity.ok(updatedLoad);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{loadId}")
    public ResponseEntity<Void> deleteLoad(@PathVariable int loadId) {
        loadService.deleteLoad(loadId);
        return ResponseEntity.noContent().build();
    }
}

