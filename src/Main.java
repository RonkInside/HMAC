import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

public class Main {

    public static void main(String[] args) {


                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");

                String data = ZonedDateTime.now().format(formatter); //11062019172500

                String number = "123456";

                String user = "TESTWS";

                String secret = "0c9e67acc4e6e4e841081a5c99908f19ddfd21b4948f78c9107887b7b0e8b9c8";

                String message = String.format("GET+/users/%s/account+%s+%s", user, data, number);

                Mac sha256HMAC = null;

                SecretKeySpec secretKey = null;

                try {
                    sha256HMAC = Mac.getInstance("HmacSHA256");
                    SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
                    sha256HMAC.init(secret_key);
                } catch (Exception ex) {

                }
                //String hash = Base64.encodeBase64String(sha256HMAC.doFinal(message.getBytes()));

                String hash = Base64.getEncoder().encodeToString(sha256HMAC.doFinal(message.getBytes()));


                System.out.println(data);
                System.out.println(hash);

            }
}
