package org.formation.spring.report;

public class PdfReportGenerator implements IReportGenerator {

	@Override
	public void generate() {
		System.out.println("Génération d'un rapport PDF...");
	}

}
