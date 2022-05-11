package com.example.thymeleaf.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.thymeleaf.exception.RecordNotFoundException;
import com.example.thymeleaf.model.OrderNotifItem;
import com.example.thymeleaf.service.OrderNotifService;
@Controller
public class OrderNotifController {
 @Autowired
 private OrderNotifService service;
 @GetMapping("/")
 public String home(OrderNotifItem item, Model model) {
  List<OrderNotifItem> list = service.getAllShops();
  model.addAttribute("list", list);
  return "index";
 }
 @GetMapping("/add")
 public String showAddForm(OrderNotifItem item, Model model) {
  return "add-item";
 }
 @PostMapping("/save")
 public String create(OrderNotifItem item, Model model) {
  service.saveOrUpdateShop(item);
  return "redirect:/";
 }
 @RequestMapping(path = { "/update","/update/{id}"})
 public String update(Model model,@PathVariable("id") Integer id) throws RecordNotFoundException {
  if(id!=null) {
   OrderNotifItem item2 = service.getShopById(id);
   model.addAttribute("orderNotifItem", item2);
  }else {
   model.addAttribute("orderNotifItem", new OrderNotifItem()); // new OrderNotificationItem();
  }
  return "add-item";
 }
 @RequestMapping(path = { "/delete/{id}"})
 public String delete(Model model, @PathVariable("id") Integer id) {
  service.deleteShop(id);
  return "redirect:/";
 }
}
