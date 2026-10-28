package lingo.project.pro.lingo_backend.language.entity;

import jakarta.persistence.*;
import lingo.project.pro.lingo_backend.task.entity.Task;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
@Table(name = "languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "language_name")
    private String languageName;

    private String code;

    @OneToMany(mappedBy = "sourceLanguage")
    private List<Task> sourceLanguageTasks;

    @OneToMany(mappedBy = "targetLanguage")
    private List<Task> targetLanguageTasks;

}
