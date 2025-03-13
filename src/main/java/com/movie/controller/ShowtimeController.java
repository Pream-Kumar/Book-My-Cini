package com.movie.controller;

import com.movie.model.Showtime;
import com.movie.service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/showtime")
public class ShowtimeController {
    @Autowired
    private ShowtimeService showtimeService;

    @GetMapping("/getAllShowtime")
    public List<Showtime> getAllShowtime(){
        return showtimeService.getAllShowtime();
    }

    @GetMapping("/getShowtimeById/{id}")
    public ResponseEntity<Showtime> getShowtimeById(@PathVariable Long id){
        Optional<Showtime> showtime = showtimeService.getShowtimeById(id);
        return showtime.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/addShowtime")
    public ResponseEntity<Showtime> addShowtime(@RequestParam Long theaterId, @RequestParam Long screenId, @RequestParam String startTime) {
        LocalDateTime parsedStartTime = LocalDateTime.parse(startTime);
        Showtime newShowtime = showtimeService.addShowtime(theaterId, screenId, parsedStartTime);
        return ResponseEntity.ok(newShowtime);
    }

    @DeleteMapping("/deleteShowtime/{id}")
    public ResponseEntity<Void> deleteShowtime(@PathVariable Long id) {
        showtimeService.deleteShowtime(id);
        return ResponseEntity.noContent().build();
    }

}
