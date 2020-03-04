package web.model;
/*
 *
 *@Data 04.03.2020
 *@autor Fedorov Yuri
 *@project spring_mvc
 *
 */

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@NoArgsConstructor
public class Car {
    private Integer id;
    private String color;
    private String model;
}
