package com.movie.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @PreAuthorize("hasAuthority('ROLE_GLOBAL_ADMIN')")
    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "Welcome to Global Admin Dashboard!";
    }

    @PreAuthorize("hasAuthority('ROLE_THEATER_ADMIN')")
    @GetMapping("/manage-movies")
    public String manageMovies() {
        return "Theater Admin can manage movies!";
    }
}
