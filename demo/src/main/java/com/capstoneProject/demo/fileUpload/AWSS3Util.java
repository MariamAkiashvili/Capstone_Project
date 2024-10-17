package com.capstoneProject.demo.fileUpload;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class AWSS3Util {

    @Value("${aws.access.key}")
    private String accessKey;

    @Value("${aws.secret.key}")
    private String secretKey;

    @Value("${aws.s3.bucket}")
    private String bucket;

    @Value("${aws.s3.region}")
    private String region;

    private AWSCredentials awsCredentials(String accessKey, String securityKey) {
        return new BasicAWSCredentials(accessKey, securityKey);
    }

    private AmazonS3 amazonS3ClientBuilder(String accessKey, String secretKey) {
        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials(accessKey, secretKey)))
                .withRegion(region)
                .build();
    }

    public String uploadDocumentToS3(String fileName, MultipartFile file) {
        AmazonS3 s3Client = amazonS3ClientBuilder(accessKey, secretKey);
        File convertedFile = convertMultiPartToFile(file);
        if (convertedFile != null) {
            s3Client.putObject(bucket, file.getOriginalFilename(), convertedFile);
            return s3Client.getUrl(bucket, file.getOriginalFilename()).toString();
        }
        return null;
    }

    public S3ObjectInputStream downloadFIleFromS3(String fileName, String accessKey, String securityKey, String bucket) {
        AmazonS3 s3Client = amazonS3ClientBuilder(accessKey, securityKey);
        S3Object s3Object = s3Client.getObject(bucket, fileName);
        return s3Object.getObjectContent();
    }

    private File convertMultiPartToFile(MultipartFile file) {
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return convertedFile;
    }
}
