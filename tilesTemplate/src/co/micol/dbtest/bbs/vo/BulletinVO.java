package co.micol.dbtest.bbs.vo;

import java.util.Date;

public class BulletinVO {


	private int bbsId;
	private String bbsTitle;
	private String bbsContent;
	private String bbsImage;
	private String bbsWriter;
	private Date bbsCreateDate;
	private int bbsHit;

	public int getBbsId() {
		return bbsId;
	}

	public void setBbsId(int bbsId) {
		this.bbsId = bbsId;
	}

	public String getBbsTitle() {
		return bbsTitle;
	}

	public void setBbsTitle(String bbsTitle) {
		this.bbsTitle = bbsTitle;
	}

	public String getBbsContent() {
		return bbsContent;
	}

	public void setBbsContent(String bbsContent) {
		this.bbsContent = bbsContent;
	}

	public String getBbsImage() {
		return bbsImage;
	}

	public void setBbsImage(String bbsImage) {
		this.bbsImage = bbsImage;
	}

	public String getBbsWriter() {
		return bbsWriter;
	}

	public void setBbsWriter(String bbsWriter) {
		this.bbsWriter = bbsWriter;
	}

	public Date getBbsCreateDate() {
		return bbsCreateDate;
	}

	public void setBbsCreateDate(Date bbsCreateDate) {
		this.bbsCreateDate = bbsCreateDate;
	}

	public int getBbsHit() {
		return bbsHit;
	}

	public void setBbsHit(int bbsHit) {
		this.bbsHit = bbsHit;
	}
	@Override
	public String toString() {
		return "BulletinVO [bbsId=" + bbsId + ", bbsTitle=" + bbsTitle + ", bbsContent=" + bbsContent + ", bbsImage="
				+ bbsImage + ", bbsWriter=" + bbsWriter + ", bbsCreateDate=" + bbsCreateDate + ", bbsHit=" + bbsHit
				+ "]";
	}
}
