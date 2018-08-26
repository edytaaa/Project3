package com.task.project3.controller;

import com.task.project3.model.Mieszkanie;
import com.task.project3.model.Mieszkaniec;
import com.task.project3.model.Wspolnota;
import com.task.project3.repository.MieszkanieRepository;
import com.task.project3.repository.WspolnotaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class WspolnotaController {

    private WspolnotaRepository wspolnotaRepository;
    private MieszkanieRepository mieszkanieRepository;

    public WspolnotaController(WspolnotaRepository wspolnotaRepository,
                               MieszkanieRepository mieszkanieRepository) {
        this.wspolnotaRepository = wspolnotaRepository;
        this.mieszkanieRepository = mieszkanieRepository;
    }


    @GetMapping("/wspolnota")
    public String wspolnota(@RequestParam Long id, Model model) {
        Optional<Wspolnota> wspolnotaOptional = wspolnotaRepository.findById(id);

        if(wspolnotaOptional.isPresent()) {
            Wspolnota wspolnota = wspolnotaOptional.get();

            double sumaPowierzchni = 0;
//            List<Mieszkanie> mieszkania = new ArrayList<>();
            List<Mieszkaniec> mieszkancy = new ArrayList<>();

            for(Mieszkanie mieszkanie : wspolnota.getMieszkanieList()){
//                mieszkania.add(mieszkanie);
                sumaPowierzchni += mieszkanie.getPowierzchnia();
                for(Mieszkaniec mieszkaniec : mieszkanie.getMieszkaniecList()){
                    mieszkancy.add(mieszkaniec);
                }
            }
            model.addAttribute("wspolnota", wspolnota);
//            model.addAttribute("mieszkania", mieszkania);
            model.addAttribute("mieszkancy", mieszkancy);

            model.addAttribute( "sumaPowierzchni", sumaPowierzchni);

            Mieszkanie newMieszkanie = new Mieszkanie();
            newMieszkanie.setWspolnota(wspolnota);
            model.addAttribute("newMieszkanie", newMieszkanie);
        } else {

            return "redirect:/";
        }

        return "wspolnotaForm";
    }


    @PostMapping("/addMieszkanie")
    public String addMieszkanie(Mieszkanie mieszkanie) {
        mieszkanieRepository.save(mieszkanie);

        return "redirect:/wspolnota?id=" + mieszkanie.getWspolnota().getId();
    }


    @PostMapping("/updateWspolnota")
    public String updateWspolnota(Wspolnota wspolnota) {
        wspolnotaRepository.save(wspolnota);

        return "redirect:/";
    }


    @PostMapping("/removeWspolnota")
    public String removeWspolnota(Wspolnota wspolnota) {
        wspolnotaRepository.delete(wspolnota);

        return "redirect:/";
    }
}