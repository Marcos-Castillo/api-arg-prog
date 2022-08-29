package app.web.marcoscastillo.apiArgProg;
/*Original*/
import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class ApiArgProgApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiArgProgApplication.class, args);
	}
        @Bean
        public CorsFilter corsFilter(){
            CorsConfiguration corsConFiguration  =new  CorsConfiguration();
            corsConFiguration.setAllowCredentials(true);
            corsConFiguration.setAllowedOrigins(Arrays.asList("https://marcos-castillo.web.app/"));
            corsConFiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                    "Accept","Authorization", "Origin, Accept", "X-Request-With",
                    "Access-Control-Request-Method", "Access-Control-Request-Headers"));
            corsConFiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization", 
                    "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
            corsConFiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
            UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
            urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConFiguration);
            return new CorsFilter(urlBasedCorsConfigurationSource);
        }

}
