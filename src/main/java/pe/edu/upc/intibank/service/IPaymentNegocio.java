package pe.edu.upc.intibank.service;

import pe.edu.upc.intibank.modelDto.PaymentRequest;

public interface IPaymentNegocio {

    void processPago(PaymentRequest paymentRequest);

}
