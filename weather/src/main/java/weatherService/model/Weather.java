package weatherService.model;

import lombok.Data;

//не храним в базе данных
@Data
public class Weather {
    private String city;
    private Integer temperature;

}
