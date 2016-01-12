package kr.niee.mdt.article.vo;

import java.sql.Timestamp;

public class ArticleVO {
/*id int primary key, title varchar(200) not null, contents LONGVARCHAR not null, regtime timestamp, modtime timestamp, writer varchar(200)*/
	private int id;
	private String title;
	private String contents;
	private Timestamp regtime;
	private Timestamp modtime;
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
	public Timestamp getRegtime() {
		return regtime;
	}
	public void setRegtime(Timestamp regtime) {
		this.regtime = regtime;
	}
	public Timestamp getModtime() {
		return modtime;
	}
	public void setModtime(Timestamp modtime) {
		this.modtime = modtime;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
}
