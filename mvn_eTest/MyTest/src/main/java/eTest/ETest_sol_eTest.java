package eTest;

import org.web3j.utils.Numeric;
import java.lang.Exception;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.4.0.
 */
public class ETest_sol_eTest extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5060008054600160a060020a0319163317905561022b806100326000396000f3006080604052600436106100615763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416630cb6aaf181146100665780634c66708014610090578063673e0481146100a05780638da5cb5b146100b8575b600080fd5b34801561007257600080fd5b5061007e6004356100f6565b60408051918252519081900360200190f35b61009e600435602435610115565b005b3480156100ac57600080fd5b5061007e6004356101d1565b3480156100c457600080fd5b506100cd6101e3565b6040805173ffffffffffffffffffffffffffffffffffffffff9092168252519081900360200190f35b600280548290811061010457fe5b600091825260209091200154905081565b600080548190819073ffffffffffffffffffffffffffffffffffffffff16331461013e57600080fd5b505060025460009150815b8181101561017f57600280548290811061015f57fe5b60009182526020909120015485141561017757600192505b600101610149565b821561018a57600080fd5b505050600082815260016020819052604082209290925560028054928301815590527f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5ace0155565b60016020526000908152604090205481565b60005473ffffffffffffffffffffffffffffffffffffffff16815600a165627a7a723058204aa4114b7cde1e8621ce3fa10b0202c9f969ecd2a71fef4f988988b3295ffc410029";

    public static final String FUNC_KEYS = "keys";

    public static final String FUNC_PUT = "put";

    public static final String FUNC_PAIRS = "pairs";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_GET = "get";

    protected ETest_sol_eTest(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ETest_sol_eTest(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<byte[]> keys(BigInteger param0) {
        final Function function = new Function(FUNC_KEYS,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<TransactionReceipt> put(String Key, String KeyValue, BigInteger weiValue) {
        byte[] value = Numeric.hexStringToByteArray(KeyValue);
        final Function function = new Function(
                FUNC_PUT,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(Key.getBytes()),
                new org.web3j.abi.datatypes.generated.Bytes32(value)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public String get(String Key, ETest_sol_eTest etest) throws Exception {
        byte[] key = Key.getBytes();
        byte[] value = etest.pairs(key).send();
        String c = "";
        for (int i = 0; i < value.length; i++) {
          String hex = Integer.toHexString(value[i] & 0xFF);
          if (hex.length() == 1) {
            hex = '0' + hex;
          }
          c = c + hex;
        }
        return c;
    }

    public RemoteCall<byte[]> pairs(byte[] param0) {
        final Function function = new Function(FUNC_PAIRS,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function(FUNC_OWNER,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public static RemoteCall<ETest_sol_eTest> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ETest_sol_eTest.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ETest_sol_eTest> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ETest_sol_eTest.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static ETest_sol_eTest load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ETest_sol_eTest(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static ETest_sol_eTest load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ETest_sol_eTest(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
