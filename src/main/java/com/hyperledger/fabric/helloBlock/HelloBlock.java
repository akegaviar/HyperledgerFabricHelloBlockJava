
package com.hyperledger.fabric.helloBlock;

import java.util.ArrayList;
import java.util.List;

import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.contract.ContractInterface;
import org.hyperledger.fabric.contract.annotation.Contact;
import org.hyperledger.fabric.contract.annotation.Contract;
import org.hyperledger.fabric.contract.annotation.Default;
import org.hyperledger.fabric.contract.annotation.Info;
import org.hyperledger.fabric.contract.annotation.License;
import org.hyperledger.fabric.contract.annotation.Transaction;
import org.hyperledger.fabric.shim.ChaincodeException;
import org.hyperledger.fabric.shim.ChaincodeStub;
import org.hyperledger.fabric.shim.ledger.KeyValue;
import org.hyperledger.fabric.shim.ledger.QueryResultsIterator;

import com.owlike.genson.Genson;

// Hello Block in Java
@Contract(
        name = "helloBlock",
        info = @Info(
                title = "helloBlock contract",
                description = "A simple Hello Block contract",
                version = "0.1"
                ))
@Default
public final class HelloBlock implements ContractInterface {

    private final Genson genson = new Genson();

// Runs a Hello Block transaction
    @Transaction()
    public Hello runHello(final Context ctx, final String key, final String block) {
        ChaincodeStub stub = ctx.getStub();

        String helloState = stub.getStringState(key);
        
        Hello hello = new Hello(block);
        helloState = genson.serialize(hello);
        stub.putStringState(key, helloState);

        return hello;
    }
}
