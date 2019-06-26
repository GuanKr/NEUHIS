package neu.his.bean;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 存储检查/检验/处置信息
 * @author lsy
 * @version 1.0
 * @since 1.8
 */
public class Inspection {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 病历号
     */
    private String medicalRecordNo;

    /**
     * 非药品id
     */
    private Integer nonDrugListId;

    /**
     * 医生id
     */
    private Integer doctorId;

    /**
     * 结果分析
     */
    private String inspectionResultAnalysis;

    /**
     * 缴费状态
     */
    private String payState;

    /**
     * 缴费时间
     */
    private Date payTime;

    /**
     * 登记状态
     */
    private String registerState;

    /**
     * 有效标志
     */
    private String validity;

    /**
     * 金额
     */
    private BigDecimal cost;

    /**
     * 模板标志
     */
    private String isCommon;

    /**
     * 非药品名称
     */
    private String nonDrugListName;

    /**
     * 项目编码
     */
    private String itemCode;

    /**
     * 价格
     */
    private String price;

    /**
     * 构造方法 ：创建检查/检验/处置对象
     * @param id 主键id
     * @param medicalRecordNo 病历号
     * @param nonDrugListId 非药品id
     * @param doctorId 医生id
     * @param inspectionResultAnalysis 结果分析
     * @param payState 缴费状态
     * @param payTime 缴费时间
     * @param registerState 登记状态
     * @param validity 有效状态
     * @param cost 金额
     * @param isCommon 模板标志
     */
    public Inspection(Integer id, String medicalRecordNo, Integer nonDrugListId, Integer doctorId, String inspectionResultAnalysis, String payState, Date payTime, String registerState, String validity, BigDecimal cost, String isCommon) {
        this.id = id;
        this.medicalRecordNo = medicalRecordNo;
        this.nonDrugListId = nonDrugListId;
        this.doctorId = doctorId;
        this.inspectionResultAnalysis = inspectionResultAnalysis;
        this.payState = payState;
        this.payTime = payTime;
        this.registerState = registerState;
        this.validity = validity;
        this.cost = cost;
        this.isCommon = isCommon;
    }

    public Inspection(Integer nonDrugListId, BigDecimal cost) {
        this.nonDrugListId = nonDrugListId;
        this.cost = cost;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNonDrugListName() {
        return nonDrugListName;
    }

    public void setNonDrugListName(String nonDrugListName) {
        this.nonDrugListName = nonDrugListName;
    }

    public Inspection() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedicalRecordNo() {
        return medicalRecordNo;
    }

    public void setMedicalRecordNo(String medicalRecordNo) {
        this.medicalRecordNo = medicalRecordNo == null ? null : medicalRecordNo.trim();
    }

    public Integer getNonDrugListId() {
        return nonDrugListId;
    }

    public void setNonDrugListId(Integer nonDrugListId) {
        this.nonDrugListId = nonDrugListId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getInspectionResultAnalysis() {
        return inspectionResultAnalysis;
    }

    public void setInspectionResultAnalysis(String inspectionResultAnalysis) {
        this.inspectionResultAnalysis = inspectionResultAnalysis == null ? null : inspectionResultAnalysis.trim();
    }

    public String getPayState() {
        return payState;
    }

    public void setPayState(String payState) {
        this.payState = payState == null ? null : payState.trim();
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getRegisterState() {
        return registerState;
    }

    public void setRegisterState(String registerState) {
        this.registerState = registerState == null ? null : registerState.trim();
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity == null ? null : validity.trim();
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getIsCommon() {
        return isCommon;
    }

    public void setIsCommon(String isCommon) {
        this.isCommon = isCommon == null ? null : isCommon.trim();
    }

    @Override
    public String toString() {
        return "Inspection{" +
                "id=" + id +
                ", medicalRecordNo='" + medicalRecordNo + '\'' +
                ", nonDrugListId=" + nonDrugListId +
                ", doctorId=" + doctorId +
                ", inspectionResultAnalysis='" + inspectionResultAnalysis + '\'' +
                ", payState='" + payState + '\'' +
                ", payTime=" + payTime +
                ", registerState='" + registerState + '\'' +
                ", validity='" + validity + '\'' +
                ", cost=" + cost +
                ", isCommon='" + isCommon + '\'' +
                ", nonDrugListName='" + nonDrugListName + '\'' +
                '}';
    }
}