package com.chitraveerakhil.DocumentCreator.processing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class DocumentGenerator {

	private XWPFDocument document;

	public void createWordFile(String name, String mobileNumber, String emailId) throws IOException {
		// Write the Document in file system

		FileOutputStream out = null;
		String filePath = "./target/generated-files/docs/" + name + ".docx";
		try {
			document = new XWPFDocument();
			out = new FileOutputStream(new File(filePath));

		} catch (FileNotFoundException e) {
			Path path = Paths.get(filePath);
			Files.createDirectories(path.getParent());

			Path file = Files.createFile(path);

			System.out.println(file.toString());
			out = new FileOutputStream(file.toString());
		} finally {
			XWPFParagraph paragraph = document.createParagraph();
			createXwpfRun(paragraph, "Name: ", name);
			createXwpfRun(paragraph, "\nMobile Number: ", mobileNumber);
			createXwpfRun(paragraph, "\nEmail Id: ", emailId);
			document.write(out);
			System.out.println("doc created");
			out.close();
		}
	}

	private void createXwpfRun(XWPFParagraph paragraph, String key, String value) {
		XWPFRun xwpfRun = paragraph.createRun();
		xwpfRun.setBold(true);
		xwpfRun.setText(key);
		xwpfRun.setBold(false);
		xwpfRun.setText(value);
	}

	public static void main(String[] args) throws IOException {
		DocumentGenerator gen = new DocumentGenerator();
		gen.createWordFile("test", "test", "test");
	}

}
