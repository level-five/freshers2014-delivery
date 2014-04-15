package jp.level_five.freshers.delivery;

import java.io.InputStream;
import java.io.PrintStream;

public class ShippingDateByShippingMethod {

    private String shippingMethod;
    private int postalCode;
    private int dateOfArrival;
    private String timeZone;
    
    public InputOutput io;

    ShippingDateByShippingMethod() {
        io = new InputOutput();
    }

    ShippingDateByShippingMethod(InputOutput inputoutput) {
        io = inputoutput;
    }

    public void setInputStream(InputStream inputStream) {
    	io.setInputStream(inputStream);
    }
    
    public void setOutputStream(PrintStream printStream) {
    	io.setPrintStream(printStream);
    }
    
    public void inputShippingMethod() {
        shippingMethod = io.inputShippingMethod();
    }
    
    public String getShippingMethod() {
    	return shippingMethod;
    }

    public void inputPostalCode() {
        postalCode = io.inputPostalCode();
    }

    public int getPostalCode() {
    	return postalCode;
    }

    public void inputDateOfArrival() {
        dateOfArrival = io.inputArrivalDate();
    }

    public int getDateOfArrival() {
    	return dateOfArrival;
    }

    public void inputTimeZone() {
        timeZone = io.inputTimeZone();
    }
    
    public String getTimeZone() {
    	return timeZone;
    }

    public ClientData createClientData(String shippingMethod, int postalCode,
            int dateOfArrival, String timeZone) {
        return new ClientData(shippingMethod, postalCode, dateOfArrival, 
				timeZone);
    }

    public String modeSelection(ClientData client) {
        String sendShippingDate = null;
        
        switch (client.getShippingMethod()) {
        case "A":
            sendShippingDate = new ShippingDateByServiceA()
                    .sendShippingDate(client);
            break;
        case "B":
            sendShippingDate = new ShippingDateByServiceB()
                    .sendShippingDate(client);
            break;
        case "":
            sendShippingDate = new ShippingDateOfLowestCost()
            		.preSendShippingDate(client);
            break;
        }
        
        return sendShippingDate;
    }
    
    public String inputClientData() {
        inputShippingMethod();
        inputPostalCode();
        inputDateOfArrival();
        inputTimeZone();
        
        return modeSelection(createClientData(shippingMethod, postalCode,
                dateOfArrival, timeZone));
    }
    
    public String inputClientDataWithoutShippingMethod() {
        inputPostalCode();
        inputDateOfArrival();
        inputTimeZone();
        
        return modeSelection(createClientData("", postalCode,
                dateOfArrival, timeZone));
    }
}
