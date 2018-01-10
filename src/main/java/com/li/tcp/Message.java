package com.li.tcp;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {

    private final DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");

    /**
     * 确认
     */
    private final String AFN_OK = "00";
    /**
     * 否认
     */
    private final String AFN_NO = "01";
    /**
     * 登录
     */
    private final String AFN_LOGIN = "02";
    /**
     * 心跳
     */
    private final String AFN_HEART_BEAT = "03";
    /**
     * 设置参数
     */
    private final String AFN_SET_STATEMENT = "04";
    /**
     * 命令控制
     */
    private final String AFN_COMMAND = "05";
    /**
     * 重启
     */
    private final String AFN_RESTART = "06";
    /**
     * 复位
     */
    private final String AFN_RELOCAL = "07";
    /**
     * 备用
     */
    private final String AFN_STANDY1 = "08";
    /**
     * 备用
     */
    private final String AFN_STANDY2 = "09";
    /**
     * 参数查询
     */
    private final String AFN_QUERY_STATEMENT = "0A";
    /**
     * 实时数据上报
     */
    private final String AFN_LASTEST_DATA = "0B";
    /**
     * 历史数据上报
     */
    private final String AFN_HISTORY_DATA = "0C";
    /**
     * 事件数据上报
     */
    private final String AFN_INCIDENT_DATA = "0E";
    /**
     * 采集器状态上报
     */
    private final String AFN_COLLETR_STATE = "0F";

    /**
     * 逆变器数据
     */
    private final String DATAUNIT_FN_DEVICE = "01";
    /**
     * 汇流箱数据
     */
    private final String DATAUNIT_FN_HUILIU = "02";
    /**
     * 电表数据
     */
    private final String DATAUNIT_FN_DIANBIAO = "03";
    /**
     * 环境采集仪数据
     */
    private final String DATAUNIT_FN_ENVIRONMENT = "04";
    /**
     * 电能质量监测数据
     */
    private final String DATAUNIT_FN_POWER = "05";
    /**
     * 保护测控数据
     */
    private final String DATAUNIT_FN_PROTECT = "06";
    /**
     * 状态数据
     */
    private final String DATAUNIT_FN_STATEE = "07";
    /**
     * 对时
     */
    private final String DATAUNIT_FN_DUISHI = "08";
    /**
     * 测点信息
     */
    private final String DATAUNIT_FN_CEDIAN = "09";

    private final String START1 = "70";
    private final String START2 = "70";

    private final String END = "20";

    private String length1;//长度L
    private String length2;//长度L

    private String controlC;//控制域C
    private String addressA;//地址域A

    private String AFN;//应用数据域:AFN
    private String deviceAddrPN;//应用数据域:设备地址PN
    private String dataUintFN;//应用数据域:数据单元FN
    private String data;//应用数据域:数据

    private Date time;//事件Time
    private String checkOutAndCS;//校验和CS

    public String getControlC() {

        return controlC;
    }

    public Message setControlC(String controlC) {

        this.controlC = controlC;
        return this;
    }

    public String getAddressA() {
        return addressA;
    }

    public Message setAddressA(String addressA) {

        this.addressA = addressA;
        return this;
    }

    public String getAFN() {

        return AFN;
    }

    public Message setAFN(String AFN) {

        this.AFN = AFN;
        return this;
    }

    public String getDeviceAddrPN() {

        return deviceAddrPN;
    }

    public Message setDeviceAddrPN(Integer deviceAddrPN) {

        this.deviceAddrPN = "0" + Integer.toHexString(deviceAddrPN);
        return this;
    }

    public String getDataUintFN() {

        return dataUintFN;
    }

    public Message setDataUintFN(String dataUintFN) {

        this.dataUintFN = dataUintFN;
        return this;
    }


    public String getData() {

        return data;
    }

    public Message setData(String data) {

        this.data = data;
        return this;
    }

    public Date getTime() {

        return time;
    }

    public Message setTime(Date time) {

        this.time = time;
        return this;
    }

    public String getCheckOutAndCS() {

        return checkOutAndCS;
    }

    public Message setCheckOutAndCS(String checkOutAndCS) {

        this.checkOutAndCS = checkOutAndCS;
        return this;
    }

    private String date2Str(Date time) {

        return df.format(time);
    }

    private void lengthCalcucate() throws Exception {

        //"170317090856"
        String data2 = controlC
                + addressA
                + AFN
                + deviceAddrPN
                + dataUintFN
                + data
                + date2Str(time);
        //String a = "C000005E2700470B010108E71CE71C141D141DD61CD61C281D281D00002700270026002700260028002600984E000010018413FFFF640098261D095709C8091A011A011901A04E0000B3190000561A00007C1B0000854F0000000000002D0B000055BE0F00170317090856";

        byte[] bytes = hexStringToByteArray(data2.trim());

        String length = Integer.toHexString(bytes.length) + "00";

        this.length1 = length.toUpperCase();
        this.length2 = length.toUpperCase();

    }


    private static byte[] hexStringToByteArray(String s) {

        int len = s.length();
        byte[] b = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            // 两位一组，表示一个字节,把这样表示的16进制字符串，还原成一个字节
            b[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character
                    .digit(s.charAt(i + 1), 16));
        }
        return b;
    }

    @Override
    public String toString() {

        try {
            lengthCalcucate();

            return (START1 + length1 + length2
                    + START2
                    + controlC
                    + addressA
                    + AFN
                    + deviceAddrPN
                    + dataUintFN
                    + data
                    + date2Str(time)
                    + checkOutAndCS
                    + END);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void main(String[] args) {

        String s = Integer.toHexString(247);
        System.out.println(s);
    }

}
