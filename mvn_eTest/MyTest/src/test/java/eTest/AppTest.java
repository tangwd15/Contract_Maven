package eTest;

import static org.junit.Assert.assertTrue;
import org.junit.*;
import java.io.File;
import java.security.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.ArrayList;
import org.web3j.utils.Numeric;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.crypto.CipherException;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.tx.Contract;
import org.web3j.tx.Contract.*;
import org.web3j.tx.TransactionManager;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    ETest_sol_eTest etest;

    @Test
    public void Test () throws Exception {
      System.out.println("--------------------------------------------------------");
      Web3j web3 = Web3j.build(new HttpService("https://rinkeby.infura.io/v3/995b4f511bc74785b1ee8dd00299da86"));
      Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().send();
      String clientVersion = web3ClientVersion.getWeb3ClientVersion();
      System.out.println("**** clientVersion:\n     " + clientVersion);
      String filePath = System.getProperty("user.dir");
      String fileName = "UTC--2018-08-14T14-52-51.919Z--8684ef445a1ffbe51919c2bab10da6df507992f4";
      Credentials credentials = WalletUtils.loadCredentials("Tang19970107", filePath+"/"+fileName);
      etest = ETest_sol_eTest.deploy( web3, credentials,
      Contract.GAS_PRICE,Contract.GAS_LIMIT).send();
      System.out.println("**** filename:\n     " + fileName);
      EthGetBalance ethGetBalance = web3
      .ethGetBalance("0x8684eF445a1FFbe51919C2Bab10Da6Df507992F4", DefaultBlockParameterName.LATEST)
      .sendAsync()
      .get();
      BigInteger wei = ethGetBalance.getBalance();
      System.out.println("**** Balance:\n     " + wei);
      System.out.println("--------------------------------------------------------");
      BigInteger big = new BigInteger("21000");
      String a = "6c73dae1d1e440fabfec82db0a3f5498";
      String b = "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855";
      //byte[] myStringInByte = Numeric.hexStringToByteArray(b);
      System.out.println("**** call put() function...");
      System.out.println("     KEY:\n       " + a);
      System.out.println("     KEYVALUE:\n       " + b);
      System.out.println("--------------------------------------------------------");
      System.out.println("**** transaction information:\n    " + etest.put(a,b).send());
      System.out.println("--------------------------------------------------------");
      System.out.println("**** call pair() function...");
      System.out.println("     given Key:\n       " + a);
      System.out.println("**** returns KeyValue:\n       " + etest.get(a));
      System.out.println("--------------------------------------------------------");
    }
}
