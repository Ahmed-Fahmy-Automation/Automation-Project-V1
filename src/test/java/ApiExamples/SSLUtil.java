package ApiExamples;

import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;


public final class SSLUtil {

    static {
        //for localhost testing only
        HttpsURLConnection.setDefaultHostnameVerifier(
            new HostnameVerifier(){

                public boolean verify(String hostname,
                                      SSLSession sslSession) {
                    if (hostname.contains("172.18.125.73")) {
                        return true;
                    }
                    return false;
                }
            });
    }

    private static final TrustManager[] UNQUESTIONING_TRUST_MANAGER = new TrustManager[]{
        new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers(){
                return null;
            }
            public void checkClientTrusted( X509Certificate[] certs, String authType ){}
            public void checkServerTrusted( X509Certificate[] certs, String authType ){}
        }
    };

    public  static void turnOffSslChecking() throws NoSuchAlgorithmException, KeyManagementException {
        // Install the all-trusting trust manager
        final SSLContext sc = SSLContext.getInstance("SSL");
        sc.init( null, UNQUESTIONING_TRUST_MANAGER, null );
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        System.out.println("Disable SSL");
    }

    public static void turnOnSslChecking() throws KeyManagementException, NoSuchAlgorithmException {
        // Return it to the initial state (discovered by reflection, now hardcoded)
        SSLContext.getInstance("SSL").init( null, null, null );
    }

    private SSLUtil(){
        throw new UnsupportedOperationException( "Do not instantiate libraries.");
    }
}
