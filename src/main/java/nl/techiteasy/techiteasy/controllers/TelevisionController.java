package nl.techiteasy.techiteasy.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    @GetMapping
    public ResponseEntity<String> getAllTelevisions() {
        return ResponseEntity.ok("All televisions");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getTelevision(@PathVariable int id) {
        return ResponseEntity.ok("television " + id);
    }

    @PostMapping
    public ResponseEntity<String> createTelevision(@RequestBody String television) {
        return ResponseEntity.created(null).body("television");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTelevision(@PathVariable int id, @RequestBody String television) {
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable int id) {
        return ResponseEntity.noContent().build();
    }
}
