package com.ans.serg.swaggerpetstore.entity;

import com.ans.serg.swaggerpetstore.enums.PetStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Category category;
    @Schema(example = "doggie")
    @NotEmpty
    @NotBlank
    private String name;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Tag> tags = new HashSet<>();
    @Schema(description = "pet status in the store")
    private PetStatus status;
}
