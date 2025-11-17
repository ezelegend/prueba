package cl.cgr.siaper.ru.api.administracion_servicios_publicos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiAdministracionServiciosPublicosApplication {

	public static void main(String[] args) {
	    System.out.println("JVM args: " + String.join(" ", java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments()));
		SpringApplication.run(ApiAdministracionServiciosPublicosApplication.class, args);
	}

}
