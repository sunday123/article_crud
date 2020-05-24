package com.ij34.model;



public class article {

private int id;
   private String title;
   private String content;
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
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}


public article() {
	super();
}
public article(int id, String title, String content) {
	super();
	this.id = id;
	this.title = title;
	this.content = content;
}
@Override
public String toString() {

//	return "{conten:\'"+this.content+"\',id:"+this.id+",title:\'"+this.title+"\'}";

	return "{id:"+this.id+",title:\'"+this.title+"\',content:\'"+this.content+"\'}";
}


}
