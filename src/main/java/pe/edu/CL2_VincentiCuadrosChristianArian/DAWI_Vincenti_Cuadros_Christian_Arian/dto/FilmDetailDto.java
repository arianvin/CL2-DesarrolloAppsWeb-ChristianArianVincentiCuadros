package pe.edu.CL2_VincentiCuadrosChristianArian.DAWI_Vincenti_Cuadros_Christian_Arian.dto;
import java.util.List;

public record FilmDetailDto(
        Integer filmId,
        String title,
        String description,
        Integer releaseYear,
        Integer rentalDuration,
        Double rentalRate,
        Integer length,
        String rating,
        String languageName,
        Integer languageId,
        List<Integer> inventoryIds,
        List<Integer> categoryIds,
        List<Integer> actorIds) {
}