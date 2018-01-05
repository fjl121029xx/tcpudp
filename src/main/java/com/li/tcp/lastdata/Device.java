package com.li.tcp.lastdata;

public class Device {

    /**
     * 运行
     */
    private final Integer STATE_RUN = 10;
    /**
     * 停机
     */
    private final Integer STATE_STOP = 11;
    /**
     * 故障
     */
    private final Integer STATE_MALFUNCTION = 12;
    /**
     * MPPT 回路数 M
     */
    private String MPPT;
    /**
     * 第 M 路直流输入电压
     */
    private String voltage;
    /**
     * 第 M 路直流输入电流
     */
    private String electricity;
    /**
     * 总直流输入功率
     */
    private String totalDCinputPower;
    /**
     * 机内温度
     */
    private String internalTemperature;
    /**
     * 电网频率
     */
    private String theGridFrequency;
    /**
     * 绝缘阻抗值
     */
    private String insulationResistanceValue;
    /**
     * 功率因素
     */
    private String powerfactor;
    /**
     * 逆变器效率
     */
    private String inverterEfficiency;
    /**
     * 交流输出 A 相电压
     */
    private String aCoutputAphaseVoltage;
    /**
     * 交流输出 B 相电压
     */
    private String aCoutputBphaseVoltage;
    /**
     * 交流输出 C 相电压
     */
    private String aCoutputCphaseVoltage;
    /**
     * 交流输出 A 相电流
     */
    private String aCoutputAphaseCurrent;
    /**
     * 交流输出 B 相电流
     */
    private String aCoutputBphaseCurrent;
    /**
     * 交流输出 C 相电流
     */
    private String aCoutputCphaseCurrent;
    /**
     * 有功总功率
     */
    private String activeTotalPower;
    /**
     * A 相有功功率
     */
    private String aPhaseActivePower;
    /**
     * B 相有功功率
     */
    private String bPphaseActivePower;
    /**
     * C 相有功功率
     */
    private String cPhaseActivePower;
    /**
     * 总视在功率
     */
    private String totalApparentPower;
    /**
     * 总无功功率
     */
    private String totalReactivePower;
    /**
     * 日发电量
     */
    private String dailyOutput;
    /**
     * 总发电量
     */
    private String totalGeneratingCapacity;
    /**
     * 状态
     */
    private String state;

    public String getMPPT() {

        return MPPT;
    }

    public Device setMPPT(String MPPT) {

        this.MPPT = MPPT;
        return this;
    }

    public String getVoltage() {

        return voltage;
    }

    public Device setVoltage(Integer... voltage) {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < voltage.length; i++) {

            builder.append(Integer.toHexString(voltage[i]));
        }

        this.voltage = builder.toString();
        return this;
    }

    public String getElectricity() {

        return electricity;
    }

    public Device setElectricity(Integer... electricity) {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < electricity.length; i++) {

            builder.append(Integer.toHexString(electricity[i]));
        }

        this.electricity = builder.toString();
        return this;
    }

    public String getTotalDCinputPower() {

        return totalDCinputPower;
    }

    public Device setTotalDCinputPower(Integer totalDCinputPower) {

        this.totalDCinputPower = Integer.toHexString(totalDCinputPower);
        return this;
    }

    public String getInternalTemperature() {

        return internalTemperature;
    }

    public Device setInternalTemperature(Integer internalTemperature) {

        this.internalTemperature = Integer.toHexString(internalTemperature);
        return this;
    }

    public String getTheGridFrequency() {

        return theGridFrequency;
    }

    public Device setTheGridFrequency(Integer theGridFrequency) {

        this.theGridFrequency = Integer.toHexString(theGridFrequency);
        return this;
    }

    public String getInsulationResistanceValue() {

        return insulationResistanceValue;
    }

    public Device setInsulationResistanceValue(Integer insulationResistanceValue) {

        this.insulationResistanceValue = Integer.toHexString(insulationResistanceValue);
        return this;
    }

    public String getPowerfactor() {

        return powerfactor;
    }

    public Device setPowerfactor(Integer powerfactor) {

        this.powerfactor = Integer.toHexString(powerfactor);
        return this;
    }

    public String getInverterEfficiency() {

        return inverterEfficiency;
    }

    public Device setInverterEfficiency(Integer inverterEfficiency) {

        this.inverterEfficiency = Integer.toHexString(inverterEfficiency);
        return this;
    }

    public String getaCoutputAphaseVoltage() {

        return aCoutputAphaseVoltage;
    }

    public Device setaCoutputAphaseVoltage(Integer aCoutputAphaseVoltage) {

        this.aCoutputAphaseVoltage = Integer.toHexString(aCoutputAphaseVoltage);
        return this;
    }

    public String getaCoutputBphaseVoltage() {

        return aCoutputBphaseVoltage;
    }

    public Device setaCoutputBphaseVoltage(Integer aCoutputBphaseVoltage) {

        this.aCoutputBphaseVoltage = Integer.toHexString(aCoutputBphaseVoltage);
        return this;
    }

    public String getaCoutputCphaseVoltage() {

        return aCoutputCphaseVoltage;
    }

    public Device setaCoutputCphaseVoltage(Integer aCoutputCphaseVoltage) {

        this.aCoutputCphaseVoltage = Integer.toHexString(aCoutputCphaseVoltage);
        return this;
    }

    public String getaCoutputAphaseCurrent() {

        return aCoutputAphaseCurrent;
    }

    public Device setaCoutputAphaseCurrent(Integer aCoutputAphaseCurrent) {

        this.aCoutputAphaseCurrent = Integer.toHexString(aCoutputAphaseCurrent);
        return this;
    }

    public String getaCoutputBphaseCurrent() {

        return aCoutputBphaseCurrent;
    }

    public Device setaCoutputBphaseCurrent(Integer aCoutputBphaseCurrent) {

        this.aCoutputBphaseCurrent = Integer.toHexString(aCoutputBphaseCurrent);
        return this;
    }

    public String getaCoutputCphaseCurrent() {

        return aCoutputCphaseCurrent;
    }

    public Device setaCoutputCphaseCurrent(Integer aCoutputCphaseCurrent) {

        this.aCoutputCphaseCurrent = Integer.toHexString(aCoutputCphaseCurrent);
        return this;
    }

    public String getActiveTotalPower() {

        return activeTotalPower;
    }

    public Device setActiveTotalPower(Integer activeTotalPower) {

        this.activeTotalPower = Integer.toHexString(activeTotalPower);
        return this;
    }

    public String getaPhaseActivePower() {

        return aPhaseActivePower;
    }

    public Device setaPhaseActivePower(Integer aPhaseActivePower) {

        this.aPhaseActivePower = Integer.toHexString(aPhaseActivePower);
        return this;
    }

    public String getbPphaseActivePower() {

        return bPphaseActivePower;
    }

    public Device setbPphaseActivePower(Integer bPphaseActivePower) {

        this.bPphaseActivePower = Integer.toHexString(bPphaseActivePower);
        return this;
    }

    public String getcPhaseActivePower() {

        return cPhaseActivePower;
    }

    public Device setcPhaseActivePower(Integer cPhaseActivePower) {

        this.cPhaseActivePower = Integer.toHexString(cPhaseActivePower);
        return this;
    }

    public String getTotalApparentPower() {

        return totalApparentPower;
    }

    public Device setTotalApparentPower(Integer totalApparentPower) {

        this.totalApparentPower = Integer.toHexString(totalApparentPower);
        return this;
    }

    public String getTotalReactivePower() {

        return totalReactivePower;
    }

    public Device setTotalReactivePower(Integer totalReactivePower) {

        this.totalReactivePower = Integer.toHexString(totalReactivePower);
        return this;
    }

    public String getDailyOutput() {

        return dailyOutput;
    }

    public Device setDailyOutput(Integer dailyOutput) {

        this.dailyOutput = Integer.toHexString(dailyOutput);
        return this;
    }

    public String getTotalGeneratingCapacity() {

        return totalGeneratingCapacity;
    }

    public Device setTotalGeneratingCapacity(Integer totalGeneratingCapacity) {

        this.totalGeneratingCapacity = Integer.toHexString(totalGeneratingCapacity);
        return this;
    }

    public String getState() {

        return state;
    }

    public Device setState(Integer state) {

        this.state = Integer.toHexString(state);
        return this;
    }

    @Override
    public String toString() {
        return MPPT
                + voltage
                + electricity
                + totalDCinputPower
                + internalTemperature
                + theGridFrequency
                + insulationResistanceValue
                + powerfactor
                + inverterEfficiency
                + aCoutputAphaseVoltage
                + aCoutputBphaseVoltage
                + aCoutputCphaseVoltage
                + aCoutputAphaseCurrent
                + aCoutputBphaseCurrent
                + aCoutputCphaseCurrent
                + activeTotalPower
                + aPhaseActivePower
                + bPphaseActivePower
                + cPhaseActivePower
                + totalApparentPower
                + totalReactivePower
                + dailyOutput
                + totalGeneratingCapacity
                + state;
    }
}
