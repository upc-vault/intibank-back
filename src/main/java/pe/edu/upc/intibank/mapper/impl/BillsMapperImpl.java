package pe.edu.upc.intibank.mapper.impl;

import org.springframework.stereotype.Component;
import pe.edu.upc.intibank.entity.Bills;
import pe.edu.upc.intibank.mapper.BillsMapper;
import pe.edu.upc.intibank.model.bills.BillsResponseModel;

@Component
public class BillsMapperImpl implements BillsMapper {

    @Override
    public BillsResponseModel toResponseModel(Bills bill) {
        return BillsResponseModel
                .builder()
                .numeroSuministro(bill.getNumeroSuministro())
                .monto(bill.getMonto())
                .fechaVencimiento(bill.getFechaVencimiento())
                .fechaEmision(bill.getFechaEmision())
                .estadoPago(bill.getEstadoPago())
                .build();
    }
}


