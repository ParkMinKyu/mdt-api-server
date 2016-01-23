package kr.niee.mdt.article.vo;

import java.sql.Date;

public class ArticleVO {
/*id int primary key, title varchar(200) not null, contents LONGVARCHAR not null, regtime Date, modtime Date, writer varchar(200)*/
	private int id;
	private String title;
	private String contents;
	private Date regtime;
	private Date modtime;
	private String writer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getRegtime() {
		return regtime;
	}
	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}
	public Date getModtime() {
		return modtime;
	}
	public void setModtime(Date modtime) {
		this.modtime = modtime;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
}
