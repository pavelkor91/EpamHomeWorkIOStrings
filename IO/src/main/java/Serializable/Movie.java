package Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Movie implements Serializable{
    private String actor;
    private String movie;
    private int lenghtMin;

}
