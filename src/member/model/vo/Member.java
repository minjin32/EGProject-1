package member.model.vo;

import java.sql.Date;

public class Member {

   private String mbId;
   private int mbNo;
   private String mbPassword;
   private String mbName;
   private String mbNickname;
   private String mbEmail;
   private String mbPhone;
   private String mbAddress1;
   private String mbAddress2;
   private String mbAddress3;
   private char mbType;
   private String shOwner;
   private String shBusinessno;
   private int shEcopoint;
   private Date mbJoindate;
   private String mbStatus;
   private String mbSex;
   
   public String getMbId() {
      return mbId;
   }
   public void setMbId(String mbId) {
      this.mbId = mbId;
   }
   public int getMbNo() {
      return mbNo;
   }
   public void setMbNo(int mbNo) {
      this.mbNo = mbNo;
   }
   public String getMbPassword() {
      return mbPassword;
   }
   public void setMbPassword(String mbPassword) {
      this.mbPassword = mbPassword;
   }
   public String getMbName() {
      return mbName;
   }
   public void setMbName(String mbName) {
      this.mbName = mbName;
   }
   public String getMbNickname() {
      return mbNickname;
   }
   public void setMbNickname(String mbNickname) {
      this.mbNickname = mbNickname;
   }
   public String getMbEmail() {
      return mbEmail;
   }
   public void setMbEmail(String mbEmail) {
      this.mbEmail = mbEmail;
   }
   public String getMbPhone() {
      return mbPhone;
   }
   public void setMbPhone(String mbPhone) {
      this.mbPhone = mbPhone;
   }
   public String getMbAddress1() {
      return mbAddress1;
   }
   public void setMbAddress1(String mbAddress1) {
      this.mbAddress1 = mbAddress1;
   }
   public String getMbAddress2() {
      return mbAddress2;
   }
   public void setMbAddress2(String mbAddress2) {
      this.mbAddress2 = mbAddress2;
   }
   public String getMbAddress3() {
      return mbAddress3;
   }
   public void setMbAddress3(String mbAddress3) {
      this.mbAddress3 = mbAddress3;
   }
   public char getMbType() {
      return mbType;
   }
   public void setMbType(char mbType) {
      this.mbType = mbType;
   }
   public String getShOwner() {
      return shOwner;
   }
   public void setShOwner(String shOwner) {
      this.shOwner = shOwner;
   }
   public String getShBusinessno() {
      return shBusinessno;
   }
   public void setShBusinessno(String shBusinessno) {
      this.shBusinessno = shBusinessno;
   }
   public int getShEcopoint() {
      return shEcopoint;
   }
   public void setShEcopoint(int shEcopoint) {
      this.shEcopoint = shEcopoint;
   }
   public Date getMbJoindate() {
      return mbJoindate;
   }
   public void setMbJoindate(Date mbJoindate) {
      this.mbJoindate = mbJoindate;
   }
   public String getMbStatus() {
      return mbStatus;
   }
   public void setMbStatus(String mbStatus) {
      this.mbStatus = mbStatus;
   }
   public String getMbSex() {
      return mbSex;
   }
   public void setMbSex(String mbSex) {
      this.mbSex = mbSex;
   }
   
   @Override
   public String toString() {
      return "Member [mbId=" + mbId + ", mbNo=" + mbNo + ", mbPassword=" + mbPassword + ", mbName=" + mbName
            + ", mbNickname=" + mbNickname + ", mbEmail=" + mbEmail + ", mbPhone=" + mbPhone + ", mbAddress1="
            + mbAddress1 + ", mbAddress2=" + mbAddress2 + ", mbAddress3=" + mbAddress3 + ", mbType=" + mbType
            + ", shOwner=" + shOwner + ", shBusinessno=" + shBusinessno + ", shEcopoint=" + shEcopoint
            + ", mbJoindate=" + mbJoindate + ", mbStatus=" + mbStatus + ", mbSex=" + mbSex + "]";
   }
}	