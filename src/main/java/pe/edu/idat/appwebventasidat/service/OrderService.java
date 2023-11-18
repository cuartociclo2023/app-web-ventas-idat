package pe.edu.idat.appwebventasidat.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.idat.appwebventasidat.model.bd.Customer;
import pe.edu.idat.appwebventasidat.model.bd.Employee;
import pe.edu.idat.appwebventasidat.model.bd.Order;
import pe.edu.idat.appwebventasidat.model.bd.OrderDetail;
import pe.edu.idat.appwebventasidat.model.bd.pk.OrderDetailId;
import pe.edu.idat.appwebventasidat.model.request.OrderDetailRequest;
import pe.edu.idat.appwebventasidat.model.request.OrderRequest;
import pe.edu.idat.appwebventasidat.model.response.ResultadoResponse;
import pe.edu.idat.appwebventasidat.repository.OrderDetailRepository;
import pe.edu.idat.appwebventasidat.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class OrderService {

    private OrderRepository orderRepository;
    private OrderDetailRepository orderDetailRepository;


    @Transactional(propagation = Propagation.REQUIRED)
    public ResultadoResponse registrarVenta(OrderRequest order,
                                            List<OrderDetailRequest> orderDetailList){
        try{
            Order newOrder = new Order();
            newOrder.setRequireddate(order.getRequireddate());
            newOrder.setShippeddate(order.getShippeddate());
            newOrder.setOrderdate(order.getOrderdate());
            Customer newCustomer = new Customer();
            newCustomer.setCustomerid(order.getCustomerid());
            Employee newEmployee = new Employee();
            //newEmployee
            Order insertOrder = orderRepository.save(newOrder);
            for(OrderDetailRequest orderDetailRequest : orderDetailList){
                OrderDetail newOrderDetail = new OrderDetail();
                newOrderDetail.setUnitprice(orderDetailRequest.getUnitprice());
                newOrderDetail.setDiscount(orderDetailRequest.getDiscount());
                newOrderDetail.setQuantity(orderDetailRequest.getQuantity());
                OrderDetailId orderDetailId = new OrderDetailId(insertOrder.getOrderid(),
                        orderDetailRequest.getProductid());
                newOrderDetail.setOrderDetailId(orderDetailId);
                orderDetailRepository.save(newOrderDetail);
            }
        }catch (Exception ex){

        }
        return null;

    }

}
