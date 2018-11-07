package com.chitraveerakhil.DocumentCreator.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chitraveerakhil.DocumentCreator.model.DocumentModel;
import com.chitraveerakhil.DocumentCreator.processing.DocumentGenerator;

@RestController
public class DocumentController {

	@RequestMapping("/getDetails")
	public DocumentModel mapDetails(@RequestParam(value = "name",defaultValue="test") String name,
			@RequestParam(value = "mobileNumber",defaultValue="test") String mobileNumber,
			@RequestParam(value = "emailId",defaultValue="test") String emailId) throws IOException {

		DocumentModel model = new DocumentModel(name, emailId, mobileNumber);
		DocumentGenerator gen = new DocumentGenerator();
		gen.createWordFile(name,mobileNumber,emailId);
		return model;
	}
}
