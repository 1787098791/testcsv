package com.freedom.test.testsocket;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author ：wujie
 * @date ：Created in 2020/3/1 19:29
 * @description：
 * @version:
 */
public class TestIp {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        String hostAddress = localHost.getHostAddress();
        String hostName = localHost.getHostName();
        System.out.println(hostAddress+"******"+hostName);
    }
}
