package ru.topjava.learn.homework.entity;
import lombok.*;

import java.io.Serializable;


// Why is Serializable?
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Bank implements Serializable {
    @NonNull private int id;
    private String name;
    private String surname;
    private double money;
    private String currency;
}
