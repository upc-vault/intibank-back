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
@Table(name="TBL_PROVEEDOR_SERVICIO")
public class SupplierService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Long idProveedor;

    @ManyToOne
    @JoinColumn(name="id_tiposervicio")
    private ServiceType tipoServicio;

    @Column(name = "nombre_proveedor")
    private String nombreProveedor;
}
