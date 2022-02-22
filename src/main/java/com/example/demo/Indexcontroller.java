package com.example.demo;

import com.azure.core.http.rest.PagedIterable;
import com.azure.spring.utils.AzureCloudUrls;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Indexcontroller {

    String connectStr = "DefaultEndpointsProtocol=https;AccountName=testexample;AccountKey=gtjq2b6hqIiIDNlwPXYowDWraSfJ7v7eVPuveDKKzaHzmOmDr/ivdRYHx/ikF1h64bTtC5e/GgTW+AStRGUm1A==;EndpointSuffix=core.windows.net";
    String connectionUrl = "jdbc:sqlserver://testexample.database.windows.net:1433;database=testexample;User=Xiaxiaotong@testexample;password=Xiaxt35363536.;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

    @GetMapping("/userName")
    public String index() throws SQLException {
        Connection connection = DriverManager.getConnection(connectionUrl);
        Statement statement = connection.createStatement();
        String selectSql = "SELECT * from [User]";
        ResultSet resultSet = statement.executeQuery(selectSql);
        while (resultSet.next()) {
            return "Hello Azure Service, " + resultSet.getString(2);
        }
        return null;
    }

    @GetMapping("/pic")
    public List<String> pic() {
        ArrayList<String> list = new ArrayList<>();

        //BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(connectStr).buildClient();
        //String containerName = "testexampleblobs2e6b5347-37eb-4ce4-9f9a-46e1c445426d";
        //BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(containerName);
        //PagedIterable<BlobItem> blobItems = containerClient.listBlobs();
        //for (BlobItem blobItem : blobItems) {
        //    BlobClient blobClient =
        //            containerClient.getBlobClient(blobItem.getName());
        //    //list.add(blobClient.getBlobUrl());
        //}
        list.add("testexample.blob.core.windows.net/testexampleblobs2e6b5347-37eb-4ce4-9f9a-46e1c445426d/pic/screenshot-1.png");
        list.add("testexample.blob.core.windows" +
                ".net/testexampleblobs2e6b5347-37eb-4ce4-9f9a-46e1c445426d/pic/screenshot-2.png");
        list.add("testexample.blob.core.windows" +
                ".net/testexampleblobs2e6b5347-37eb-4ce4-9f9a-46e1c445426d/pic/screenshot-3.png");
        return list;
    }

}
