package com.example.test.entiity;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@TypeDef(name = "json", typeClass = JsonStringType.class)
@Table(name = "products")
public class Products {
    @Id
    private String id;
    private String name;
    private Date date;
    private boolean promoted;
    private int tax;
    private int price;
}
