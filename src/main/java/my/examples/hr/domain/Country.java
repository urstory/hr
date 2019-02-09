package my.examples.hr.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "countries")
@Setter
@Getter
public class Country {
    @Id
    private String countryId;
    private String countryName;
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToMany
    @JoinColumn(name = "country_id")
    private Set<Location> locations;

    public Country(){
//        locations = new HashSet<>();
    }
}
