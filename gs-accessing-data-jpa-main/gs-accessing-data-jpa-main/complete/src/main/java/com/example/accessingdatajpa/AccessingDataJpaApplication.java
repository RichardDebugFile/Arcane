package com.example.accessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class AccessingDataJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(
			PersonajeRepository personajeRepo,
			OrganizacionRepository orgRepo,
			TecnologiaRepository techRepo,
			AfiliacionRepository afiliacionRepo,
			UsoTecnologiaRepository usoTecRepo,
			RelacionRepository relacionRepo
	) {
		return args -> {
			// 1) Crear personajes
			Personaje p1 = personajeRepo.save(new Personaje("Jinx", "Zaun", "Campeona", "Caótica"));
			Personaje p2 = personajeRepo.save(new Personaje("Ekko", "Zaun", "Timewinder", "Neutral"));
			Personaje p3 = personajeRepo.save(new Personaje("Vi",  "Piltover", "Oficial",   "Legal"));

			// 2) Crear organizaciones
			Organizacion o1 = orgRepo.save(new Organizacion("Enforcer Corps", "Piltover", "Policial"));
			Organizacion o2 = orgRepo.save(new Organizacion("Slaughtergang",   "Zaun",    "Criminal"));

			// 3) Crear tecnologías
			Tecnologia t1 = techRepo.save(new Tecnologia("Hextech Gauntlet", "Arma", "Potencia de Hextech"));
			Tecnologia t2 = techRepo.save(new Tecnologia("Chronobreak",      "Habilidad", "Manipula el tiempo"));

			// 4) Asociar afiliaciones
			afiliacionRepo.save(new Afiliacion(p1, o2, "Miembro fundador",  LocalDate.of(2015, 6, 1)));
			afiliacionRepo.save(new Afiliacion(p2, o2, "Recluta",           LocalDate.of(2016, 9, 15)));
			afiliacionRepo.save(new Afiliacion(p3, o1, "Líder de patrulla", LocalDate.of(2017, 3, 20)));

			// 5) Asociar uso de tecnología
			usoTecRepo.save(new UsoTecnologia(p1, t1));
			usoTecRepo.save(new UsoTecnologia(p2, t2));
			usoTecRepo.save(new UsoTecnologia(p3, t1));
			usoTecRepo.save(new UsoTecnologia(p3, t2));

			// 6) Crear relaciones entre personajes
			relacionRepo.save(new Relacion(p1, p2, "Amigos de infancia"));
			relacionRepo.save(new Relacion(p1, p3, "Enemistad intensa"));
			relacionRepo.save(new Relacion(p2, p3, "Alianza táctica"));

			// 7) Loguear todo para comprobar
			log.info("=== PERSONAJES ===");
			personajeRepo.findAll().forEach(pe -> log.info(pe.toString()));

			log.info("=== ORGANIZACIONES ===");
			orgRepo.findAll().forEach(o -> log.info(o.toString()));

			log.info("=== TECNOLOGIAS ===");
			techRepo.findAll().forEach(t -> log.info(t.toString()));

			log.info("=== AFILIACIONES ===");
			afiliacionRepo.findAll().forEach(a ->
					log.info(a.getPersonaje().getNombre() + " en "
							+ a.getOrganizacion().getNombre()
							+ " desde " + a.getFechaIngreso())
			);

			log.info("=== USO DE TECNOLOGIA ===");
			usoTecRepo.findAll().forEach(u ->
					log.info(u.getPersonaje().getNombre() + " usa "
							+ u.getTecnologia().getNombre())
			);

			log.info("=== RELACIONES ===");
			relacionRepo.findAll().forEach(r ->
					log.info(r.getPersonajeA().getNombre() + " ↔ "
							+ r.getPersonajeB().getNombre()
							+ ": " + r.getTipoRelacion())
			);
		};
	}
}
