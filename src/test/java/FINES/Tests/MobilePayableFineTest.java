package FINES.Tests;

import FINES.APIs.*;
import org.testng.annotations.Test;

public class MobilePayableFineTest {

    @Test
    public void testPayableMobileFine() {

        GetToken token = new GetToken();
        String access_token = token.getMobileAccessToken();
        GetPayableFines payableFine = new GetPayableFines();
        int ticketNo = payableFine.getMobilePayableFines(access_token, "10351032");
        CreatePaybleFine createJourney = new CreatePaybleFine();
        String applicationRefNo = createJourney.createMobileFineJourney(access_token, ticketNo);
        GetFinalInvoice invoice = new GetFinalInvoice();
        invoice.getFinalInv(applicationRefNo , access_token);
        SentForPayment sentPayment = new SentForPayment();
        sentPayment.sentPayment(access_token , applicationRefNo);
        PayAndConfirm payAndConfirm = new PayAndConfirm();
        payAndConfirm.payConfirm(access_token,applicationRefNo,ticketNo);

    }

}
