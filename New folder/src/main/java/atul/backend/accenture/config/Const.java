package atul.backend.accenture.config;

public class Const {
    public interface DBQueries {
        String
                LANDING_QUERY =
                "SELECT cc.card_num, cc.name, cc.lim_bal, sm.sexDesc, ed.eduNm, mr.marriageNm, cc.age, pm0.PayDesc AS pay_0, pm2.PayDesc AS pay_2, pm3.PayDesc AS pay_3, pm4.PayDesc AS pay_4, pm5.PayDesc AS pay_5, pm6.PayDesc AS pay_6, cc.bill_amt1, cc.bill_amt2, cc.bill_amt3, cc.bill_amt4, cc.bill_amt5, cc.bill_amt6, cc.pay_amt1, cc.pay_amt2, cc.pay_amt3, cc.pay_amt4, cc.pay_amt5, cc.pay_amt6, dp.payDesc\n" +
                        "FROM credit_card cc\n" +
                        "INNER JOIN default_payment dp ON dp.payId = cc.pay_next_month\n" +
                        "INNER JOIN education ed ON ed.eduId = cc.eduId\n" +
                        "INNER JOIN marriage mr ON mr.marriageId = cc.marId\n" +
                        "INNER JOIN sexmstr sm ON sm.sexId = cc.sex\n" +
                        "INNER JOIN paymstr pm0 ON pm0.payId = cc.pay_0\n" +
                        "INNER JOIN paymstr pm2 ON pm2.payId = cc.pay_2\n" +
                        "INNER JOIN paymstr pm3 ON pm3.payId = cc.pay_3\n" +
                        "INNER JOIN paymstr pm4 ON pm4.payId = cc.pay_4\n" +
                        "INNER JOIN paymstr pm5 ON pm5.payId = cc.pay_5\n" +
                        "INNER JOIN paymstr pm6 ON pm6.payId = cc.pay_6";

        String getByIDQuery =
                "SELECT cc.card_num, cc.name, cc.lim_bal, sm.sexDesc, ed.eduNm, mr.marriageNm, cc.age, pm0.PayDesc AS pay_0, pm2.PayDesc AS pay_2, pm3.PayDesc AS pay_3, pm4.PayDesc AS pay_4, pm5.PayDesc AS pay_5, pm6.PayDesc AS pay_6, cc.bill_amt1, cc.bill_amt2, cc.bill_amt3, cc.bill_amt4, cc.bill_amt5, cc.bill_amt6, cc.pay_amt1, cc.pay_amt2, cc.pay_amt3, cc.pay_amt4, cc.pay_amt5, cc.pay_amt6, dp.payDesc\n" +
                        "FROM credit_card cc\n" +
                        "INNER JOIN default_payment dp ON dp.payId = cc.pay_next_month\n" +
                        "INNER JOIN education ed ON ed.eduId = cc.eduId\n" +
                        "INNER JOIN marriage mr ON mr.marriageId = cc.marId\n" +
                        "INNER JOIN sexmstr sm ON sm.sexId = cc.sex\n" +
                        "INNER JOIN paymstr pm0 ON pm0.payId = cc.pay_0\n" +
                        "INNER JOIN paymstr pm2 ON pm2.payId = cc.pay_2\n" +
                        "INNER JOIN paymstr pm3 ON pm3.payId = cc.pay_3\n" +
                        "INNER JOIN paymstr pm4 ON pm4.payId = cc.pay_4\n" +
                        "INNER JOIN paymstr pm5 ON pm5.payId = cc.pay_5\n" +
                        "INNER JOIN paymstr pm6 ON pm6.payId = cc.pay_6\n" +
                        "where cc.card_num = ?1";
    }

    public interface KeyWords{
         String GET_BY_ID = "getById";
         String GET_All = "getAll";
    }

    public interface Status {
        String SUCCESS = "0000";
        String ERROR = "9999";
        String FAILURE = "0010";
        String ACCESS_DENOED_ERROR_CODE = "9000";
        String ACCESS_DENOED_ERRROR_MSG = "User does not have proper access";
        String UNDEFINED = "9990";

    }
}
