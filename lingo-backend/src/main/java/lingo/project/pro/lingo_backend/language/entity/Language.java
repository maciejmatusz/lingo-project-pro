package lingo.project.pro.lingo_backend.language.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigInteger;

@Getter
@Entity
@Table(name = "languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    private String language_name;

    private String code;

}
