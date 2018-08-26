package com.task.project3.controller;

import com.task.project3.model.Mieszkanie;
import com.task.project3.repository.MieszkanieRepository;
import com.task.project3.model.Mieszkaniec;
import com.task.project3.repository.MieszkaniecRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class MieszkanieController {

    private MieszkanieRepository mieszkanieRepository;
    private MieszkaniecRepository mieszkaniecRepository;

    public MieszkanieController(MieszkanieRepository mieszkanieRepository,
                                MieszkaniecRepository mieszkaniecRepository) {
        this.mieszkanieRepository = mieszkanieRepository;
        this.mieszkaniecRepository = mieszkaniecRepository;
    }


    @GetMapping("/mieszkanie")
    public String mieszkanie(@RequestParam Long id, Model model) {
        Optional<Mieszkanie> mieszkanieOptional = mieszkanieRepository.findById(id);

        if (mieszkanieOptional.isPresent()) {
            Mieszkanie mieszkanie = mieszkanieOptional.get();

//            List<Mieszkaniec> mieszkancy = new ArrayList<>();
//            for(Mieszkaniec mieszkaniec : mieszkanie.getMieszkaniecList()){
//                mieszkancy.add(mieszkaniec);
//            }
//            model.addAttribute("mieszkancy", mieszkancy);

            Mieszkaniec newMieszkaniec = new Mieszkaniec();
            newMieszkaniec.setMieszkanie(mieszkanie);
            model.addAttribute("mieszkanie", mieszkanie);
            model.addAttribute("newMieszkaniec", newMieszkaniec);
        } else {

            return "redirect:/";
        }

        return "mieszkanieForm";
    }


    @PostMapping("/addMieszkaniec")
    public String addMieszkaniec(Mieszkaniec mieszkaniec) {
        mieszkaniecRepository.save(mieszkaniec);

        return "redirect:/mieszkanie?id=" + mieszkaniec.getMieszkanie().getId();
    }


    @PostMapping("/updateMieszkanie")
    public String updateMieszkanie(Mieszkanie mieszkanie) {
        mieszkanieRepository.save(mieszkanie);

        return "redirect:/wspolnota?id=" + mieszkanie.getWspolnota().getId();
    }


    @PostMapping("/removeMieszkanie")
    public String removeMieszkanie(Mieszkanie mieszkanie) {
        mieszkanieRepository.delete(mieszkanie);

        return "redirect:/wspolnota?id=" + mieszkanie.getWspolnota().getId();
    }
}
