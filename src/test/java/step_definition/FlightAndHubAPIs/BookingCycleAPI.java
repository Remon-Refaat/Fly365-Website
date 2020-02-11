package step_definition.FlightAndHubAPIs;

import helper.APIUtility;
import helper.GeneralMethods;
import io.restassured.path.json.JsonPath;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookingCycleAPI {

    public static String orderIdCheckoutResponse = null;

    GeneralMethods gmObject = new GeneralMethods();
    public String oneWayAPI() {
        String departureDate1 = gmObject.addDateWithCertainPeriodAndFormat(10, "yyyy-MM-dd");
        String oneWay = "{\"legs\": [{\"origin\": \"JED\",\"destination\": \"CAI\",\"departureDate\": \"" + departureDate1 + "\"}],\n" +
                " \"cabinClass\": \"Economy\",\"infant\": 0,\"child\": 0,\"adult\": 1}";
        return oneWay;
    }

    public  String roundTripAPI() {
        String departureDate1 = gmObject.addDateWithCertainPeriodAndFormat(10, "yyyy-MM-dd");
        String departureDate2 = gmObject.addDateWithCertainPeriodAndFormat(20, "yyyy-MM-dd");
        String roundTrip = "{\"legs\": [{\"origin\": \"JED\",\"destination\": \"CAI\",\"departureDate\": \"" + departureDate1 + "\"\n" +
                "   },{\"origin\": \"CAI\",\"destination\": \"DMM\",\"departureDate\": \"" + departureDate2 + "\"}],\n" +
                " \"cabinClass\": \"Economy\",\"infant\": 0,\"child\": 0,\"adult\": 1}";
        return roundTrip;
    }

    public String multiCityAPI() {
        String departureDate1 = gmObject.addDateWithCertainPeriodAndFormat(10, "yyyy-MM-dd");
        String departureDate2 = gmObject.addDateWithCertainPeriodAndFormat(20, "yyyy-MM-dd");
        String departureDate3 = gmObject.addDateWithCertainPeriodAndFormat(30, "yyyy-MM-dd");
        String multiCity = "{\"legs\": [{\"origin\": \"JED\",\"destination\": \"CAI\",\"departureDate\": \"" + departureDate1 + "\"\n" +
                "   },{\"origin\": \"CAI\",\"destination\": \"JED\",\"departureDate\": \"" + departureDate2 + "\"},{\"origin\": \"CAI\",\n" +
                "     \"destination\": \"DXB\",\"departureDate\": \"" + departureDate3 + "\"}],\n" +
                " \"cabinClass\": \"Economy\",\"infant\": 0,\"child\": 0,\"adult\": 1}";
        return multiCity;
    }

    public static String    getItineraryId(String returnedJsongString, int tripnumber) {
        JSONObject jObject = new JSONObject(returnedJsongString);
        JSONArray arr = jObject.getJSONArray("itineraries");
        String itineraryId = null;
        for (int i = 0; i < arr.length(); i++) {
            itineraryId = arr.getJSONObject(tripnumber - 1).getString("itineraryId");
        }
        return itineraryId;
    }

    public static String createCart(String itineraryId, String domain) throws IOException {

        String createCartAPI = "{\"itineraryId\": \"" + itineraryId + "\"}";
        String returnedJsonString = APIUtility.sendRequestFlight("https://nz.fly365" + domain + ".com/api/flight/cart", createCartAPI,"post");
        JSONObject jObject = new JSONObject(returnedJsonString);
        return jObject.getString("id");

    }

    public static void addPassenger(String cartID, String domain) throws IOException {

        String addPassengerDetailsAPI = "{\"passengers\": [" +
                "{\"title\": \"Mr\", \"firstName\": \"John\",\"middleName\": \"William\",\"lastName\": \"Smith\",\"dateOfBirth\": \"1991-06-04\"," +
                "\"reference\": \"123\",\"passengerType\": \"ADT\",\"frequentFlyerOptions\": {\"airlineCode\": \"code\",\"number\": \"num\"" +
                "}}],\"customer\": {\"title\": \"Mr\",\"firstName\": \"John\",\"lastName\": \"William\",\"email\": \"john.smith.fly365@gmail.com\"," +
                "\"mobileNumber\": \"0121234567\"}}";
        APIUtility.sendRequestFlight("https://nz.fly365" + domain + ".com/api/flight/cart/" + cartID + "/passenger", addPassengerDetailsAPI, "post");
    }

    public static String[] checkoutTrip(String cartID, String domain) throws IOException {
        String addCardDetailsAPI = "{\n" +
                "    \"method\": \"cc\",\n" +
                "    \"type\": \"direct\",\n" +
                "    \"card\": {\n" +
                "        \"number\": \"5123450000000008\",\n" +
                "        \"cvv\": \"123\",\n" +
                "        \"expiryDate\": \"1122\",\n" +
                "        \"type\": \"cc-visa-credit\",\n" +
                "        \"holderName\": \"Alaa Attya\"\n" +
                "    },\n" +
                "    \"billingAddress\": {\n" +
                "        \"address\": \"Something\",\n" +
                "        \"country\": \"DO\",\n" +
                "        \"city\": \"AZS\",\n" +
                "        \"zipCode\": \"5678\",\n" +
                "        \"state\": \"NY\"\n" +
                "    },\n" +
                "    \"holdFees\":{\n" +
                "    \t\"amount\": 15.8\n" +
                "    }\n" +
                "}";
        String returnedJsonString = APIUtility.sendRequestFlight("https://nz.fly365" + domain + ".com/api/flight/cart/" + cartID + "/checkout", addCardDetailsAPI, "post");
//To validate that the order no./pnr number is displayed correctly in retrieve my booking
        JSONObject jObject = new JSONObject(returnedJsonString);
        String orderNumber = jObject.getJSONObject("order").get("orderNumber").toString();
        orderIdCheckoutResponse = jObject.getJSONObject("order").get("orderId").toString();
        String[] fly365AirlineRef = {orderNumber, orderIdCheckoutResponse};
        String finalResponse = getresult(orderIdCheckoutResponse, orderNumber);
        getBookingResponse();
        System.out.println(finalResponse);
        return fly365AirlineRef;
    }

    public static String depCity = null, arrCity = null, bookingCode = null, storeUser = null, storeId = null, carrierCode = null,
            email = null, mobileNumber = null, airLineRef = null, flyRef = null, paymentGateway = null, discountName = null, orderId = null, totalPrice;

    public static void getBookingResponse() {
        ArrayList<String> bookingCodeArr = new ArrayList<String>();
        airLineRef = APIUtility.jsonPathEvaluator.get("products[0].confirmation.supplierConfirmationCode").toString();
        flyRef = APIUtility.jsonPathEvaluator.get("products[0].confirmation.vendorConfirmationCode").toString();
        storeId = APIUtility.jsonPathEvaluator.get("storeId").toString();
        email = APIUtility.jsonPathEvaluator.get("customer.email").toString();
        mobileNumber = APIUtility.jsonPathEvaluator.get("customer.mobileNumber").toString();
        storeUser = APIUtility.jsonPathEvaluator.get("storeUser").toString();
        paymentGateway = APIUtility.jsonPathEvaluator.get("payment.additionalInformation.provider").toString();
        totalPrice = APIUtility.jsonPathEvaluator.get("displayTotal.total").toString();
        carrierCode = APIUtility.jsonPathEvaluator.get("products[0].options[1].value.carrier.code").toString();
        discountName = APIUtility.jsonPathEvaluator.get("products[0].options[1].value.discounts.name");
        orderId = APIUtility.jsonPathEvaluator.get("id").toString();
        List<JSONArray> legsArr = APIUtility.jsonPathEvaluator.getList("products[0].options[1].value.legs");
        for (int i = 0; i < legsArr.size(); i++) {
            List<JSONArray> segArr = APIUtility.jsonPathEvaluator.getList("products[0].options[1].value.legs[" + i + "].segments");
            for (int segCount = 0; segCount < segArr.size(); segCount++) {
                bookingCodeArr.add(APIUtility.jsonPathEvaluator.get("products[0].options[1].value.legs[" + i + "].segments[" + segCount + "].bookingInfo.bookingCode").toString());
            }
        }
        List<String> removeDuplCodes = bookingCodeArr.stream().distinct().collect(Collectors.toList());
        bookingCode = String.join(",", removeDuplCodes);
        depCity = APIUtility.jsonPathEvaluator.get("products[0].options[2].value.legs.origin[0]").toString();
        List<String> arrivals = APIUtility.jsonPathEvaluator.getList("products[0].options[2].value.legs.destination");
        if (arrivals.get(0).equals(arrivals.get(arrivals.size() - 1))) {
            arrCity = arrivals.get(arrivals.size() - 2);
        } else {
            arrCity = arrivals.get(arrivals.size() - 1);
        }
    }

    public static String getresult(String orderId, String orderNumber) throws IOException {
        String finalResponse = APIUtility.sendRequestFlight("https://nz.fly365stage.com/api/user/order/find?orderId=" + orderId + "&orderNumber=" + orderNumber + "","noBody", "get");
        return finalResponse;
    }

    public static String getTripResponse(String email, String orderNumber) throws IOException {
        String response = APIUtility.sendRequestFlight("https://www.fly365stage.com/api/user/order/find?email=" + email + "&orderNumber=" + orderNumber,"no Body", "get");
        return response;
    }
}
