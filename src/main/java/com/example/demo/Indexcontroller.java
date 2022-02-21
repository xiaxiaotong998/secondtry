package com.example.demo;

import java.sql.*;
import java.util.List;

import com.azure.core.http.rest.PagedIterable;
import com.example.demo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.azure.storage.blob.*;
import com.azure.storage.blob.models.*;

@RestController
public class Indexcontroller {

    String connectStr = "DefaultEndpointsProtocol=https;AccountName=testexample;AccountKey=gtjq2b6hqIiIDNlwPXYowDWraSfJ7v7eVPuveDKKzaHzmOmDr/ivdRYHx/ikF1h64bTtC5e/GgTW+AStRGUm1A==;EndpointSuffix=core.windows.net";
    String connectionUrl = "jdbc:sqlserver://testexample.database.windows.net:1433;database=testexample;user=Xiaxiaotong@testexample;password=Xiaxt35363536.;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    @GetMapping("/pic")
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


    @GetMapping("")
    public PagedIterable<BlobItem> index1() {

        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(connectStr).buildClient();
        String containerName = "testexampleblobs2e6b5347-37eb-4ce4-9f9a-46e1c445426d";
        BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(containerName);

//        for (BlobItem blobItem : containerClient.listBlobs()) {
//            return "Blob name: " + blobItem.getName() + ", Snapshot: " + "https://testexample.blob.core.windows.net/testexampleblobs2e6b5347-37eb-4ce4-9f9a-46e1c445426d/screenshot-1.png?snapshot=2022-02-16T09:16:08.9155424Z&sv=2020-08-04&ss=bqtf&srt=sco&sp=rwdlacuptfxi&se=2022-02-21T15:20:38Z&sig=L39sjU8SwLhBxdJr8rzONf5thJkBzCnOik2IKO2x0f4%3D&_=1645439177315";
//        }
       return containerClient.listBlobs();
    }
}
