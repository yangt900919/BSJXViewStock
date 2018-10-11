package com.linkpal.model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 异常出入库
 * @author Yang
 *
 */
public class ICStockBill  {

	private String FNumber;
	private int FBillType;//出入库类型
	private Material material;//物料
	private int FMaterialID;
	private Goodseat goodseat;//货位
	private int FGoodSeatID;
	private ERPStock stock;//仓库
	private int FStockID ;
	private Cabinet cabinet;
	private int FCabinetID;
	private Scabinet scabinet;
	private int FSCabinetID;
	private String FBatchNo;//批号
	private String FMdate;
	private Double FGperiod;
	private String FRemark;//备注
	private Double FQty;//入库数量
	private int FID;
	private int FcreatorID;
	private User creator;

	private Date FCreateTime;


	
	public ICStockBill()
	{
		SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
		try {
			this.FCreateTime=sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.FBillType=0;
		this.FMaterialID=0;
		this.FGoodSeatID=0;
		this.FStockID=0;
		this.FQty=0.00;
		this.FGperiod= Double.valueOf(0);
	}

	public String getFNumber() {
		return FNumber;
	}

	public void setFNumber(String FNumber) {
		this.FNumber = FNumber;
	}

	public int getFBillType() {
		return FBillType;
	}

	public void setFBillType(int FBillType) {
		this.FBillType = FBillType;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public int getFMaterialID() {
		return FMaterialID;
	}

	public void setFMaterialID(int FMaterialID) {
		this.FMaterialID = FMaterialID;
	}

	public Goodseat getGoodseat() {
		return goodseat;
	}

	public void setGoodseat(Goodseat goodseat) {
		this.goodseat = goodseat;
	}

	public int getFGoodSeatID() {
		return FGoodSeatID;
	}

	public void setFGoodSeatID(int FGoodSeatID) {
		this.FGoodSeatID = FGoodSeatID;
	}

	public ERPStock getStock() {
		return stock;
	}

	public void setStock(ERPStock stock) {
		this.stock = stock;
	}

	public int getFStockID() {
		return FStockID;
	}

	public void setFStockID(int FStockID) {
		this.FStockID = FStockID;
	}

	public Cabinet getCabinet() {
		return cabinet;
	}

	public void setCabinet(Cabinet cabinet) {
		this.cabinet = cabinet;
	}

	public int getFCabinetID() {
		return FCabinetID;
	}

	public void setFCabinetID(int FCabinetID) {
		this.FCabinetID = FCabinetID;
	}

	public Scabinet getScabinet() {
		return scabinet;
	}

	public void setScabinet(Scabinet scabinet) {
		this.scabinet = scabinet;
	}

	public int getFSCabinetID() {
		return FSCabinetID;
	}

	public void setFSCabinetID(int FSCabinetID) {
		this.FSCabinetID = FSCabinetID;
	}

	public String getFBatchNo() {
		return FBatchNo;
	}

	public void setFBatchNo(String FBatchNo) {
		this.FBatchNo = FBatchNo;
	}

	public String getFRemark() {
		return FRemark;
	}

	public void setFRemark(String FRemark) {
		this.FRemark = FRemark;
	}

	public Double getFQty() {
		return FQty;
	}

	public void setFQty(Double FQty) {
		this.FQty = FQty;
	}

	public int getFID() {
		return FID;
	}

	public void setFID(int FID) {
		this.FID = FID;
	}

	public Date getFCreateTime() {
		return FCreateTime;
	}

	public void setFCreateTime(Date FCreateTime) {
		this.FCreateTime = FCreateTime;
	}

	public String getFMdate() {
		return FMdate;
	}

	public void setFMdate(String FMdate) {
		this.FMdate = FMdate;
	}

	public Double getFGperiod() {
		return FGperiod;
	}

	public void setFGperiod(Double FGperiod) {
		this.FGperiod = FGperiod;
	}

	public int getFcreatorID() {
		return FcreatorID;
	}

	public void setFcreatorID(int fcreatorID) {
		FcreatorID = fcreatorID;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}
}
