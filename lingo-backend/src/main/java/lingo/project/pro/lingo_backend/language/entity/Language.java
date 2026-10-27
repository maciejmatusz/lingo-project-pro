package lingo.project.pro.lingo_backend.language.entity;

import jakarta.persistence.*;
import lingo.project.pro.lingo_backend.task.entity.Task;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
@EqualsAndHashCode
@Table(name = "languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String language_name;

    private String code;

    @OneToMany(mappedBy = "sourceLanguage", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Task> sourceLanguageTasks;

    @OneToMany(mappedBy = "targetLanguage", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Task> targetLanguageTasks;

}
