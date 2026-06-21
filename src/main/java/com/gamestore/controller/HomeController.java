package com.gamestore.controller;

import com.gamestore.model.Genero;
import com.gamestore.model.Plataforma;
import com.gamestore.repository.GeneroRepository;
import com.gamestore.repository.PlataformaRepository;
import com.gamestore.repository.VideojuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private VideojuegoRepository videojuegoRepository;

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private PlataformaRepository plataformaRepository;

    private static final int JUEGOS_POR_PAGINA = 8;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("generos", generoRepository.findAll());
        return "index";
    }

    @GetMapping("/catalogo")
    public String catalogo(
            @RequestParam(required = false) Long generoId,
            @RequestParam(required = false) Long plataformaId,
            @RequestParam(required = false) String busqueda,
            @RequestParam(defaultValue = "0") int pagina,
            Model model) {

        String busquedaParam = (busqueda != null && !busqueda.isBlank()) ? busqueda.trim() : null;

        Page<com.gamestore.model.Videojuego> resultado = videojuegoRepository.buscarConFiltros(
                generoId, plataformaId, busquedaParam,
                PageRequest.of(pagina, JUEGOS_POR_PAGINA)
        );

        model.addAttribute("juegos", resultado.getContent());
        model.addAttribute("paginaActual", pagina);
        model.addAttribute("totalPaginas", resultado.getTotalPages());
        model.addAttribute("totalResultados", resultado.getTotalElements());

        model.addAttribute("generos", generoRepository.findAll());
        model.addAttribute("plataformas", plataformaRepository.findAll());

        model.addAttribute("generoId", generoId);
        model.addAttribute("plataformaId", plataformaId);
        model.addAttribute("busqueda", busqueda);

        return "catalogo";
    }
}
