package pe.edu.CL2_VincentiCuadrosChristianArian.DAWI_Vincenti_Cuadros_Christian_Arian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.CL2_VincentiCuadrosChristianArian.DAWI_Vincenti_Cuadros_Christian_Arian.entity.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Film f WHERE f.id = :filmId")
    void deleteByFilmId(Integer filmId);
}
