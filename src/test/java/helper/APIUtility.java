package helper;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class APIUtility extends TestBase {

    GeneralMethods gmObject = new GeneralMethods();

    public static String sendPostRequest(String requestUrl, String tripType) {
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("x-store-id", "fly365_com");
            connection.setRequestProperty("authorization", "5TGy5xPegnkS2ML7pNbSsWJfSywSLQGZ");
            connection.setRequestProperty("x-store-user", "fly365_com_nz");
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            writer.write(tripType);
            writer.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer jsonString = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                jsonString.append(line);
            }
            br.close();
            connection.disconnect();
            return jsonString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public String oneWayAPI() {
        String departureDate1 = gmObject.addDateWithCertainPeriodAndFormat(10, "yyyy-MM-dd");
        String oneWay = "{\"legs\": [{\"origin\": \"LON\",\"destination\": \"CAI\",\"departureDate\": \"" + departureDate1 + "\"}],\n" +
                " \"cabinClass\": \"Economy\",\"infant\": 0,\"child\": 0,\"adult\": 1}";
        return oneWay;
    }

    public String roundTripAPI() {
        String departureDate1 = gmObject.addDateWithCertainPeriodAndFormat(10, "yyyy-MM-dd");
        String departureDate2 = gmObject.addDateWithCertainPeriodAndFormat(20, "yyyy-MM-dd");
        String roundTrip = "{\"legs\": [{\"origin\": \"DMS\",\"destination\": \"CAI\",\"departureDate\": \"" + departureDate1 + "\"\n" +
                "   },{\"origin\": \"CAI\",\"destination\": \"DMS\",\"departureDate\": \"" + departureDate2 + "\"}],\n" +
                " \"cabinClass\": \"Economy\",\"infant\": 0,\"child\": 0,\"adult\": 1}";
        return roundTrip;
    }

    public String multiCityAPI() {
        String departureDate1 = gmObject.addDateWithCertainPeriodAndFormat(10, "yyyy-MM-dd");
        String departureDate2 = gmObject.addDateWithCertainPeriodAndFormat(20, "yyyy-MM-dd");
        String departureDate3 = gmObject.addDateWithCertainPeriodAndFormat(30, "yyyy-MM-dd");
        String multiCity = "{\"legs\": [{\"origin\": \"DMS\",\"destination\": \"CAI\",\"departureDate\": \"" + departureDate1 + "\"\n" +
                "   },{\"origin\": \"CAI\",\"destination\": \"DMS\",\"departureDate\": \"" + departureDate2 + "\"},{\"origin\": \"CAI\",\n" +
                "     \"destination\": \"DXB\",\"departureDate\": \"" + departureDate3 + "\"}],\n" +
                " \"cabinClass\": \"Economy\",\"infant\": 0,\"child\": 0,\"adult\": 1}";
        return multiCity;
    }

    public String createDiscount(String discountEnteredName) {
        String discountRule = "{\n" +
                "    \"name\": \"" + discountEnteredName + "\",\n" +
                "    \"storeId\": \"fly365_nz\",\n" +
                "    \"storeUser\": \"\",\n" +
                "    \"carrierCode\": \"\",\n" +
                "    \"bookingCode\": \"\",\n" +
                "    \"fareBaseCode\": \"\",\n" +
                "    \"priority\": 0,\n" +
                "    \"cabinClass\": \"\",\n" +
                "    \"flightType\": \"\",\n" +
                "    \"searchType\": \"\",\n" +
                "    \"routeDepartureType\": \"\",\n" +
                "    \"routeDepartureCode\": \"\",\n" +
                "    \"routeDestinationType\": \"\",\n" +
                "    \"routeDestinationCode\": \"\",\n" +
                "    \"discountUpSell\": false,\n" +
                "    \"discountPercent\": 2,\n" +
                "    \"discountAmount\": 0,\n" +
                "    \"taxUpSell\": false,\n" +
                "    \"taxPercent\": 0,\n" +
                "    \"taxAmount\": 0,\n" +
                "    \"taxCode\": \"\",\n" +
                "    \"excludeCountry\": false,\n" +
                "    \"isActive\": true\n" +
                "}";
        return discountRule;
    }

    public static String getItineraryId(String returnedJsongString, int tripnumber) {
        JSONObject jObject = new JSONObject(returnedJsongString);
        JSONArray arr = jObject.getJSONArray("itineraries");
        String itineraryId = null;
        for (int i = 0; i < arr.length(); i++) {
            itineraryId = arr.getJSONObject(tripnumber - 1).getString("itineraryId");
        }
        return itineraryId;
    }

    public static String getDiscountName(String returnedJsongString, int tripnumber) {
        JSONObject jObject = new JSONObject(returnedJsongString);
        JSONArray arr = jObject.getJSONArray("itineraries");
        String discountName = null;
        for (int i = 0; i < arr.length(); i++) {
            discountName = arr.getJSONObject(tripnumber - 1).getJSONObject("discounts").get("name").toString();
        }
        return discountName;
    }

    public static String getDiscountStatus(String returnedJsongString, int tripnumber) {
        JSONObject jObject = new JSONObject(returnedJsongString);
        JSONArray arr = jObject.getJSONArray("itineraries");
        String discountField = null;
        for (int i = 0; i < arr.length(); i++) {
            discountField = arr.getJSONObject(tripnumber - 1).get("discounts").toString();
        }
        return discountField;
    }

    public static String createCart(String itineraryId, String domain) {

        String createCartAPI = "{\"itineraryId\": \"" + itineraryId + "\"}";
        String returnedJsonString = sendPostRequest("https://api.fly365" + domain + ".com/flight/cart", createCartAPI);
        JSONObject jObject = new JSONObject(returnedJsonString);
        return jObject.getString("id");
    }

    public static void addPassenger(String cartID, String domain) {

        String addPassengerDetailsAPI = "{\"passengers\": [" +
                "{\"firstName\": \"John\",\"middleName\": \"William\",\"lastName\": \"Smith\",\"title\": \"Mr\",\"dateOfBirth\": \"1991-06-04\"," +
                "\"reference\": \"123\",\"passengerType\": \"ADT\",\"frequentFlyerOptions\": {\"airlineCode\": \"code\",\"number\": \"num\"" +
                "}}],\"customer\": {\"title\": \"mr\",\"firstName\": \"John\",\"lastName\": \"William\",\"email\": \"john.smith.fly365@gmail.com\"," +
                "\"mobileNumber\": \"0121234567\"}}";
        sendPostRequest("https://api.fly365" + domain + ".com/flight/cart/" + cartID + "/passenger", addPassengerDetailsAPI);
    }

    public static String[] checkoutTrip(String cartID, String domain) throws InterruptedException {

        String addCardDetailsAPI = "{\"method\":\"cc\",\"type\":\"direct\",\"card\":{\"number\":\"4242424242424242\",\"cvv\":\"123\",\n" +
                "\"expiryDate\":\"1120\",\"type\":\"visa\",\"holderName\": \"Alaa Attya\"},\n" +
                " \"billingAddress\":{\"address\":\"Something\",\"country\":\"DO\",\"city\":\"AZS\",\"zipCode\":\"5678\",\"state\":\"NY\"}}";
        String returnedJsonString = sendPostRequest("https://api.fly365" + domain + ".com/flight/cart/" + cartID + "/checkout", addCardDetailsAPI);
//To validate that the order no./pnr number is displayed correctly in retrieve my booking
        Thread.sleep(15000);
        JSONObject jObject = new JSONObject(returnedJsonString);
        String orderNumber = jObject.getString("orderNumber");
        String pnrNumber = jObject.getString("flightPNR");
        String referenceNum = jObject.getString("orderReference");
        String[] fly365AirlineRef = {orderNumber, pnrNumber};
        return fly365AirlineRef;
    }





    public static void createTicketAPI(String domain) throws IOException {
        String createContactUsAPI = "{\"name\":\"me\",\"email\":\"khaled.abdelaziz@fly365.com\", \"category\":\"Booking Enquiry\", \"message\":\"testing contact\"}";
        sendPostRequestCreateTicket("https://api.fly365" + domain + ".com/api/user",createContactUsAPI);
    }


    public static void createRuleAPI(String domain){
        String createRuleAPI = "{ \"name\" : \"egypt-dubai14\", \"storeId\" : \"fly365_nz\", \"carrierCodeString\" : \"RJ\", \"bookingCodeString\": \"Q\","+
                "\"departureType\" : \"country\", \"departureCodeString\" : \"eg\", \"destinationType\" : \"country\", \"destinationCodeString\" : \"ae\","+
                "\"airlineChangeFees\" : 100, \"fly365ChangeFees\" : 200, \"defaultBaseChangeFees\": 50, \"defaultTaxChangeFees\": 50,"+
                "\"airlineCancelFees\": 1000, \"fly365CancelFees\": 2000, \"cancellationOption\": 1, \"isActive\": false }";
        sendPostRequestCreateTicket("https://www.fly365" + domain + ".com/api/rules",createRuleAPI);
    }

    public static String sendPostRequestCreateTicket(String requestUrl, String createRuleAPI) {
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("x-user-token", "iKW0cf68638aeaad43297055aa446693276EcV");
            connection.setRequestProperty("authorization", "XXu5WbKbM6XHbU5VKNETr6AMnNaVNd9E");
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            writer.write(createRuleAPI);
            writer.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer jsonString = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                jsonString.append(line);
            }
            br.close();
            connection.disconnect();
            return jsonString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

