package jp.level_five.freshers.delivery;

//import java.io.InputStream;

public class ShippingDateByShippingMethod {

    public String shippingMethod;
    public int postalCode;
    public int dateOfArrival;
    public String timeZone;
    private InputOutput input;

    // InputOutput input = new InputOutput();
//     public void setInputStream(InputStream inputStream) {
//     input.setInputStream(inputStream);
//     }
    ShippingDateByShippingMethod() {
        input = new InputOutput();
    }

    ShippingDateByShippingMethod(InputOutput inputoutput) {
        input = inputoutput;
    }

    public String inputClientData() {
        inputShippingMethod();
        inputPostalCode();
        inputDateOfArrival();
        inputTimeZone();

        return modeSelection(createClientData(shippingMethod, postalCode,
                dateOfArrival, timeZone));
    }

    public void inputShippingMethod() {
        shippingMethod = input.inputShippingMethod();
    }

    public void inputPostalCode() {
        postalCode = input.inputPostalCode();
    }

    public void inputDateOfArrival() {
        dateOfArrival = input.inputArrivalDate();
    }

    public void inputTimeZone() {
        timeZone = input.inputTimeZone();
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
        }
        return sendShippingDate;
    }

}
