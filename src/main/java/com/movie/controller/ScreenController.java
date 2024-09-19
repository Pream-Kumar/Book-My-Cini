package com.movie.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.model.Screen;
import com.movie.service.ScreenService;

@RestController
@RequestMapping("/api/screen")
public class ScreenController {

    @Autowired
    private ScreenService screenService;

    // Get all screens
    @GetMapping("/getAllScreens")
    public List<Screen> getAllScreens() {
        return screenService.getAllScreens();
    }

    // Get a screen by ID
    @GetMapping("/getScreenById/{id}")
    public ResponseEntity<Screen> getScreenById(@PathVariable Long id) {
        Optional<Screen> screen = screenService.getScreenById(id);
        return screen.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Add a new screen
    @PostMapping("/addNewScreen")
    public ResponseEntity<Screen> addScreen(@RequestBody Screen screen) {
        Screen newScreen = screenService.addScreen(screen);
        return ResponseEntity.status(HttpStatus.CREATED).body(newScreen);
    }

    // Delete a screen by ID
    @DeleteMapping("/deleteScreen/{id}")
    public ResponseEntity<Void> deleteScreen(@PathVariable Long id) {
        Optional<Screen> screen = screenService.getScreenById(id);
        if (screen.isPresent()) {
            screenService.deleteScreen(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}


