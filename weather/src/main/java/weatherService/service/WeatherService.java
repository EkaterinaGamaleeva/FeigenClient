package weatherService.service;
import org.springframework.stereotype.Service;
import weatherService.model.Weather;

import java.util.SplittableRandom;

@Service
public class WeatherService {
    private SplittableRandom random = new SplittableRandom();
    public Weather getWeather(String city){
        Weather weather=new Weather();
        weather.setCity(city);
        weather.setTemperature(random.nextInt(-20,45));
         return weather;
    }
}
