package com.fatesg.meutransporteapi.entities;

import com.fatesg.meutransporteapi.utils.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Entity(name = "tb_user")
@SequenceGenerator(name = "user_seq", sequenceName = "user_seq", initialValue = 1, allocationSize = 1)
public class User extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @Column(name = "id")
    private Long idUser;

    @NotBlank(message = "Usuário é obrigatório")
    @Size(min = 5, message = "Usuário deve ter no mínimo 5 caracteres")
    @Column(name = "user_name", length = 75, nullable = false, unique = true)
    private String userName;

    @NotBlank(message = "Senha é obrigatório")
    @Size(min = 4, message = "Senha deve ter no mínimo 4 caracteres")
    @Column(length = 50, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Perfil é obrigatório")
    @Column(nullable = false)
    private Role role;

}
