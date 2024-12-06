package pe.edu.CL2_VincentiCuadrosChristianArian.DAWI_Vincenti_Cuadros_Christian_Arian.dto;

public record FilmCreateDto(
        String title,
        String description,
        Integer releaseYear,
        Integer languageId,
        Integer rentalDuration,
        Double rentalRate,
        Integer length,
        Double replacementCost,
        String rating,
        String specialFeatures
) {
}
