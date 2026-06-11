package com.loomic.ecommerceapp.util;

import java.util.UUID;

public final class TransactionIdGenerator {

    public static String generateTxnId(){
        return "TXN-"+ UUID.randomUUID().toString().replace("-", "").substring(0,10).toUpperCase();
    }
}
