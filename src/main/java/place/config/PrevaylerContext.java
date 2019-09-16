package place.config;

import java.io.IOException;
import java.io.Serializable;

import org.prevayler.Prevayler;
import org.prevayler.PrevaylerFactory;
import org.prevayler.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import place.model.Data;

@ApplicationScope
@Component
public class PrevaylerContext implements Serializable {

	private static final long serialVersionUID = 1L;

	private Prevayler prevayler;

	public PrevaylerContext() {
		PrevaylerFactory factory = new PrevaylerFactory();
		factory.configurePrevalenceBase("data");
		factory.configurePrevalentSystem(new Data());
		try {
			prevayler = factory.create();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

	public void execute(Transaction transaction) {
		prevayler.execute(transaction);
	}

	public Data getData() {
		return (Data) prevayler.prevalentSystem();
	}
}