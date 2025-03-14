package pe.edu.upc.intibank.service;

import pe.edu.upc.intibank.entity.Bills;
import pe.edu.upc.intibank.entity.User;
import pe.edu.upc.intibank.model.account.AccountResponseModel;
import pe.edu.upc.intibank.model.bills.BillsResponseModel;

import java.util.List;

public interface IBillsNegocio {

    public List<Bills> listarBillsPorSuministro(String sumi);

    List<BillsResponseModel> getMyRecibos();

    List<Bills> findByNumeroSuministroAndEstadoPagoOrderByFechaEmisionAsc(String numeroSuministro, String estadoPago);

    Bills save(Bills bill);

    Bills findById(Long id);


}
