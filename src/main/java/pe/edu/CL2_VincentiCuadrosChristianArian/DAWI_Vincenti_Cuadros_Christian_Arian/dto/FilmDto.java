package pe.edu.CL2_VincentiCuadrosChristianArian.DAWI_Vincenti_Cuadros_Christian_Arian.dto;
import java.util.List;

public record FilmDto(
        Integer filmId,
        String title,
        Integer releaseYear,
        Integer rentalDuration,
        Double rentalRate,
        String languageName,
        Integer languageId,
        List<Integer> inventoryIds,
        List<Integer> categoryIds,
        List<Integer> actorIds) {
}