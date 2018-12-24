package versionBeta;

import org.threeten.bp.LocalDate;

import com.jimmoores.quandl.DataSetRequest;
import com.jimmoores.quandl.Frequency;
import com.jimmoores.quandl.TabularResult;
import com.jimmoores.quandl.classic.ClassicQuandlSession;

public class QuandlAuthenticator {
	ClassicQuandlSession session;
	
	QuandlAuthenticator(){
		// Store Quandl API key
		String QUANDL_AUTH_TOKEN_PROPERTY_NAME = "Q-w7mP8umy6qy8_VCAH_";
		System.setProperty(QUANDL_AUTH_TOKEN_PROPERTY_NAME, "Q-w7mP8umy6qy8_VCAH_");

		// Example1.java
		this.session = ClassicQuandlSession.create();
		TabularResult tabularResult = this.session.getDataSet(DataSetRequest.Builder
				.of("WIKI/AAPL")
				.withFrequency(Frequency.ANNUAL)
				.withStartDate(LocalDate.of(2010, 1, 10))
				.withEndDate(LocalDate.of(2018, 12, 23))
				.build());
		System.out.println(tabularResult.toPrettyPrintedString());
	}
	
	public ClassicQuandlSession getSession() {
		return this.session;
	}
	
}
