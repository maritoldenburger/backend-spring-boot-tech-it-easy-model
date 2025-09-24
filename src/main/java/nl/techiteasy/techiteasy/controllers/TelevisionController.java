package nl.techiteasy.techiteasy.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private List<String> televisionDataBase = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<String>> getAllTelevisions() {
        return ResponseEntity.ok(televisionDataBase);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getTelevision(@PathVariable int id) {
        return ResponseEntity.ok(televisionDataBase.get(id));
    }

    @PostMapping
    public ResponseEntity<String> createTelevision(@RequestBody String television) {
        televisionDataBase.add(television);
        return ResponseEntity.created(null).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTelevision(@PathVariable int id, @RequestBody String television) {
        televisionDataBase.set(id, television);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable int id) {
        televisionDataBase.set(id, null);
        return ResponseEntity.noContent().build();
    }
}
