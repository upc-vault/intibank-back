package pe.edu.upc.intibank.mapper;


import pe.edu.upc.intibank.entity.Bills;
import pe.edu.upc.intibank.model.bills.BillsResponseModel;

public interface BillsMapper {

    BillsResponseModel toResponseModel(Bills bills);

}
