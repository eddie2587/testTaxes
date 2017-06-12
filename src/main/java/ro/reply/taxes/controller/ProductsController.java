package ro.reply.taxes.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ro.reply.taxes.controller.util.ResponseWrapper;
import ro.reply.taxes.exceptions.BadRequestException;
import ro.reply.taxes.model.Product;
import ro.reply.taxes.service.ProductService;

@Controller
@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductsController {

	@Autowired
	ProductService productService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResponseWrapper<Product> createProduct(@RequestBody final Product product, BindingResult result)
			throws BadRequestException, IOException {

		return new ResponseWrapper<Product>(true, productService.createProduct(product));
	}

}
