package com.csye6225.fall2018.courseservice.datamodel;

import java.io.IOException;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

public class DynamoDbConnector {

	static AmazonDynamoDB dynamoDb;

	public static void init() {
		if (dynamoDb == null) {
			dynamoDb = AmazonDynamoDBClientBuilder.standard()
					.withCredentials(DefaultAWSCredentialsProviderChain.getInstance()).withRegion(Regions.US_EAST_2)
					.build();
		}

	}

	public AmazonDynamoDB getClient() {
		return dynamoDb;
	}

}

