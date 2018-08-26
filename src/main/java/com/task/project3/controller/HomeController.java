package com.task.project3.controller;

import com.task.project3.model.Mieszkanie;
import com.task.project3.model.Mieszkaniec;
import com.task.project3.model.Wspolnota;
import com.task.project3.repository.MieszkanieRepository;
import com.task.project3.repository.MieszkaniecRepository;
import com.task.project3.repository.WspolnotaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    private WspolnotaRepository wspolnotaRepository;
    private MieszkanieRepository mieszkanieRepository;
    private MieszkaniecRepository mieszkaniecRepository;

    public HomeController(WspolnotaRepository wspolnotaRepository,
                          MieszkanieRepository mieszkanieRepository,
                          MieszkaniecRepository mieszkaniecRepository) {
        this.wspolnotaRepository = wspolnotaRepository;
        this.mieszkanieRepository = mieszkanieRepository;
        this.mieszkaniecRepository = mieszkaniecRepository;
    }


    @GetMapping("/dodajWspolnote")
    public String dodajWsponote(Model model) {
        model.addAttribute("newWspolnota", new Wspolnota());

        return "addWspolnotaForm";
    }

    @PostMapping("/addWspolnota")
    public String addWspolnota(Wspolnota wspolnota) {
        if(wspolnota.getNazwa() == null || wspolnota.getNazwa().equals("")) {
            wspolnota.setNazwa(wspolnota.getAdres());
        }
        wspolnotaRepository.save(wspolnota);

        return "redirect:/";
    }


    @GetMapping("/")
    public String list(Model model) {
        List<Wspolnota> wspolnoty = wspolnotaRepository.findAll();
        model.addAttribute("wspolnoty", wspolnoty);

        //dodatkowo
        List<Mieszkanie> mieszkania = mieszkanieRepository.findAll();
        model.addAttribute("mieszkania", mieszkania);

        //dodatkowo
        List<Mieszkaniec> mieszkancy = mieszkaniecRepository.findAll();
        model.addAttribute("mieszkancy", mieszkancy);

        return "index";
    }
}
