package pe.edu.CL2_VincentiCuadrosChristianArian.DAWI_Vincenti_Cuadros_Christian_Arian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.CL2_VincentiCuadrosChristianArian.DAWI_Vincenti_Cuadros_Christian_Arian.repository.FilmRepository;

@SpringBootApplication
public class DawiVincentiCuadrosChristianArianApplication implements CommandLineRunner {

	@Autowired
	FilmRepository filmRepository;

	public static void main(String[] args) {
		SpringApplication.run(DawiVincentiCuadrosChristianArianApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
