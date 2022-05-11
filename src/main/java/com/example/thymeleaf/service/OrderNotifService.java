package com.example.thymeleaf.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.thymeleaf.exception.RecordNotFoundException;
import com.example.thymeleaf.model.OrderNotifItem;
import com.example.thymeleaf.repository.OrderNotifRepository;
@Service
public class OrderNotifService {
 @Autowired
 private OrderNotifRepository repository;
 
 /*
  * TODO: Get the List of Shops
  */
 public List<OrderNotifItem> getAllShops(){
  List<OrderNotifItem> list =  (List<OrderNotifItem>)repository.findAll();
  return list;
 }
 /*
  * TODO: Get Shop by Id.
  */
 public OrderNotifItem getShopById(Integer id) throws RecordNotFoundException {
  
  Optional<OrderNotifItem> tblOrderNotifications = repository.findById(id);
  if(tblOrderNotifications!=null) {
   return tblOrderNotifications.get();
  }
  else
  {
   throw new RecordNotFoundException("Not found");
  }
 }
 /*
  * TODO: Save into db
  */
 public OrderNotifItem saveOrUpdateShop(OrderNotifItem item) {
  if(item.getNotificationReasonId() == null) {
  return repository.save(item);
  } else {
   Optional<OrderNotifItem> sOptional = repository.findById(item.getNotificationReasonId());
   if(sOptional!=null) {
    OrderNotifItem item2 = sOptional.get();
    item2.setNotificationReasonCode(item.getNotificationReasonCode());
    item2 = repository.save(item2);
    return item2;
   }
   else {
	   item = repository.save(item);
    return item;
   
  }
 }
}
 public void deleteShop(Integer id) {  
  repository.deleteById(id);
 }
}