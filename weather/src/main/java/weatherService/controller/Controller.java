package weatherService.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import weatherService.service.WeatherService;

@RestController
@RequestMapping("/weather")
public class Controller {
    private final WeatherService weatherService;


    @Autowired
    public Controller(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{city}")
    public ResponseEntity getWeather(@PathVariable("city") String city) {
       // (weatherService.getWeather(city)
        return new ResponseEntity(weatherService.getWeather(city), HttpStatus.OK);
    }
}
