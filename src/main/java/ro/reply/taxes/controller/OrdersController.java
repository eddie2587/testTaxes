package ro.reply.taxes.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ro.reply.taxes.controller.util.ResponseWrapper;
import ro.reply.taxes.exceptions.BadRequestException;
import ro.reply.taxes.model.Order;
import ro.reply.taxes.model.Receipt;
import ro.reply.taxes.service.OrderService;

@Controller
@RequestMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrdersController {

	@Autowired
	OrderService orderService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResponseWrapper<Receipt> createOrder(@RequestBody final Order order)
			throws BadRequestException, IOException {
		return new ResponseWrapper<Receipt>(true, orderService.processOrder(order));
	}

}
