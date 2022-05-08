package com.example.database.controller;

import com.example.database.model.Profile;
import com.example.database.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class ProfileController {
    private final ProfileRepository profileRepository;
    @Autowired
    public ProfileController(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @PostMapping("/addProfile")
    public String saveProfile(@RequestBody Profile profile) {
        profileRepository.save(profile);
        return "profile added";
    }

    @GetMapping("/findAllProfiles")
    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    @GetMapping("/findAllProfiles/{id}")
    public Optional<Profile> getProfile(@PathVariable Long id) {
        return profileRepository.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProfile(@PathVariable Long id) {
        profileRepository.deleteById(id);
        return "profile deleted";
    }
}
