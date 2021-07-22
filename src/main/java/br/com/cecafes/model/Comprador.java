package br.com.cecafes.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Audited
@Entity
public class Comprador extends Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty
    private String nome;
    @NotNull
    @NotEmpty
    private String contato;
    @NotNull
    @NotEmpty
    private String cpf;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="endereco_id")
    private Endereco endereco;
    @OneToMany(mappedBy = "comprador")
    private List<Pedido> pedidos;
}
