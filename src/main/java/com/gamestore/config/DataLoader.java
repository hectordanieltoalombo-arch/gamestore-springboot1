package com.gamestore.config;

import com.gamestore.model.Genero;
import com.gamestore.model.Plataforma;
import com.gamestore.model.Videojuego;
import com.gamestore.repository.GeneroRepository;
import com.gamestore.repository.PlataformaRepository;
import com.gamestore.repository.VideojuegoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * Carga datos de prueba automaticamente al iniciar la app, solo si las
 * tablas estan vacias. Reemplaza la necesidad de insertar datos manualmente
 * con pgAdmin: toda la interaccion ocurre dentro de la aplicacion.
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final GeneroRepository generoRepository;
    private final PlataformaRepository plataformaRepository;
    private final VideojuegoRepository videojuegoRepository;

    public DataLoader(GeneroRepository generoRepository,
                       PlataformaRepository plataformaRepository,
                       VideojuegoRepository videojuegoRepository) {
        this.generoRepository = generoRepository;
        this.plataformaRepository = plataformaRepository;
        this.videojuegoRepository = videojuegoRepository;
    }

    @Override
    public void run(String... args) {
        if (videojuegoRepository.count() > 0) {
            return; // ya hay datos, no duplicar
        }

        Genero accion = generoRepository.save(new Genero("Accion"));
        Genero rpg = generoRepository.save(new Genero("RPG"));
        Genero deportes = generoRepository.save(new Genero("Deportes"));
        Genero terror = generoRepository.save(new Genero("Terror"));
        Genero aventura = generoRepository.save(new Genero("Aventura"));

        Plataforma pc = plataformaRepository.save(new Plataforma("PC"));
        Plataforma ps5 = plataformaRepository.save(new Plataforma("PS5"));
        Plataforma xbox = plataformaRepository.save(new Plataforma("Xbox"));
        Plataforma switchP = plataformaRepository.save(new Plataforma("Nintendo Switch"));

        guardar("Elden Ring", "Un vasto mundo de fantasia oscura por explorar.", "59.99", 15, rpg, pc,
                "https://cdn.cloudflare.steamstatic.com/steam/apps/1245620/header.jpg");
        guardar("God of War Ragnarok", "Kratos y Atreus enfrentan el fin de los tiempos.", "49.99", 10, accion, ps5,
                "https://cdn.cloudflare.steamstatic.com/steam/apps/2322010/header.jpg");
        guardar("FIFA 24", "El simulador de futbol mas popular.", "39.99", 20, deportes, xbox,
                "https://cdn.cloudflare.steamstatic.com/steam/apps/2195250/header.jpg");
        guardar("Resident Evil 4", "Sobrevive al horror en un remake aclamado.", "44.99", 8, terror, pc,
                "https://cdn.cloudflare.steamstatic.com/steam/apps/2050650/header.jpg");
        guardar("Zelda: Tears of the Kingdom", "Una aventura epica en Hyrule.", "59.99", 12, aventura, switchP,
                "https://cdn.cloudflare.steamstatic.com/steam/apps/2074740/header.jpg");
        guardar("Call of Duty: MW3", "Accion militar trepidante multijugador.", "54.99", 18, accion, xbox,
                "https://cdn.cloudflare.steamstatic.com/steam/apps/2519060/header.jpg");
        guardar("Final Fantasy XVI", "Una epopeya de fantasia con combate en tiempo real.", "49.99", 9, rpg, ps5,
                "https://cdn.cloudflare.steamstatic.com/steam/apps/2515020/header.jpg");
        guardar("NBA 2K24", "El simulador definitivo de baloncesto.", "34.99", 14, deportes, pc,
                "https://cdn.cloudflare.steamstatic.com/steam/apps/2338770/header.jpg");
        guardar("Dead Space Remake", "Terror espacial reimaginado.", "42.99", 7, terror, ps5,
                "https://cdn.cloudflare.steamstatic.com/steam/apps/1693980/header.jpg");
        guardar("Tunic", "Una aventura aislada en un mundo de zorros.", "29.99", 11, aventura, switchP,
                "https://cdn.cloudflare.steamstatic.com/steam/apps/553420/header.jpg");
        guardar("Hogwarts Legacy", "Vive tu propia historia en el mundo magico.", "49.99", 16, aventura, pc,
                "https://cdn.cloudflare.steamstatic.com/steam/apps/990080/header.jpg");
        guardar("Mortal Kombat 1", "Lucha brutal con el roster clasico renovado.", "44.99", 13, accion, xbox,
                "https://cdn.cloudflare.steamstatic.com/steam/apps/1971870/header.jpg");
        guardar("Persona 5 Royal", "Un RPG estiloso de la vida estudiantil con un giro.", "39.99", 10, rpg, switchP,
                "https://cdn.cloudflare.steamstatic.com/steam/apps/1687950/header.jpg");
        guardar("EA Sports FC 24", "El sucesor de FIFA con licencias reales.", "39.99", 17, deportes, ps5,
                "https://cdn.cloudflare.steamstatic.com/steam/apps/2195250/header.jpg");
        guardar("Alan Wake 2", "Suspenso psicologico con horror narrativo.", "49.99", 6, terror, xbox,
                "https://cdn.cloudflare.steamstatic.com/steam/apps/1500900/header.jpg");
    }

    private void guardar(String titulo, String descripcion, String precio, int stock,
                          Genero genero, Plataforma plataforma, String imagenUrl) {
        Videojuego v = new Videojuego();
        v.setTitulo(titulo);
        v.setDescripcion(descripcion);
        v.setPrecio(new BigDecimal(precio));
        v.setStock(stock);
        v.setGenero(genero);
        v.setPlataforma(plataforma);
        v.setImagenUrl(imagenUrl);
        videojuegoRepository.save(v);
    }
}
