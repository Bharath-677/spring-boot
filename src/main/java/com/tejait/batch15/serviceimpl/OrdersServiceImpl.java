package com.tejait.batch15.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tejait.batch15.dto.OrdersRequestDto;
import com.tejait.batch15.exceptions.DataNotFoundException;
import com.tejait.batch15.model.Customer;
import com.tejait.batch15.model.Orders;
import com.tejait.batch15.repository.CustomerRepository;
import com.tejait.batch15.repository.OrdersRepository;
import com.tejait.batch15.service.OrdersService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OrdersServiceImpl implements OrdersService {
	
   OrdersRepository repository;
   CustomerRepository customerRepository;
  
   @Override
   public OrdersRequestDto saveOrders(OrdersRequestDto dto) {

   Customer customer=customerRepository.findById(dto.getCustomerId())
   .orElseThrow(()->new DataNotFoundException("Customer not Found"));
   
        List<Orders> ordersList=dto.getOrders();
        
        for(Orders order:ordersList) {
        	order.setCustom(customer);
        }
        
        // dto.getOrders().forEach(order->order.setCustom(customer));
       List<Orders> saveOrderssList= repository.saveAll(ordersList);
       
       OrdersRequestDto resposnseDto= new OrdersRequestDto();
       
       resposnseDto.setOrders(saveOrderssList);
       resposnseDto.setCustomerId(dto.getCustomerId());
   
	return resposnseDto;
   }
	
}
