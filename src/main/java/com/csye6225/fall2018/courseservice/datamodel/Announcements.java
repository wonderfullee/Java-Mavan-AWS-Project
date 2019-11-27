package com.csye6225.fall2018.courseservice.datamodel;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Announcement")
public class Announcements {
	private String Id;
	private String annnouncementId;
	private String announcementText;
	private String boardId;
	
	public Announcements() {}

	public Announcements(String Id, String annnouncementId, String announcementText, String boardId) {
		this.Id = Id;
		this.annnouncementId = annnouncementId;
		this.announcementText = announcementText;
		this.boardId = boardId;
	}
	
	@DynamoDBHashKey
	@DynamoDBAutoGeneratedKey
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	@DynamoDBIndexHashKey(attributeName = "annnouncementId", globalSecondaryIndexName = "annnouncementId")
	public String getAnnnouncementId() {
		return annnouncementId;
	}

	public void setAnnnouncementId(String annnouncementId) {
		this.annnouncementId = annnouncementId;
	}
	
	@DynamoDBAttribute(attributeName = "announcementText")
	public String getAnnouncementText() {
		return announcementText;
	}

	public void setAnnouncementText(String announcementText) {
		this.announcementText = announcementText;
	}
	
	@DynamoDBAttribute(attributeName = "boardId")
	public String getBoardId() {
		return boardId;
	}

	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}


}