package com.task.project3.controller;

import com.task.project3.model.Mieszkaniec;
import com.task.project3.repository.MieszkaniecRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class MieszkaniecController {

    private MieszkaniecRepository mieszkaniecRepository;

    public MieszkaniecController(MieszkaniecRepository mieszkaniecRepository) {
        this.mieszkaniecRepository = mieszkaniecRepository;
    }

    @GetMapping("/mieszkaniec")
    public String mieszkaniec(@RequestParam Long id, Model model) {
        Optional<Mieszkaniec> mieszkaniecOptional = mieszkaniecRepository.findById(id);
        if (mieszkaniecOptional.isPresent()) {
            Mieszkaniec mieszkaniec = mieszkaniecOptional.get();
            model.addAttribute("mieszkaniec", mieszkaniec);
        }

        return "mieszkaniecForm";
    }


    @PostMapping("/updateMieszkaniec")
    public String updateMieszkaniec(Mieszkaniec mieszkaniec) {
        mieszkaniecRepository.save(mieszkaniec);

        return "redirect:/mieszkanie?id=" + mieszkaniec.getMieszkanie().getId();
    }


    @PostMapping("/removeMieszkanca")
    public String removeMieszkanca(Mieszkaniec mieszkaniec) {
        mieszkaniecRepository.delete(mieszkaniec);

        return "redirect:/mieszkanie?id=" + mieszkaniec.getMieszkanie().getId();
    }
}
