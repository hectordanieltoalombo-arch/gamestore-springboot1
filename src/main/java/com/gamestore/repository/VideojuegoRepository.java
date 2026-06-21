package com.gamestore.repository;

import com.gamestore.model.Videojuego;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VideojuegoRepository extends JpaRepository<Videojuego, Long> {

    @Query("""
        SELECT v FROM Videojuego v
        WHERE (:generoId IS NULL OR v.genero.id = :generoId)
        AND (:plataformaId IS NULL OR v.plataforma.id = :plataformaId)
        AND (:busqueda IS NULL OR LOWER(v.titulo) LIKE LOWER(CONCAT('%', CAST(:busqueda AS string), '%')))
        """)
    Page<Videojuego> buscarConFiltros(
        @Param("generoId") Long generoId,
        @Param("plataformaId") Long plataformaId,
        @Param("busqueda") String busqueda,
        Pageable pageable
    );
}