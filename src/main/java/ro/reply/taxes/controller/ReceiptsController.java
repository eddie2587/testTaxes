package ro.reply.taxes.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import ro.reply.taxes.model.Receipt;
import ro.reply.taxes.service.ReceiptService;

@Controller
@RequestMapping(value = "/receipts", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReceiptsController {

	@Autowired
	ReceiptService receiptService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ModelAndView listAllReceipts(ModelAndView model) throws IOException {
		List<Receipt> receipts = receiptService.getAllReceipts();
		model.addObject("receipts", receipts);
		model.setViewName("receipts");
		return model;
	}

}
