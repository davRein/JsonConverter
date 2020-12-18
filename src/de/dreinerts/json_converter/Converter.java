package de.dreinerts.json_converter;

import javax.json.stream.JsonGenerator;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;

import javax.json.Json;

public class Converter {

	private int[] treffer = { 2, 3, 33, 6, 33, 76, 44 };

	public void start() {
		ArrayList<Integer> trefferList = new ArrayList<Integer>();
		for (int i = 0; i < treffer.length; i++) {
			trefferList.add(treffer[i]);
		}
		System.out.println(trefferList);
		String strData;
		try (Writer writer = new StringWriter()) {
			try (JsonGenerator generator = Json.createGenerator(writer)) {
				generator.writeStartObject().writeStartArray("treffer");
				generator.write("Details");
				for (Integer values : trefferList) {
					generator.write(values);
				}
				generator.writeEnd().writeEnd();
			}
			strData = writer.toString();
		} catch (IOException e) {
			strData = "";
		}
		System.out.println(strData);
	}
}