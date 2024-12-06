package pe.edu.CL2_VincentiCuadrosChristianArian.DAWI_Vincenti_Cuadros_Christian_Arian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.CL2_VincentiCuadrosChristianArian.DAWI_Vincenti_Cuadros_Christian_Arian.entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Inventory i WHERE i.film.filmId = :filmId")
    void deleteByFilmId(@Param("filmId") int filmId);
}