package lingo.project.pro.lingo_backend.language.entity;

import jakarta.persistence.*;
import lingo.project.pro.lingo_backend.task.entity.Task;
import lombok.Getter;

import java.math.BigInteger;
import java.util.List;

@Getter
@Entity
@Table(name = "languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    private String language_name;

    private String code;

    @OneToMany(mappedBy = "sourceLanguage")
    private List<Task> sourceLanguageTasks;

    @OneToMany(mappedBy = "targetLanguage")
    private List<Task> targetLanguageTasks;

}
