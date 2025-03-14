package pe.edu.upc.intibank.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table (name = "TBL_TIPO_SERVICIO")
public class ServiceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tiposervicio")
    private Long idTipoServicio;

    @Column(name = "nombre_servicio")
    private String nombreServicio;
}
