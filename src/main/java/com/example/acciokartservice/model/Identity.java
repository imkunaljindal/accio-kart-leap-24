package com.example.acciokartservice.model;

import com.example.acciokartservice.Enum.IdentityType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="unique_identity")
public class Identity {

    @Id
    int uniqueId;

    @Enumerated(EnumType.STRING)
    IdentityType identityType;

    String identityNumber;
}
